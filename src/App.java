public class App {
    public static void main(String[] args) {
        String ex1 = "AAAA";
        String ex2 = "ABCDE";
        String ex3 = "AABAACAABAA";
        String ex4 = "AAACAAAAAC";
        String ex5 = "AAABAAA";
        String pattern = "CAABA";

        String longString = "ABCAABCAABCAABCF";
        String longPattern = "ABCD";

        longString = longString.substring(0,16).repeat(2048) + longPattern;

        Knuth knuth = new Knuth();
        knuth.KMPSearch(longPattern,longString);
    }
}
