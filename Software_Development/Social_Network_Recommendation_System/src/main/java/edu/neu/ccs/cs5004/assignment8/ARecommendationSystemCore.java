package edu.neu.ccs.cs5004.assignment8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/**
 * core recommendation system.
 */
public class ARecommendationSystemCore implements RecommendationSystemCore {
  private Map<Id, ArrayList<Id>> edgeMap;
  private Map<Id, ArrayList<Id>> recommendationMap;
  private ArrayList<Id> idList;
  private ArrayList<Id> influencerList;
  private String destFile;
  private Flag processingFlag;
  private Integer numberOfUsersToProcess;
  private Integer numberOfRecommendations;

  /**
   * constructor for core. run time: O(n).
   * @param nodeFile source file
   * @param edgeFile source file
   * @param destFile dest file
   * @param processingFlag flag
   * @param numberOfUsersToProcess integer
   * @param numberOfRecommendations integer
   */
  public ARecommendationSystemCore(String nodeFile,
                                   String edgeFile,
                                   String destFile,
                                   Flag processingFlag,
                                   Integer numberOfUsersToProcess,
                                   Integer numberOfRecommendations) {
    this.edgeMap = generateEdgeMapFromInput(edgeFile);
    this.recommendationMap = new HashMap<>();
    this.idList = generateIdListFromInput(nodeFile);
    this.influencerList = new ArrayList<>();
    this.destFile = destFile;
    this.processingFlag = processingFlag;
    this.numberOfUsersToProcess = numberOfUsersToProcess;
    this.numberOfRecommendations = numberOfRecommendations;
  }

  /**
   * generate edge map from file input. run time: O(n).
   * @param csvEdgeFile file name
   * @return edge map
   */
  private Map<Id, ArrayList<Id>> generateEdgeMapFromInput(String csvEdgeFile) {
    String line = "";
    String cvsSplitBy = ",";

    Map<Id, ArrayList<Id>> map = new HashMap<>();

    try (BufferedReader bufferReader = new BufferedReader(
        new InputStreamReader(new FileInputStream(csvEdgeFile), "UTF-8"))) {

      while ((line = bufferReader.readLine()) != null) {

        // use comma as separator
        String[] lineInfo = line.split(cvsSplitBy);

        Id src;
        Id dest;
        try {
          src = new Id(Integer.valueOf(lineInfo[0]));
          dest = new Id(Integer.valueOf(lineInfo[1]));
        } catch (NumberFormatException e) {
          System.out.println("NumberFormatException catched.");
          continue;
        }

        ArrayList<Id> destList = new ArrayList<>();

        if (map.containsKey(src)) {
          destList = map.get(src);
          destList.add(dest);
        } else {
          destList.add(dest);
          map.put(src, destList);
        }
      }

    } catch (IOException ioe) {
      ioe.printStackTrace();
    }

    return map;
  }

  /**
   * generate id list from file input. run time: O(n).
   * @param csvNodeFile file name
   * @return id list
   */
  private ArrayList<Id> generateIdListFromInput(String csvNodeFile) {
    String line = "";
    String cvsSplitBy = ",";
    ArrayList<Id> list = new ArrayList<>();

    try (BufferedReader bufferReader = new BufferedReader(
        new InputStreamReader(new FileInputStream(csvNodeFile), "UTF-8"))) {

      while ((line = bufferReader.readLine()) != null) {

        // use comma as separator
        String[] lineInfo = line.split(cvsSplitBy);

        Id idNum;
        try {
          idNum = new Id(Integer.valueOf(lineInfo[0]));
        } catch (NumberFormatException e) {
          System.out.println("NumberFormatException catched.");
          continue;
        }

        list.add(idNum);
      }

    } catch (IOException ioe) {
      ioe.printStackTrace();
    }

    return list;
  }

  /**
   * generate influencer list. run time: O(n).
   * @return influencer list
   */
  private void generateInfluencerList() {
    Integer size = idList.size();
    Map<Id, Integer> influenceMap = new HashMap<>();
    ArrayList<Id> influencerList = new ArrayList<>();
    Integer influenceThreshhold = size > 200 ? 250 : 25;
    System.out.println("influence threshhold: " + influenceThreshhold);

    for (Map.Entry entry : edgeMap.entrySet()) {
      ArrayList<Id> list = (ArrayList<Id>) entry.getValue();
      for (Id ele : list) {
        if (influenceMap.containsKey(ele)) {
          Integer level = influenceMap.get(ele);
          influenceMap.replace(ele, level + 1);
        } else {
          influenceMap.put(ele, 1);
        }
      }
    }

    for (Map.Entry entry : influenceMap.entrySet()) {
      Integer level = (Integer) entry.getValue();
      Id idNum = (Id) entry.getKey();

      if (level > influenceThreshhold) {
        influencerList.add(idNum);
      }
    }

    System.out.println("influencer list: " + influencerList);
    this.influencerList = influencerList;
  }

  /**
   * adds list to recommendation list properly. run time: O(n).
   * @param list to be added
   * @param followingList currently following list
   * @param recommendationList recommendation list
   */
  private void addListToRecommendationList(ArrayList<Id> list,
                                           ArrayList<Id> followingList,
                                           ArrayList<Id> recommendationList) {
    if (recommendationList.size() < numberOfRecommendations) {
      Iterator<Id> itr = list.iterator();
      while (itr.hasNext() && recommendationList.size() < numberOfRecommendations) {
        Id ele = itr.next();
        if (!followingList.contains(ele) && !recommendationList.contains(ele)) {
          recommendationList.add(ele);
        }
      }

    }
  }

  /**
   * get iterator according to flag. run time: O(n).
   * @return proper iterator
   */
  private Iterator<Id> getIterator() {
    if (processingFlag.equals(Flag.s)) {
      return idList.iterator();
    } else if (processingFlag.equals(Flag.e)) {
      Collections.reverse(idList);
      return idList.iterator();
    } else {
      return new RandomOrderIterator(idList);
    }
  }

  /**
   * write recommendation map to dest file. run time: O(n).
   */
  private void writeRecommendationMap() {
    try (BufferedWriter bufferWriter = new BufferedWriter(
        new OutputStreamWriter(new FileOutputStream(destFile), "UTF-8"))) {

      bufferWriter.write("Node Id, Recommended nodes\n");
      for (Map.Entry entry : recommendationMap.entrySet()) {
        Id idNum = (Id) entry.getKey();
        bufferWriter.write(idNum.getId() + ",");

        ArrayList<Id> list = (ArrayList<Id>) entry.getValue();
        for (Id ele : list) {
          bufferWriter.write(" " + ele.getId());
        }

        bufferWriter.write("\n");
      }

    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  @Override
  public void process() {
    generateInfluencerList();

    // Iterate through idList to find recommendations for required individual
    Iterator<Id> iterator = getIterator();
    while (iterator.hasNext() && numberOfUsersToProcess > 0) {
      Id idNum = iterator.next();
      ArrayList<Id> followingList = new ArrayList<>();

      if (edgeMap.get(idNum) != null) {
        followingList = edgeMap.get(idNum);
      }

      followingList.add(idNum);
      numberOfUsersToProcess--;

      ArrayList<Id> recommendationList = new ArrayList<>();

      // criteria 1
      for (Id friendId : followingList) {
        ArrayList<Id> list = new ArrayList<>();
        if (edgeMap.get(friendId) != null) {
          list = edgeMap.get(friendId);
        }

        addListToRecommendationList(list, followingList, recommendationList);

        if (recommendationList.size() == numberOfRecommendations) {
          break;
        }
      }

      // criteria 2
      addListToRecommendationList(influencerList, followingList, recommendationList);

      // criteria 3
      ArrayList<Id> backUpList = new ArrayList<>();
      int randomStreamSize = numberOfRecommendations * 2;

      new Random()
          .ints(numberOfRecommendations, 0, idList.size() - 1)
          .forEach(index -> {
            backUpList.add(idList.get(index));
          });

      addListToRecommendationList(backUpList, followingList, recommendationList);

      //load info to recommendation map
      recommendationMap.put(idNum, recommendationList);
    }

    //write recommendation map to output file
    writeRecommendationMap();
  }
}
