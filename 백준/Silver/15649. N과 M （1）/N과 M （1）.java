import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n , m;
    static boolean[] visited;
    static int[] table;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        table = new int[m];

        DFS(0);
    }
    static void DFS(int depth) {
        if (depth == m) {
            for (int i : table) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]){
                visited[i] = true;
                table[depth] = i + 1;
                DFS(depth + 1);
                visited[i] = false;
            }
        }
    }
}