import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        IntStream.rangeClosed(1 , n).forEach(i -> {
            sb.append(i).append("\n");
        });

        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }
}