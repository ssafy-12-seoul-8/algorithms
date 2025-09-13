import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int lv = Integer.parseInt(st.nextToken());
        String judge = st.nextToken();

        switch (judge) {
            case "miss":
                System.out.println(0);
                break;
            case "bad":
                System.out.println(200 * lv);
                break;
            case "cool":
                System.out.println(400 * lv);
                break;
            case "great":
                System.out.println(600 * lv);
                break;
            case "perfect":
                System.out.println(1000 * lv);
        }

    }
}
