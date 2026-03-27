import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] blueray = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            blueray[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(parametricSearch(1, n * 10_000, blueray, m));
    }

    static int parametricSearch(int start, int end, int[] blueray, int m) {
        while (start < end){
            int mid = (start + end) / 2;
            if (possible(blueray, m, mid)) {
                end = mid;
                continue;
            }
            start = mid + 1;
        }

        return start;
    }

    static boolean possible(int[] blueray, int m, int size) {
        int count = 1;
        int curr = 0;
        for (int min:blueray) {
            if (size < min) {
                return false;
            }
            
            if (min <= size - curr) {
                curr += min;
            } else {
                count++;
                curr = min;
            }

            if (count > m) {
                return false;
            }
        }

        return true;
    }
}