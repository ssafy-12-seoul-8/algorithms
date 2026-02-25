import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s1 = br.readLine();
        String s2 = br.readLine();
        int[] lcs = new int[1000];
        Node[] tailNodes = new Node[1000];
        int maxIdx = 0;

        for (int i = 0; i < s1.length(); i++) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    int idx = binarySearch(lcs, 0, maxIdx, j);
                    if (idx == maxIdx) {
                        maxIdx++;
                    }
                    lcs[idx] = j;
                    if (idx == 0) {
                        tailNodes[idx] = new Node(j, null);
                    } else {
                        tailNodes[idx] = new Node(j, tailNodes[idx - 1]);
                    }
                }
            }
        }

        sb.append(maxIdx).append("\n");
        if (maxIdx != 0) {
            Node currNode = tailNodes[maxIdx - 1];
            ArrayList<Character> list = new ArrayList<>();
            while (currNode != null) {
                list.add(s2.charAt(currNode.pos));
                currNode = currNode.parent;
            }
            for (int i = list.size() - 1; i >= 0; i--) {
                sb.append(list.get(i));
            }
        }

        System.out.println(sb);
    }

    static int binarySearch(int[] arr, int start, int end, int target) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] < target) {
                start = mid + 1;
                continue;
            }
            end = mid;
        }
        return end;
    }

    private static class Node {
        int pos;
        Node parent;

        public Node(int pos, Node parent) {
            this.pos = pos;
            this.parent = parent;
        }
    }
}
