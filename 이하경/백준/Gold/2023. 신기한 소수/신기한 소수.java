import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> primes = getPrimes(n);
        ArrayList<Integer> prev = new ArrayList<>();
        ArrayList<Integer> next = new ArrayList<>();

        prev.add(2);
        prev.add(3);
        prev.add(5);
        prev.add(7);

        for (int i = 1; i < n; i++) {
            next = new ArrayList<>();
            for (int p:prev) {
                for (int j = 1; j <= 9; j++) {
                    int curr = p * 10 + j;
                    boolean isPrime = true;
                    for (int prime:primes) {
                        if (curr % prime == 0) {
                            isPrime = false;
                            break;
                        }
                        if (prime >= Math.sqrt(curr)) {
                            break;
                        }
                    }

                    if (isPrime) {
                        next.add(curr);
                    }
                }
            }
            prev = next;
        }

        for (int p:prev) {
            sb.append(p).append("\n");
        }
        System.out.println(sb);
    }

    public static ArrayList<Integer> getPrimes(int digit) {
        ArrayList<Integer> primes = new ArrayList<>();
        int maxNum = (int) Math.sqrt(Math.pow(10, digit));
        boolean[] notPrime = new boolean[maxNum + 1];

        int checkMax = (int) Math.sqrt(maxNum + 1);
        for (int i = 2; i <= checkMax; i++) {
            if (notPrime[i]) {
                continue;
            }

            primes.add(i);
            for (int j = 2; j * i < maxNum; j++) {
                notPrime[i * j] = true;
            }
        }

        for (int i = checkMax + 1; i < maxNum; i++) {
            if (!notPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }
}
