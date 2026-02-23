import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        boolean[] exist = new boolean[1_000_001];
        int[] idx = new int[1_000_001];
        int[] cards = new int[n];
        int[] score = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            exist[num] = true;
            cards[i] = num;
            idx[num] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= Math.sqrt(cards[i]); j++) {
                if (cards[i] % j == 0) {
                    if (exist[j]) {
                        score[i]--;
                        score[idx[j]]++;
                    }
                    if (j * j != cards[i] && exist[cards[i] / j]) {
                        score[i]--;
                        score[idx[cards[i] / j]]++;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            sb.append(score[i]).append(" ");
        }

        System.out.println(sb);
    }
}
