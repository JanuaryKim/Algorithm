package Baekjoon.map;

import javax.swing.text.html.parser.Entity;
import java.util.*;

public class B20291 {
    public static void main(String[] args) {

        //삭제
        String[] ss = new String[]{
                "sbrus.txt",
                "spc.spc",
                "acm.icpc",
                "korea.icpc",
                "sample.txt",
                "hello.world",
                "sogang.spc",
                "example.txt"
        };



        Scanner scanner = new Scanner(System.in);
        int n = Character.getNumericValue(scanner.nextLine().charAt(0));//scanner.nextLine().charAt(0) - '0';
        List<String> fileList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
//            fileList.add(scanner.nextLine());
            fileList.add(ss[i]);
        }

        solution(fileList);
    }

    public static void solution(List<String> _fileList) {

        Map<String, Integer> hashMap = new HashMap();

        for (int i = 0; i < _fileList.size(); i++) {
            String[] splitStr = _fileList.get(i).split("\\.");
            String key = splitStr[1];

            if (hashMap.containsKey(key)) {
                int value = (int)hashMap.get(splitStr[1]);
                hashMap.put(key, ++value);
            }
            else
            {
                hashMap.put(key, 1);
            }
        }

        Map<String, Integer> treeMap = new TreeMap<>(hashMap);

        for ( Map.Entry<String, Integer> entries : treeMap.entrySet()) { //해당 부분에서 왜 entrySet
            System.out.println(entries.getKey() + " " + entries.getValue());
        }


    }

}
