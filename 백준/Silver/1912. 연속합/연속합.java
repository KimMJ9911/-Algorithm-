import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine() , " ");
        int MAX = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) + arr[i - 1];
            MAX = Math.max(MAX , arr[i]);
            //0 아래로 떨어지는 경우 0으로 초기화
            if (arr[i] < 0) arr[i] = 0;
        }

        bw.write(String.valueOf(MAX));
        bw.flush();
        br.close();
        bw.close();
    }
}