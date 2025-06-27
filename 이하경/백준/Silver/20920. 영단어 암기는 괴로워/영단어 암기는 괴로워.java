import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        while (n-- > 0) {
            String word = br.readLine();

            if (word.length() < m) {
                continue;
            }

            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
                continue;
            }

            map.put(word, 1);
        }

        Set<Word> set = new TreeSet<>();
        for (String word:map.keySet()) {
            set.add(new Word(word, map.get(word)));
        }

        for (Word w : set) {
            sb.append(w.word).append("\n");
        }

        System.out.println(sb);
    }

    private static class Word implements Comparable<Word> {
        String word;
        int count;
        int length;

        public Word(String word, int count) {
            this.word = word;
            this.count = count;
            this.length = word.length();
        }

        @Override
        public int compareTo(Word o) {
            if (this.count != o.count) {
                return o.count - this.count;
            }

            if (this.length != o.length) {
                return o.length - this.length;
            }

            return this.word.compareTo(o.word);
        }
    }
}