import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n , m;
    static int[][] table , visit;
    static int[] mx = {1 , -1 , 0 , 0};     //상하좌우
    static int[] my = {0 , 0 , 1 , -1};     //상하좌우
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine() , " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        table = new int[n][m];
        visit = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            for (int j = 0; j < m; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
                visit[i][j] = -1;
            }
        }

        bw.write(DFS(0 , 0) + "");
        bw.flush();
        br.close();
        bw.close();
    }

    static int DFS(int x , int y) {
        //둘 다 종착점에 도착하는 경우
        if (x == m - 1 && y == n - 1) return 1;
        //순회 전 시작되는 구역의 값이 -1이 아닌 경우
        if (visit[y][x] != -1) return visit[y][x];

        visit[y][x] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + mx[i];
            int ny = y + my[i];
            if ((nx >= 0 && ny >= 0 && nx < m && ny < n) && table[ny][nx] < table[y][x]) {
                visit[y][x] += DFS(nx , ny);
            }
        }

        return visit[y][x];
    }
}