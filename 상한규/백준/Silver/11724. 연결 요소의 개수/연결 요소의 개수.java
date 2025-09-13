import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N + 1];
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        int result = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                result++;
                visited[i] = true;
                queue.add(i);

                while (!queue.isEmpty()) {
                    int cur = queue.poll();

                    for (int next : adj.get(cur)) {
                        if (!visited[next]) {
                            visited[next] = true;
                            queue.add(next);
                        }
                    }
                }
            }
        }

        System.out.println(result);
    }
}
