import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {
    static long[] a, b, c, d;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = new long[2];
        b = new long[2];
        c = new long[2];
        d = new long[2];

        a[0] = Long.parseLong(st.nextToken());
        a[1] = Long.parseLong(st.nextToken());
        b[0] = Long.parseLong(st.nextToken());
        b[1] = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        c[0] = Long.parseLong(st.nextToken());
        c[1] = Long.parseLong(st.nextToken());
        d[0] = Long.parseLong(st.nextToken());
        d[1] = Long.parseLong(st.nextToken());

        long minabx = Math.min(a[0], b[0]);
        long minaby = Math.min(a[1], b[1]);
        long maxabx = Math.max(a[0], b[0]);
        long maxaby = Math.max(a[1], b[1]);

        long mincdx = Math.min(c[0], d[0]);
        long mincdy = Math.min(c[1], d[1]);
        long maxcdx = Math.max(c[0], d[0]);
        long maxcdy = Math.max(c[1], d[1]);

        long leftx = Math.min(maxabx, maxcdx);
        long rightx = Math.max(minabx, mincdx);
        long lefty = Math.min(maxaby, maxcdy);
        long righty = Math.max(minaby, mincdy);

        long abc = ccw(a, b, c);
        long abd = ccw(a, b, d);

        if (abc == 0 && abd == 0) {
            if (leftx == rightx && lefty == righty) {
                print(1, leftx, lefty);
                return;
            }

            if (leftx < rightx || lefty < righty) {
                System.out.println(0);
                return;
            }

            System.out.println(1);
            return;
        }

        long cda = ccw(c, d, a);
        long cdb = ccw(c, d, b);

        if (abc * abd > 0 || cda * cdb > 0) {
            System.out.println(0);
            return;
        }

        if (abc == 0) {
            print(1, c[0], c[1]);
            return;
        }

        if (abd == 0) {
            print(1, d[0], d[1]);
            return;
        }

        if (cda == 0) {
            print(1, a[0], a[1]);
            return;
        }

        if (cdb == 0) {
            print(1, b[0], b[1]);
            return;
        }

        if (a[0] == b[0]) {
            double m = (double) (d[1] - c[1]) / (d[0] - c[0]);
            double k = c[1] - m * c[0];
            print(1, a[0], m * a[0] + k);
            return;
        }

        if (c[0] == d[0]) {
            double m = (double) (b[1] - a[1]) / (b[0] - a[0]);
            double k = a[1] - m * a[0];
            print(1, c[0], m * c[0] + k);
            return;
        }

        double m1 = (double) (d[1] - c[1]) / (d[0] - c[0]);
        double k1 = c[1] - m1 * c[0];
        double m2 = (double) (b[1] - a[1]) / (b[0] - a[0]);
        double k2 = a[1] - m2 * a[0];

        double x = (k2 - k1) / (m1 - m2);
        print(1, x, m1 * x + k1);
    }

    static long ccw(long[] a, long[] b, long[] c) {
        if ((b[0] - a[0]) * (c[1] - b[1]) > (b[1] - a[1]) * (c[0] - b[0])) {
            return 1;
        }
        if ((b[0] - a[0]) * (c[1] - b[1]) < (b[1] - a[1]) * (c[0] - b[0])) {
            return -1;
        }
        return 0;
    }

    static void print(int possible, double x, double y) {
        StringBuilder sb = new StringBuilder();
        sb.append(possible).append("\n").append(x).append(" ").append(y);
        System.out.println(sb);
    }
}
