import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    static int A = 1 , B = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        IntStream.rangeClosed(2 , m).forEach(i -> {
            B *= i;
        });

        IntStream.rangeClosed(n - m + 1 , n).forEach(j -> {
            A *= j;
        });

        bw.write(String.valueOf(A / B));
        bw.flush();
        br.close();
        bw.close();
    }
}