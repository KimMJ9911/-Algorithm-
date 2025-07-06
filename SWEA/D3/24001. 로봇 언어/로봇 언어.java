import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            int[] vertex = new int[word.length()];

            int cnt = 0;
            int question_cnt = 0;
            int MAX = 0;
            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) == 'L') cnt--;
                else if (word.charAt(j) == '?') question_cnt++;
                else cnt++;

                if (cnt > 0) MAX = cnt + question_cnt;
                else if (cnt == 0) MAX = question_cnt;
                else MAX = - (cnt - question_cnt);

                vertex[j] = MAX;
            }

            bw.write(Arrays.stream(vertex).max().getAsInt() + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}