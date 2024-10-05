import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer> preOrder = new ArrayList<>();
    static int next = 1;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                preOrder.add(Integer.parseInt(br.readLine()));
            } catch (Exception e) {
                break;
            }
        }

        preToPost(1_000_000, preOrder.get(0));
        System.out.println(sb);
    }

    static void preToPost(int root, int curr) {
        if (next >= preOrder.size()) {
            sb.append(curr).append("\n");
            return;
        }

        if (preOrder.get(next) < curr) {
            preToPost(curr, preOrder.get(next++));
        }

        if (next >= preOrder.size()) {
            sb.append(curr).append("\n");
            return;
        }

        if (preOrder.get(next) < root) {
            preToPost(root, preOrder.get(next++));
        }

        sb.append(curr).append("\n");
    }
}
