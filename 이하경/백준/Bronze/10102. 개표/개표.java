import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        String vote = br.readLine();
        int a = 0, b = 0;

        for (int i = 0; i < v; i++) {
            if (vote.charAt(i) == 'A') {
                a++;
            } else {
                b++;
            }
        }

        if (a == b) {
            System.out.println("Tie");
        }

        if (a > b) {
            System.out.println("A");
        }

        if (a < b) {
            System.out.println("B");
        }
    }
}
