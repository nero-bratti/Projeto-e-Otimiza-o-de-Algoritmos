class Knuth {
    int iterations;
    int instructions;

    void clear() {
        iterations = 0;
        instructions = 0;
    }

    void KMPSearch(String pat, String txt) {
        clear();        
        long time = System.nanoTime();
        int M = pat.length();
        int N = txt.length();

        // cria lps[] que vai guardar o maior
        // valor prefixo sufixo para o padrão
        int lps[] = new int[M];
        int j = 0; // index for pat[]

        // Calcula lps[]
        computeLPSArray(pat, M, lps);

        int i = 0; // index for txt[]

        instructions += 6;
        while (i < N) {
            iterations++;
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
                instructions += 3;
            }
            if (j == M) {
                j = lps[j - 1];
                instructions += 3;
            }

            // mismatch após j matches
            else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                // Não faz match dos caracteres lps[0..lps[j-1]],
                // não é necesssário, eles combinarão
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
                instructions += 3;
            }
        }
        time = System.nanoTime() - time;
        System.out.println("Knuth with txt size " + txt.length() + ": " + iterations + " iterations, " + instructions + 
                            " instructions and " + time + " nanoseconds.");
    }

    void computeLPSArray(String pat, int M, int lps[]) {
        // tamanho do maior prefixo sufixo anterior
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0
        instructions += 3;
        // loop calcula lps[i] for i = 1 to M-1
        while (i < M) {
            iterations++;
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
                instructions += 4;
            } else // (pat[i] != pat[len])
            {
                if (len != 0) {
                    len = lps[len - 1];
                    instructions += 3;
                } else // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                    instructions += 2;
                }
            }
        }
    }
}