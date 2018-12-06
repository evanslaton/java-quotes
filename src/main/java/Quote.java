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

    public String toString() {
        return this.text + " --" + this.author;
    }
}
