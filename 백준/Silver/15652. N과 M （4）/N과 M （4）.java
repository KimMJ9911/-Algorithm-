import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n , m;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];

        DFS(0 , 0);
    }

    private static void DFS(int depth , int k) {
        if (depth == m) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = k; i < n; i++) {
            arr[depth] = i + 1;
            DFS(depth + 1 , i);
        }
    }
}