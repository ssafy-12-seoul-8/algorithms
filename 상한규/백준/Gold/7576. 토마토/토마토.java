import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    int[][] map = new int[N][M];
    int result = 0;
    Queue<int[]> queue = new LinkedList<>();
    int[] dirR = {-1, 1, 0, 0};
    int[] dirC = {0, 0, -1, 1};

    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());

      for(int j = 0; j < M; j++) {
        int value = Integer.parseInt(st.nextToken());
        map[i][j] = value;

        if(value == 1) {
          queue.add(new int[]{i, j});
        }
      }
    }

    while(!queue.isEmpty()) {
      int[] current = queue.poll();
      result = map[current[0]][current[1]] < result ? result : map[current[0]][current[1]];
      for(int direction = 0; direction < 4; direction++) {
        if(
          dirR[direction] + current[0] >= 0 && dirR[direction] + current[0]< N &&
          dirC[direction] + current[1] >= 0 && dirC[direction] + current[1]< M &&
          map[dirR[direction] + current[0]][dirC[direction] + current[1]] == 0
        ) {
          map[dirR[direction] + current[0]][dirC[direction] + current[1]] = map[current[0]][current[1]] + 1;
          
          queue.add(new int[] {dirR[direction] + current[0], dirC[direction] + current[1]});
        }
      }
    }

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < M; j++) {
        if(map[i][j] == 0) {
          result = 0;
        }
      }
    }

    System.out.println(result - 1);
  }
}