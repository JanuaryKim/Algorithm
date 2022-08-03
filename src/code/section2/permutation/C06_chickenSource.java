package code.section2.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C06_chickenSource {
    public static void main(String[] args) {
//        ArrayList<Integer[]> output1 = newChickenRecipe(new int[]{1, 10, 1100, 1111}, 2);
//        output1.stream().forEach(arr-> System.out.println(Arrays.toString(arr))); //12



//        ArrayList<Integer[]> output3 = newChickenRecipe(new int[]{11, 1, 10, 1111111111, 10000}, 4);
//        output3.stream().forEach(arr-> System.out.println(Arrays.toString(arr))); //24


//        ArrayList<Integer[]> output3 = newChickenRecipe(new int[]{11, 1000}, 2); //잘못된 인풋
//        output3.stream().forEach(arr-> System.out.println(Arrays.toString(arr)));

//        ArrayList<Integer[]> output3 = newChickenRecipe(new int[]{11, 1100, 111}, 4);
//        output3.stream().forEach(arr-> System.out.println(Arrays.toString(arr)));
    }

    public static ArrayList<Integer[]> newChickenRecipe(int[] stuffArr, int choiceNum) {
        // TODO:
        Arrays.sort(stuffArr);

        List<Integer> freshStufList = new ArrayList<>();
        for (int i = 0; i < stuffArr.length; i++) {
//            String str = String.valueOf(stuffArr[i]);
//            for(int j = 0; j < )

            if(3 <= String.valueOf(stuffArr[i]).chars().filter(c->c == '0').count())
                continue;
            freshStufList.add(stuffArr[i]);
        }

        Integer[] freshStufArr = freshStufList.toArray(new Integer[freshStufList.size()]);

        if(freshStufArr.length < choiceNum || freshStufArr.length == 0) return null;

        ArrayList<Integer[]> result = new ArrayList<>();
        Integer[] curStuffs = new Integer[choiceNum];
        Arrays.fill(curStuffs,-1);
        recursion(result, freshStufArr, curStuffs, 0, choiceNum);
        return result;
    }

    public static void recursion(ArrayList<Integer[]> stuffList, Integer[] stuffArr, Integer[] curStuffs, int curStuIdx, int choiceNum) {

        if(curStuIdx >= choiceNum) {
            stuffList.add(curStuffs);
            return;
        }

        for (int i = 0; i < stuffArr.length; i++) {
            Integer[] newCurStuffs = curStuffs.clone();
            Integer curStuff = stuffArr[i];
            if(Arrays.stream(newCurStuffs).anyMatch(stuff-> stuff.equals(curStuff))) //하나라도 중복되는게 있다면
                continue;

            newCurStuffs[curStuIdx] = stuffArr[i];
            recursion(stuffList,stuffArr, newCurStuffs, curStuIdx+1, choiceNum);

        }
        //만약 현재 소스인덱스가 선택소스 갯수와 같거나 크다면
            //현재 소스를 리스트에 추가
            //리턴

        //소스 갯수만큼 반복
            //소스배열 클론 하여 생성
            //클론된 현재 소스 배열에 i번째 소스를 넣음
            //소스 리스트, 현재 소스 배열, 소스인덱스, 총 소스 갯수를 인자로 재귀

        //~반복문 종료




    }
}
