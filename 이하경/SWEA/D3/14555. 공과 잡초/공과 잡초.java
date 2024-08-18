import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++){
            int cnt = 0;
            String input = br.readLine();
            int len = input.length();

            for (int i = 0; i < len; i++){
                char c = input.charAt(i);
                if (c == '('){
                    cnt++;
                    i++;
                } else if (c == ')'){
                    cnt++;
                }
            }

            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
