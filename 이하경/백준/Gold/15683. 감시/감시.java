import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] room;
    static ArrayList<int[]> cctv;
    static int min;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        room = new int[n][m];
        cctv = new ArrayList<>();
        min = n * m;

        int count = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if (room[i][j] >= 1 && room[i][j] <= 5) {
                    cctv.add(new int[]{i, j, room[i][j]});
                }
                if (room[i][j] == 0) {
                    count++;
                }
            }
        }

        bt(0, count);
        System.out.println(min);
    }

    public static void bt(int idx, int count) {
        if (idx == cctv.size()) {
            min = Math.min(min, count);
            return;
        }

        if (count == 0) {
            min = 0;
            return;
        }

        int[] c = cctv.get(idx);

        ArrayList<int[]> tmp = new ArrayList<>();
        if (c[2] == 1) {
            for (int d = 0; d < 4; d++) {
                int nx = c[0] + dx[d];
                int ny = c[1] + dy[d];
                while (nx >= 0 && nx < n && ny >= 0 && ny < m && room[nx][ny] != 6) {
                    if (room[nx][ny] == 0) {
                        room[nx][ny] = -1;
                        tmp.add(new int[]{nx, ny});
                    }
                    nx += dx[d];
                    ny += dy[d];
                }
                bt(idx + 1, count - tmp.size());
                for (int[] t : tmp) {
                    room[t[0]][t[1]] = 0;
                }
                tmp.clear();
            }
            return;
        }

        if (c[2] == 2) {
            for (int d = 0; d < 2; d++) {
                int nx = c[0] + dx[d];
                int ny = c[1] + dy[d];
                while (nx >= 0 && nx < n && ny >= 0 && ny < m && room[nx][ny] != 6) {
                    if (room[nx][ny] == 0) {
                        room[nx][ny] = -1;
                        tmp.add(new int[]{nx, ny});
                    }
                    nx += dx[d];
                    ny += dy[d];
                }
                nx = c[0] + dx[d + 2];
                ny = c[1] + dy[d + 2];
                while (nx >= 0 && nx < n && ny >= 0 && ny < m && room[nx][ny] != 6) {
                    if (room[nx][ny] == 0) {
                        room[nx][ny] = -1;
                        tmp.add(new int[]{nx, ny});
                    }
                    nx += dx[d + 2];
                    ny += dy[d + 2];
                }
                bt(idx + 1, count - tmp.size());
                for (int[] t : tmp) {
                    room[t[0]][t[1]] = 0;
                }
                tmp.clear();
            }
            return;
        }

        if (c[2] == 3) {
            for (int d = 0; d < 4; d++) {
                int nx = c[0] + dx[d];
                int ny = c[1] + dy[d];
                while (nx >= 0 && nx < n && ny >= 0 && ny < m && room[nx][ny] != 6) {
                    if (room[nx][ny] == 0) {
                        room[nx][ny] = -1;
                        tmp.add(new int[]{nx, ny});
                    }
                    nx += dx[d];
                    ny += dy[d];
                }
                nx = c[0] + dx[(d + 1) % 4];
                ny = c[1] + dy[(d + 1) % 4];
                while (nx >= 0 && nx < n && ny >= 0 && ny < m && room[nx][ny] != 6) {
                    if (room[nx][ny] == 0) {
                        room[nx][ny] = -1;
                        tmp.add(new int[]{nx, ny});
                    }
                    nx += dx[(d + 1) % 4];
                    ny += dy[(d + 1) % 4];
                }
                bt(idx + 1, count - tmp.size());
                for (int[] t : tmp) {
                    room[t[0]][t[1]] = 0;
                }
                tmp.clear();
            }
            return;
        }

        if (c[2] == 4) {
            for (int d = 0; d < 4; d++) {
                int nx = c[0] + dx[d];
                int ny = c[1] + dy[d];
                while (nx >= 0 && nx < n && ny >= 0 && ny < m && room[nx][ny] != 6) {
                    if (room[nx][ny] == 0) {
                        room[nx][ny] = -1;
                        tmp.add(new int[]{nx, ny});
                    }
                    nx += dx[d];
                    ny += dy[d];
                }
                nx = c[0] + dx[(d + 1) % 4];
                ny = c[1] + dy[(d + 1) % 4];
                while (nx >= 0 && nx < n && ny >= 0 && ny < m && room[nx][ny] != 6) {
                    if (room[nx][ny] == 0) {
                        room[nx][ny] = -1;
                        tmp.add(new int[]{nx, ny});
                    }
                    nx += dx[(d + 1) % 4];
                    ny += dy[(d + 1) % 4];
                }
                nx = c[0] + dx[(d + 2) % 4];
                ny = c[1] + dy[(d + 2) % 4];
                while (nx >= 0 && nx < n && ny >= 0 && ny < m && room[nx][ny] != 6) {
                    if (room[nx][ny] == 0) {
                        room[nx][ny] = -1;
                        tmp.add(new int[]{nx, ny});
                    }
                    nx += dx[(d + 2) % 4];
                    ny += dy[(d + 2) % 4];
                }
                bt(idx + 1, count - tmp.size());
                for (int[] t : tmp) {
                    room[t[0]][t[1]] = 0;
                }
                tmp.clear();
            }
            return;
        }

        if (c[2] == 5) {
            int nx = c[0] + dx[0];
            int ny = c[1] + dy[0];
            while (nx >= 0 && nx < n && ny >= 0 && ny < m && room[nx][ny] != 6) {
                if (room[nx][ny] == 0) {
                    room[nx][ny] = -1;
                    tmp.add(new int[]{nx, ny});
                }
                nx += dx[0];
                ny += dy[0];
            }
            nx = c[0] + dx[1];
            ny = c[1] + dy[1];
            while (nx >= 0 && nx < n && ny >= 0 && ny < m && room[nx][ny] != 6) {
                if (room[nx][ny] == 0) {
                    room[nx][ny] = -1;
                    tmp.add(new int[]{nx, ny});
                }
                nx += dx[1];
                ny += dy[1];
            }
            nx = c[0] + dx[2];
            ny = c[1] + dy[2];
            while (nx >= 0 && nx < n && ny >= 0 && ny < m && room[nx][ny] != 6) {
                if (room[nx][ny] == 0) {
                    room[nx][ny] = -1;
                    tmp.add(new int[]{nx, ny});
                }
                nx += dx[2];
                ny += dy[2];
            }
            nx = c[0] + dx[3];
            ny = c[1] + dy[3];
            while (nx >= 0 && nx < n && ny >= 0 && ny < m && room[nx][ny] != 6) {
                if (room[nx][ny] == 0) {
                    room[nx][ny] = -1;
                    tmp.add(new int[]{nx, ny});
                }
                nx += dx[3];
                ny += dy[3];
            }
            bt(idx + 1, count - tmp.size());
            for (int[] t : tmp) {
                room[t[0]][t[1]] = 0;
            }
            tmp.clear();
        }
    }
}
