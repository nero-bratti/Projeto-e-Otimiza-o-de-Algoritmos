public class Karp {
    int iterations;
    int instructions;

    void clear() {
        iterations = 0;
        instructions = 0;
    }

    public String findOccurrenceWithRegionMatches(String s1, String s2) {
        iterations = 0;
        if (s1.contains(s2)) {
            for (int i = 0; i < s1.length() - 1; i++) {
                iterations++;
                if (s1.charAt(i) == s2.charAt(0)) {
                    if (s1.regionMatches(i,s2,0,s2.length())) return "Posição " + i
                             + " e " + iterations + " iterations.";
                }
            }
        }
        return "Não encontrado";
    }
    public String findOccurrence(String s1, String s2) {
        iterations = 0;
        if (s1.contains(s2)) {
            for (int i = 0; i < s1.length() - 1; i++) {
                iterations++;
                if (s1.charAt(i) == s2.charAt(0)) {
                    if ((s1.substring(i)).equals(s2)) return "Posição " + i
                            + " e " + iterations + " iterations.";
                }
            }
        }
        return "Não encontrado";
    }
    public void karp(String pat, String txt) {
        clear();        
        long time = System.nanoTime();
        iterations = 0;
        int m = pat.length();
        int n = txt.length();
        long patHash = horner(pat, m);
        long txtHash = horner(txt.substring(0,m), m);
        instructions = 4;
        for (int i = 0; i <= n - m; i++) {
            iterations++;
            txtHash = horner(txt.substring(i, i + m), m);
            instructions =+ 2;
            if (patHash == txtHash) {
                if (pat.equals(txt.substring(i))) {
                    time = System.nanoTime() - time;
                    System.out.println("Karp with txt size " + txt.length() + ": " + iterations + " iterations, " + instructions + 
                            " instructions and " + time + " nanoseconds.");
                }
            }
        }
    }
    public long horner(String s, int m) {
        long h = 0;
        for (int j = 0; j < m; j++) {
            iterations++;
            instructions++;
            h = (h * 5 + s.charAt(j)) % 11;
        }
        return h;
    }
}