import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        char[][] sky = new char[h][w];
        int[][] predict = new int[h][w];

        for (int i = 0; i < h; i++) {
            sky[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < h; i++) {
            int prev = -1;
            for (int j = 0; j < w; j++) {
                if (sky[i][j] == 'c') {
                    predict[i][j] = 0;
                    prev = j;
                } else {
                    if (prev == -1){
                        predict[i][j] = -1;
                    } else {
                        predict[i][j] = j - prev;
                    }
                }
            }
        }

        for (int[] pr : predict) {
            for (int p : pr){
                sb.append(p).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
