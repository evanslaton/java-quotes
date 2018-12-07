public class Quote {

    protected String[] tags;
    protected String author;
    protected String likes;
    protected String text;

    // Constructor
    public Quote (String[] tags, String author, String likes, String text) {
        this.tags = tags;
        this.author = author;
        this.likes = likes;
        this.text = text;
    }

    // Returns a quote and its author
    public String toString() {
        return this.text + " --" + this.author;
    }

    // Returns the first quote from a specific author from an array of quotes
    public static String searchAuthor(Quote[] array, String name){
        for(int i = 0; i < array.length; i++) {
            if (array[i].author.contains(name)) {
                return array[i].toString();
            }
        }
        return name + " not found.";
    }

    // Returns the first quote that contains a specific word from an array of quotes
    public static String searchContains(Quote[] array, String contains) {
        for(int i = 0; i < array.length; i++) {
            if (array[i].text.contains(contains)) {
                return array[i].toString();
            }
        }
        return contains + " not found.";
    }
}
