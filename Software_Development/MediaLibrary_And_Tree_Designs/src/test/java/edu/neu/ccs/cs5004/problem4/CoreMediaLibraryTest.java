package edu.neu.ccs.cs5004.problem4;

import edu.neu.ccs.cs5004.problem4.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CoreMediaLibraryTest {

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
  private Media sameRefMedia;
  private Media sameStateMedia;
  private Media yetAnotherMedia;
  private Media diffMedia;
  private Media nullMedia;

  private ICoreMediaLibrary CoreMediaLibrary;

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

    this.limitLessM = new TvSeries();

    this.limitLessM.addActors(bradleyCooperActor);
    this.limitLessM.addActors(annaFrielActor);

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

    this.DunkirkM = new TvSeries();
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

    this.diffMedia = new TvSeries();
    this.diffMedia.addActors(FionnWhiteHeadActor);
    this.diffMedia.addDirectors(ChristopherNolanDirector);
    this.diffMedia.setAlias(xx04Alias);
    this.diffMedia.setTitle(Dunkirk);
    this.diffMedia.setReleaseYear(aDunkirk);

    this.nullMedia = null;
    ///////////////////////////////

    this.CoreMediaLibrary = ICoreMediaLibrary.createCoreMediaLibrary();

  }

  @Test
  public void addCoreMedia() {
    Assert.assertTrue(this.CoreMediaLibrary.addCoreMedia(InceptionM));
    Assert.assertTrue(this.CoreMediaLibrary.addCoreMedia(DunkirkM));
    Assert.assertTrue(this.CoreMediaLibrary.addCoreMedia(InterStellarM));
    Assert.assertTrue(this.CoreMediaLibrary.addCoreMedia(limitLessM));
    Assert.assertTrue(this.CoreMediaLibrary.addCoreMedia(AWrinkleInTimeM));







    }

}