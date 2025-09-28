import java.io.*;
import java.util.*;

public class Main {
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
    static int[] dp;
    static Node[] lan;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        lan = new Node[n];
        dp = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            lan[i] = new Node(start , end);
        }

        Arrays.sort(lan);

        int ans = soultion();

        bw.write(String.valueOf(n - ans));
        bw.flush();
        br.close();
        bw.close();
    }
    private static int soultion() {
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (lan[j].end < lan[i].end)
                    dp[i] = Math.max(dp[i] , dp[j] + 1);
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}