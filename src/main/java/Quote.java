public class Quote {

    protected String[] tags;
    protected String author;
    protected String likes;
    protected String text;

    public Quote (String[] tags, String author, String likes, String text) {
        this.tags = tags;
        this.author = author;
        this.likes = likes;
        this.text = text;
    }

    // this method prints a quote and author
    public String toString() {
        return this.text + " --" + this.author;
    }

    // this method searches the authors in a Quote[] and returns the quote
    public static String searchAuthor(Quote[] array, String name){
        for(int i = 0; i < array.length; i++) {
            if (array[i].author.contains(name)) {
                return array[i].toString();
            }
        }
        return name + " not found.";
    }

    // this method searches the Quote[] for any text that contains the input string and returns a quote
    public static String searchContains(Quote[] array, String contains) {
        for(int i = 0; i < array.length; i++) {
            if (array[i].text.contains(contains)) {
                return array[i].toString();
            }
        }
        return contains + " not found.";
    }
}
