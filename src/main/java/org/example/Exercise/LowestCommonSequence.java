package org.example.Exercise;

public class LowestCommonSequence {

    static int LCS(char[] chars1, char[] chars2, int m, int n) {
        int[][] lcs = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) { //condition to set the pointer to index zero;
                    lcs[i][j] = 0;

                } else if (chars1[i - 1] == chars2[j - 1]) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;

                } else {
                    lcs[i][j] = max(lcs[i - 1][j], lcs[j - 1][i]);
                }
            }
        }
        int index = lcs[m][n];
        int temp = index;
        char[] newChars = new char[index + 1];
        newChars[index] = '\0';

        int i = m;
        int j = n;
        while (i > 0 && j > 0) {
            if (chars1[i - 1] == chars2[j - 1]) {
                newChars[index - 1] = newChars[i - 1];

                i--;
                j--;
                index--;
            } else if (lcs[i - 1][j] > lcs[j - 1][i]) {
                i--;
            } else {
                j--;
            }
        }
        System.out.println("LCS:");
        for (int k = 0; k < temp; k++) {
            System.out.println(newChars[k]);
        }
        return lcs[m][n];
    }

    private static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    void main() {
        String s1 = "ABCDEH";
        String s2 = "BCSDE";
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        int m = s1.length();
        int n = s2.length();
        System.out.println(STR."The lowest common sequence is \{LCS(ch1, ch2, m, n)}");
    }
}
