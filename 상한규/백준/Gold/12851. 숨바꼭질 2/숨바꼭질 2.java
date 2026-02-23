import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int result = Integer.MAX_VALUE;
    int count = 1;
    boolean[] visited = new boolean[100001];
    Queue<int[]> queue = new LinkedList<>();
    
    queue.add(new int[] {N, 0});

    while(!queue.isEmpty()) {
      int[] current = queue.poll();
      visited[current[0]] = true;

      if(current[0] == K) {
        if(result == current[1]) {
          count++;
        }
        result = result < current[1] ? result : current[1];
        continue;
      }

      if(current[0] > 0 && visited[current[0] - 1] == false) {
        queue.add(new int[] {current[0] - 1, current[1] + 1});
      }

      if(current[0] < 100000 && visited[current[0] + 1] == false) {
        queue.add(new int[] {current[0] + 1, current[1] + 1});
      }

      if(current[0] * 2 <= 100000 && current[0] != 0 && visited[current[0] * 2] == false) {
        queue.add(new int[] {current[0] * 2, current[1] + 1});
      }
    }

    System.out.println(result);
    System.out.println(count);
  }
}