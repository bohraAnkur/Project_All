package edu.neu.ccs.cs5004.assignment8;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class RecommendationSystemTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void main() {
    String str = "nodes_small.csv edges_small.csv output.csv e 20 20";
    String[] args = str.split(" ");
    RecommendationSystem.main(args);

    str = "nodes_small.csv edges_small.csv";
    boolean thrown = false;
    try {
      RecommendationSystem.main(str.split(" "));
    } catch (InvalidInputException e) {
      thrown = true;
    }
    Assert.assertTrue(thrown);

    str = "nodes_small.csv edges_small.csv output.csv a 20 20";
    thrown = false;
    try {
      RecommendationSystem.main(str.split(" "));
    } catch (InvalidInputException e) {
      thrown = true;
    }
    Assert.assertTrue(thrown);

    str = "nodes_small.csv edges_small.csv output.csv s 200 20";
    thrown = false;
    try {
      RecommendationSystem.main(str.split(" "));
    } catch (InvalidInputException e) {
      thrown = true;
    }
    Assert.assertTrue(thrown);

    str = "nodes_small.csv edges_small.csv output.csv s 20 200";
    thrown = false;
    try {
      RecommendationSystem.main(str.split(" "));
    } catch (InvalidInputException e) {
      thrown = true;
    }
    Assert.assertTrue(thrown);

    str = "nodes_small.csv edges_small.csv output.csv";
    RecommendationSystem.main(str.split(" "));
    str = "nodes_small.csv edges_small.csv output.csv s";
    RecommendationSystem.main(str.split(" "));
    str = "nodes_small.csv edges_small.csv output.csv r 20";
    RecommendationSystem.main(str.split(" "));
    str = "nodes_10000.csv edges_10000.csv output.csv e";
    RecommendationSystem.main(str.split(" "));
    str = "nodes_10000.csv edges_10000.csv output.csv s";
    RecommendationSystem.main(str.split(" "));
    str = "nodes_10000.csv edges_10000.csv output.csv r";
    RecommendationSystem.main(str.split(" "));
  }
}