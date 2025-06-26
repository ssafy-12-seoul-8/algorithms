import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int maxDay = 0;
        int[][][] box = new int[H][N][M];
        boolean[][][] visited = new boolean[H][N][M];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    int status = Integer.parseInt(st.nextToken());
                    box[i][j][k] = status;
                    if (status == 1) {
                        queue.add(new int[] {i, j, k, 0});
                    }
                }
            }
        }

        int[] dx = {1, 0, -1, 0, 0, 0};
        int[] dy = {0, 1, 0, -1, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};

        while (!queue.isEmpty()) {
            int[] location = queue.poll();
            for (int i = 0; i < 6; i++) {
                int nz = location[0] + dz[i];
                int nx = location[1] + dx[i];
                int ny = location[2] + dy[i];
                if (nx >= 0 && ny >= 0 && nz >= 0 && nx < N && ny < M && nz < H && box[nz][nx][ny] == 0) {
                    queue.add(new int[] {nz, nx, ny, location[3] + 1});
                    maxDay = location[3] + 1;
                    box[nz][nx][ny] = 1;
                }
            }
        }

        one: for (int[][] oneBox : box) {
            for (int[] oneLine : oneBox) {
                for (int tomato : oneLine) {
                    if (tomato == 0) {
                        maxDay = -1;
                        break one;
                    }
                }
            }
        }

        System.out.println(maxDay);
    }
}