import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int n , m;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine() , " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];

        IntStream.rangeClosed(1 , n).forEach(i -> {
            arr[i] = i;
        });

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            logic(start , end);
        }

        for (int i = 1; i <= n; i++) {
            sb.append(arr[i]).append(" ");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }

    private static void logic(int start, int end) {
        for (int i = start; i <= (start + end) / 2; i++) {
            int val = arr[i];
            arr[i] = arr[start + end - i];
            arr[start + end - i] = val;
        }
    }
}