import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class App {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {
        System.out.println(readFile()[0].toString());
    }

    //method to read the the JSON file 
    public static Quote[] readFile() {
        Path file = Paths.get("./resources/recentquotes.json");
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            Gson gson = new Gson();
            Quote[] response = gson.fromJson(reader, Quote[].class);
            return response;
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        return null;
    }

    // Gets a random number
}
