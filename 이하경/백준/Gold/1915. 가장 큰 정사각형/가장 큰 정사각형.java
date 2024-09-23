import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 0번 행과 열 처리
        int[][] rowLen = new int[n][m]; // 가로로 이어진 개수
        int[][] colLen = new int[n][m]; // 세로로 이어진 개수
        int[][] sqLen = new int[n][m];
        rowLen[0][0] = map[0][0] - '0';
        colLen[0][0] = map[0][0] - '0';
        sqLen[0][0] = map[0][0] - '0';

        for (int i = 1; i < m; i++) {
            if (map[0][i] == '1') {
                rowLen[0][i] = rowLen[0][i - 1] + 1;
                colLen[0][i] = 1;
                sqLen[0][i] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            if (map[i][0] == '1') {
                rowLen[i][0] = 1;
                colLen[i][0] = colLen[i - 1][0] + 1;
                sqLen[i][0] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (map[i][j] == '1') {
                    rowLen[i][j] = rowLen[i][j - 1] + 1;
                    colLen[i][j] = colLen[i - 1][j] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                sqLen[i][j] = Math.min(rowLen[i][j], colLen[i][j]);
                sqLen[i][j] = Math.min(sqLen[i][j], sqLen[i - 1][j - 1] + 1);
                max = Math.max(max, sqLen[i][j]);
            }
        }

        if (max == 0) {
            for (int i = 0; i < m; i++) {
                if (map[0][i] == '1') {
                    max = 1;
                    break;
                }
            }
        }
        if (max == 0) {
            for (int i = 1; i < n; i++) {
                if (map[i][0] == '1'){
                    max = 1;
                    break;
                }
            }
        }
        System.out.println(max * max);
    }
}

