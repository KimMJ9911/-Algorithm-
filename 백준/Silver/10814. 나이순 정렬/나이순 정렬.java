import java.io.*;
import java.util.*;

public class Main {
    public static class Node implements Comparable<Node> {
        int age;
        String name;

        public Node(int age , String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Node o) {
            return this.age - o.age;
        }
    }
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<Node> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            list.add(new Node(Integer.parseInt(st.nextToken()) , st.nextToken()));
        }

        Collections.sort(list);

        for (Node node : list) {
            sb.append(node.age).append(" ").append(node.name).append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }
}