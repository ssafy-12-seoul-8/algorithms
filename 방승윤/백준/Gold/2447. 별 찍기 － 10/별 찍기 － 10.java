import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static char[][] stars;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        stars = new char[N][N];

        for (char[] line : stars) {
            Arrays.fill(line, ' ');
        }

        draw(0, 0, N);

        for (char[] line : stars) {
            for (char star : line) {
                sb.append(star);
            }

            sb.append("\n");
        }
        
        System.out.println(sb);
    }

    public static void draw(int x, int y, int n) {
        if (n == 1) {
            stars[x][y] = '*';
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }

                draw(x + i * n / 3, y + j * n / 3, n / 3);
            }
        }
    }
}