import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int s = 0;
        int k = 0;
        int max = 0;
        int[][] needK = new int[200_001][2];
        int[][] leftK = new int[100_001][2];

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'S') {
                s++;
            } else if (c == 'K') {
                k++;
            }

            if (s != 0 && k != 0 && 2 * s == k) {
                max = Math.max(max, i + 1);
                continue;
            }

            int gap = 2 * s - k;
            if (gap > 0) {
                if (needK[gap][0] == 0) {
                    needK[gap][0] = i + 1;
                    needK[gap][1] = s;
                } else if (needK[gap][1] != s){
                    max = Math.max(max, i - needK[gap][0] + 1);
                }
                continue;
            }

            if (gap < 0) {
                if (leftK[-gap][0] == 0) {
                    leftK[-gap][0] = i + 1;
                    leftK[-gap][1] = s;
                } else if (leftK[-gap][1] != s){
                    max = Math.max(max, i - leftK[-gap][0] + 1);
                }
            }
        }

        System.out.println(max == 0 ? -1 : max);
    }
}
