package blatt03;

import java.util.Scanner;

public class FrohlischeZahl {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int lower, upper;

        System.out.print("Bitte geben Sie die untere Grenze ein: ");
        lower = sc.nextInt();

        System.out.print("Bitte geben Sie die obere Grenze ein: ");
        upper = sc.nextInt();

        for (int i = lower; i <= upper; i++) {
            int w = i;
            while (w != 1 && w != 4) {
                int q = 0;
                while (w > 0) {
                    int d = w%10;
                    q += d*d;
                    w /= 10;
                }
                w = q;
            }
            if (w == 1) {
                System.out.print(i);
                w = i;
                while (w != 1 && w != 4) {
                    int q = 0;
                    while (w > 0) {
                        int d = w%10;
                        q += d*d;
                        w /= 10;
                    }
                    w = q;
                    System.out.print(" -> " + w);
                }
                System.out.println();
            }
        }

    }
}
