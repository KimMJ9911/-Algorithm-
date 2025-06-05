import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int sum = sc.nextInt() + sc.nextInt();
            System.out.println(sum);
        }
    }
}