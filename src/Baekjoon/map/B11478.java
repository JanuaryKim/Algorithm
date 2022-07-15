package Baekjoon.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class B11478 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(Solution(s));
    }

    public static int Solution(String str) {

        Map<String, String> map = new HashMap();

        for (int i = 0; i < str.length(); i++) {

            String partStr = "";
            for(int j = i; j < str.length(); j++)
            {
                partStr += Character.toString(str.charAt(j));

                map.put(partStr, partStr);
            }
        }
        return map.size();
    }
}

