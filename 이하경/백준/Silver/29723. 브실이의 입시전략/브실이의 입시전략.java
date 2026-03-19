import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String title = st.nextToken();
            int score = Integer.parseInt(st.nextToken());

            map.put(title, score);
        }

        int show = 0;
        for (int i = 0; i < k; i++) {
            String title = br.readLine();
            show += map.get(title);
            map.remove(title);
        }

        int[] scores = new int[n - k];
        int idx = 0;
        for (int score:map.values()) {
            scores[idx++] = score;
        }

        Arrays.sort(scores);
        int max = 0;
        int min = 0;
        for (int i = 0; i < m - k; i++) {
            min += scores[i];
            max += scores[n - k - 1 - i];
        }

        sb.append(show + min).append(" ").append(show + max);
        System.out.println(sb);
    }
}
