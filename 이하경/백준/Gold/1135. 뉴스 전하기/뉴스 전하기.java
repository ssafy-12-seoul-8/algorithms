import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] child;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        child = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            child[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        st.nextToken();
        for (int i = 1; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            child[parent].add(i);
        }

        System.out.println(getTime(0) - 1);
    }

    static int getTime(int p) {
        if (child[p].isEmpty()) {
            return 1;
        }

        int[] times = new int[child[p].size()];
        for (int i = 0; i < times.length; i++) {
            times[i] = getTime(child[p].get(i));
        }

        Arrays.sort(times);

        int max = 0;

        for (int i = 0; i < times.length; i++) {
            max = Math.max(max, times[times.length - 1 - i] + i);
        }

        return max + 1;
    }
}
