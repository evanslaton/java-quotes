import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

// Gets quotes from a json file and converts into an array of Quote instances
public class FileQuoteGetter {

    // Gets a random quote from the quote file
    public static Quote getRandomQuote(Path path) throws IOException {
        Quote[] quotes = getFileQuotes(path);
        int randomNumber = getRandomNumber(quotes.length);
        return quotes[randomNumber];
    }

    // Gets quotes from the quote file
    public static Quote[] getFileQuotes(Path path) throws IOException {
        BufferedReader quotesJson = readJsonFile(path);
        Quote[] quotes = parseJson(quotesJson);
        return quotes;
    }

    // Reads and returns a json file
    public static BufferedReader readJsonFile(Path path) throws IOException {
        BufferedReader file = Files.newBufferedReader(path);
        return file;
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
