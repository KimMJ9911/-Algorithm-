import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n , m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];

        BFS(0 , 0);

        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }

    private static void BFS(int depth , int k) {
        if (depth == m) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = k; i < n; i++) {
            arr[depth] = i + 1;
            BFS(depth + 1 , i);
        }
    }
}