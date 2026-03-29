import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());

        Node first = new Node(1, num, null, null);
        Node prev = first;
        for (int i = 2; i <= n; i++) {
            num = Integer.parseInt(st.nextToken());
            Node curr = new Node(i, num, prev, null);
            prev.next = curr;
            prev = curr;
        }
        prev.next = first;
        first.prev = prev;

        Node curr = first;
        while (n-- > 0) {
            sb.append(curr.idx).append(" ");
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;

            num = curr.num;
            while (num > 0) {
                curr = curr.next;
                num--;
            }
            while (num < 0) {
                curr = curr.prev;
                num++;
            }
        }

        System.out.println(sb);
    }

    private static class Node {
        int idx;
        int num;
        Node prev;
        Node next;

        public Node(int idx, int num, Node prev, Node next) {
            this.idx = idx;
            this.num = num;
            this.prev = prev;
            this.next = next;
        }
    }
}