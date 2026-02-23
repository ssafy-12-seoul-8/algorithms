import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        TreeSet<Node> tree = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            TreeSet<Node> next = tree;
            for (int j = 0; j < k; j++) {
                String word = st.nextToken();
                boolean find = false;
                for (Node nd:next) {
                    if (nd.word.equals(word)) {
                        next = nd.children;
                        find = true;
                        break;
                    }
                }
                if (!find) {
                    Node newNode = new Node(word, new TreeSet<>());
                    next.add(newNode);
                    next = newNode.children;
                }
            }
        }

        for (Node nd:tree) {
            append(sb, nd, 0);
        }

        System.out.println(sb);
    }

    static void append(StringBuilder sb, Node node, int depth) {
        for (int i = 0; i < depth; i++) {
            sb.append("--");
        }
        sb.append(node.word).append("\n");

        for (Node nd: node.children) {
            append(sb, nd, depth + 1);
        }
    }

    private static class Node implements Comparable<Node> {
        String word;
        TreeSet<Node> children;

        public Node(String word, TreeSet<Node> children) {
            this.word = word;
            this.children = children;
        }

        @Override
        public int compareTo(Node o){
            return this.word.compareTo(o.word);
        }
    }
}
