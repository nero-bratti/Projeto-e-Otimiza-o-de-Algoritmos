public class Karp {
    static int iterações = 0;

    public static void main(String[] args) {
        String s1 = "ABCDCBDCBDACBDABDCBADF", s2 = "ADF";

        System.out.println("\nImplementação com .regionMatches: ");
        System.out.println(findOccurrenceWithRegionMatches(s1,s2));

        System.out.println("\nImplementação com .equals: ");
        System.out.println(findOccurrence(s1,s2));

        System.out.println("\nImplementação com karp: ");
        System.out.println(karp(s2,s1));

        s1 = s1.substring(0,16).repeat(128) + s1.substring(19);

        System.out.println("\nImplementação com .regionMatches: ");
        System.out.println(findOccurrenceWithRegionMatches(s1,s2));

        System.out.println("\nImplementação com .equals: ");
        System.out.println(findOccurrence(s1,s2));

        System.out.println("\nImplementação com karp: ");
        System.out.println(karp(s2,s1));
    }
    public static String findOccurrenceWithRegionMatches(String s1, String s2) {
        iterações = 0;
        if (s1.contains(s2)) {
            for (int i = 0; i < s1.length() - 1; i++) {
                iterações++;
                if (s1.charAt(i) == s2.charAt(0)) {
                    if (s1.regionMatches(i,s2,0,s2.length())) return "Posição " + i
                             + " e " + iterações + " iterações.";
                }
            }
        }
        return "Não encontrado";
    }
    public static String findOccurrence(String s1, String s2) {
        iterações = 0;
        if (s1.contains(s2)) {
            for (int i = 0; i < s1.length() - 1; i++) {
                iterações++;
                if (s1.charAt(i) == s2.charAt(0)) {
                    if ((s1.substring(i)).equals(s2)) return "Posição " + i
                            + " e " + iterações + " iterações.";
                }
            }
        }
        return "Não encontrado";
    }
    private static String karp(String pat, String txt) {
        iterações = 0;
        int m = pat.length();
        int n = txt.length();
        long patHash = horner(pat, m);
        long txtHash = horner(txt.substring(0,m), m);

        for (int i = 0; i <= n - m; i++) {
            iterações++;
            //txtHash = txtHash -
            if (patHash == txtHash) {
                if (pat.equals(txt.substring(i))) {
                    return "Posição " + i
                            + " e " + iterações + " iterações.";
                }
            }
        }
        return "Não encontrado";
    }
    private static long betterHash() {
        return 0;
    }
    private static long horner(String s, int m) {
        long h = 0;
        for (int j = 0; j < m; j++) {
            iterações++;
            h = (h * 5 + s.charAt(j)) % 11;
        }
        return h;
    }
}