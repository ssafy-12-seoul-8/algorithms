import java.util.*;
import java.io.*;

public class Main {
  static public class Point {
    int r;
    int c;
    int distance;
    boolean canBreak;

    Point(int r, int c, int distance, boolean canBreak) {
      this.r = r;
      this.c = c;
      this.distance = distance;
      this.canBreak = canBreak;
    }
  }

  static public void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[][] map = new int[N][M];
    boolean[][][] visited = new boolean[N][M][2];
    int[] dirR = {-1, 1, 0, 0};
    int[] dirC = {0, 0, -1, 1};
    Queue<Point> queue = new LinkedList<>();
    int result = Integer.MAX_VALUE;

    for(int i = 0; i < N; i++) {
      String lines = br.readLine();
      char[] mapArray = lines.toCharArray();

      for(int j = 0; j < M; j++) {
        map[i][j] = mapArray[j] - '0';
      }
    }

    queue.add(new Point(0, 0, 1, true));
    visited[0][0][0] = true;

    while(!queue.isEmpty()) {
      Point current = queue.poll();
      
      if(current.r == N - 1 && current.c == M - 1) {
        result = Math.min(result, current.distance);

        continue;
      }

       for(int i = 0; i < 4; i++) {
        int nextR = current.r + dirR[i];
        int nextC = current.c + dirC[i];

        if(nextR >= 0 && nextR < N && nextC >= 0 && nextC < M) {
          int state = current.canBreak ? 0 : 1;

          if(map[nextR][nextC] == 0) {
            if(!visited[nextR][nextC][state]) {
              visited[nextR][nextC][state] = true;
              queue.add(new Point(nextR, nextC, current.distance + 1, current.canBreak));
            }
          } else {
            if(current.canBreak && !visited[nextR][nextC][1]) {
              visited[nextR][nextC][1] = true;
              queue.add(new Point(nextR, nextC, current.distance + 1, false));
            }
          }
        }
      }
    }
    
    result = result == Integer.MAX_VALUE ? -1 : result;

    System.out.println(result);
  }
}