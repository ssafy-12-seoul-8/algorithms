import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] map = new char[r][];

        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }

        Queue<int[]> jq = new LinkedList<>();
        Queue<int[]> fq = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'J') {
                    jq.add(new int[]{i, j});
                    continue;
                }
                if (map[i][j] == 'F') {
                    fq.add(new int[]{i, j});
                }
            }
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int time = 1;
        boolean possible = false;
        loop:
        while (!jq.isEmpty()) {
            int fmove = fq.size();
            while (fmove-- > 0) {
                int[] curr = fq.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = curr[0] + dx[d];
                    int ny = curr[1] + dy[d];

                    if (nx >= 0 && nx < r && ny >= 0 && ny < c && map[nx][ny] == '.') {
                        map[nx][ny] = 'F';
                        fq.add(new int[]{nx, ny});
                    }
                }
            }

            int jmove = jq.size();
            while (jmove-- > 0) {
                int[] curr = jq.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = curr[0] + dx[d];
                    int ny = curr[1] + dy[d];

                    if (nx >= 0 && nx < r && ny >= 0 && ny < c && map[nx][ny] == '.') {
                        map[nx][ny] = 'J';
                        jq.add(new int[]{nx, ny});
                        continue;
                    }

                    if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                        possible = true;
                        break loop;
                    }
                }
            }
            
            time++;
        }

        System.out.println(possible ? time : "IMPOSSIBLE");
    }
}
