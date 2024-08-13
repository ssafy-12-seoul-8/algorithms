import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++){
            int three = 0;
            int num = i;
            while (num != 0){
                int tmp = num % 10;
                if (tmp != 0 && tmp % 3 == 0){
                    three++;
                }
                num /= 10;
            }
            if (three == 0){
                sb.append(i);
            } else {
                while (three > 0){
                    sb.append("-");
                    three--;
                }
            }
            sb.append(" ");
        }
        System.out.println(sb);
    }
}
