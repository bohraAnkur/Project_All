package edu.neu.ccs.cs5004.problem4;

import java.util.LinkedList;

/**
 * Represents the common properties of the coreMedia entity.
 */
public class CoreMediaLibrary implements ICoreMediaLibrary {
  private LinkedList<Media> listOfMedia;

  /**
   * Constructor for the core Media Entity.
   */

  public CoreMediaLibrary() {
    this.listOfMedia = new LinkedList<>();
  }

  /**
   * Adding more media to the core Media Entity.
   * Any Media added to the implemented media should also be stored in the coreMedia.
   *
   * @param media media to be added into the Entity
   */
  public boolean addCoreMedia(Media media) {
    return this.listOfMedia.add(media);
  }


}
