import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] cost = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }

        int INF = 1_000_000;

        int[][] rStart = new int[n][3];
        rStart[0][0] = cost[0][0];
        rStart[0][1] = INF;
        rStart[0][2] = INF;

        for (int i = 1; i < n; i++) {
            rStart[i][0] = Math.min(rStart[i - 1][1] + cost[i][0], rStart[i - 1][2] + cost[i][0]);
            rStart[i][1] = Math.min(rStart[i - 1][0] + cost[i][1], rStart[i - 1][2] + cost[i][1]);
            rStart[i][2] = Math.min(rStart[i - 1][0] + cost[i][2], rStart[i - 1][1] + cost[i][2]);
        }

        int[][] gStart = new int[n][3];
        gStart[0][0] = INF;
        gStart[0][1] = cost[0][1];
        gStart[0][2] = INF;

        for (int i = 1; i < n; i++) {
            gStart[i][0] = Math.min(gStart[i - 1][1] + cost[i][0], gStart[i - 1][2] + cost[i][0]);
            gStart[i][1] = Math.min(gStart[i - 1][0] + cost[i][1], gStart[i - 1][2] + cost[i][1]);
            gStart[i][2] = Math.min(gStart[i - 1][0] + cost[i][2], gStart[i - 1][1] + cost[i][2]);
        }

        int[][] bStart = new int[n][3];
        bStart[0][0] = INF;
        bStart[0][1] = INF;
        bStart[0][2] = cost[0][2];

        for (int i = 1; i < n; i++) {
            bStart[i][0] = Math.min(bStart[i - 1][1] + cost[i][0], bStart[i - 1][2] + cost[i][0]);
            bStart[i][1] = Math.min(bStart[i - 1][0] + cost[i][1], bStart[i - 1][2] + cost[i][1]);
            bStart[i][2] = Math.min(bStart[i - 1][0] + cost[i][2], bStart[i - 1][1] + cost[i][2]);
        }


        int min = Math.min(Math.min(rStart[n - 1][1], rStart[n - 1][2]), Math.min(Math.min(gStart[n - 1][0], gStart[n - 1][2]), Math.min(bStart[n - 1][0], bStart[n - 1][1])));
        System.out.println(min);
    }
}
