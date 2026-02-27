import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] room;
    static ArrayList<long[]> view;
    static int min;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        room = new int[n][m];
        min = n * m;
        view = new ArrayList<>();
        long bit = 0;

        ArrayList<int[]> cctv = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if (room[i][j] == 6) {
                    bit |= pointToBit(i, j);
                    continue;
                }
                if (room[i][j] >= 1) {
                    cctv.add(new int[]{ i, j });
                }
            }
        }

        for (int[] c:cctv) {
            view.add(getView(c[0], c[1], room[c[0]][c[1]]));
        }

        bt(0, bit);
        System.out.println(min);
    }

    public static void bt(int idx, long bit) {
        if (Long.bitCount(bit) == n * m) {
            min = 0;
            return;
        }

        if (idx == view.size()) {
            min = Math.min(min, n * m - Long.bitCount(bit));
            return;
        }

        for (long viewBit:view.get(idx)) {
            bt(idx + 1, bit | viewBit);
        }
    }

    public static long[] getView(int x, int y, int type) {
        long[] dirBits = new long[4];
        for (int i = 0; i < 4; i++) {
            dirBits[i] = getDirBit(x, y, i);
        }

        if (type == 1) {
            return dirBits;
        }

        if (type == 2) {
            return new long[]{dirBits[0] | dirBits[2], dirBits[1] | dirBits[3]};
        }

        if (type == 3) {
            return new long[]{dirBits[0] | dirBits[1], dirBits[1] | dirBits[2], dirBits[2] | dirBits[3], dirBits[0] | dirBits[3]};
        }

        if (type == 4) {
            return new long[]{dirBits[0] | dirBits[1] | dirBits[2], dirBits[0] | dirBits[1] | dirBits[3], dirBits[0] | dirBits[2] | dirBits[3], dirBits[1] | dirBits[2] | dirBits[3]};
        }

        if (type == 5) {
            return new long[]{dirBits[0] | dirBits[1] | dirBits[2] | dirBits[3]};
        }

        return new long[]{};
    }

    public static long getDirBit(int x, int y, int dir) {
        long bit = pointToBit(x, y);
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        while (nx >= 0 && nx < n && ny >= 0 && ny < m && room[nx][ny] != 6) {
            if (room[nx][ny] == 0) {
                bit |= pointToBit(nx, ny);
            }
            nx += dx[dir];
            ny += dy[dir];
        }
        return bit;
    }

    public static long pointToBit(int x, int y) {
        return (1L << (x * m + y));
    }
}
