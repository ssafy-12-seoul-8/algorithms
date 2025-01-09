import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int zeroX = 0;
        int zeroY = 0;
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                int num = Integer.parseInt(st.nextToken());
                sb.append(num);

                if (num == 0) {
                    zeroX = i;
                    zeroY = j;
                }
            }
        }

        System.out.println(solve(new State(sb.toString(), zeroX, zeroY, 0)));
    }

    public static int solve(State init) {
        String arranged = "123456780";
        int[] dx = { 0, 0, 1, -1 };
        int[] dy = { 1, -1, 0, 0 };

        Set<String> check = new HashSet<>();
        Queue<State> q = new LinkedList<>();
        q.add(init);
        check.add(init.puzzle);

        while (!q.isEmpty()) {
            State curr = q.poll();

            if (curr.puzzle.equals(arranged)) {
                return curr.move;
            }

            for (int d = 0; d < 4; d++) {
                int nx = curr.zeroX + dx[d];
                int ny = curr.zeroY + dy[d];

                if (nx >= 0 && nx < 3 && ny >= 0 && ny < 3) {
                    String nextPuzzle = curr.swap(curr.zeroX * 3 + curr.zeroY, nx * 3 + ny);

                    if (check.contains(nextPuzzle)) {
                        continue;
                    }
                    check.add(nextPuzzle);

                    q.add(new State(nextPuzzle, nx, ny, curr.move + 1));
                }
            }
        }

        return -1;
    }

    public static class State {
        String puzzle;
        int zeroX;
        int zeroY;
        int move;

        public State(String puzzle, int zeroX, int zeroY, int move) {
            this.puzzle = puzzle;
            this.zeroX = zeroX;
            this.zeroY = zeroY;
            this.move = move;
        }

        public String swap(int i, int j) {
            StringBuilder sb = new StringBuilder(this.puzzle);
            char tmp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, tmp);

            return sb.toString();
        }
    }
}
