import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<Comp> maxHeap = new PriorityQueue<>(Comparator.comparingInt(a -> -a.val));
        PriorityQueue<Comp> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        Queue<Comp> q = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            int num = Integer.parseInt(br.readLine());
            Comp nComp = new Comp(num, i);
            q.offer(nComp);
            maxHeap.add(nComp);
        }

        while (maxHeap.size() > minHeap.size() + 1) {
            Comp move = maxHeap.poll();
            minHeap.offer(move);
        }

        long sum = maxHeap.isEmpty() ? 0 : maxHeap.peek().val;

        for (int i = k; i < n; i++) {
            Comp rmv = q.poll();
            minHeap.remove(rmv);
            maxHeap.remove(rmv);

            int num = Integer.parseInt(br.readLine());
            Comp nComp = new Comp(num, i);
            q.offer(nComp);

            if (!minHeap.isEmpty() && num > minHeap.peek().val) {
                minHeap.add(nComp);
            } else {
                maxHeap.add(nComp);
            }

            while (minHeap.size() > maxHeap.size()) {
                Comp move = minHeap.poll();
                maxHeap.offer(move);
            }

            while (maxHeap.size() > minHeap.size() + 1) {
                Comp move = maxHeap.poll();
                minHeap.offer(move);
            }

            sum += maxHeap.peek().val;
        }

        System.out.println(sum);
    }

    private static class Comp {
        int val;
        int idx;

        public Comp(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public String toString() {
            return "Comp{" +
                    "val=" + val +
                    ", idx=" + idx +
                    '}';
        }
    }
}
