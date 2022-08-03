package code.section2.permutation;

import java.util.ArrayList;

public class C05_rockPaperScissors {

    public static void main(String[] args) {

        ArrayList<String[]> output = rockPaperScissors(5);
        System.out.println();
    }

    public static ArrayList<String[]> rockPaperScissors(int rounds) {
        // TODO:
        ArrayList<String[]> result = new ArrayList<>();
        recursion(result, new String[rounds], 0, rounds);
        return result;
    }

    public static void recursion(ArrayList<String[]> list, String[] matches, int curRound, int finalRound) {

        //Rock, Paper, scissors 를 담은 스트링 배열 선언 (웨폰 배열이라 칭함)

        //만약 현재라운드가 최종라운드와 같다면
            //현재까지의 매치 반환

        //웨폰배열 길이만큼 반복
            //새 배열 만들어서 매치스 배열의 현재라운드 인덱스에 i번째 웨폰을 넣음 (newMatches 배열)
            //전역 리스트.add(현재 라운드 + 1 하여 newMatches 배열과 함께 recursion 메소드 재귀)
        //~반복문 종료

        String[] weapons = new String[]{"rock","paper","scissors"};

        if(curRound == finalRound) {
            list.add(matches);
            return;
        }
        for (int i = 0; i < weapons.length; i++) {
            String[] newArr = matches.clone();
            newArr[curRound] = weapons[i];
            recursion(list,newArr,curRound + 1, finalRound);
        }
    }
}
