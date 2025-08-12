import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N , M;
    static int[][] map;
    static boolean[][] visited;
    static class Node implements Comparable<Node> {
        int x , y , R;
        public Node(int x , int y , int R) {
            this.x = x;
            this.y = y;
            this.R = R;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.R , o.R);
        }
    }

    static Queue<Node> queue = new LinkedList<>();
    static int[] row = new int[] {-1 , 1 , 0 , 0} , column = new int[] {0 , 0 , -1 , 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int ans = BFS();

        bw.write(ans + "");
        bw.flush();
        br.close();
        bw.close();
    }


    private static int BFS() {
         queue.offer(new Node(0 , 0 , 1));
         visited[0][0] = true;

         while (!queue.isEmpty()) {
             Node next = queue.poll();
             if (next.x == N - 1 && next.y == M - 1) {
                 return next.R;
             }
             search_4_way(next);
         }
         return 0;
    }

    private static void search_4_way(Node next) {
        for (int i = 0; i < 4; i++) {
            int dx = next.x + row[i];
            int dy = next.y + column[i];
            int dWeight = next.R + 1;

            if (isValid(dx , dy) && map[dx][dy] != 0 && !visited[dx][dy]) {
                queue.offer(new Node(dx , dy , dWeight));
                visited[dx][dy] = true;
            }
        }
    }
    private static boolean isValid(int dx , int dy) {
        return 0 <= dx && dx < N && 0 <= dy && dy < M;
    }
}