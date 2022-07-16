package Baekjoon.list;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B2605 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentCnt = Integer.parseInt(scanner.nextLine());
        StringTokenizer stringTokenizer = new StringTokenizer(scanner.nextLine());
        LinkedList<Integer> orderLine = new LinkedList<>();
        for (int i = 0; i < studentCnt; i++) {

            orderLine.add(i - Integer.parseInt(stringTokenizer.nextToken()), i+1);
        }

        for (Integer i : orderLine) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
