import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

// Gets quotes from a json file and converts into an array of Quote instances
public class FileQuoteGetter {

    // Gets quotes from the file
    public Quote[] getFileQuotes(Path path) {
        BufferedReader quotesJson = readJsonFile(path);
        Quote[] quotes = parseJson(quotesJson);
        return quotes;
    }

    // Reads and returns a json file
    public static BufferedReader readJsonFile(Path path) {
        try {
            BufferedReader file = Files.newBufferedReader(path);
            return file;
        } catch (IOException error) {
            System.err.format("IOException: %s%n", error);
        }
        return null;
    }

    // Parses a json file using gson and returns an array of Quote instances
    public static Quote[] parseJson(BufferedReader file) {
        Gson gson = new Gson();
        return gson.fromJson(file, Quote[].class);
    }

    // Gets a random number
    public static int getRandomNumber(int number) {
        return (int) Math.floor(Math.random() * number);
    }
}
