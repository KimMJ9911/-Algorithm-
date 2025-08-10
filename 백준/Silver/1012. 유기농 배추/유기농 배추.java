import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N , M , K , cnt;
    static int[][] map;
    static boolean[][] visited;
    static PriorityQueue<int[]> pq = new PriorityQueue<>((o1 , o2) -> o1[0] - o2[0]);
    static int[] row = new int[] {-1 , 1 , 0 , 0} , column = new int[] {0 , 0 , -1 , 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            cnt = 0;

            map = new int[N][M];
            visited = new boolean[N][M];
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine() , " ");
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                map[X][Y] = 1;
            }

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[j][k] != 0 && !visited[j][k])
                        BFS(j , k);
                }
            }

            bw.write(cnt + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static void BFS(int j, int k) {
        pq.offer(new int[] {j , k});
        visited[j][k] = true;
        map[j][k] = cnt;

        while (!pq.isEmpty()) {
            int[] next = pq.poll();
            int nx = next[0];
            int ny = next[1];
            search_4_way(nx , ny);
        }
        cnt++;
    }

    private static void search_4_way(int nx, int ny) {
        for (int i = 0; i < 4; i++) {
            int dx = nx + row[i];
            int dy = ny + column[i];
            if (isValid(dx , dy) && map[dx][dy] != 0 && !visited[dx][dy]) {
                pq.offer(new int[] {dx , dy});
                visited[dx][dy] = true;
                map[dx][dy] = cnt;
            }
        }
    }
    private static boolean isValid(int dx , int dy) {
        return 0 <= dx && dx < N && 0 <= dy && dy < M;
    }
}