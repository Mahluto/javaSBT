import java.util.ArrayList;

public class TaskId2037 {

    public static String tooShortWords(int k, String str) {

        ArrayList<String> stArray = new ArrayList<String>();
        String[] s = str.split(",");
        for (String i : s) {
            if (i.length() >= k) {
                stArray.add(i);
            }
        }
        String outString = String.join(",", stArray);
        System.out.println(outString);

        return outString;

    }












//    public static void tooShortWords(int k, String str) {
//        char[] chars = str.toCharArray();
//        int strlen = str.length();
//        char[] word = new char[str.length()];
//        int count = 0;
//        ArrayList<char[]> words = new ArrayList<char[]>();
//        for (char i : chars) {
//            if (i == ',') {
//                if (word.length >= k) {
//                    words.add(word);
//                }
//                word = new char[str.length()];
//                count = 0;
////                System.out.println();
//
//            }
//            else {
//                System.out.println(i);
//                word[count] = i;
//                count++;
//            }
//
//        }
////        System.out.println(Arrays.toString(words.toArray()));
//    }
}
