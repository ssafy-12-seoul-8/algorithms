import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[] visited;
    static int n, m, answer;
    static ArrayList<Point> home;
    static ArrayList<Point> chicken;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        home = new ArrayList<>();
        chicken = new ArrayList<>();
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == 1) {
                    home.add(new Point(i, j));
                } else if (arr[i][j] == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }

        answer = Integer.MAX_VALUE;
        visited = new boolean[chicken.size()];

        solve(0, 0);
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void solve(int start, int depth) {
        if (depth == m) {
            int res = 0;

            for (int i = 0; i < home.size(); i++) {
                int temp = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++) {
                    if (visited[j]) {
                        int dist = Math.abs(home.get(i).x - chicken.get(j).x)
                                + Math.abs(home.get(i).y - chicken.get(j).y);

                        temp = Math.min(temp, dist);
                    }
                }
                res += temp;
            }
            answer = Math.min(answer, res);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            visited[i] = true;
            solve(i + 1, depth + 1);
            visited[i] = false;
        }
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
