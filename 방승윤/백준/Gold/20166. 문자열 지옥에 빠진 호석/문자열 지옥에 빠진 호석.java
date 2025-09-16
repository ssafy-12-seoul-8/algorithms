import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main {
    public static int N;
    public static int M;
    public static int K;
    public static int maxLength;
    public static HashSet<String> godLike = new HashSet<>();
    public static HashMap<String, Integer> godLikeCnt = new HashMap<>();
    public static StringBuilder str;
    public static char[][] arr;
    public static int[] dx = {1, 1, 1, -1, -1, -1, 0, 0};
    public static int[] dy = {1, -1, 0, 1, -1, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        String[] godLikeArr = new String[K];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < K; i++) {
            String god = br.readLine();
            godLike.add(god);
            godLikeArr[i] = god;
            maxLength = Math.max(maxLength, god.length());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                str = new StringBuilder();
                str.append(arr[i][j]);
                makeStr(i, j);
            }
        }

        for (String god : godLikeArr) {
            sb.append(godLikeCnt.getOrDefault(god, 0)).append("\n");
        }

        System.out.println(sb);
    }

    public static void makeStr(int x, int y) {
        if (godLike.contains(str.toString())) {
            godLikeCnt.put(str.toString(), godLikeCnt.getOrDefault(str.toString(), 0) + 1);
        }

        if (str.length() == maxLength) {
            return;
        }

        for (int d = 0; d < 8; d++) {
            int nx = x + dx[d] == -1 ? N - 1 : x + dx[d] == N ? 0 : x + dx[d];
            int ny = y + dy[d] == -1 ? M - 1 : y + dy[d] == M ? 0 : y + dy[d];
            str.append(arr[nx][ny]);
            makeStr(nx, ny);
            str.deleteCharAt(str.length() - 1);
        }
    }
}