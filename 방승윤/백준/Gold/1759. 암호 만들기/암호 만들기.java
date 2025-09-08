import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static StringBuilder sb = new StringBuilder();
    public static int L;
    public static int C;
    public static char[] alphabets;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        alphabets = new char[C];
        visited = new boolean[C];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < C; i++) {
            alphabets[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(alphabets);
        recur(-1, 0,0);
        System.out.println(sb);
    }

    public static void recur(int curr, int level, int vowel) {
        if (level == L) {
            if (vowel < 1 || vowel > L - 2) {
                return;
            }

            for (int i = 0; i < C; i++) {
                if (visited[i]) {
                    sb.append(alphabets[i]);
                }
            }

            sb.append("\n");
        }

        for (int i = curr + 1; i < C; i++) {
            visited[i] = true;
            char alphabet = alphabets[i];

            if (alphabet == 'a' || alphabet == 'e' || alphabet == 'i' || alphabet == 'o' || alphabet == 'u') {
                recur(i, level + 1, vowel + 1);
                visited[i] = false;
                continue;
            }

            recur(i, level + 1, vowel);
            visited[i] = false;
        }
    }
}