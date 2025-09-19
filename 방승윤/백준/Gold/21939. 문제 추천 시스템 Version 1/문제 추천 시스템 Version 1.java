import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static int cnt;
    public static int bomb;
    public static ArrayList<Integer>[] tree;

    public static class Problem implements Comparable<Problem> {
        int num;
        int difficult;

        Problem(int num, int difficult) {
            this.num = num;
            this.difficult = difficult;
        }

        @Override
        public int compareTo(Problem problem) {
            if (this.difficult == problem.difficult) {
                return this.num - problem.num;
            }

            return this.difficult - problem.difficult;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Problem> pq = new PriorityQueue<>();
        PriorityQueue<Problem> pqReverse = new PriorityQueue<>(Comparator.reverseOrder());
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int difficult = Integer.parseInt(st.nextToken());
            Problem problem = new Problem(num, difficult);
            pq.add(problem);
            pqReverse.add(problem);
            hashMap.put(num, difficult);
        }

        int M = Integer.parseInt(br.readLine());

        one: for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("add")) {
                int num = Integer.parseInt(st.nextToken());
                int difficult = Integer.parseInt(st.nextToken());
                hashMap.put(num, difficult);
                Problem problem = new Problem(num, difficult);
                pq.add(problem);
                pqReverse.add(problem);
                continue;
            }

            if (command.equals("recommend")) {
                int type = Integer.parseInt(st.nextToken());

                if (type == 1) {
                    while (true) {
                        Problem problem = pqReverse.peek();
                        int num = problem.num;
                        int difficult = problem.difficult;

                        if (hashMap.containsKey(num) && hashMap.get(num) == difficult) {
                            sb.append(num).append("\n");
                            continue one;
                        }

                        pqReverse.poll();
                    }
                }

                while (true) {
                    Problem problem = pq.peek();
                    int num = problem.num;
                    int difficult = problem.difficult;

                    if (hashMap.containsKey(num) && hashMap.get(num) == difficult) {
                        sb.append(num).append("\n");
                        continue one;
                    }

                    pq.poll();
                }
            }

            int num = Integer.parseInt(st.nextToken());
            hashMap.remove(num);
        }

        System.out.println(sb);
    }
}