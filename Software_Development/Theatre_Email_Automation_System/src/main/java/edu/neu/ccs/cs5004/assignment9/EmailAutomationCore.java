package edu.neu.ccs.cs5004.assignment9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


/**
 * email automation core.
 */
public class EmailAutomationCore {
  private ArrayList<IndividualInfo> infoList;
  private String destDir;
  private String emailTemplateSrc;
  private String letterTemplateSrc;
  private boolean printEmail;

  public static final String MANUAL = "Usage:\n"
      + "\n"
      + "    --email                        only generate email messages\n"
      + "    --email-template <file>        accepts a filename "
      + "that holds the email template.\n"
      + "                                   Required if --email is used\n"
      + "\n"
      + "    --letter                       only generate letters\n"
      + "    --letter-template <file>       accepts a filename "
      + "that holds the email template.\n"
      + "                                   Required if --letter is used\n"
      + "\n"
      + "    --output-dir <path>            accepts the name of a folder, "
      + "all output is placed in this folder\n"
      + "\n"
      + "    --csv-file <path>              accepts the name of the csv file "
      + "to process\n\n"
      + "Examples:\n\n"
      + "    --email --email-template email-template.txt "
      + "--output-dir emails --csv-file customer.csv\n"
      + "    --letter --letter-template letter-template.txt "
      + "--output-dir letters --csv-file customer.csv\n";


  /**
   * construct email automation core.
   * @param args input
   */
  public EmailAutomationCore(String[] args) {
    emailTemplateSrc = "default-email-template.txt";
    letterTemplateSrc = "N/A";
    printEmail = true;
    infoList = new ArrayList<>();

    inputHandler(args);
  }

  /**
   * start the program.
   */
  public void process() {
    // generate template
    System.out.println("Loading template.");
    ArrayList<String> template;
    if (printEmail) {
      template = FileReader.read(emailTemplateSrc);
    } else {
      template = FileReader.read(letterTemplateSrc);
    }
    System.out.println("Template loaded.");

    System.out.println("Generating message for all users.");
    infoList.forEach(person -> {
      // generate message for this person
      Pattern pattern = Pattern.compile("(\\[\\[)([^]]*)(]])");
      List<String> message = template.stream()
          .map(line -> {
            Matcher matcher = pattern.matcher(line);
            String output = line;
            while (matcher.find()) {
              output = matcher.replaceFirst(person.get(matcher.group(2)));
              matcher = pattern.matcher(output);
            }
            return output;
          }).collect(Collectors.toList());

      // write message to target directory
      FileWriter.write(message, destDir, person.generateFileName());
    });
    System.out.println("Message generated for all users.");
  }


  /**
   * handles string array input.
   * @param args input
   */
  private void inputHandler(String[] args) {
    if (Arrays.stream(args).noneMatch(string -> string.equals("--csv-file"))
        || Arrays.stream(args).noneMatch(string -> string.equals("--output-dir"))) {
      throw new InvalidInputException(
          "\nError: --csv-file or --output-dir missing.\n" + MANUAL);
    }

    for (int i = 0; i < args.length; i++) {
      if (args[i].equals("--csv-file")) {
        i++;
        individualInfoLoader(args[i]);
        continue;
      }

      if (args[i].equals("--output-dir")) {
        i++;
        destDir = args[i];
        continue;
      }

      if (args[i].equals("--email-template")) {
        if (Arrays.stream(args).anyMatch(string -> string.equals("--email"))) {
          i++;
          emailTemplateSrc = args[i];
          continue;
        } else  {
          throw new InvalidInputException(
              "\nError: --email-template provided but no "
                  + "--email was given.\n" + MANUAL);
        }
      }

      if (args[i].equals("--letter-template")) {
        if (Arrays.stream(args).anyMatch(string -> string.equals("--letter"))) {
          i++;
          letterTemplateSrc = args[i];
          continue;
        } else {
          throw new InvalidInputException(
              "\nError: --letter-template provided but no "
                  + "--letter was given.\n" + MANUAL);
        }
      }

      if (args[i].equals("--email")) {
        if (Arrays.stream(args).anyMatch(
            string -> string.equals("--email-template"))) {
          printEmail = true;
        } else {
          throw new InvalidInputException("\nError: --email provided but no "
              + "--email-template was given.\n" + MANUAL);
        }
      }

      if (args[i].equals("--letter")) {
        if (Arrays.stream(args).anyMatch(
            string -> string.equals("--letter-template"))) {
          printEmail = false;
        } else {
          throw new InvalidInputException("\nError: --letter provided but no "
              + "--letter-template was given.\n" + MANUAL);
        }
      }
    }
  }

  /**
   * load info to infoList.
   * @param csvFile info src file
   */
  private void individualInfoLoader(String csvFile) {
    ArrayList<String> info = FileReader.read(csvFile);
    String cvsSplitBy = ",";

    info.forEach(line -> {
      if (line.contains("first_name")) {
        System.out.println("first_name detected! could be header. line skipped.");
        return;
      }
      try {
        line = line.replace("\"", "");
        infoList.add(new IndividualInfo(line.split(cvsSplitBy)));
      } catch (ArrayIndexOutOfBoundsException aobe) {
        System.out.println("unrecognized line detected in csv file. "
            + "could be an empty line at the end of file. line skipped. "
            + "please check csv file.");
      }
    });
  }
}
