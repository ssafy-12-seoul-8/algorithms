import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                if (!map.containsKey(x)) {
                    map.put(x, new ArrayList<>());
                }

                map.get(x).add(y);
            }

            ArrayList<int[]> cafe = new ArrayList<>();
            int lastY = 0;
            for (Map.Entry<Integer, ArrayList<Integer>> entry: map.entrySet()) {
                int key = entry.getKey();
                ArrayList<Integer> vals = entry.getValue();
                if (vals.size() == 1) {
                    cafe.add(new int[]{ key, vals.get(0) });
                    continue;
                }
                Collections.sort(vals);
                if (vals.get(0) == lastY) {
                    for (int i = 0; i < vals.size(); i++) {
                        cafe.add(new int[]{ key, vals.get(i) });
                    }
                    lastY = vals.get(vals.size() - 1);
                    continue;
                }
                for (int i = vals.size() - 1; i >= 0; i--) {
                    cafe.add(new int[]{ key, vals.get(i) });
                }
                lastY = vals.get(0);
            }

            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            for (int i = 0; i < m; i++) {
                int idx = Integer.parseInt(st.nextToken()) - 1;
                sb.append(cafe.get(idx)[0]).append(" ").append(cafe.get(idx)[1]).append("\n");
            }
        }
        System.out.println(sb);
    }
}
