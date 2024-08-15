import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int l = Integer.parseInt(br.readLine());
        int[] cake = new int[l + 1];
        int wantMax = 0;
        int wantMaxPerson = -1;
        int haveMax = 0;
        int haveMaxPerson = -1;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int want = k - p + 1;
            if (want > wantMax){
                wantMax = want;
                wantMaxPerson = i + 1;
            }
            int have = 0;
            for (int j = p; j <= k; j++){
                if (cake[j] == 0){
                    cake[j] = i + 1;
                    have++;
                }
            }
            if (have > haveMax){
                haveMax = have;
                haveMaxPerson = i + 1;
            }
        }

        System.out.println(wantMaxPerson);
        System.out.println(haveMaxPerson);

    }
}
