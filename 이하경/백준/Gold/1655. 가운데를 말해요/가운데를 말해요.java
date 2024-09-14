import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// pq를 2 개 이용한다
// 작은 쪽은 MaxHeap을 이용해서 작은 것중 최대를 뽑고
// 큰쪽은 MinHeap을 이용해서 큰 것중 최소를 뽑고
// 둘이 개수를 같게 유지하면 항상 중간값을 logN에 뽑을 수 있다

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder()); // 작은쪽, MaxHeap
        PriorityQueue<Integer> right = new PriorityQueue<>(); // 큰쪽, MinHeap

        // left의 크기가 right와 같거나 1개 크게 유지하면 항상 left.peek가 정답이다
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (left.isEmpty() || left.peek() >= num) {
                left.offer(num);
                if (left.size() > right.size() + 1) {
                    right.offer(left.poll());
                }
            } else {
                right.offer(num);
                if (right.size() > left.size()) {
                    left.offer(right.poll());
                }
            }


            sb.append(left.peek()).append("\n");
        }

        System.out.println(sb);
    }
}
