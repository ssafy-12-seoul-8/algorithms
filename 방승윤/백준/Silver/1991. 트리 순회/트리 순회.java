import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static StringBuilder sb = new StringBuilder();
    public static Node[] tree;

    public static class Node {
        char left;
        char right;

        Node(char left, char right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        tree = new Node[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            tree[st.nextToken().charAt(0) - 'A'] = new Node(st.nextToken().charAt(0), st.nextToken().charAt(0));
        }

        preorder('A');
        sb.append("\n");
        inorder('A');
        sb.append("\n");
        postorder('A');
        System.out.println(sb);
    }

    public static void preorder(char curr) {
        if (curr == '.') {
            return;
        }

        sb.append(curr);
        preorder(tree[curr - 'A'].left);
        preorder(tree[curr - 'A'].right);
    }

    public static void inorder(char curr) {
        if (curr == '.') {
            return;
        }

        inorder(tree[curr - 'A'].left);
        sb.append(curr);
        inorder(tree[curr - 'A'].right);
    }

    public static void postorder(char curr) {
        if (curr == '.') {
            return;
        }

        postorder(tree[curr - 'A'].left);
        postorder(tree[curr - 'A'].right);
        sb.append(curr);
    }
}