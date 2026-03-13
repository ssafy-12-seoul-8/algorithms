import java.io.*;
import java.util.*;

public class Main {
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input;
        while ((input = br.readLine()) != null) {
            count = 0;
            int n = Integer.parseInt(input);
            Alp head = new Alp('0');
            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                Alp curr = head;
                for (int j = 0; j < str.length(); j++) {
                    char next = str.charAt(j);
                    if (curr.children[next - 'a'] == null) {
                        curr.children[next - 'a'] = new Alp(next);
                        curr.childCount++;
                    }
                    curr = curr.children[next - 'a'];
                }
                curr.end = true;
            }

            for (int i = 0; i < 26; i++) {
                if (head.children[i] == null) {
                    continue;
                }
                dfs(head.children[i], 1);
            }

            sb.append(String.format("%.2f", (double) count / n)).append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(Alp head, int type) {
        if (head.end) {
            count += type;
        }

        int nextType = type + (head.childCount > 1 || head.end ? 1 : 0);
        for (int i = 0; i < 26; i++) {
            if (head.children[i] == null) {
                continue;
            }
            dfs(head.children[i], nextType);
        }
    }

    private static class Alp {
        char c;
        Alp[] children;
        boolean end = false;
        int childCount = 0;

        Alp(char c) {
            this.c = c;
            children = new Alp[26];
        }
    }
}
