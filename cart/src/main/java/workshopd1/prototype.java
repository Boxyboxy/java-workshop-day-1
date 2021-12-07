package workshopd1;

import java.util.*;
import java.io.*;
import java.nio.file.*;

public class prototype {
  public static void main(String[] args) {

    String dirName;
    if (args.length == 0) {
      dirName = "db";
    } else {
      dirName = args[0];
    }
    // instantiate path
    Path path = Paths.get(dirName);
    // if directory exists
    if (Files.isDirectory(path)) {

    } else { // create directory if it doesnt exist

      try {
        Files.createDirectories(path);
      } catch (IOException e) {
        System.err.println("Failed to create directory!" + e.getMessage());
      }
    }

    Console cons = System.console();
    boolean running = true;

    while (running) {

      System.out.print("Please enter a line >>");
      Scanner sc = new Scanner(cons.readLine());
      String cmd = sc.next();

      if (cmd.equals("login")) {
        String username = sc.next();
        System.out.println(username);
        String userPath = dirName + "/" + username + ".db";

        // File userFile = new File(userPath);
        File userFile = Paths.get(userPath).toFile();
        try {
          if (userFile.createNewFile()) {
            System.out.println("File created: " + userFile.getName());
          } else {
            System.out.println("File already exists.");
          }
        } catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }

      }
    }

  }
}
