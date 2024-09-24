import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int h, w, cnt;
    static char[][] map;
    static boolean[] key;
    static Queue<Point> q;
    static Map<Integer, ArrayList<Point>> door;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            map = new char[h][w];

            for (int i = 0; i < h; i++) {
                map[i] = br.readLine().toCharArray();
            }

            key = new boolean[26];
            String haveKey = br.readLine();
            if (haveKey.charAt(0) != '0') {
                for (int i = 0; i < haveKey.length(); i++) {
                    key[haveKey.charAt(i) - 'a'] = true;
                }
            }

            q= new LinkedList<>();
            door = new HashMap<>();
            cnt = 0;

            for (int i = 0; i < w; i++) {
                action(0, i);
                action(h - 1, i);
            }

            for (int i = 1; i < h; i++) {
                action(i, 0);
                action(i, w - 1);
            }

            while (!q.isEmpty()) {
                Point curr = q.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = curr.x + dx[i];
                    int ny = curr.y + dy[i];

                    if (isValid(nx, ny)) {
                        action(nx, ny);
                    }
                }
            }
//            System.out.println(door);

            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    static void printMap() {
        for (char[] m : map) {
            System.out.println(Arrays.toString(m));
        }
        System.out.println();
    }

    static void action(int x, int y) {
//        printMap();
        char c = map[x][y];
        if (c == '*') {
            return;
        }
        if (c == '.') {
            q.add(new Point(x, y));
            map[x][y] = '*';
            return;
        }
        if (c == '$') {
            q.add(new Point(x, y));
            map[x][y] = '*';
            cnt++;
            return;
        }
        if (c >= 'a' && c <= 'z') {
            if (!key[c - 'a']) { // 전에 키가 없었다면 그때 저장해놓은 문 넣기
                key[c - 'a'] = true;
                if (door.containsKey(c - 'a')) {
                    q.addAll(door.get(c - 'a'));
                }
            }
            q.add(new Point(x, y));
            map[x][y] = '*';
            return;
        }
        if (c >= 'A' && c <= 'Z') {
            if (key[c - 'A']) {
                q.add(new Point(x, y));
                map[x][y] = '*';
                return;
            }
            if (!door.containsKey(c - 'A')) {
                door.put(c - 'A', new ArrayList<>());
            }
            door.get(c - 'A').add(new Point(x, y));
            map[x][y] = '*';
        }
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < h && y >= 0 && y < w;
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}

