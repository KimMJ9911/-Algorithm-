import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] line = new int[n];

        st = new StringTokenizer(br.readLine() , " ");
        for (int i = 0; i < n; i++) {
            line[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n - 2; i++) {
            int init = line[i];
            for (int j = i + 1; j < n - 1; j++) {
                init += line[j];
                for (int k = j + 1; k < n; k++) {
                    if (line[k] + init <= m) max = Math.max(max , line[k] + init);
                }
                init -= line[j];
            }
        }

        bw.write(max + "");
        bw.flush();
        br.close();
        bw.close();
    }
}