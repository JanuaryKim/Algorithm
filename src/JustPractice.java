import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Stream;

public class JustPractice {
    public static void main(String[] args) {
        // TODO:
        System.out.println(letterCapitalize("i  can doit!"));
        System.out.println(letterCapitalize("I  canDDit!"));
        String result3 = letterCapitalize("    ");
        System.out.println();

    }

    public static String letterCapitalize(String str) {
        // TODO:

        Stream<Character> characterStream = str.chars()
                .mapToObj(c -> (char) c);

        if(characterStream.filter(c->!c.equals(' ')).count() == 0) return "";


//        System.out.println("=======");
//        char[] hh =str.toCharArray();
//        for (int i = 0; i < hh.length; i++) {
//            if(hh[i].equas)
//                System.out.println("찾음");
//        }
//        char a = 'd';
//        hh.
//        System.out.println(Stream.of(str.toCharArray()).filter(c-> !c.equals(' ')).count());
//
//        if(Arrays.stream(str.toCharArray()).filter(c-> !c.).count() == 0) return "";

        boolean firstChar = true;

        StringBuilder sb = new StringBuilder(str);

        for(int i = 0; i < sb.length(); i++)
        {
            if (sb.charAt(i) == ' ') {
                firstChar = true;
            }
            else { //문자 발견
                if(firstChar) //첫글자일때
                {
                    if(sb.charAt(i) >= 'a' && sb.charAt(i) <= 'z')
                    {
                        int chIdx = (int) sb.charAt(i) - 'a';
                        sb.setCharAt(i, (char) ('A' + chIdx));

                    }
                    firstChar = false;
                }
            }
        }
        return sb.toString();
    }
}
