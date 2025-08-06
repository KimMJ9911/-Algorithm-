import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[] point = new int[] {-2 , -1 , 1 , 2};

        for (int i = 1; i <= 10; i++) {
            int n = Integer.parseInt(br.readLine());

            int[] view = new int[n + 4];
            st = new StringTokenizer(br.readLine() , " ");

            for (int j = 2; j <= n + 1; j++) {
                view[j] = Integer.parseInt(st.nextToken());
            }

            int total = 0;

            for (int j = 2; j <= n + 1; j++) {
                int val = view[j];
                int sum = Integer.MAX_VALUE;
                for (int c : point) {
                    int around = view[j + c];
                    if (val - around < 0) {
                        sum = 0;
                        break;
                    }
                    else sum = Math.min(val - around , sum);
                }
                total += sum;
            }

            bw.write("#" + i + " " + total + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}