import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[][] map = new int[N][N];
    boolean[][] visited = new boolean[N][N];
    Queue<int[]> queue = new LinkedList<>();
    int[] dirR = {-1, 1, 0, 0};
    int[] dirC = {0, 0, -1, 1};
    int groupCount = 0;
    ArrayList<Integer> houseCounts = new ArrayList<>();

    for(int i = 0; i < N; i++) {
      char[] charArray = br.readLine().toCharArray();

      for(int j = 0; j < N; j++) {
        map[i][j] = charArray[j] - '0';
      }
    }

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < N; j++) {
        if(map[i][j] == 1 && visited[i][j] == false) {
          int[] startPosition = {i, j};
          int houseCount = 1;

          queue.add(startPosition);
          visited[i][j] = true;
          groupCount++;

          while(!queue.isEmpty()) {
            int[] current = queue.poll();
            
            for(int k = 0; k < 4; k++) {
              int nextR = current[0] + dirR[k];
              int nextC = current[1] + dirC[k];
              if(nextR >= 0 && nextC >= 0 && nextR < N && nextC < N && map[nextR][nextC] == 1 && visited[nextR][nextC] == false) {
                int[] next = {nextR, nextC};

                queue.add(next);
                visited[nextR][nextC] = true;
                houseCount++;
              }
            }
          }

          houseCounts.add(houseCount);
        }
      }
    }
    System.out.println(groupCount);
    houseCounts.sort((a,b) -> a - b);
    houseCounts.forEach(house -> System.out.println(house));
  }
}