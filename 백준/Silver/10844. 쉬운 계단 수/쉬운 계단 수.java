import java.io.*;
import java.math.BigInteger;
import java.util.stream.IntStream;

public class Main {
    private static final BigInteger DIV = BigInteger.valueOf(1_000_000_000);
    private static BigInteger[][] dp = new BigInteger[101][10];     //  전체 경우의 수는 100의 자리 수인 값과 그 마지막 수에 관한 저장 배열을 만든다.
    static {
        //배열을 미리 만들어 계산해 둔다. 배열의 크기가 크지 않기 때문에 가능
        //각 가짓수는 1로 고정 (각 1 ~ 9 나올 경우의 수 , 0 만 나오는 경우는 없으므로 0)
        dp[1][0] = BigInteger.ZERO;
        IntStream.range(1 , 10).forEach(i -> dp[1][i] = BigInteger.ONE);

        IntStream.range(2 , 101).forEach(i -> {
            IntStream.range(0 , 10).forEach(j -> {
                switch (j) {
                    //마지막 자리 수가 0 이나 9가 나오면 1 이랑 8이 나오는 경우밖에 없으므로
                    case 0 :
                        dp[i][0] = dp[i - 1][1];
                        break;
                    case 9 :
                        dp[i][9] = dp[i - 1][8];
                        break;
                    //0이나 9가 아닌 경우는 앞 뒤 수 2가지 경우
                    default :
                        dp[i][j] = dp[i - 1][j - 1].add(dp[i - 1][j + 1]);
                        break;
                }
            });
        });
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        BigInteger ans = BigInteger.ZERO;
        //모든 n의 자리 수 중에서 마지막 자리 수가 오는 모든 경우의 수의 합
        for (int i = 0; i < 10; i++) {
            ans = ans.add(dp[n][i]);
        }

        bw.write(String.valueOf(ans.remainder(DIV)));
        bw.flush();
        br.close();
        bw.close();
    }
}