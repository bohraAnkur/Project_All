package edu.neu.ccs.cs5004.assignment8;

/**
 * recommendation system.
 */
public class RecommendationSystem {
  /**
   * recommendation system. flag option: e, s, r. run time: O(n).
   * NumberofUserToProcess: [1,100].
   * NumberofRecommendation: [1,100].
   * @param args nodeFile edgeFile destFile flag NumberofUsersToProcess NumberofRecommendation
   */
  public static void main(String[] args) {
    String nodeFile;
    String edgeFile;
    String destFile;

    try {
      nodeFile = args[0];
      edgeFile = args[1];
      destFile = args[2];
    } catch (ArrayIndexOutOfBoundsException exp) {
      throw new InvalidInputException("Invalid input. Three parameters required (source node, "
          + "source edge, and dest output).");
    }

    Flag processingFlag = Flag.s;
    Integer numberOfUsersToProcess = 50;
    Integer numberOfRecommendations = 15;

    try {
      switch (args[3]) {
        case "s":
          processingFlag = Flag.s;
          break;
        case "e":
          processingFlag = Flag.e;
          break;
        case "r":
          processingFlag = Flag.r;
          break;
        default:
          throw new InvalidInputException("invalid 4th input. input option: s, e, r.");
      }
    } catch (ArrayIndexOutOfBoundsException exp) {
      System.out.println("no 4th input. default: s");
    } catch (InvalidInputException iie) {
      throw new InvalidInputException(iie.getMessage());
    }

    try {
      numberOfUsersToProcess = Integer.valueOf(args[4]);
      if (numberOfUsersToProcess < 1 || numberOfUsersToProcess > 100) {
        throw new InvalidInputException("invalid 5th input. input option: [1,100]");
      }
    } catch (ArrayIndexOutOfBoundsException exp) {
      System.out.println("no 5th input. default: 50");
    } catch (InvalidInputException iie) {
      throw new InvalidInputException(iie.getMessage());
    }

    try {
      numberOfRecommendations = Integer.valueOf(args[5]);
      if (numberOfRecommendations < 1 || numberOfRecommendations > 100) {
        throw new InvalidInputException("invalid 6th input. input option: [1,100]");
      }
    } catch (ArrayIndexOutOfBoundsException exp) {
      System.out.println("no 6th input. default: 15");
    } catch (InvalidInputException iie) {
      throw new InvalidInputException(iie.getMessage());
    }

    RecommendationSystemCore core = new ARecommendationSystemCore(nodeFile,
        edgeFile, destFile, processingFlag,
        numberOfUsersToProcess, numberOfRecommendations);

    core.process();
  }
}
