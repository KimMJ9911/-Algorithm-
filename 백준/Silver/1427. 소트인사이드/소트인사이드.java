import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String[] num = br.readLine().split("");
        int[] arr = new int[num.length];
        for (int i = 0; i < num.length; i++) {
            arr[i] = Integer.parseInt(num[i]);
        }
        Arrays.sort(arr);

        for (int i : arr) {
            sb.append(i);
        }

        sb.reverse();
        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }
}