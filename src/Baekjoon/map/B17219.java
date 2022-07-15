package Baekjoon.map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B17219 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StringTokenizer sT = new StringTokenizer(scanner.nextLine());
        StringBuilder sB = new StringBuilder();

        int n = Integer.parseInt(sT.nextToken());
        int m = Integer.parseInt(sT.nextToken());

        HashMap<String, String> addrPwd = new HashMap<>();

        for(int i = 0; i < n; i++)
        {
            sT = new StringTokenizer(scanner.nextLine());
            addrPwd.put(sT.nextToken(), sT.nextToken());
        }


        for (int i = 0; i < m; i++) {
            sB.append(addrPwd.get(scanner.nextLine())).append("\n");
        }

        System.out.println(sB);
    }
}
