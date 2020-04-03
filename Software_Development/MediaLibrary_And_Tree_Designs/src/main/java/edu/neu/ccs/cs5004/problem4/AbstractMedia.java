package edu.neu.ccs.cs5004.problem4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents the common properties of Abstract Media Entity.
 */
public abstract class AbstractMedia implements Media {
  private Alias alias;
  private List<Actor> actorList;
  private Title title;
  private ReleaseYear releaseYear;
  private List<Director> directorList;
  private int streamed;

  /**
   * Constructor for the AbstractMedia Entity.
   */

  public AbstractMedia() {
    this.alias = null;
    this.actorList = new ArrayList<>();
    this.title = null;
    this.releaseYear = null;
    this.directorList = new ArrayList<>();
    this.streamed = 0;
  }

  /**
   * Getter for the Alias of the movie.
   *
   * @return the alias of the movie
   */
  public Alias getAlias() {
    return this.alias;
  }

  /**
   * setter for the alias of the media.
   *
   * @param alias alias of the media
   */
  public void setAlias(Alias alias) {
    this.alias = alias;
  }


  /**
   * Getter for all the actors of the movie.
   *
   * @return list of actors  of the movie
   */

  public List<Actor> getAllActor() {
    return this.actorList;
  }

  /**
   * Implementation of getting the actors one by one.
   * In case if there are more than one actors.
   * the index is greater than zero and lesser than the size.
   *
   * @param index an index , could be first or second
   * @return an Actor
   */


  @Override
  public Actor getActor(int index) {
    return this.actorList.get(index - 1);
  }

  /**
   * adder for the actor of the media.
   *
   * @param actor actor of the media
   */

  public void addActors(Actor actor) {
    this.actorList.add(actor);
  }


  /**
   * Getter for the title of the movie.
   *
   * @return the title of the movie
   */

  public Title getTitle() {
    return this.title;
  }

  /**
   * Setter for the title of the media.
   *
   * @param title title of the media.
   */
  public void setTitle(Title title) {
    this.title = title;
  }

  /**
   * Getter for the release year of the movie.
   *
   * @return the release year of the movie
   */

  public ReleaseYear getReleaseYear() {
    return releaseYear;
  }

  /**
   * Setter for the releaseYear of the media.
   *
   * @param releaseYear release Year of the media.
   */

  public void setReleaseYear(ReleaseYear releaseYear) {
    this.releaseYear = releaseYear;
  }

  /**
   * Getter for all the directors of the movie.
   *
   * @return the list of directors of the movie
   */

  public List<Director> getAllDirector() {
    return this.directorList;
  }

  /**
   * Adder for the Director of the Media.
   *
   * @param director director of the media
   */

  public void addDirectors(Director director) {
    this.directorList.add(director);
  }

  /**
   * Implementation of the property of getting Directors One by One
   * in case if there are more than One Directors.
   * the index is greater than zero and lesser than the size.
   *
   * @param index represent the director no, first Director , Second Director
   * @return a Director
   */

  @Override
  public Director getDirector(int index) {
    return this.directorList.get(index - 1);
  }

  /**
   * getter for the stream of the media.
   *
   * @return the stream quantity of the media
   */
  public Integer getStreamed() {
    return this.streamed;
  }

  /**
   * setter for the stream of the media.
   */
  public void setStreamed() {
    this.streamed = this.getStreamed() + 1;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    AbstractMedia that = (AbstractMedia) object;
    return streamed == that.streamed
            &&
            Objects.equals(alias, that.alias)
            &&
            Objects.equals(actorList, that.actorList)
            &&
            Objects.equals(title, that.title)
            &&
            Objects.equals(releaseYear, that.releaseYear)
            &&
            Objects.equals(directorList, that.directorList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(alias, actorList, title, releaseYear, directorList, streamed);
  }


}
