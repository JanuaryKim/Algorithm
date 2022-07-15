package Baekjoon.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class Assign {
    int strNum;
    String[] key1;
    HashMap<String,Integer> key2 = new HashMap<>();
    HashMap<Integer,String> pwd = new HashMap<>();
    int[] memorize;
}

public class B9322 {

    static Assign assign[];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int assignCtn = Integer.parseInt(scanner.nextLine());
        assign = new Assign[assignCtn];

        for (int i = 0; i < assignCtn; i++) {
            int strNum = Integer.parseInt(scanner.nextLine());
            assign[i] = new Assign();
            assign[i].strNum = strNum;

            String key1 = scanner.nextLine();
            assign[i].key1 = key1.split(" ");
            String key2 = scanner.nextLine();
            String key2Spl[] = key2.split(" ");

            for (int j = 0; j < key2Spl.length; j++) {
                assign[i].key2.put(key2Spl[j], j);
            }

            String pwd = scanner.nextLine();
            String[] tempPwd = pwd.split(" ");
            for(int j = 0; j < tempPwd.length; j++)
            {
                assign[i].pwd.put(j, tempPwd[j]);
            }
        }

        solution();
    }

    public static void solution(){
        for (int i = 0; i < assign.length; i++) {
            assign[i].memorize = new int[assign[i].strNum];
            HashMap<Integer, String> pwd = new HashMap<>();
            for(int j = 0; j < assign[i].strNum; j++)
            {
                assign[i].memorize[j] = assign[i].key2.get(assign[i].key1[j]); //바뀐 인덱스 기억하기
            }


            for (int j = 0; j < assign[i].strNum; j++) {
                System.out.print(assign[i].pwd.get(assign[i].memorize[j]) + " ");
            }
            System.out.println();

        }


    }
}




