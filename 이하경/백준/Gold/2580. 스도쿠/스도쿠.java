import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] row;
    static boolean[][] col;
    static boolean[][][] box;
    static int[][] map;
    static ArrayList<int[]> blank;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        row = new boolean[9][9];
        col = new boolean[9][9];
        box = new boolean[3][3][9];
        map = new int[9][9];
        blank = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int num = Integer.parseInt(st.nextToken()) - 1;
                map[i][j] = num;
                if (num == -1) {
                    blank.add(new int[]{i, j});
                    continue;
                }

                row[i][num] = true;
                col[j][num] = true;
                box[i / 3][j / 3][num] = true;
            }
        }

        bt(0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(map[i][j] + 1).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static boolean bt(int idx) {
        if (idx >= blank.size()) {
            return true;
        }

        int x = blank.get(idx)[0];
        int y = blank.get(idx)[1];

        for (int i = 0; i < 9; i++) {
            if (!row[x][i] && !col[y][i] && !box[x / 3][y / 3][i]) {
                row[x][i] = true;
                col[y][i] = true;
                box[x / 3][y / 3][i] = true;
                map[x][y] = i;
                if (bt(idx + 1)) {
                    return true;
                }
                row[x][i] = false;
                col[y][i] = false;
                box[x / 3][y / 3][i] = false;
            }
        }
        return false;
    }
}
