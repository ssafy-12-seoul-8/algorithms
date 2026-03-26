import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] connect; // n번 티셔츠랑 연결된 카라
    static boolean[] visit;
    static int[] match;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] tShirts = new int[n];
        int[] collar = new int[m];

        for (int i = 0; i < n; i++) {
            tShirts[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            collar[i] = Integer.parseInt(br.readLine());
        }

        connect = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            connect[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((collar[j] * 2 >= tShirts[i] && collar[j] * 4 <= tShirts[i] * 3) || collar[j]>= tShirts[i] && collar[j] * 4 <= tShirts[i] * 5) {
                    connect[i].add(j);
                }
            }
        }

        match = new int[m];
        Arrays.fill(match, -1);

        int count = 0;
        for (int i = 0; i < n; i++) {
            visit = new boolean[m];
            if (dfs(i)) {
                count++;
            }
        }

        System.out.println(count);
    }

    static boolean dfs(int start) {
        for (int next:connect[start]) { // 연결된 칼라들에 대해
            if (visit[next]) {
                continue;
            }

            visit[next] = true;

            if (match[next] == -1 || dfs(match[next])) { // 사용x거나 사용중인 티셔츠가 비킨다면
                match[next] = start;
                return true;
            }
        }

        return false;
    }
}
