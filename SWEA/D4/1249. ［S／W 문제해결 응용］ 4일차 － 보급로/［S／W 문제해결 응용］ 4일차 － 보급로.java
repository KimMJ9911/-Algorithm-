import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    static class Node implements Comparable<Node> {
        int x , y , r;

        public Node(int x , int y , int r) {
            this.r = r;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.r , o.r);
        }
    }
    static int[] vert = new int[] {0 , 0 , -1 , 1} , horiz = new int[]{-1 , 1 , 0 , 0};
    static int[][] distance , table;    //  필요한 총 거리를 저장하는 배열
    static boolean[][] visited;
    static int n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //상하좌우 움직이면서 경우에 따라 이동하는 과정이 필요
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            n = Integer.parseInt(br.readLine());
            table = new int[n][n];
            distance = new int[n][n];
            visited = new boolean[n][n];

            for (int j = 0; j < n; j++) {
                String line = br.readLine();
                for (int k = 0; k < n; k++) {
                    table[j][k] = line.charAt(k) - '0';
                    distance[j][k] = Integer.MAX_VALUE;
                }
            }

            Dijkstra(i);
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }

    static PriorityQueue<Node> pq;
    private static void Dijkstra(int idx) {
        pq = new PriorityQueue<>();
        pq.offer(new Node(0 , 0 , 0));  //  시작 지점
        distance[0][0] = 0;

        while (!pq.isEmpty()) {
            Node next = pq.poll();
            if (next.x == n - 1 && next.y == n - 1) {
                sb.append("#").append(idx).append(" ").append(distance[n - 1][n - 1]).append("\n");
                break;
            }

            if (!visited[next.x][next.y])
                visited[next.x][next.y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = next.x + horiz[i];
                int ny = next.y + vert[i];

                if (isValid(nx , ny) && !visited[nx][ny] && next.r + table[nx][ny] < distance[nx][ny]) {
                    distance[nx][ny] = next.r + table[nx][ny];
                    pq.offer(new Node(nx , ny , distance[nx][ny]));
                }
            }
        }
    }

    private static boolean isValid(int nx , int ny) {
        return 0 <= nx && nx < n && 0 <= ny && ny < n;
    }
}