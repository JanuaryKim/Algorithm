package code.section2.stack;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Stack;

public class C03_Browser_ReCoding {
    public static void main(String[] args) {

        //1번 인풋
        String[] actions = new String[]{"B", "C", "-1", "D", "A", "-1", "1", "-1", "-1"};
        String start = "A";
        ArrayList<Stack> output = browserStack(actions, start);
        System.out.println(output); // [["A"], ["B"], ["A", "D"]]

        //2번 인풋
        String[] actions2 = new String[]{"B", "-1", "B", "A", "C", "-1", "-1", "D", "-1", "1", "E", "-1", "-1", "1"};
        String start2 = "A";
        ArrayList<Stack> output2 = browserStack(actions2, start2);
        System.out.println(output2); // [["A", "B"], ["D"], ["E"]]
    }

    public static ArrayList<Stack> browserStack(String[] actions, String start) {
        //actions의 요소를 순차적으로 접근하는 반북문 시작
        //actions 요소를 하나 가져 온다.

        //만약 이전페이지가 존재하면서, -1 일 경우
        //현재 페이지를 다음 페이지에 넣는다
        //이전 페이지를 가져와 현재 페이지로 한다.
        //만약 다음페이지가 존재하면서, 1일 경우
        //현재 페이지를 이전 페이지에 넣는다.
        //다음 페이지를 가져와 현재 페이지로 한다
        //나머지 (문자일 경우)

        //반복문 종료
        Stack<String> prevStack = new Stack<>();
        Stack<String> nextStack = new Stack<>();
        Stack<String> current = new Stack<>();
        ArrayList<Stack> result = new ArrayList<>();

        current.push(start);
        for (String action : actions) {

            if (action.equals("-1")) {
                if(prevStack.empty()) continue;
                nextStack.push(current.pop());
                current.push(prevStack.pop());
            } else if (action.equals("1")) {
                if(nextStack.empty()) continue;
                prevStack.push(current.pop());
                current.push(nextStack.pop());
            }
            else{
                prevStack.push(current.pop());
                current.push(action);
                nextStack.clear();
            }
        }
        result.add(prevStack);
        result.add(current);
        result.add(nextStack);
        return result;
    }
}
