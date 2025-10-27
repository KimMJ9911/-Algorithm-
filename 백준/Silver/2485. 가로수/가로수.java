import java.util.*;


public class Main {

    public static void main(String... args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        List<Integer> list     = new ArrayList<>();
        List<Integer> distance = new ArrayList<>();

        while (N-- > 0) {
            list.add(sc.nextInt());
        }

        list.sort(Comparator.naturalOrder());

        for (int i = 0; i < list.size() - 1; i++) {
            distance.add(list.get(i + 1) - list.get(i));
        }

        int GCD = distance.get(0);
        int sum = 0;

        for (int i = 0; i < distance.size(); i++) {
            GCD = euclidean(GCD, distance.get(i));
        }

        for (int d : distance) {
            sum += ((d / GCD) - 1);
        }

        System.out.println(sum);

        sc.close();
    }

    // a = bq + r 유클리드 호제법
    public static int euclidean(int A, int B) {

        if (B == 0) {
            return A;
        }
        else {
            return euclidean(B, A % B);
        }
    }
}