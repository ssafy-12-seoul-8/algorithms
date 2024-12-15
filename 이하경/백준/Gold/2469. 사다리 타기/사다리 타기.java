import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int k = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        char[] targetSequence = br.readLine().toCharArray();

        char[] sequence = new char[k];
        for (int i = 0; i < k; i++) {
            sequence[i] = (char) (i + 'A');
        }

        int hiddenLine = -1;
        for (int i = 0; i < n; i++) {
            char[] line = br.readLine().toCharArray();
            if (line[0] == '?') {
                hiddenLine = i;
                break;
            }

            climbLadder(sequence, line);
        }

        char[][] ladder = new char[n - 1 - hiddenLine][];
        for (int i = 0; i < ladder.length; i++) {
            ladder[i] = br.readLine().toCharArray();
        }

        for (int i = ladder.length - 1; i >= 0; i--) {
            climbLadder(targetSequence, ladder[i]);
        }

        boolean flag = true;
        for (int i = 0; i < k - 1; i++) {
            if (sequence[i] == targetSequence[i]) {
                sb.append('*');
                continue;
            }

            if (sequence[i] == targetSequence[i + 1] && sequence[i + 1] == targetSequence[i]) {
                sb.append('-');
                swap(sequence, i, i + 1);
                continue;
            }

            flag = false;
            break;
        }

        if (flag) {
            System.out.println(sb);
            return;
        }

        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < k - 1; i++) {
            sb2.append('x');
        }
        System.out.println(sb2);
    }

    public static void climbLadder(char[] seq, char[] ladder) {
        for (int i = 0; i < ladder.length; i++) {
            if (ladder[i] == '-') {
                swap(seq, i, i + 1);
                i++;
            }
        }
    }

    public static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
