import java.util.*;
import java.io.*;

public class Main {
  static int[] dx = {0, 0, -1, 1};
  static int[] dy = {-1, 1, 0, 0};

  static public void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int M = Integer.parseInt(st.nextToken());
      int N = Integer.parseInt(st.nextToken());
      int K = Integer.parseInt(st.nextToken());

      int[][] map = new int[N][M];
      List<int[]> cabbages = new ArrayList<>();

      int result = 0;
      for (int j = 0; j < K; j++) {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        map[y][x] = 1;
        cabbages.add(new int[]{x, y});
      }

      for (int[] position : cabbages) {
        int currentX = position[0];
        int currentY = position[1];

        if (map[currentY][currentX] == 1) {
          result++; 
          bfs(currentX, currentY, M, N, map);
        }
      }

      System.out.println(result);
    }
  }

  static void bfs(int startX, int startY, int M, int N, int[][] map) {
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{startX, startY});
    map[startY][startX] = 0;

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int x = current[0];
      int y = current[1];

      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
          if (map[ny][nx] == 1) {
            map[ny][nx] = 0;
            queue.offer(new int[]{nx, ny});
          }
        }
      }
    }
  }
}