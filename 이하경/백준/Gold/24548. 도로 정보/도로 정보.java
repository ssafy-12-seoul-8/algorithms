import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int[][][][] tgfp = new int[3][3][3][3]; // t, g, f, p 누적합 개수를 3으로 나눈 나머지
        tgfp[0][0][0][0] = 1;
        int count = 0;

        int t = 0;
        int g = 0;
        int f = 0;
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'T') {
                t = (t + 1) % 3;
            } else if (c == 'G') {
                g = (g + 1) % 3;
            } else if (c == 'F') {
                f = (f + 1) % 3;
            } else {
                p = (p + 1) % 3;
            }
            count += tgfp[t][g][f][p];
            tgfp[t][g][f][p]++;
        }

        System.out.println(count);
    }
}
