import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int computerCount = Integer.parseInt(br.readLine());
    int coupleCount = Integer.parseInt(br.readLine());
    int[][] node = new int[computerCount + 1][computerCount + 1];
    boolean[] visited = new boolean[computerCount + 1];
    Queue<Integer> queue = new LinkedList<>();
    int result = 0;

    for(int i = 0; i < coupleCount; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int startNode = Integer.parseInt(st.nextToken());
      int endNode = Integer.parseInt(st.nextToken());

      node[startNode][endNode] = node[endNode][startNode] = 1;
    }

    queue.add(1);
    visited[1] = true;

    while(!queue.isEmpty()) {
      int currentNode = queue.poll();

      for(int i = 1; i <= computerCount; i++) {
        if(node[currentNode][i] == 1 && !visited[i]) {
          queue.add(i);
          visited[i] = true;
          result++;
        }
      }
    }

    System.out.println(result);
  }
}