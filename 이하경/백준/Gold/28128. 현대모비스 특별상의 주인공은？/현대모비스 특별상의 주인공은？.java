import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[][] names = new String[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                names[i][j] = st.nextToken();
            }
        }

        Set<String> ans = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (m >= 2) {
                if (names[i][0].equals(names[i][1])) {
                    ans.add(names[i][0]);
                }
            }
            for (int j = 2; j < m; j++) {
                if (names[i][j].equals(names[i][j - 1]) || names[i][j].equals(names[i][j - 2])) {
                    ans.add(names[i][j]);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (n >= 2) {
                if (names[0][i].equals(names[1][i])) {
                    ans.add(names[0][i]);
                }
            }
            for (int j = 2; j < n; j++) {
                if (names[j][i].equals(names[j - 1][i]) || names[j][i].equals(names[j - 2][i])) {
                    ans.add(names[j][i]);
                }
            }
        }

        ArrayList<String> tmp = new ArrayList<>(ans);
        Collections.sort(tmp);
        for (String s:tmp) {
            sb.append(s).append("\n");
        }

        if (tmp.isEmpty()) {
            sb.append("MANIPULATED");
        }

        System.out.println(sb);
    }
}
