import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> all = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        TreeSet<Integer> starts = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int home = Integer.parseInt(st.nextToken());
            int office = Integer.parseInt(st.nextToken());
            if (home < office) {
                all.add(new int[]{home, office});
                starts.add(home);
            } else {
                all.add(new int[]{office, home});
                starts.add(office);
            }
        }

        int l = Integer.parseInt(br.readLine());

        // 현재 철로에 집과 사무실이 모두 포함. 먼저 벗어나는 거 기준 정렬
        PriorityQueue<int[]> include = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        // 현재 철로에 집만 포함. 철로에 빨리 들어가는 기준 정렬
        PriorityQueue<int[]> reserve = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        int start = starts.pollFirst();
        while (!all.isEmpty() && all.peek()[0] <= start + l) {
            reserve.add(all.poll());
        }
        while (!reserve.isEmpty() && reserve.peek()[1] <= start + l) {
            include.add(reserve.poll());
        }
        int max = include.size();

        while (!starts.isEmpty()) {
            start = starts.pollFirst();

            while (!all.isEmpty() && all.peek()[0] <= start + l) {
                reserve.add(all.poll());
            }
            while (!reserve.isEmpty() && reserve.peek()[1] <= start + l) {
                include.add(reserve.poll());
            }
            while (!include.isEmpty() && include.peek()[0] < start) {
                include.poll();
            }
            max = Math.max(max, include.size());

        }

        System.out.println(max);
    }
}
