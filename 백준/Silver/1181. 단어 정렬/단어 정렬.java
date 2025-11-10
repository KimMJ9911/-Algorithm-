import java.io.*;
import java.util.*;

public class Main {
    public static class Node implements Comparable<Node> {
        String word;

        public Node(String word) {
            this.word = word;
        }

        @Override
        public int compareTo(Node o) {
            if (o.word.length() == this.word.length()) {
                return this.word.compareTo(o.word);
            } else return this.word.length() - o.word.length();
        }
    }
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<String> dup = new ArrayList<>();
        List<Node> words = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String next = br.readLine();
            if (!dup.contains(next)) {
                dup.add(next);
                words.add(new Node(next));
            }
        }

        Collections.sort(words);

        for (Node word : words) {
            sb.append(word.word).append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }
}