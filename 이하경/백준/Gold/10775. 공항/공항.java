import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int g = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());

        TreeSet<Integer> gates = new TreeSet<>();

        for (int i = 1; i <= g; i++) {
            gates.add(i);
        }

        int cnt = 0;
        for (int i = 0; i < p; i++) {
            int plane = Integer.parseInt(br.readLine());
            Integer find = gates.floor(plane);
            if (find == null) {
                System.out.println(cnt);
                return;
            }
            gates.remove(find);
            cnt++;
        }
        System.out.println(cnt);
    }
}
