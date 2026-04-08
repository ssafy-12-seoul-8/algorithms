import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] use = new int[k];
        Queue<Integer>[] time = new Queue[k + 1];
        for (int i = 1; i <= k; i++) {
            time[i] = new ArrayDeque<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            use[i] = Integer.parseInt(st.nextToken());
            time[use[i]].offer(i);
        }

        for (int i = 1; i <= k; i++) {
            time[i].offer(k); // 마지막에 최댓값을 넣어준다
        }

        HashSet<Integer> multitap = new HashSet<>();
        int count = 0;

        for (int i = 0; i < k; i++) {
            if (multitap.contains(use[i])) {
                time[use[i]].poll();
                continue;
            }

            if (multitap.size() == n) {
                int maxVal = 0;
                int maxIdx = 0;
                for (int j : multitap) {
                    int t = time[j].peek();
                    if (t > maxVal) {
                        maxVal = t;
                        maxIdx = j;
                    }
                }
                multitap.remove(maxIdx);
                count++;
            }

            multitap.add(use[i]);
            time[use[i]].poll();
        }

        System.out.println(count);
    }
}
