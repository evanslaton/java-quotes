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

    public static String searchAuthor(Quote[] array, String name){
        System.out.println("######################");
        for(int i = 0; i < array.length; i++) {
            if (array[i].author == name) {
                return array[i].toString();
            }
//            System.out.println("IN FOR LOoP");
        }
        return name + " not found.";
    }

    public static String searchContains(Quote[] array, String contains) {
        for(int i = 0; i < array.length; i++) {
            if (array[i].text.contains(contains)) {
                return array[i].toString();
            }
        }
        return contains + " not found.";
    }
}
