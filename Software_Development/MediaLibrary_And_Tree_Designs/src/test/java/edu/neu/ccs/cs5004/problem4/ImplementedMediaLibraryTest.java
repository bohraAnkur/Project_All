package edu.neu.ccs.cs5004.problem4;

import edu.neu.ccs.cs5004.problem4.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ImplementedMediaLibraryTest {

  private String storm;
  private String reid;
  private Name stormReid;
  private Actor stormReidActor;


  private String oprah;
  private String winfrey;
  private Name oprahWinfrey;
  private Actor oprahWinfreyActor;


  private String reese;
  private String WitherSpoon;
  private Name reeseWitherSpoon;
  private Actor reeseWitherSpoonActor;


  private String mindy;
  private String kaling;
  private Name mindyKaling;
  private Actor mindyKalingActor;


  private String ava;
  private String duVernay;
  private Name avaDuvernay;
  private Director avaDuvernayDirector;

  private String xx01;
  private Alias xx01Alias;

  private Integer releaseAWrinkleInTime;
  private ReleaseYear AWrinkleInTime;

  private String TitleWrinkle;
  private Title WrinkleInTimeTitle;

  private Media AWrinkleInTimeM;

  //////////////////////////////////////

  private String bradley;
  private String cooper;
  private Name bradleyCooper;
  private Actor bradleyCooperActor;

  private String Anna;
  private String Friel;
  private Name annaFriel;
  private Actor annaFrielActor;

  private String neil;
  private String burger;
  private Name neilBurger;
  private Director neilBurgerDirector;

  private String xx02;
  private Alias xx02Alias;

  private Integer releaseLimitless;
  private ReleaseYear aLimitLess;

  private String limitLess;
  private Title limitLessTitle;

  private Media limitLessM;

  ///////////////////////////////////

  private String Christopher;
  private String Nolan;
  private Name ChristopherNolan;
  private Director ChristopherNolanDirector;

  private String Matthew;
  private String McConaughey;
  private Name MatthewMcConaughey;
  private Actor MatthewMcConaugheyActor;

  private String xx03;
  private Alias xx03Alias;

  private Integer releaseInterstellar;
  private ReleaseYear aInterStellar;

  private String InterStellar;
  private Title InterStellarTitle;

  private Media InterStellarM;

  //////////////////////////////////////

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

  private Media DunkirkM;

  //////////////////////////////////////
  private String LeoNardo;
  private String DiCaprio;
  private Name LeoNardoDiCaprio;
  private Actor LeoNardoDiCaprioActor;

  private String xx05;
  private Alias xx05Alias;

  private Integer releaseInception;
  private ReleaseYear aInception;

  private String inception;
  private Title Inception;

  private Media InceptionM;

  private MediaLibrary mediaLibrary;
  private MediaLibrary sameRefLibrary;
  private MediaLibrary sameStateLibrary;
  private MediaLibrary yetAnotherLibrary;
  private MediaLibrary differentLibrary;
  private MediaLibrary nullLibrary;


  @Before
  public void setUp() throws Exception {
    this.storm = "stormm";
    this.reid = "reid";
    this.stormReid = new Name(this.storm, this.reid);
    this.stormReidActor = new Actor(stormReid);

    this.oprah = "oprah";
    this.winfrey = "winfrey";
    this.oprahWinfrey = new Name(oprah, winfrey);
    this.oprahWinfreyActor = new Actor(oprahWinfrey);


    this.reese = "reese";
    this.WitherSpoon = "WitherSpoon";
    this.reeseWitherSpoon = new Name(reese, WitherSpoon);
    this.reeseWitherSpoonActor = new Actor(reeseWitherSpoon);


    this.mindy = "mindy";
    this.kaling = "kaling";
    this.mindyKaling = new Name(mindy, kaling);
    this.mindyKalingActor = new Actor(mindyKaling);


    this.ava = "ava";
    this.duVernay = "duVernay";
    this.avaDuvernay = new Name(ava, duVernay);
    this.avaDuvernayDirector = new Director(avaDuvernay);

    this.xx01 = "xx01";
    this.xx01Alias = new Alias(xx01);

    this.releaseAWrinkleInTime = 2018;
    this.AWrinkleInTime = new ReleaseYear(releaseAWrinkleInTime);

    this.TitleWrinkle = "A Wrinkle in Time";
    this.WrinkleInTimeTitle = new Title(TitleWrinkle);

    this.AWrinkleInTimeM = new Movie();
    this.AWrinkleInTimeM.addActors(stormReidActor);
    this.AWrinkleInTimeM.addActors(oprahWinfreyActor);
    this.AWrinkleInTimeM.addActors(reeseWitherSpoonActor);
    this.AWrinkleInTimeM.addActors(mindyKalingActor);
    this.AWrinkleInTimeM.addDirectors(avaDuvernayDirector);
    this.AWrinkleInTimeM.setAlias(xx01Alias);
    this.AWrinkleInTimeM.setTitle(WrinkleInTimeTitle);
    this.AWrinkleInTimeM.setReleaseYear(AWrinkleInTime);

    //////////////////////////////////

    this.bradley = "bradley";
    this.cooper = "cooper";
    this.bradleyCooper = new Name(bradley, cooper);
    this.bradleyCooperActor = new Actor(bradleyCooper);

    this.Anna = "Anna";
    this.Friel = "Friel";
    this.annaFriel = new Name(Anna, Friel);
    this.annaFrielActor = new Actor(annaFriel);

    this.neil = "neil";
    this.burger = "burger";
    this.neilBurger = new Name(neil, burger);
    this.neilBurgerDirector = new Director(neilBurger);

    this.xx02 = "xx02";
    this.xx02Alias = new Alias(xx02);

    this.releaseLimitless = 2017;
    this.aLimitLess = new ReleaseYear(releaseLimitless);

    this.limitLess = "LimitLess";
    this.limitLessTitle = new Title(limitLess);

    this.limitLessM = new Movie();

    this.limitLessM.addActors(bradleyCooperActor);
    this.limitLessM.addActors(annaFrielActor);
    this.limitLessM.addDirectors(neilBurgerDirector);

    this.limitLessM.setAlias(xx02Alias);
    this.limitLessM.setTitle(limitLessTitle);
    this.limitLessM.setReleaseYear(aLimitLess);

    ///////////////////////////////

    this.Christopher = "Christopher";
    this.Nolan = "Nolan";
    this.ChristopherNolan = new Name(Christopher, Nolan);
    this.ChristopherNolanDirector = new Director(ChristopherNolan);

    this.Matthew = "Matthew";
    this.McConaughey = "McConaughey";
    this.MatthewMcConaughey = new Name(Matthew, McConaughey);
    this.MatthewMcConaugheyActor = new Actor(MatthewMcConaughey);

    this.xx03 = "xx03";
    this.xx03Alias = new Alias(xx03);

    this.releaseInterstellar = 2014;
    this.aInterStellar = new ReleaseYear(releaseInterstellar);

    this.InterStellar = "InterStellar";
    this.InterStellarTitle = new Title(InterStellar);

    this.InterStellarM = new Movie();
    this.InterStellarM.addActors(MatthewMcConaugheyActor);
    this.InterStellarM.addDirectors(ChristopherNolanDirector);
    this.InterStellarM.setTitle(InterStellarTitle);
    this.InterStellarM.setAlias(xx03Alias);
    this.InterStellarM.setReleaseYear(aInterStellar);

    /////////////////////////
    this.Fionn = "Fionn";
    this.WhiteHead = "WhiteHead";
    this.FionnWhiteHead = new Name(Fionn, WhiteHead);
    this.FionnWhiteHeadActor = new Actor(FionnWhiteHead);

    this.xx04 = "xx04";
    this.xx04Alias = new Alias(xx04);

    this.releaseDunkirk = 2017;
    this.aDunkirk = new ReleaseYear(releaseDunkirk);

    this.dunkirk = "Dunkirk";
    this.Dunkirk = new Title(dunkirk);

    this.DunkirkM = new Movie();
    this.DunkirkM.addActors(FionnWhiteHeadActor);
    this.DunkirkM.addDirectors(ChristopherNolanDirector);
    this.DunkirkM.setAlias(xx04Alias);
    this.DunkirkM.setTitle(Dunkirk);
    this.DunkirkM.setReleaseYear(aDunkirk);

    ////////////////////////////

    this.LeoNardo = "LeoNardo";
    this.DiCaprio = "DiCaprio";
    this.LeoNardoDiCaprio = new Name(LeoNardo, DiCaprio);
    this.LeoNardoDiCaprioActor = new Actor(LeoNardoDiCaprio);

    this.xx05 = "xx05";
    this.xx05Alias = new Alias(xx05);

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


    this.mediaLibrary = new ImplementedMediaLibrary();
    this.mediaLibrary.add(AWrinkleInTimeM);
    this.mediaLibrary.add(limitLessM);
    this.mediaLibrary.add(DunkirkM);
    this.mediaLibrary.add(InceptionM);
    this.mediaLibrary.add(InterStellarM);

    this.sameRefLibrary = this.mediaLibrary;

    this.sameStateLibrary = new ImplementedMediaLibrary();
    this.sameStateLibrary.add(AWrinkleInTimeM);
    this.sameStateLibrary.add(limitLessM);
    this.sameStateLibrary.add(DunkirkM);
    this.sameStateLibrary.add(InceptionM);
    this.sameStateLibrary.add(InterStellarM);

    this.yetAnotherLibrary = new ImplementedMediaLibrary();
    this.yetAnotherLibrary.add(AWrinkleInTimeM);
    this.yetAnotherLibrary.add(limitLessM);
    this.yetAnotherLibrary.add(DunkirkM);
    this.yetAnotherLibrary.add(InceptionM);
    this.yetAnotherLibrary.add(InterStellarM);

    this.differentLibrary = new ImplementedMediaLibrary();
    this.differentLibrary.add(AWrinkleInTimeM);
    this.differentLibrary.add(limitLessM);

    this.nullLibrary = null;


  }

  @Test
  public void search() {
    ArrayList<Media> list = new ArrayList<>();
    list.add(this.AWrinkleInTimeM);
    Assert.assertEquals(list, this.mediaLibrary.search(avaDuvernayDirector));

    ArrayList<Media> listnew = new ArrayList<>();
    listnew.add(this.limitLessM);

    Assert.assertEquals(listnew, this.mediaLibrary.search(this.neilBurgerDirector));

    ArrayList<Media> listneew = new ArrayList<>();
    listneew.add(this.InceptionM);
    listneew.add(this.InterStellarM);
    listneew.add(this.DunkirkM);
    Assert.assertEquals(listneew, this.mediaLibrary.search(ChristopherNolanDirector));


  }

  @Test
  public void add() {
    ArrayList<Media> listneew = new ArrayList<>();
    listneew.add(this.InceptionM);
    listneew.add(this.InterStellarM);
    listneew.add(this.DunkirkM);
    Assert.assertEquals(listneew, this.mediaLibrary.search(ChristopherNolanDirector));
  }

  @Test
  public void requestStreaming() {
    this.mediaLibrary.requestStreaming(xx01Alias);
    this.mediaLibrary.requestStreaming(xx01Alias);
    this.mediaLibrary.requestStreaming(xx01Alias);
    Assert.assertEquals(3, this.mediaLibrary.getStatistics(xx01Alias));


  }

  @Test
  public void getStatistics() {
    this.mediaLibrary.requestStreaming(xx04Alias);
    Assert.assertEquals(1, this.mediaLibrary.getStatistics(xx04Alias));
  }

  @Test
  public void mostStreamed() {
    this.mediaLibrary.requestStreaming(xx01Alias);
    this.mediaLibrary.requestStreaming(xx01Alias);
    this.mediaLibrary.requestStreaming(xx01Alias);
    this.mediaLibrary.requestStreaming(xx04Alias);
    this.mediaLibrary.requestStreaming(xx02Alias);
    this.mediaLibrary.requestStreaming(xx02Alias);
    this.mediaLibrary.requestStreaming(xx02Alias);
    this.mediaLibrary.requestStreaming(xx02Alias);
    this.mediaLibrary.requestStreaming(xx02Alias);
    Assert.assertEquals(limitLessM, this.mediaLibrary.mostStreamed());
  }

  @Test
  public void equals() {

    Assert.assertEquals(this.mediaLibrary,this.sameRefLibrary);

    Assert.assertEquals(this.mediaLibrary,this.sameStateLibrary);

    Assert.assertEquals(this.sameStateLibrary,this.mediaLibrary);

    Assert.assertEquals(this.mediaLibrary.equals(this.sameStateLibrary)
            &&
                    this.sameStateLibrary.equals(this.yetAnotherLibrary),
            this.mediaLibrary.equals(this.yetAnotherLibrary));

    Assert.assertFalse(this.mediaLibrary.equals("B"));

    Assert.assertFalse(this.mediaLibrary.equals(nullLibrary));

    Assert.assertFalse(this.mediaLibrary.equals(null));

  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(this.mediaLibrary.hashCode(),this.sameRefLibrary.hashCode());
    Assert.assertEquals(this.mediaLibrary.hashCode(),this.sameStateLibrary.hashCode());

  }
}