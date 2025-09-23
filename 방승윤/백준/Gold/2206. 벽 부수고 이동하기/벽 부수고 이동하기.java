import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        boolean[][][] visited = new boolean[N][M][2];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < line.length(); j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1, 0});
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            int dist = curr[2];
            int flag = curr[3];

            if (x == N - 1 && y == M - 1) {
                System.out.println(dist);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (arr[nx][ny] == 1 && flag == 0 && !visited[nx][ny][1]) {
                        queue.add(new int[]{nx, ny, dist + 1, 1});
                        visited[nx][ny][1] = true;
                        continue;
                    }

                    if (arr[nx][ny] == 0 && !visited[nx][ny][flag]) {
                        queue.add(new int[]{nx, ny, dist + 1, flag});
                        visited[nx][ny][flag] = true;
                    }
                }
            }
        }

        System.out.println(-1);
    }
}