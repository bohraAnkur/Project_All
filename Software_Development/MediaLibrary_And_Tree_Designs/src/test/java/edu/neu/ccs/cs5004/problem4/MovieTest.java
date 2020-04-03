package edu.neu.ccs.cs5004.problem4;

import edu.neu.ccs.cs5004.problem4.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class MovieTest {

  private String LeoNardo;
  private String DiCaprio;
  private Name LeoNardoDiCaprio;
  private Actor LeoNardoDiCaprioActor;

  private String Christopher;
  private String Nolan;
  private Name ChristopherNolan;
  private Director ChristopherNolanDirector;


  private String xx05;
  private Alias xx05Alias;

  private Integer releaseInception;
  private ReleaseYear aInception;

  private String inception;
  private Title Inception;

  private Movie InceptionM;
  private Movie sameRefMedia;
  private Movie sameStateMedia;
  private Movie yetAnotherMedia;
  private Movie diffMedia;
  private Movie nullMedia;

  private String Fionn;
  private String WhiteHead;
  private Name FionnWhiteHead;
  private Actor FionnWhiteHeadActor;

  private String xx04;
  private Alias xx04Alias;

  private Integer releaseDunkirk;
  private ReleaseYear aDunkirk;

  private String dunkirk;
  private Title Dunkirk;


  @Test
  public void hashCodeTest() {
    Assert.assertEquals(this.InceptionM.hashCode(), this.sameRefMedia.hashCode());

    Assert.assertEquals(this.InceptionM.hashCode(), this.sameStateMedia.hashCode());
  }

  @Test
  public void equals() {
    Assert.assertTrue(this.InceptionM.equals(sameRefMedia));

    Assert.assertTrue(this.InceptionM.equals(this.sameStateMedia));

    Assert.assertTrue(this.sameStateMedia.equals(this.InceptionM));

    Assert.assertEquals(this.InceptionM.equals(this.sameStateMedia)
                    &&
                    this.sameStateMedia.equals(this.yetAnotherMedia),
            this.InceptionM.equals(this.yetAnotherMedia));

    Assert.assertFalse(this.InceptionM.equals("S"));

    Assert.assertFalse(this.InceptionM.equals(null));

    Assert.assertFalse(this.InceptionM.equals(nullMedia));
  }

  @Test
  public void toStringTest() {

    Assert.assertEquals("Movie{}",this.InceptionM.toString());


  }

  @Before
  public void setUp() throws Exception {
    this.LeoNardo = "LeoNardoo";
    this.DiCaprio = "DiCaprio";
    this.LeoNardoDiCaprio = new Name(LeoNardo, DiCaprio);
    this.LeoNardoDiCaprioActor = new Actor(LeoNardoDiCaprio);

    this.Fionn = "Fionn";
    this.WhiteHead = "WhiteHead";
    this.FionnWhiteHead = new Name(Fionn, WhiteHead);
    this.FionnWhiteHeadActor = new Actor(FionnWhiteHead);

    this.Christopher = "Christopher";
    this.Nolan = "Nolan";
    this.ChristopherNolan = new Name(Christopher, Nolan);
    this.ChristopherNolanDirector = new Director(ChristopherNolan);

    this.xx04 = "xx04";
    this.xx04Alias = new Alias(xx04);

    this.xx05 = "xx05";
    this.xx05Alias = new Alias(xx05);

    this.releaseDunkirk = 2017;
    this.aDunkirk = new ReleaseYear(releaseDunkirk);

    this.dunkirk = "Dunkirk";
    this.Dunkirk = new Title(dunkirk);

    this.releaseInception = 2010;
    this.aInception = new ReleaseYear(releaseInception);

    this.inception = "Inception";
    this.Inception = new Title(inception);

    this.InceptionM = new Movie();
    this.InceptionM.addActors(LeoNardoDiCaprioActor);
    this.InceptionM.addDirectors(ChristopherNolanDirector);
    this.InceptionM.setTitle(Inception);
    this.InceptionM.setAlias(xx05Alias);
    this.InceptionM.setReleaseYear(aInception);

    this.sameRefMedia = this.InceptionM;

    this.sameStateMedia = new Movie();
    this.sameStateMedia.addActors(LeoNardoDiCaprioActor);
    this.sameStateMedia.addDirectors(ChristopherNolanDirector);
    this.sameStateMedia.setTitle(Inception);
    this.sameStateMedia.setAlias(xx05Alias);
    this.sameStateMedia.setReleaseYear(aInception);

    this.yetAnotherMedia = new Movie();
    this.yetAnotherMedia.addActors(LeoNardoDiCaprioActor);
    this.yetAnotherMedia.addDirectors(ChristopherNolanDirector);
    this.yetAnotherMedia.setTitle(Inception);
    this.yetAnotherMedia.setAlias(xx05Alias);
    this.yetAnotherMedia.setReleaseYear(aInception);

    this.diffMedia = new Movie();
    this.diffMedia.addActors(FionnWhiteHeadActor);
    this.diffMedia.addDirectors(ChristopherNolanDirector);
    this.diffMedia.setAlias(xx04Alias);
    this.diffMedia.setTitle(Dunkirk);
    this.diffMedia.setReleaseYear(aDunkirk);

    this.nullMedia = null;

  }
}