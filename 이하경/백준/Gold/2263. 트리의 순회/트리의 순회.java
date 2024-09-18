import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] inOrderIdx, postOrder;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        inOrderIdx = new int[n + 1];
        postOrder = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int idx = Integer.parseInt(st.nextToken());
            inOrderIdx[idx] = i;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }

        toPreOrder(1, 1, n);

        System.out.println(sb);
    }

    static void toPreOrder(int inStart, int postStart, int len) {
        if (len == 0) {
            return;
        }
        
        // postOrder의 LRV를 VLR로 바꾼다
        // 트리를 돌며 루트만 앞으로 빼준다
        if (len == 1) { // 리프노드인 경우
            sb.append(postOrder[postStart]).append(" ");
            return;
        }

        int root = postOrder[postStart + len - 1];
        sb.append(root).append(" ");

        // inStart에서 inOrder[root] 전까지가 왼쪽 트리
        int leftLen = inOrderIdx[root] - inStart;
        toPreOrder(inStart, postStart, leftLen);
        toPreOrder(inOrderIdx[root] + 1, postStart + leftLen, len - leftLen - 1);
    }
}
