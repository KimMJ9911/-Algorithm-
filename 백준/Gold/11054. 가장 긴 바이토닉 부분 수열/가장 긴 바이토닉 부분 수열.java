import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp_1 = new int[n];
        int[] dp_2 = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }



        for (int i = 0; i < n; i++) {
            dp_1[i] = 1;
            for (int j = 0; j <= i; j++) {
                if (arr[i] > arr[j]) dp_1[i] = Math.max(dp_1[j] + 1 , dp_1[i]);
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            dp_2[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (arr[i] > arr[j]) dp_2[i] = Math.max(dp_2[j] + 1 , dp_2[i]);
            }
        }

        int MAX = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            MAX = Math.max(MAX , dp_1[i] + dp_2[i] - 1);
        }

        bw.write(String.valueOf(MAX));
        bw.flush();
        br.close();
        bw.close();
    }
}