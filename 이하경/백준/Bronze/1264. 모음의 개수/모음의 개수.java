import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Set<Character> vowel = new HashSet<>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');
        vowel.add('A');
        vowel.add('E');
        vowel.add('I');
        vowel.add('O');
        vowel.add('U');

        String input = br.readLine();
        while (!input.equals("#")) {
            int count = 0;
            for (int i = 0; i < input.length(); i++) {
                if (vowel.contains(input.charAt(i))) {
                    count++;
                }
            }
            sb.append(count).append("\n");
            input = br.readLine();
        }

        System.out.println(sb);
    }
}