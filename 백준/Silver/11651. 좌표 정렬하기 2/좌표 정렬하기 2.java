import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static class Node implements Comparable<Node> {
        int x , y;

        public Node(int x , int y) {
            this.x = x;
            this.y = y;
        }


        @Override
        public int compareTo(Node o) {
            if (o.y == this.y) {
                return this.x - o.x;
            } else return this.y - o.y;
        }
    }
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Node> node = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            node.add(new Node(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
                    )
            );
        }

        Collections.sort(node);

        for (Node node1 : node) {
            sb.append(node1.x).append(" ").append(node1.y).append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }
}