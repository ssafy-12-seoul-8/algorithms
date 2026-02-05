import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int year = Integer.parseInt(st.nextToken());

        int[] dx = {1, 1, 1, 0, -1, -1, -1, 0};
        int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

        PriorityQueue<Integer>[][] trees = new PriorityQueue[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                trees[i][j] = new PriorityQueue<>();
            }
        }

        int[][] land = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                land[i][j] = 5;
            }
        }

        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            trees[x - 1][y - 1].add(z);
        }

        for (int i = 0; i < year; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    // 봄, 여름
                    int[] tmpTree = new int[trees[j][k].size()];
                    for (int l = 0; l < tmpTree.length; l++) {
                        tmpTree[l] = trees[j][k].poll();
                    }
                    boolean dead = false;
                    for (int l = 0; l < tmpTree.length; l++) {
                        if (!dead) {
                            if (land[j][k] >= tmpTree[l]) {
                                trees[j][k].offer(tmpTree[l] + 1);
                                land[j][k] -= tmpTree[l];
                                continue;
                            } else {
                                dead = true;
                            }
                        }
                        if (dead) {
                            land[j][k] += tmpTree[l] / 2;
                        }
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    // 가을
                    for (int tr : trees[j][k]) {
                        if (tr % 5 == 0) {
                            for (int l = 0; l < 8; l++) {
                                int nx = j + dx[l];
                                int ny = k + dy[l];

                                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                                    trees[nx][ny].offer(1);
                                }
                            }
                        }
                    }

                    // 겨울
                    land[j][k] += a[j][k];
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count += trees[i][j].size();
            }
        }

        System.out.println(count);
    }
}
