/**
 * Created by robert on 21.08.17.
 */
public class TaskId2028 {
    public static void fromOneToFour(int n, int[] numbers) {
        int zero = 0;
        int one = 0;
        int tow = 0;
        int three = 0;
        int four = 0;

        if (n >= 1 && n <= 100 && numbers.length == n) {
            for (int i : numbers) {
                if (i < 0 || i > 4) {
                    System.out.println("Incoming data is incorrect");
                    return;
                }
                switch (i) {
                    case 0: zero++;
                            break;
                    case 1: one++;
                        break;
                    case 2: tow++;
                        break;
                    case 3: three++;
                        break;
                    case 4: four++;
                        break;
                }
            }

            if (zero > 0) {

                System.out.println("0 " + zero);
            }

            if (one > 0) {

                System.out.println("1 " + one);
            }

            if (tow > 0) {

                System.out.println("2 " + tow);
            }

            if (three > 0) {

                System.out.println("3 " + three);
            }

            if (four > 0) {

                System.out.println("4 " + four);
            }

        }
        else {
            System.out.println("Incoming data is incorrect");
        }
    }
}
