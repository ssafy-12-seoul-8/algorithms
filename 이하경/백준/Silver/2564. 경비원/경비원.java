import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int r, c;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());
        int[] shopDists = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            shopDists[i] = getDist(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        int dongDist = getDist(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        int sum = 0;
        for (int shopDist : shopDists) {
            int tmp = Math.abs(dongDist - shopDist);
            if (tmp > r + c) {
                tmp = r + r + c + c - tmp;
            }
            sum += tmp;
        }
        System.out.println(sum);
    }

    public static int getDist(int dir, int dist) {
        if (dir == 3) {
            return dist;
        } else if (dir == 2) {
            return c + dist;
        } else if (dir == 4){
            return c + r + c - dist;
        } else {
            return c + r + c + r - dist;
        }
    }
}
