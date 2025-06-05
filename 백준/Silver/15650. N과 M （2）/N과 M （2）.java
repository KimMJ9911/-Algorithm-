import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int[] ans;
    static int n , m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        ans = new int[m + 1];

        DFS(0 , 0);
    }
    static void DFS(int depth , int k) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = k; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                ans[depth] = i + 1;
                DFS(depth + 1 , i + 1);
                visited[i] = false;
            }
        }
    }
}