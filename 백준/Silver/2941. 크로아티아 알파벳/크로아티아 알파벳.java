import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String Cro_word = br.readLine();
        int word_size = Cro_word.length();
        for (int i = 1; i < Cro_word.length(); i++) {
            char c = Cro_word.charAt(i);
            if (c == '-') word_size--;

            if (Cro_word.charAt(i) == '=') {
                if (i >= 2 &&
                        Cro_word.charAt(i - 2) == 'd' &&
                        Cro_word.charAt(i - 1) == 'z') word_size -= 2;
                else word_size--;
            }

            if (c == 'j') {
                if (Cro_word.charAt(i - 1) == 'l' || Cro_word.charAt(i - 1) == 'n') word_size--;
            }
        }

        bw.write(word_size + "");
        bw.flush();
        br.close();
        bw.close();
    }
}