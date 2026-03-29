import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] team1;
    static ArrayList<Integer>[] team2;
    static int[] whoPick;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k1 = Integer.parseInt(st.nextToken());
        int k2 = Integer.parseInt(st.nextToken());

        team1 = new ArrayList[n + 1];
        team2 = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            team1[i] = new ArrayList<>();
            team2[i] = new ArrayList<>();
        }

        for (int i = 0; i < k1; i++) {
            st = new StringTokenizer(br.readLine());
            int mate = Integer.parseInt(st.nextToken());
            int pick = Integer.parseInt(st.nextToken());
            team1[mate].add(pick);
        }

        for (int i = 0; i < k2; i++) {
            st = new StringTokenizer(br.readLine());
            int mate = Integer.parseInt(st.nextToken());
            int pick = Integer.parseInt(st.nextToken());
            team2[mate].add(pick);
        }

        int trollCount = 0;
        whoPick = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            visit = new boolean[m + 1];
            if (dfs(i, team1)) {
                trollCount++;
            }
        }

        whoPick = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            visit = new boolean[m + 1];
            if (dfs(i, team2)) {
                trollCount--;
            }
        }

        System.out.println(trollCount < 0 ? "네 다음 힐딱이" : "그만 알아보자");
    }

    static boolean dfs(int mate, ArrayList<Integer>[] team) {
        for (int hero:team[mate]) {
            if (visit[hero]) {
                continue;
            }

            visit[hero] = true;
            if (whoPick[hero] == 0 || dfs(whoPick[hero], team)) {
                whoPick[hero] = mate;
                return true;
            }
        }

        return false;
    }
}