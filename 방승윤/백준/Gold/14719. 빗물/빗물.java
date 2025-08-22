import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] block = new int[W];
        st = new StringTokenizer(br.readLine());
        int max = -1;
        int maxW = -1;
        int curH = 0;
        int sumL = 0;
        int temp = 0;

        for (int i = 0; i < W; i++) {
            block[i] = Integer.parseInt(st.nextToken());

            if (block[i] >= max) {
                max = block[i];
                maxW = i;
            }
        }

        for (int i = 0; i <= maxW; i++) {
            if (block[i] >= curH) {
                curH = block[i];
                sumL += temp;
                temp = 0;
                continue;
            }

            temp += curH - block[i];
        }

        int sumR = 0;
        curH = 0;
        temp = 0;

        for (int i = W - 1; i >= maxW; i--) {
            if (block[i] >= curH) {
                curH = block[i];
                sumR += temp;
                temp = 0;
                continue;
            }

            temp += curH - block[i];
        }

        System.out.println(sumL + sumR);
    }
}