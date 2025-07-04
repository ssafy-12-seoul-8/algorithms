import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] board = new int[101];
        int[] road = new int[101];

        Arrays.fill(road, Integer.MAX_VALUE);

        for (int i = 1; i <= 100; i++) {
            board[i] = i;
        }

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> q = new LinkedList<>();
        road[1] = 0;
        q.add(1);

        while (!q.isEmpty()) {
            int x = q.poll();

            for (int i = 1; i <= 6; i++) {
                if (x + i <= 100) {
                    int location = board[x + i];

                    if (road[x] + 1 < road[location]) {
                        road[location] = road[x] + 1;
                        q.add(location);
                    }
                }
            }
        }

        System.out.println(road[100]);
    }
}