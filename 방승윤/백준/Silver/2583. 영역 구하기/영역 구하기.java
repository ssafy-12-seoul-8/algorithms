import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[M][N];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    arr[k][j] = -1;
                }
            }
        }

        int cnt = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    arr[i][j] = 1;
                    int area = 1;
                    cnt++;

                    while (!queue.isEmpty()) {
                        int[] box = queue.poll();

                        for (int d = 0; d < 4; d++) {
                            int nx = box[0] + dx[d];
                            int ny = box[1] + dy[d];

                            if (nx >= 0 && ny >= 0 && nx < M && ny < N && arr[nx][ny] == 0) {
                                queue.add(new int[]{nx, ny});
                                arr[nx][ny] = 1;
                                area++;
                            }
                        }
                    }

                    pq.add(area);
                }
            }
        }

        sb.append(cnt).append("\n");

        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append(" ");
        }

        System.out.println(sb);
    }
}