import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = br.readLine().toLowerCase();
        int[] ascii_word = new int[29];

        for (int i = 0; i < word.length(); i++) {
            int val = word.charAt(i) - 97;
            ascii_word[val]++;
        }

        int max = 0;
        for (int i = 0; i < 29; i++) {
            if (ascii_word[i] > max) {
                max = ascii_word[i];
            }
        }

        List<Integer> cmp = new ArrayList<>();
        for (int i = 0; i < 29; i++) {
            if (ascii_word[i] == max) {
                cmp.add(i);
            }
        }
        char ans;
        if (cmp.size() > 1) ans = '?';
        else ans = (char) (cmp.get(0) + 65);
        bw.write(ans + "");
        bw.flush();
        br.close();
        bw.close();
    }
}