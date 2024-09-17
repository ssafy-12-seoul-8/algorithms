import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    static int n, k;
    static Jewel[] jewels;
    static TreeMap<Integer, Integer> bag;

    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        jewels = new Jewel[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int mass = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(mass, value);
        }

        bag = new TreeMap<>();
        for (int i = 0; i < k; i++) {
            int cost = Integer.parseInt(br.readLine());

            if (!bag.containsKey(cost)) {
                bag.put(cost, 1);
                continue;
            }

            bag.put(cost, bag.get(cost) + 1);
        }
    }

    static void solve() {
        Arrays.sort(jewels);

        long ans = 0; // 1,000,000 * 300,000
        for (int i = 0; i < n; i++) {
            Jewel j = jewels[i];
            Integer find = bag.ceilingKey(j.mass);

            if (find == null) {
                continue;
            }

            ans += j.value;

            if (bag.get(find) == 1) {
                bag.remove(find);
                continue;
            }
            bag.put(find, bag.get(find) - 1);
        }

        System.out.println(ans);
    }

    static class Jewel implements Comparable<Jewel> {
        int mass, value;

        public Jewel(int mass, int value) {
            this.mass = mass;
            this.value = value;
        }

        @Override
        public int compareTo(Jewel o) {
            return o.value - this.value;
        }
    }
}
