import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Cls[] person = new Cls[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            person[i] = new Cls(start, end);
        }

        Arrays.sort(person);

        PriorityQueue<Cls> using = new PriorityQueue<>();
        PriorityQueue<Integer> seat = new PriorityQueue<>();
        int[] com = new int[n + 1];
        int count = 0;

        for (int i = 0; i < n; i++) {
            while (!using.isEmpty() && using.peek().std < person[i].std) {
                Cls now = using.poll();
                seat.add(now.rest);
            }
            if (seat.isEmpty()) {
                using.add(new Cls(person[i].rest, ++count));
                com[count]++;
            } else {
                int use = seat.poll();
                using.add(new Cls(person[i].rest, use));
                com[use]++;
            }
        }

        sb.append(count).append("\n");
        for (int i = 1; i <= count; i++) {
            sb.append(com[i]).append(" ");
        }

        System.out.println(sb);
    }

    static class Cls implements Comparable<Cls> {
        int std;
        int rest;

        public Cls(int std, int rest) {
            this.std = std;
            this.rest = rest;
        }

        @Override
        public int compareTo(Cls o) {
            return this.std - o.std;
        }
    }
}
