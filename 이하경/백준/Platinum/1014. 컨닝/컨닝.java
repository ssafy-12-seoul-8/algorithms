import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int c = Integer.parseInt(br.readLine());
        while (c-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] room = new int[n];
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                for (int j = 0; j < m; j++) {
                    if (line.charAt(j) == 'x') {
                        room[i] |= (1 << j);
                    }
                }
            }

            int maxBit = 1 << m;
            int[] prevDp = new int[maxBit];
            int[] currDp = new int[maxBit];
            ArrayList<Integer>[] validBit = new ArrayList[n];

            for (int i = 0; i < n; i++) {
                validBit[i] = new ArrayList<>();
            }

            for (int i = 0; i < maxBit; i++) {
                if ((i & (i << 1)) == 0 && (i & room[0]) == 0) {
                    prevDp[i] = Integer.bitCount(i);
                    validBit[0].add(i);
                }
            }

            for (int i = 1; i < n; i++) {
                for (int j = 0; j < maxBit; j++) {
                    if ((j & (j << 1)) != 0 || ((j & room[i]) != 0)) {
                        continue;
                    }
                    validBit[i].add(j);
                    int ban = (j << 1) | (j >> 1);
                    int bitCount = Integer.bitCount(j);

                    for (int bit:validBit[i - 1]) {
                        if ((ban & bit) == 0) {
                            currDp[j] = Math.max(currDp[j], prevDp[bit] + bitCount);
                        }
                    }
                }
                prevDp = currDp;
                currDp = new int[maxBit];
            }

            int max = 0;
            for (int i = 0; i < maxBit; i++) {
                max = Math.max(max, prevDp[i]);
            }

            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}
