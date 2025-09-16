import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String name = st.nextToken();

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String nick = st.nextToken();
            String ans = st.nextToken();

            if (nick.equals(name)) {
                System.out.println(map.getOrDefault(ans, 0));
                return;
            }

            map.put(ans, map.getOrDefault(ans, 0) + 1);
        }
    }
}
