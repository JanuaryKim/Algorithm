package Baekjoon.recusion;

import java.util.Arrays;
import java.util.Scanner;

public class B10994 {

    static char arr[][];
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int leng = 1;

        for(int i = 1; i < n; i++)
            leng += 4;

        arr = new char[leng][leng];

        for (int i = 0; i < leng; i++) {
            Arrays.fill(arr[i], ' ');
        }

        solution(0, leng);

        print();

    }

    private static void print() {
        for(int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    static void solution(int start, int length) {

        for (int i = start; i < length; i++) {
            arr[start][i] = '*'; //상단 좌측에서 우측으로
            arr[length-1][i] = '*'; //하단 좌측에서 우측으로
            arr[i][start] = '*'; //좌측 상단에서 좌측 하단으로
            arr[i][length -1] = '*';  //우측 상단에서 우측 하단으로
        }
        if(length != 1)
            solution(start +2, length -2);
    }
}
