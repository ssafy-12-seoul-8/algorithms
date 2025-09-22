import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> lower = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> upper = new PriorityQueue<>();
        int curr = Integer.parseInt(br.readLine());
        sb.append(curr).append("\n");

        for (int i = 0; i < N - 1; i++) {
            int newNum = Integer.parseInt(br.readLine());

            if (curr > newNum) {
                lower.add(newNum);
            } else {
                upper.add(newNum);
            }

            if (lower.size() > upper.size()) {
                upper.add(curr);
                curr = lower.poll();
            } else if (upper.size() > lower.size() + 1) {
                lower.add(curr);
                curr = upper.poll();
            }

            sb.append(curr).append("\n");
        }

        System.out.println(sb);
    }
}