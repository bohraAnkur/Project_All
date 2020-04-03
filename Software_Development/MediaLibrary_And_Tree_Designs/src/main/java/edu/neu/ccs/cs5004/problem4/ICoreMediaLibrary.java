package edu.neu.ccs.cs5004.problem4;


/**
 * Represents the common properties of the ICoreMediaLibrary entity.
 */
public interface ICoreMediaLibrary {

  /**
   * The constructor of the CoreMediaLibrary.
   */
  static ICoreMediaLibrary createCoreMediaLibrary() {
    return new CoreMediaLibrary();
  }

  /**
   * Adding more media to the core Media Entity.
   * Any Media added to the implemented media should also be stored in the coreMedia.
   *
   * @param media media to be added into the Entity
   */
  boolean addCoreMedia(Media media);
}
