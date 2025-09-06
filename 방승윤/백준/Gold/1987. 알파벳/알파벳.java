import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static int R;
    public static int C;
    public static char[][] field;
    public static boolean[] visited = new boolean[26];
    public static int max;
    public static int[] dr = {1, -1, 0, 0};
    public static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        field = new char[R][];

        for (int i = 0; i < R; i++) {
            field[i] = br.readLine().toCharArray();
        }

        visited[field[0][0] - 'A'] = true;
        dfs(0, 0, 1);
        System.out.println(max);
    }

    public static void dfs(int r, int c, int level) {
        if (level > max) {
            max = level;
        }

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[field[nr][nc] - 'A']) {
                visited[field[nr][nc] - 'A'] = true;
                dfs(nr, nc, level + 1);
                visited[field[nr][nc] - 'A'] = false;
            }
        }
    }
}