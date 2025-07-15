import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");


        int[] arr = new int[3];
        int MAX = 0;

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        if (A + B <= C) bw.write((A + B) * 2 - 1 + "");
        else if(A + C <= B) bw.write((A + C) * 2 - 1 + "");
        else if ( B + C <= A) bw.write((B + C) * 2 - 1 + "");
        else bw.write((A + B + C) + "");

        bw.flush();
        br.close();
        bw.close();
    }
}