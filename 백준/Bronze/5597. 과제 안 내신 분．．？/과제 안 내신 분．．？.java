import java.io.*;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[] vector = new int[31];
        for (int i = 0; i < 28; i++) {
            vector[Integer.parseInt(br.readLine())] = 1;
        }

        for (int i = 1; i <= 30; i++) {
            if (vector[i] != 1) bw.write(i + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}