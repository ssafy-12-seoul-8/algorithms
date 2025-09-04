import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

class Main {
    public static int[] p;
    public static boolean[] know;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> positiveQueue = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> negativeQueue = new PriorityQueue<>();
        int zeroCnt = 0;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num > 0) {
                positiveQueue.add(num);
            }

            if (num == 0) {
                zeroCnt++;
            }

            if (num < 0) {
                negativeQueue.add(num);
            }
        }

        while (!positiveQueue.isEmpty()) {
            if (positiveQueue.size() > 1) {
                int num1 = positiveQueue.poll();
                int num2 = positiveQueue.poll();

                if (num2 == 1) {
                    sum += num1 + num2;
                } else {
                    sum += num1 * num2;
                }
            }

            if (positiveQueue.size() == 1) {
                sum += positiveQueue.poll();
            }
        }

        while (!negativeQueue.isEmpty()) {
            if (negativeQueue.size() > 1) {
                sum += negativeQueue.poll() * negativeQueue.poll();
            }

            if (negativeQueue.size() == 1) {
                int num = negativeQueue.poll();

                if (zeroCnt == 0) {
                    sum += num;
                }
            }
        }

        System.out.println(sum);
    }
}