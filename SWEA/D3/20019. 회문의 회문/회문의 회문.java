import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            String word = br.readLine();
            int length = word.length();
            boolean Rflag = true;
            for (int j = 0; j < length; j++) {
                if (word.charAt(j) != word.charAt(length - j - 1)){
                    Rflag = false;
                    break;
                }
            }

            int half = (length - 1) / 2;
            boolean Cflag = true;
            for (int j = 0; j < half; j++) {
                if (word.charAt(j) != word.charAt(half - j - 1)) {
                    Cflag = false;
                    break;
                }
            }

            for (int j = half + 1; j < length; j++) {
                if (word.charAt(j) != word.charAt(length - j - 1)) {
                    Cflag = false;
                    break;
                }
            }

            if (Rflag) {
                if (Cflag)
                    bw.write("#" + i + " " + "YES" + "\n");
                else
                    bw.write("#" + i + " " + "NO" + "\n");
            }
            else bw.write("#" + i + " " + "NO" + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}