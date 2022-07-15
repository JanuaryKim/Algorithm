package Baekjoon.set;


import java.util.*;
import java.util.stream.Collectors;

public class B16499 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String str = scanner.nextLine();
            String[] sArr = new String[str.length()];
            for(int j = 0; j < str.length(); j++)
            {
                sArr[j] = String.valueOf(str.charAt(j));
            }

            Arrays.sort(sArr);
            String sortStr = Arrays.stream(sArr).collect(Collectors.joining());
            set.add(sortStr);
        }

        System.out.println(set.size());
    }
}
