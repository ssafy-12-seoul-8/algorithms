import java.io.*;
import java.util.*;

public class Main {
    static int l, k, c;
    static int[] pieces;
    static int firstCut;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        l = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int[] cut = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            cut[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cut);

        pieces = new int[k + 1];
        pieces[0] = cut[0];
        for (int i = 1; i < k; i++) {
            pieces[i] = cut[i] - cut[i - 1];
        }
        pieces[k] = l - cut[k - 1];

        int len = parametricSearh(0, l);
        sb.append(len).append(" ").append(firstCut);

        System.out.println(sb);
    }

    static int parametricSearh(int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (possible(mid)) {
                end = mid;
                continue;
            }
            start = mid + 1;
        }

        return start;
    }

    static boolean possible(int len) {
        int count = 1;
        int sum = 0;

        for (int i = k; i >= 0; i--) {
            if (len < pieces[i]) {
                return false;
            }
            if (pieces[i] <= len - sum) {
                sum += pieces[i];
                continue;
            }
            count++;
            sum = pieces[i];
        }

        if (count > c + 1) {
            return false;
        }

        if (count <= c) {
            firstCut = pieces[0];
        } else {
            firstCut = sum;
        }

        return true;
    }
}