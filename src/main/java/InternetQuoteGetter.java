import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

// Gets a random quote from the internet and returns it as an instance of Quote
public class InternetQuoteGetter {

    // Converts the internet quote to an instance of Quote
    public static Quote getInternetQuote() throws IOException {
        String randomQuote = getRandomQuoteFromInternet();
        String author = getInternetQuoteAuthor(randomQuote);
        String text = getInternetQuoteText(randomQuote);
        String[] tags = new String[0];
        Quote quote = new Quote(tags, author, "0 likes", text);
        return quote;
    }

    // Gets a random quotes from the Formismatic API
    protected static String getRandomQuoteFromInternet() throws IOException {
        // Sends a GET request to Formismatic
        URL url = new URL("http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Saves the response as a string
        BufferedReader response = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String responseToString = response.readLine();

        // Closes the connection
        response.close();
        connection.disconnect();
        return responseToString;
    }

    // Gets the internet quote's author
    protected static String getInternetQuoteAuthor(String internetQuote) {
        return internetQuote.split("\",")[1].split(":\"")[1];
    }

    // Gets the internet quote's text
    protected static String getInternetQuoteText(String internetQuote) {
        return internetQuote.split("\",")[0].split(":\"")[1];
    }
}
