import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String t = br.readLine();
        int key = t.charAt(0)^'C';

        for (int i = 0; i < t.length(); i++) {
            sb.append((char)(t.charAt(i)^key));
        }

        System.out.println(sb);
    }
}
