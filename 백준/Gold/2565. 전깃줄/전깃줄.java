import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static class Node implements Comparable<Node> {
        int start , end;

        public Node(int start , int end) {
            this.start = start;
            this.end = end;
        }


        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.start , o.start);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];
        Node[] lan = new Node[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            lan[i] = new Node(start , end);
        }

        Arrays.sort(lan);

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (lan[i].end > lan[j].end)
                    dp[i] = Math.max(dp[i] , dp[j] + 1);
            }
        }

        bw.write(String.valueOf(n - Arrays.stream(dp).max().getAsInt()));
        bw.flush();
        br.close();
        bw.close();
    }
}