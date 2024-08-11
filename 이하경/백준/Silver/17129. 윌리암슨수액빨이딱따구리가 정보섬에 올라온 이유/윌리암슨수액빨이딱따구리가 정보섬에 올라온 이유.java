import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] map;
    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        int[] start = {};

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j) - '0';
                if (map[i][j] == 2){
                    start = new int[]{ i, j, 0 };
                }
            }
        }
        int res = bfs(start);

        if (res == -1){
            System.out.println("NIE");
        } else {
            System.out.println("TAK");
            System.out.println(res);
        }
    }

    // 큐에는 { x, y, 거리 } 배열이 들어있다
    // map이 1 이면 visit이라고 판단한다
    static int bfs(int[] start){
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        map[start[0]][start[1]] = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] != 1){
                    if (map[nx][ny] >= 3){
                        return cur[2] + 1;
                    }
                    map[nx][ny] = 1;
                    q.add(new int[]{ nx, ny, cur[2] + 1 });
                }
            }
        }
        return -1;
    }
}
