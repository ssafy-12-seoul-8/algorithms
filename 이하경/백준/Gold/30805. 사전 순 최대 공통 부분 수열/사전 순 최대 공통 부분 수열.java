import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        int aIdx = 0;
        int bIdx = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (aIdx < n && bIdx < m) {
            int max = 0;
            int aTmp = 0;
            int bTmp = 0;
            for (int i = aIdx; i < n; i++) {
                if (a[i] <= max) {
                    continue;
                }
                for (int j = bIdx; j < m; j++) {
                    if (a[i] == b[j]) {
                        max = a[i];
                        aTmp = i + 1;
                        bTmp = j + 1;
                        break;
                    }
                }
            }
            aIdx = aTmp;
            bIdx = bTmp;
            if (max == 0) {
                break;
            }
            list.add(max);
        }

        sb.append(list.size()).append("\n");
        for (int i:list) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}
