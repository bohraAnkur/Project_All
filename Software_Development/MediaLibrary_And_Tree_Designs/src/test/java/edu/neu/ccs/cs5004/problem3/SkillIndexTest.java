package edu.neu.ccs.cs5004.problem3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import edu.neu.ccs.cs5004.problem1and2.TestUtility;

import static org.junit.Assert.*;

public class SkillIndexTest extends TestUtility {
  SkillIndex<String, Integer> s1;
  SkillIndex<String, Integer> s2;
  SkillIndex<String, Integer> s3;
  SkillIndex<Integer, String> diff;
  Map<String, ArrayList<Integer>> map;

  @Before
  public void setUp() throws Exception {
    map = new HashMap<>();
    ArrayList<Integer> l1 = new ArrayList<>();
    l1.add(112233);
    l1.add(223456);
    l1.add(357911);
    l1.add(481216);
    l1.add(714210);
    map.put("Java", l1);
    ArrayList<Integer> l2 = new ArrayList<>();
    l2.add(112233);
    l2.add(357911);
    l2.add(714210);
    map.put("Python", l2);
    l2 = new ArrayList<>();
    l2.add(112233);
    map.put("OOD", l2);
    map.put("Go", l2);
    map.put("ASP.NET", l2);
    l2 = new ArrayList<>();
    l2.add(223456);
    map.put("JavaScript", l2);
    map.put("security", l2);
    map.put("r", l2);
    map.put("Scala", l2);
    l2 = new ArrayList<>();
    l2.add(357911);
    map.put("AI", l2);
    map.put("assembly", l2);
    map.put("AWS", l2);
    l2 = new ArrayList<>();
    l2.add(481216);
    map.put("hardware d", l2);
    map.put("C#", l2);
    l2 = new ArrayList<>();
    l2.add(714210);
    map.put("Ruby", l2);
    map.put("Cloud comp", l2);

    s1 = new SkillIndex<>(map);
    s2 = s1;
    s3 = s1;
    diff = s1.analyze();
  }

  @Test
  public void getMap() {
    Assert.assertTrue(s1.getMap().equals(map));
  }

  @Test
  public void analyze() {
    Assert.assertTrue(s1.analyze().equals(diff));
    for (Map.Entry en : s1.getMap().entrySet()) {
      System.out.println(en.getKey() + " " + en.getValue());
    }

    for (Map.Entry en : diff.getMap().entrySet()) {
      System.out.println(en.getKey() + " " + en.getValue());
    }
  }

  @Test
  public void toStringT() {
    String str = "SkillIndex{map={C#=[481216], Java=[112233, 223456, 357911, 481216, 714210], " +
        "OOD=[112233], Scala=[223456], Go=[112233], AI=[357911], security=[223456], r=[223456], " +
        "Cloud comp=[714210], JavaScript=[223456], assembly=[357911], ASP.NET=[112233], " +
        "hardware d=[481216], AWS=[357911], Ruby=[714210], Python=[112233, 357911, 714210]}}";
    Assert.assertEquals(s1.toString(), str);
  }

  @Test
  public void equalsT() {
    isEqualsContractValid(s1, s2, s3, diff);
  }
}