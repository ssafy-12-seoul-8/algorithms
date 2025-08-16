import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] conn = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            conn[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            conn[B].add(A);
        }

        int max = 0;
        int[] com = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            boolean[] visited = new boolean[N + 1];
            visited[i] = true;
            int cnt = 0;
            Queue<Integer> q = new LinkedList<>();
            q.add(i);

            while (!q.isEmpty()) {
                int curr = q.poll();

                for (int next : conn[curr]) {
                    if (visited[next]) {
                        continue;
                    }

                    visited[next] = true;
                    cnt++;
                    q.add(next);
                }
            }

            max = Math.max(max, cnt);
            com[i] = cnt;
        }

        for (int i = 1; i <= N; i++) {
            if (com[i] == max) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }
}