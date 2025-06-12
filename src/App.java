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

        Karp karp = new Karp();
        karp.karp(pattern, ex3);
        karp.karp(longPattern,longString);

        Knuth knuth = new Knuth();
        knuth.KMPSearch(pattern, ex3);
        knuth.KMPSearch(longPattern,longString);

        
    }
}
