import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String name;
        HashMap<String, Integer> hashMap = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>();
        double cnt = 0;

        while ((name = br.readLine()) != null) {
            hashMap.put(name, hashMap.getOrDefault(name, 0) + 1);
            cnt++;
        }

        pq.addAll(hashMap.keySet());

        while (!pq.isEmpty()) {
            String tree = pq.poll();
            sb.append(tree).append(" ").append(String.format("%.4f", hashMap.get(tree) / cnt * 100)).append("\n");
        }

        System.out.println(sb);
    }
}