import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine() , " ");
        String val_1 = st.nextToken();
        String val_2 = st.nextToken();

        BigInteger Bval_1 = new BigInteger(val_1);
        BigInteger Bval_2 = new BigInteger(val_2);

        sb.append(Bval_1.add(Bval_2)).append("\n");

        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }
}