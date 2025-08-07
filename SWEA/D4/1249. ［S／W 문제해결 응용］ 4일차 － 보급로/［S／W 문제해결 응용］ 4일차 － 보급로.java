import java.io.*;
import java.util.PriorityQueue;

public class Solution {
    static class Node implements Comparable<Node> {
       int c , w , r;
        public Node(int c , int w , int r) {
            this.c = c;
            this.w = w;
            this.r = r;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.r , o.r);
        }
    }

    static int[][] map , distance;
    static boolean[][] visited;
    static PriorityQueue<Node> pq;
    static int n;
    static int[] dc = new int[] {0 , 0 , 1 , -1};
    static int[] dw = new int[] {1 , -1 , 0 , 0};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            visited = new boolean[n][n];
            distance = new int[n][n];

            for (int j = 0; j < n; j++) {
                String line = br.readLine();
                for (int k = 0; k < n; k++) {
                    map[j][k] = line.charAt(k) - '0';
                    distance[j][k] = Integer.MAX_VALUE;
                }
            }
            Dijkstra(i);
        }

        bw.write(sb + "");
        bw.flush();
        br.close();
        bw.close();
    }

    private static void Dijkstra(int i) {
        pq = new PriorityQueue<>();
        pq.offer(new Node(0 , 0 , 0));

        //초기 값 설정
        distance[0][0] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (node.c == n - 1 && node.w == n - 1) {
                sb.append("#").append(i).append(" ").append(distance[n - 1][n - 1]).append("\n");
                break;
            }

            if (!visited[node.c][node.w]) visited[node.c][node.w] = true;

            //4 방향 전체 검사
            for (int j = 0; j < 4; j++) {
                int nc = node.c + dc[j];
                int nw = node.w + dw[j];

                if (isValid(nc , nw) && !visited[nc][nw] && node.r + map[nc][nw] < distance[nc][nw]) {
                    distance[nc][nw] = node.r + map[nc][nw];
                    pq.offer(new Node(nc , nw , distance[nc][nw]));
                }
            }
        }
    }
    static boolean isValid(int nc , int nw) {
        return 0 <= nc && nc < n && 0 <= nw && nw < n;
    }
}