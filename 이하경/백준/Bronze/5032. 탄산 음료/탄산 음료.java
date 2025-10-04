import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int bottle = e + f;
        int count = 0;

        while (bottle >= c) {
            count += bottle / c;
            bottle = bottle % c + bottle / c;
        }

        System.out.println(count);
    }
}
