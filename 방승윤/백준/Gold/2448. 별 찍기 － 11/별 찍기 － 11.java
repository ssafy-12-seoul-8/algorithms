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
        stars = new char[N][N * 2 - 1];

        for (char[] star : stars) {
            Arrays.fill(star, ' ');
        }

        draw(0, N - 1, N);

        for (char[] star : stars) {
            for (char type : star) {
                sb.append(type);
            }

            sb.append("\n");
        }
        
        System.out.println(sb);
    }

    public static void draw(int r, int c, int size) {
        if (size == 3) {
            stars[r][c] = '*';
            stars[r + 1][c - 1] = '*';
            stars[r + 1][c + 1] = '*';

            for (int i = -2; i <= 2; i++) {
                stars[r + 2][c + i] = '*';
            }

            return;
        }

        draw(r, c, size / 2);
        draw(r + size / 2, c - size / 2, size / 2);
        draw(r + size / 2, c + size / 2, size / 2);
    }
}