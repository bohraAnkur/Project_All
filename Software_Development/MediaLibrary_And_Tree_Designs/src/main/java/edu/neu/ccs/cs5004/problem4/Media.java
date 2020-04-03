package edu.neu.ccs.cs5004.problem4;

import java.util.List;

/**
 * Represents the common properties of the media.
 */

public interface Media {

  /**
   * Getter for the Alias of the movie.
   *
   * @return the alias of the movie
   */
  Alias getAlias();

  /**
   * setter for the alias of the media.
   *
   * @param alias alias of the media
   */
  void setAlias(Alias alias);

  /**
   * Implementation of getting the actors one by one.
   * In case if there are more than one actors.
   * index should be greater than 0 and lesser than or equal to size.
   *
   * @param index an index , could be first or second
   * @return an Actor
   */

  Actor getActor(int index);

  /**
   * Getter for the All the actors of the movie.
   *
   * @return the list of actors of the movie
   */

  List<Actor> getAllActor();

  /**
   * Implementation of the property if there are more than One actors in the media.
   *
   * @param actor  the new Actor
   */

  void addActors(Actor actor);

  /**
   * Getter for the title of the movie.
   *
   * @return the title of the movie
   */

  Title getTitle();

  /**
   * Setter for the title of the media.
   *
   * @param title title of the media.
   */
  void setTitle(Title title);

  /**
   * Getter for the release year of the movie.
   *
   * @return the release year of the movie
   */

  ReleaseYear getReleaseYear();


  /**
   * Setter for the releaseYear of the media.
   *
   * @param releaseYear release Year of the media.
   */

  void setReleaseYear(ReleaseYear releaseYear);

  /**
   * Implementation of the property of getting the directors.
   * may it be first or second Directors
   * the index should be greater than 0 and lesser than or equal to size.
   *
   * @param index represent the index of the directors
   * @return a Director
   */

  Director getDirector(int index);

  /**
   * Getter for all the directors of the movie.
   *
   * @return the list of  director of the movie
   */

  List<Director> getAllDirector();

  /**
   * Implementation of the property if there are more than one Directors in the movie.
   *
   * @param director the name of the new Director
   */

  void addDirectors(Director director);

  /**
   * Setter for the streamed.
   */

  void setStreamed();

  /**
   * Getter for the Streamed.
   *
   * @return the number of times the media is being streamed
   */

  Integer getStreamed();
}
