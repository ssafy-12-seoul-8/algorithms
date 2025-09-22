import java.util.*;
import java.io.*;

public class Main {
  static public void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int result = Integer.MAX_VALUE;
    boolean[] visited = new boolean[100001];
    Queue<int[]> queue = new LinkedList<>();
    
    queue.add(new int[] {N, 0});

    while(!queue.isEmpty()) {
      int[] current = queue.poll();
      visited[current[0]] = true;

      if(current[0] == K) {
        result = result < current[1] ? result : current[1];
      }

      if(current[0] > 0 && visited[current[0] - 1] == false) {
        queue.add(new int[] {current[0] - 1, current[1] + 1});
      }

      if(current[0] < 100000 && visited[current[0] + 1] == false) {
        queue.add(new int[] {current[0] + 1, current[1] + 1});
      }

      if(current[0] * 2 <= 100000 && current[0] != 0 && visited[current[0] * 2] == false) {
        queue.add(new int[] {current[0] * 2, current[1]});
      }
    }

    System.out.println(result);
  }
}