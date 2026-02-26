import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int c;
    static long[] items;
    static ArrayList<Long> lItems;
    static ArrayList<Long> rItems;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        items = new long[n];
        lItems = new ArrayList<>();
        rItems = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            items[i] = Long.parseLong(st.nextToken());
        }

        comb(0, 0, n / 2, lItems);
        comb(0, n / 2, n, rItems);
        Collections.sort(lItems);
        Collections.sort(rItems);

        int count = 0;
        int l = 0;
        int r = rItems.size() - 1;
        while (l < lItems.size() && r >= 0) { // l 위치의 조합이 r 이하의 모든 조합 선택 가능한지
            while (r >= 0 && lItems.get(l) + rItems.get(r) > c) {
                r--;
            }

            count += r + 1;
            l++;
        }

        System.out.println(count);
    }

    static void comb(long sum, int idx, int end, ArrayList<Long> list) { // 현재 합 sum, idx번을 선택할지 말지
        list.add(sum);

        if (idx == end) {
            return;
        }

        for (int i = idx; i < end; i++) {
            comb(sum + items[i], i + 1, end, list);
        }
    }
}
