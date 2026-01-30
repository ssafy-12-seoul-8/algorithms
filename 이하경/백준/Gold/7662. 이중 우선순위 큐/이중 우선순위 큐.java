import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                String op = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (op.equals("I")) {
                    if (map.containsKey(num)) {
                        map.put(num, map.get(num) + 1);
                    } else {
                        map.put(num, 1);
                    }
                    continue;
                }

                if (op.equals("D")) {
                    if (map.isEmpty()) {
                        continue;
                    }

                    if (num == -1) {
                        Map.Entry<Integer, Integer> ent = map.firstEntry();
                        if (ent.getValue() == 1) {
                            map.remove(ent.getKey());
                        } else {
                            map.put(ent.getKey(), ent.getValue() - 1);
                        }
                        continue;
                    }

                    if (num == 1) {
                        Map.Entry<Integer, Integer> ent = map.lastEntry();
                        if (ent.getValue() == 1) {
                            map.remove(ent.getKey());
                        } else {
                            map.put(ent.getKey(), ent.getValue() - 1);
                        }
                    }
                }
            }

            if (map.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
        }

        System.out.println(sb);
    }
}
