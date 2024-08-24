import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[][] map = new int[n + 2][2];
            for (int i = 0; i < n + 2; i++) {
                st = new StringTokenizer(br.readLine());
                map[i][0] = Integer.parseInt(st.nextToken());
                map[i][1] = Integer.parseInt(st.nextToken());
            }

            Queue<Integer> q = new LinkedList<>(); // 큐에 인덱스 넣기
            boolean[] visit = new boolean[n + 2];
            q.offer(0);
            visit[0] = true;
            boolean happy = false;

            outer:
            while (!q.isEmpty()) {
                int curIdx = q.poll();
                int x = map[curIdx][0];
                int y = map[curIdx][1];

                for (int i = 1; i < n + 2; i++) {
                    int nx = map[i][0];
                    int ny = map[i][1];

                    if (!visit[i] && canGo(x, y, nx, ny)) {
                        if (i == n + 1) {
                            happy = true;
                            break outer;
                        }
                        visit[i] = true;
                        q.offer(i);
                    }
                }
            }
            sb.append(happy ? "happy" : "sad").append("\n");
        }
        System.out.println(sb);
    }

    static boolean canGo (int x, int y, int nx, int ny) {
        int xDist = Math.abs(x - nx);
        int yDist = Math.abs(y - ny);
        return (xDist + yDist) <= 1000;
    }
}
