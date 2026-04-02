import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int b = Integer.parseInt(br.readLine());

        Set<String> low = new HashSet<>();
        Set<String> high = new HashSet<>();

        for (int i = 0; i < b; i++) {
            String bit = br.readLine();
            low.add(bit);
        }

        for (int i = 0; i < b; i++) {
            String bit = br.readLine();
            high.add(bit);
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String bit = br.readLine();
            int c = 0;
            for (int j = 0; j < bit.length(); j++) {
                for (int k = j + 3; k <= bit.length(); k++) {
                    String sub = bit.substring(j, k);
                    if (low.contains(sub)) {
                        c--;
                    }
                    if (high.contains(sub)) {
                        c++;
                    }
                }
            }

            if (c > 0) {
                sb.append("LOW ").append(c).append("\n");
            } else if (c == 0) {
                sb.append("GOOD").append("\n");
            } else {
                sb.append("HIGH ").append(-c).append("\n");
            }
        }

        System.out.println(sb);
    }
}
