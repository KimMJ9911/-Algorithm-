import java.io.*;
import java.util.*;

public class Main {
    public static class Node implements Comparable<Node> {
        String word;
        int cnt;
        public Node(String word , int cnt) {
            this.word = word;
            this.cnt = cnt;
        }


        @Override
        public int compareTo(Node o) {
            if (o.cnt != this.cnt) return o.cnt - this.cnt;
            else {
                if (o.word.length() != this.word.length())
                    return  o.word.length() - this.word.length();
                else return this.word.compareTo(o.word);
            }
        }
    }
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine() , " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //자주 나오는 단어 앞에 배치
        List<Node> arr = new ArrayList<>();
        Map<String , Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (word.length() >= m) {
                if (!map.containsKey(word)) map.put(word , 1);
                else map.put(word , map.get(word) + 1);
            }
        }
        
        for (Map.Entry<String , Integer> entry : map.entrySet()) {
            arr.add(new Node(entry.getKey() , entry.getValue()));
        }
        
        Collections.sort(arr);

        for (Node node : arr) {
            sb.append(node.word).append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}