import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class JustPractice {
    public static void main(String[] args) {
        String str = "D";
        Stack<Integer> ss = new Stack<>();



        final String REGEX = "[A-Z]+";
        if(!str.matches(REGEX))
            System.out.println("불일치");

    }

    public static String reverseStr(String str) {

        if(str.length() == 0)
            return "";

        String mainStr = Character.toString(str.charAt(str.length() - 1));
        String subStr = str.substring(0,str.length()-1);
        return mainStr + reverseStr(subStr);
    }
}
