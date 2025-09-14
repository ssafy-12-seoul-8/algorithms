import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String sent = br.readLine();
        String key = br.readLine();

        int[] keyNum = new int[key.length()];
        for (int i = 0; i < key.length(); i++) {
            keyNum[i] = key.charAt(i) - 'a' + 1;
        }

        int keyIdx = -1;
        for (int i = 0; i < sent.length(); i++) {
            char c = sent.charAt(i);
            keyIdx += 1;
            if (keyIdx >= key.length()) {
                keyIdx = 0;
            }

            int tmp = c - keyNum[keyIdx];
            if (c == ' ') {
                sb.append(' ');
                continue;
            }

            if (tmp < 'a') {
                tmp += 26;
            }

            sb.append((char) tmp);
        }

        System.out.println(sb);
    }
}
