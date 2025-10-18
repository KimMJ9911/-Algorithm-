import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine() , " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        IntStream.rangeClosed(1 , n).forEach(i -> {
            arr[i] = i;
        });
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int val = arr[start];
            arr[start] = arr[end];
            arr[end] = val;
        }

        IntStream.rangeClosed(1 , n).forEach(i -> {
            sb.append(arr[i]).append(" ");
        });

        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }
}