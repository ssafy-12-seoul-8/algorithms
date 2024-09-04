import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] preorder, inorderIdx, postorder;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            preorder = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                preorder[i] = Integer.parseInt(st.nextToken());
            }

            inorderIdx = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                inorderIdx[Integer.parseInt(st.nextToken()) - 1] = i;
            }

            postorder = new int[n];
            toPostorder(0, 0, 0, n);

            for (int p : postorder) {
                sb.append(p).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    // 현재 배열에서 후위로 바꿀 부분의 인덱스
    static void toPostorder(int preStart, int inStart, int postStart, int size) {
        if (size == 0) {
            return;
        }
        if (size == 1) {
            postorder[postStart] = preorder[preStart];
            return;
        }

        int root = preorder[preStart];
        postorder[postStart + size - 1] = root;
        int leftSize = inorderIdx[root - 1] - inStart;
        toPostorder(preStart + 1, inStart, postStart, leftSize);
        toPostorder(preStart + leftSize + 1, inStart + leftSize + 1, postStart + leftSize, size - leftSize - 1);
    }
}
