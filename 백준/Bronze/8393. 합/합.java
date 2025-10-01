import java.io.*;
import java.util.stream.IntStream;

public class Main {
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        IntStream.rangeClosed(0 , n).forEach(i -> sum += i);

        bw.write(String.valueOf(sum));
        bw.flush();
        br.close();
        bw.close();
    }
}