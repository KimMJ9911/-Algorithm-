import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n;
    static String[] cantor;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        cantor = new String[13];
        create_Cantor();

        while (sc.hasNextInt()) {
            n = sc.nextInt();

            System.out.println(cantor[n]);
        }
    }
    static void create_Cantor() {
        cantor[0] = "-";
        for (int i = 1; i < 13; i++) {
            cantor[i] = cantor[i - 1] + " ".repeat((int) Math.pow(3.0 , (double) i - 1)) + cantor[i - 1];
        }
    }
}