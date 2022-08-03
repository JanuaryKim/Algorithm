package code.section2.powerSet;

import java.util.ArrayList;
import java.util.Arrays;

public class C09_sideDishes {

    public static void main(String[] args) {
        ArrayList<String[]> output = missHouseMeal(new String[]{"eggroll", "kimchi", "fishSoup"});

        for (String[] dishes : output) {
            System.out.println(Arrays.toString(dishes));
        }
    }
    public static ArrayList<String[]> missHouseMeal(String[] sideDishes) {
        // TODO:
        Arrays.sort(sideDishes);
        ArrayList<String[]> result = new ArrayList<>();
        result.add(new String[0]);
        result.add(sideDishes);

        int combiCtn = sideDishes.length - 1;

        while(combiCtn != 0)
        {
            recursion(result, new String[combiCtn], sideDishes, combiCtn, 0);
            combiCtn--;
        }
        return result;
    }

    private static void recursion(ArrayList<String[]> list, String[] curDishes, String[] sideDishes, int combiCtn, int curDishesIdx)
    {
        //인자 (전체 리스트, 현재 반찬상태 배열 클론, 반찬메뉴 배열, 총 조합 수, 현재 반찬 위치 인덱스)

        //만약 현재 반찬 인덱스가 반찬조합수보다 크거나 같다면
            //결과 리스트에 현재 반찬 배열 add
            //리턴

        //반찬 메뉴 만큼 반복문 시작
            //현재 반찬 상태 배열 클론으로 생성
            //현재 반찬 상태 배열에 i번째 반찬 넣음,
            //재귀호출 (전체 리스트, 현재 반찬상태 배열 클론, 반찬메뉴 배열, 총 조합 수, 현재 반찬 위치 인덱스 + 1)
        //~반복문 종료

        if(curDishesIdx >= combiCtn) {
            list.add(curDishes);
            return;
        }
        for(int i = 0; i < sideDishes.length; i ++)
        {
            String[] cloneCurDishes = curDishes.clone();
            cloneCurDishes[curDishesIdx] = sideDishes[i];
            recursion(list, cloneCurDishes, sideDishes, combiCtn, curDishesIdx + 1);
        }
    }

    //결과 리스트,현재 상태 배열(항상 반찬배열 크기의 -1로) (0번째 인자는 고정), 조합 크기, 반찬메뉴배열)
    private static void recursion(ArrayList<String[]> list, String[] curDishes, String[] sideDishes, int combiCtn)
    {
        //만약 조합 크기가 1이라면
            //리스트에 현재 배열 추가
            //리턴

        //반찬수만큼 반복문 시작
            //



        //~반복문 종료
    }

}
