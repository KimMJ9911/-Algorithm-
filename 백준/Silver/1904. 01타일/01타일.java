import java.io.*;

public class Main {
    static final int div = 15746;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        //11111 , 11100 , 11001 , 10011 , 00111 , 10000 , 00100 , 00001

        //dp 가 어려운 경우
        //1. 점화식을 먼저 접근, 패턴이 있거나 규칙이 발견되면 가정을 세워서 반복하면 됨
        //2. 점화식이 안보이면 1 부터 가짓수를 구해본다. 가짓수에 규칙이 보이면 더하는 방식으로 반복한다.
        if (n == 1) System.out.println(1);
        else if (n == 2) System.out.println(2);
        else {
            arr[1] = 1;
            arr[2] = 2;
            for (int i = 3; i <= n; i++) {
                arr[i] = (arr[i - 2] + arr[i - 1]) % div;
            }

            System.out.println(arr[n]);
        }

    }
}