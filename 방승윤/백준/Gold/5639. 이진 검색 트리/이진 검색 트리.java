import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static StringBuilder sb = new StringBuilder();

    public static class Node {
        int v;
        Node l;
        Node r;

        Node(int v) {
            this.v = v;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        Node root = new Node(Integer.parseInt(br.readLine()));

        while ((line = br.readLine()) != null) {
            int num = Integer.parseInt(line);
            insert(root, num);
        }

        postOrder(root);
        System.out.println(sb);
    }

    public static Node insert(Node node, int v) {
        if (node == null) {
            return new Node(v);
        }

        if (v < node.v) {
            node.l = insert(node.l, v);
        }

        if (v > node.v) {
            node.r = insert(node.r, v);
        }

        return node;
    }

    public static void postOrder(Node node) {
        if (node.l != null) {
            postOrder(node.l);
        }

        if (node.r != null) {
            postOrder(node.r);
        }

        sb.append(node.v).append("\n");
    }
}