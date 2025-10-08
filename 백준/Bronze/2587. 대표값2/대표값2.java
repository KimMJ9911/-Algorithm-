import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[5];
        int val = 0;

        for (int i = 0; i < 5; i++) {
            int num = Integer.parseInt(br.readLine());
            val += num;
            arr[i] = num;
        }
        val /= 5;
        Arrays.sort(arr);

        bw.write(  val+ "\n" + arr[2]);
        bw.flush();
        br.close();
        bw.close();
    }
}