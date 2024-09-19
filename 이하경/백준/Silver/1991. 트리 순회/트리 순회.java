import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] child;
    static StringBuilder pre, in, post;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        child = new int[26][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int root = st.nextToken().charAt(0) - 'A';
            int left = st.nextToken().charAt(0) - 'A';
            int right = st.nextToken().charAt(0) - 'A';

            child[root][0] = left;
            child[root][1] = right;
        }

        pre = new StringBuilder();
        in = new StringBuilder();
        post = new StringBuilder();

        traversal(0);

        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }

    static void traversal(int root) {
        if (root < 0) {
            return;
        }

        char r = (char) (root + 'A');
        pre.append(r);
        traversal(child[root][0]);
        in.append(r);
        traversal(child[root][1]);
        post.append(r);
    }
}
