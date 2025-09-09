import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] U = new int[N];
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < N; i++) {
            U[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(U);

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                hashSet.add(U[i] + U[j]);
            }
        }

        for (int i = N - 1; i >= 1; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (hashSet.contains(U[i] - U[j])) {
                    System.out.println(U[i]);
                    return;
                }
            }
        }
    }
}