import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] used = new boolean[26];
        int[] cipher = new int[26];

        String w = br.readLine();
        String s = br.readLine();

        int pos = 0;
        for (int i = 0; i < w.length(); i++) {
            char c = w.charAt(i);
            if (!used[c - 'A']) {
                used[c - 'A'] = true;
                cipher[pos++] = c - 'A';
            }
        }

        int alp = 0;
        for (int i = pos; i < 26; i++) {
            while (used[alp]) {
                alp++;
            }
            used[alp] = true;
            cipher[pos++] = alp++;
        }

        for (int i = 0; i < s.length(); i++) {
            sb.append((char) (cipher[s.charAt(i) - 'A'] + 'A'));
        }

        System.out.println(sb);
    }
}
