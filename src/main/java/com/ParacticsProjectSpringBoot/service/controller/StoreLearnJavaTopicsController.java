package com.ParacticsProjectSpringBoot.service.controller;

import com.ParacticsProjectSpringBoot.service.entity.StoreLearnJavaTopics;
import com.ParacticsProjectSpringBoot.service.service.StoreLearnJavaTopicsService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/LearnJava")
public class StoreLearnJavaTopicsController {

    @Autowired
    StoreLearnJavaTopicsService storeLearnJavaTopicsService;

    @PostMapping(path = "/storeData")
    public String storeData(@RequestBody Map<String, Map<String, List<String>>> requestBody){
        List<StoreLearnJavaTopics> storeLearnJavaTopicsList = new ArrayList<>();
        // Iterate over categories and topics in the JSON request
        String ulr = "http://localhost:8081/CoreJava/";
        requestBody.forEach((category, content) -> {
            List<String> topicNames = content.get("topics");
            if (topicNames != null) {
                for (String topicName : topicNames) {
                    StoreLearnJavaTopics storeLearnJavaTopics = new StoreLearnJavaTopics();
                    storeLearnJavaTopics.setName(topicName);
                    storeLearnJavaTopics.setCategory(category);
                    String pageUrl= topicName.replaceAll(" ", "-");
                    storeLearnJavaTopics.setTopicUrl(ulr+pageUrl+".html");
                    storeLearnJavaTopicsList.add(storeLearnJavaTopics);
                }
            }
        });

        // Save topics to the database
        Boolean storeSuccessfully= storeLearnJavaTopicsService.storeData(storeLearnJavaTopicsList);
        if(storeSuccessfully){
            return "Topics saved successfull";
        }else {
            return "Topics saved failed";
        }
    }

    // Endpoint to fetch all topics
    @GetMapping("/fetchAll")
    public List<StoreLearnJavaTopics> getAllTopics() {
        return storeLearnJavaTopicsService.getAllTopics();
    }

    // Endpoint to generate html file based on topics
    @GetMapping("/generateHtml")
    public List<StoreLearnJavaTopics> generateHtml() {
        String SAVE_PATH = "D:\\spring projects\\PracticeProjectSpringBoot\\PracticeProjectSpringBoot\\src\\main\\resources\\static\\CoreJava";

        List<StoreLearnJavaTopics> topics = storeLearnJavaTopicsService.getAllTopics();

        for (StoreLearnJavaTopics topic : topics) {
            String fileName = topic.getName().replaceAll(" ", "-") + ".html"; // Sanitize the file name
            File file = new File(SAVE_PATH, fileName);

            // Check if the file already exists
            if (file.exists()) {
                System.out.println("File " + fileName + " already exists. Skipping creation.");
                continue;
            }

            try (FileWriter writer = new FileWriter(file)) {
                writer.write("<!DOCTYPE html>\n");
                writer.write("<html lang=\"en\">\n");
                writer.write("<head>\n");
                writer.write("    <meta charset=\"UTF-8\">\n");
                writer.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
                writer.write("    <title>Learn Java</title>\n");
                writer.write("    <link rel=\"stylesheet\" href=\"/css/styles.css\">\n");
                writer.write("    <link rel=\"stylesheet\" href=\"/css/corejava.css\">\n");
                writer.write("</head>\n");
                writer.write("<body>\n");

                // Navbar section
                writer.write("<!-- Navbar -->\n");
                writer.write("<nav class=\"navbar\">\n");
                writer.write("    <div class=\"navbar-left\">\n");
                writer.write("        <a href=\"#\" class=\"logo\">♨️Learn Java</a>\n");
                writer.write("    </div>\n");
                writer.write("    <div class=\"navbar-center\">\n");
                writer.write("        <a href=\"#\">Category</a>\n");
                writer.write("        <a href=\"#\">About</a>\n");
                writer.write("        <a href=\"#\">Contact</a>\n");
                writer.write("    </div>\n");
                writer.write("    <div class=\"navbar-right\">\n");
                writer.write("        <button class=\"login-btn\">Login</button>\n");
                writer.write("    </div>\n");
                writer.write("</nav>\n");

                // Main content section
                writer.write("</div>");
                writer.write("<div class=\"selectRiderForm\">\n");
                writer.write("    <ul class=\"sortable-list\">\n");
                writer.write("        <!-- List items will be generated here -->\n");
                writer.write("    </ul>\n");
                writer.write("</div>\n");

                // Middle content section
                writer.write("<div class=\"mainSection\">");
                writer.write("<div class=\"w3-example\">");
                writer.write("<h2>Java Tutorial</h2>");
                writer.write("<div class=\"w3-code notranslate htmlHigh\">");
                writer.write("</div>");
                writer.write("</div>");
                writer.write("</div>");
                writer.write("</div>");

                // Footer section
                writer.write("<!-- Footer -->\n");
                writer.write("<footer>\n");
                writer.write("    <p>&copy; 2024 Learn Java - All rights reserved.</p>\n");
                writer.write("</footer>\n");

                // JavaScript inclusion
                writer.write("<!-- JavaScript -->\n");
                writer.write("<script src=\"/Javascript/scripts.js\"></script>\n");

                writer.write("</body>\n");
                writer.write("</html>");
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace(); // Handle exceptions properly in real scenarios
            }
        }

        // Return the list of topics after generating HTML files
        return topics;
    }


    @DeleteMapping("/truncate")
    public String truncateTable() {
        // Truncate the database table
        storeLearnJavaTopicsService.truncateTopicsTable();

        // Directory path where the .html files are stored
        String SAVE_PATH = "D:\\spring projects\\PracticeProjectSpringBoot\\PracticeProjectSpringBoot\\src\\main\\resources\\static\\CoreJava";

        // Initialize a set to track unique file names (excluding duplicates)
        Set<String> uniqueFileNames = new HashSet<>();

        // Directory where the .html files are stored
        File directory = new File(SAVE_PATH);

        // Check if the directory exists and is a directory
        if (directory.exists() && directory.isDirectory()) {
            // Get all files in the directory with .html extension
            File[] files = directory.listFiles((dir, name) -> name.toLowerCase().endsWith(".html"));

            if (files != null) {
                for (File file : files) {
                    // If the file name is already in the set, delete it as a duplicate
                    if (uniqueFileNames.contains(file.getName())) {
                        if (file.delete()) {
                            System.out.println(file.getName() + " (duplicate) deleted successfully.");
                        } else {
                            System.out.println("Failed to delete " + file.getName());
                        }
                    } else {
                        // Add unique file name to the set
                        uniqueFileNames.add(file.getName());
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist or is not a directory.");
        }

        return "Table truncated and duplicate HTML files deleted successfully";
    }


    @GetMapping("/files")
    public List<String> getFileNames() throws IOException {
      String SAVE_PATH = "D:\\spring projects\\PracticeProjectSpringBoot\\PracticeProjectSpringBoot\\src\\main\\resources\\static\\CoreJava";

        Path dirPath = Paths.get(SAVE_PATH);
        // Using Files.list to fetch all files in the directory
        try (var paths = Files.list(dirPath)) {
            return paths.filter(Files::isRegularFile) // Filters to get only regular files (ignores directories)
                    .map(Path::getFileName)       // Gets the filename
                    .map(Path::toString)          // Converts Path to String
                    .collect(Collectors.toList()); // Collects the names into a List
        }
    }

}

