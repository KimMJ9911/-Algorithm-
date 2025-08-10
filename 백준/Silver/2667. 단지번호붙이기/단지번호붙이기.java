import java.io.*;
import java.util.*;

public class Main {
    static PriorityQueue<int[]> pq = new PriorityQueue<>((o1 , o2) -> o1[0] - o2[0]);
    static int[][] map;
    static boolean[][] visited;
    static int n , cnt = 1 ,  ans;
    static int[] row = new int[] {-1 , 1 , 0 , 0};
    static int[] column = new int[] {0 , 0 , -1 , 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] != 0) BFS(i , j);
            }
        }

//        for (int[] ints : map) {
//            for (int i : ints) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }

        ans = 0;
        List<Integer> table = new ArrayList<>();

        for (int i = 1; i <= cnt; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (map[j][k] == i) count++;
                }
            }

            if (count != 0) {
                ans++;
                table.add(count);
            }
        }
        Collections.sort(table);
        for (Integer i : table) {
            sb.append(i).append("\n");
        }

        bw.write(ans + "\n" + sb);
        bw.flush();
        br.close();
        bw.close();
    }

    private static void BFS(int x, int y) {
        visited[x][y] = true;
        pq.offer(new int[] {x , y});
        map[x][y] = cnt;
        while (!pq.isEmpty()) {
            //다음 값 반환
            int[] next = pq.poll();
            int dx = next[0];
            int dy = next[1];
            search_next(dx , dy);
        }
        cnt++;
    }
    static void search_next(int x , int y) {
        for (int i = 0; i < 4; i++) {
            int dx = x + row[i];
            int dy = y + column[i];
            if (isValid(dx , dy) && !visited[dx][dy] && map[dx][dy] != 0) {
                pq.offer(new int[] {dx , dy});
                visited[dx][dy] = true;
                map[dx][dy] = cnt;
            }
        }
    }

    static boolean isValid(int x , int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}