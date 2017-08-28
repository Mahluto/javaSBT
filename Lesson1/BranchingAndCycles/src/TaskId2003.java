/**
 * Created by robert on 21.08.17.
 */
public class TaskId2003 {
    public static void alternateSumOfNumbers(int n, int[] numbers) {
//        int n = 8;
//        int[] numbers = new int[] { 47, 51, 11, 12, 17, 8, 6, 44 };
        boolean lable = true;
        int result = 0;
        if (n >= 1 && n <= 10000 && numbers.length == n) {

            for (int i : numbers) {
                if (lable) {
                    result = result + i;
                    lable = false;
                }
                else {
                    result = result - i;
                    lable = true;
                }

            }
            System.out.println(result);
        }
        else {
            System.out.println("Incoming data is incorrect");
        }

    }
}
