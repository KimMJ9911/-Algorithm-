import java.io.*;

public class Main {
    static int[] arr;
    static int n , cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        set_Queen(0);

        bw.write(cnt + "");
        bw.flush();
        br.close();
        bw.close();
    }

    //한 줄에는 하나의 값이 들어간다. 그냥 한줄 배열에 y값을 저장하면 됨
    private static void set_Queen(int k) {
        if (k == n) {
            cnt++;
        } else {
            for (int i = 0; i < n; i++) {
                arr[k] = i;
                if (check_board(k)) set_Queen(k + 1);
            }
        }
    }

    private static boolean check_board(int k) {
        for (int i = 0; i < k; i++) {
            //같은 열에 있는 경우
            if (arr[k] == arr[i]) return false;
            //대각선도 체크
            if (Math.abs(i - k) == Math.abs(arr[i] - arr[k])) return false;
        }
        return true;
    }
}