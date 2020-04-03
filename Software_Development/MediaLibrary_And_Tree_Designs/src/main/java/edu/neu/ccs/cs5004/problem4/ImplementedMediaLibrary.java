package edu.neu.ccs.cs5004.problem4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

/**
 * Represents the common properties of Implemented Media Library.
 */

public class ImplementedMediaLibrary implements MediaLibrary {
  private HashMap<Director, ArrayList<Media>> searchByDirector;
  private HashMap<Alias, Media> searchByAlias;
  private HashSet<Alias> listOfAlias;
  private Media mostStreamedMedia;
  private ICoreMediaLibrary coreMediaLibrary;

  /**
   * Constructor For the Implemented Media Library.
   */

  public ImplementedMediaLibrary() {
    this.searchByDirector = new HashMap<>();
    this.searchByAlias = new HashMap<>();
    this.listOfAlias = new HashSet<>();
    this.mostStreamedMedia = null;
    this.coreMediaLibrary = ICoreMediaLibrary.createCoreMediaLibrary();
  }

  /**
   * search the library by director name.
   *
   * @param director the name of the director
   * @return a list of medias directed by this director
   */

  public ArrayList<Media> search(Director director) {
    return searchByDirector.get(director);
  }

  /**
   * Implementation Of the property to add Media into the Library.
   *
   * @param media Media to be formed to be added into the library
   */

  public void add(Media media) {
    if (listOfAlias.contains(media.getAlias())) {
      throw new IllegalArgumentException("this alias has already been used, "
              + "please choose another one");
    }
    listOfAlias.add(media.getAlias());

    for (Director director : media.getAllDirector()) {
      if (searchByDirector.containsKey(director)) {
        searchByDirector.get(director).add(media);
        searchByDirector.get(director).sort(new YearComparator());
      } else {
        this.searchByDirector.put(director, new ArrayList<Media>());
        this.searchByDirector.get(director).add(media);
      }
    }
    this.searchByAlias.put(media.getAlias(), media);
    this.coreMediaLibrary.addCoreMedia(media);

  }

  /**
   * request a media to be streamed.
   * time complexity: O(1)
   * space complexity: O(1)
   *
   * @param alias the alias of media
   */

  public void requestStreaming(Alias alias) {
    this.searchByAlias.get(alias).setStreamed();
    Media temp = this.searchByAlias.get(alias);
    if (mostStreamedMedia == null || temp.getStreamed() >= mostStreamedMedia.getStreamed()) {
      this.mostStreamedMedia = temp;
    }
  }

  /**
   * get the number of the media streamed by its alias.
   * time complexity: O(1)
   * space complexity: O(1)
   *
   * @param alias the alias you want to search
   * @return the number of the media streamed
   */

  public int getStatistics(Alias alias) {
    return this.searchByAlias.get(alias).getStreamed();
  }

  /**
   * most streamed media.
   * time complexity: O(1)
   * space complexity: O(1)
   *
   * @return most streamed media
   */

  public Media mostStreamed() {
    return this.mostStreamedMedia;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    ImplementedMediaLibrary that = (ImplementedMediaLibrary) object;
    return Objects.equals(searchByDirector, that.searchByDirector)
            &&
            Objects.equals(searchByAlias, that.searchByAlias)
            &&
            Objects.equals(listOfAlias, that.listOfAlias)
            &&
            Objects.equals(mostStreamedMedia, that.mostStreamedMedia);

  }

  @Override
  public int hashCode() {

    return Objects.hash(searchByDirector, searchByAlias,
            listOfAlias, mostStreamedMedia

    );
  }
}





