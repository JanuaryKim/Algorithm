package code.section2.GCD;

import java.util.ArrayList;

public class C08_pocky {
    public static void main(String[] args) {
        int M = 4;
        int N = 8;
        ArrayList<Integer[]> output = divideChocolateStick(M, N);
        System.out.println(output);
    }

    public static ArrayList<Integer[]> divideChocolateStick(int M, int N) {
        // TODO:

        //직원수 변수 (1부터)

        //무한 반복문 시작

        //M을 직원수로 나눈 몫 저장
        //N을 직원수로 나눈 몫 저장

        //만약 두개의 몫중 하나라도 0이 나온다면, 직원수가 더 많기에 더 이상 나눠줄 수 없음
            //반복문 탈출

        //만약 현재 직원수로 M, N을 나머지 연산 했을때 하나라도 0이 아닌게 나오면, 공평하게 나눠 줄수 없는 빼빼로의 갯수이므로
            //직원수 증가
            //continue;

        //Integer[] 배열 생성, 크기 3
        //배열 0번째에 직원수, M의 몫, N의 몫 넣어서 리스트에 추가

        //직원수 증가

        //~반복문
        ArrayList<Integer[]> result = new ArrayList<>();

        int employee = 1;

        while(true)
        {
            int mCount = M / employee;
            int nCount = N / employee;

            if(mCount == 0 || nCount == 0)
                break;

            if(M % employee != 0 || N % employee != 0)
            {
                employee++;
                continue;
            }

            Integer[] divResult = new Integer[]{employee, mCount, nCount};
            result.add(divResult);
            employee++;
        }
        return result;
    }
}
