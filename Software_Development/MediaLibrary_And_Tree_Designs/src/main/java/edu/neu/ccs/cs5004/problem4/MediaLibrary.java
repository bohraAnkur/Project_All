package edu.neu.ccs.cs5004.problem4;

import java.util.ArrayList;

/**
 * Represents the common entities of Media Library.
 */

public interface MediaLibrary {


  /**
   * search the library by director name.
   *
   * @param director the name of the director
   * @return a list of medias directed by this director
   */

  ArrayList<Media> search(Director director);

  /**
   * Implementation Of the property to add Media into the Library.
   *
   * @param media Media to be formed to be added into the library
   */

  void add(Media media);


  /**
   * request a media to be streamed.
   * time complexity: O(1)
   * space complexity: O(1)
   *
   * @param alias the alias of media
   */

  void requestStreaming(Alias alias);


  /**
   * get the number of the media streamed by its alias.
   * time complexity: O(1)
   * space complexity: O(1)
   *
   * @param alias the alias you want to search
   * @return the number of the media streamed
   */

  int getStatistics(Alias alias);

  /**
   * most streamed media.
   * time complexity: O(1)
   * space complexity: O(1)
   *
   * @return most streamed media
   */

  Media mostStreamed();


}
