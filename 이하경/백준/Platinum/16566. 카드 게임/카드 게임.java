import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static int[] minsu, p;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken()); // n은 왜 주는걸까?
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        minsu = new int[m + 1];
        p = new int[m + 1]; // 나보다 크거나같은 다음수의 인덱스 저장

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            minsu[i] = Integer.parseInt(st.nextToken());
        }
        minsu[m] = n;
        Arrays.sort(minsu);

        for (int i = 1; i <= m; i++) {
            p[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int chulsu = Integer.parseInt(st.nextToken());
            sb.append(findCard(m, chulsu)).append("\n");
        }
        System.out.println(sb);
    }

    // chulsu보다 큰 가장 작은 카드의 인덱스 구하기
    // 내지 못하는 경우는 없으므로 범위 내에서만 탐색
    static int findCard(int m, int chulsu) {
        int start = 0;
        int end = m;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (minsu[mid] > chulsu) { // mid가 크거나같으면 작은쪽에 답이있다
                end = mid - 1;
                continue;
            }
            start = mid + 1;
        }
        // start == end일때 end는 1 작아지고, start는 그대로이므로 start가 답이다
        int ansIdx = find(start);
        union(ansIdx + 1, ansIdx);

        return minsu[ansIdx];
    }

    // y가 x의 자식이 된다
    static void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        p[py] = px;
    }

    static int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
