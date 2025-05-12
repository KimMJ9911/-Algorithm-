import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int range1 = sc.nextInt();
        int range2 = sc.nextInt();
        int sum = 0;
        boolean ans = true;
        int min_prime_num = 10001;
        int arr[] = new int[10001];
        for (int i = range1; i <= range2; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    ans = false;
                    break;
                }
                else {
                    ans = true;
                }
            }
            if (ans == true) {
                arr[i] = 1;
            }
        }

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] == 1) {
                sum += i;
                if (min_prime_num > i)  {
                    min_prime_num = i;
                }
            }
        }
        if (sum == 0) {
            System.out.println(-1);
        }
        else {
            System.out.println(sum);
            System.out.println(min_prime_num);
        }
    }
}