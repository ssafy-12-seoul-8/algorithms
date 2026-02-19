import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int c = Integer.parseInt(br.readLine());
        while (c-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] room = new int[n];
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                for (int j = 0; j < m; j++) {
                    if (line.charAt(j) == 'x') {
                        room[i] |= (1 << j);
                    }
                }
            }

            int maxBit = 1 << m;
            int[][] lineCount = new int[n][maxBit];
            int[][] maxCount = new int[n][maxBit];

            for (int i = 0; i < n; i++) {
                getAllBit(m, 0, lineCount[i], 0, room[i]);
            }

            maxCount[0] = lineCount[0];
            for (int i = 0; i < n - 1; i++) {
                int max = 0;
                for (int j = 0; j < maxBit; j++) { // i번 줄
                    if (lineCount[i][j] == 0 && j != 0) {
                        continue;
                    }
                    max = Math.max(max, maxCount[i][j]);
                    int ban = (j * 2) | (j / 2);
                    for (int k = 0; k < maxBit; k++) { // i+1번 줄
                        if (lineCount[i + 1][k] == 0) {
                            continue;
                        }
                        if ((ban & k) == 0) {
                            maxCount[i + 1][k] = Math.max(maxCount[i + 1][k], maxCount[i][j] + lineCount[i + 1][k]);
                        }
                    }
                }
                maxCount[i + 1][0] = max;
            }

            int max = 0;
            for (int i = 0; i < maxBit; i++) {
                max = Math.max(max, maxCount[n - 1][i]);
            }

            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }

    static void getAllBit(int m, int y, int[] lineCount, int currBit, int ban) {
        for (int i = y; i < m; i++) {
            if ((ban & (1 << i)) == 0) {
                lineCount[currBit | (1 << i)] = lineCount[currBit] + 1;
                getAllBit(m, i + 1, lineCount, currBit | (1 << i), ban | (1 << (i + 1)));
            }
        }
    }
}
