import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        boolean[] song = new boolean[n * (l + 5) - 5];
        int time = 0;
        while (time < song.length) {
            for (int i = 0; i < l; i++) {
                song[time + i] = true;
            }
            time += l + 5;
        }

        time = 0;
        while (time < song.length) {
            if (!song[time]) {
                System.out.println(time);
                return;
            }
            time += d;
        }

        System.out.println(time);
    }
}