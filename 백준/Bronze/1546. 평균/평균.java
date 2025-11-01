import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int sum = 0;
        st = new StringTokenizer(br.readLine() , " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        int max = Arrays.stream(arr).max().getAsInt();
        float ans = (float) sum / (max * n) * 100;

        bw.write(String.valueOf(ans));
        bw.flush();
        br.close();
        bw.close();
    }
}