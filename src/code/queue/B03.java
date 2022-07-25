package code.queue;

import java.util.ArrayList;
import java.util.Stack;

public class B03 {
    public static void main(String[] args) {
        System.out.println(browserStack(new String[]{"B", "C", "-1", "D", "A", "-1", "1", "-1", "-1"}, "A"));
        System.out.println(browserStack(new String[]{"B", "-1", "B", "A", "C", "-1", "-1", "D", "-1", "1", "E", "-1", "-1", "1"}, "A"));
    }

    public static ArrayList<Stack> browserStack(String[] actions, String start) {
        final String REGEX = "[A-Z]+";

        if(!start.matches(REGEX))
            return null;

        Stack<String> prevStack = new Stack<>();
        Stack<String> nextStack = new Stack<>();
        Stack<String> current = new Stack<>();
        ArrayList<Stack> result = new ArrayList<>();

        // TODO:

        current.push(start);

        for(int i = 0; i < actions.length; i++)
        {
            if(actions[i].equals("-1")){ //뒤로 가기 일때
                if(prevStack.empty()) //뒤로 가기 비활성 일때
                    continue;
                nextStack.push(current.pop());
                current.clear();
                current.push(prevStack.pop());
            }
            else if(actions[i].equals("1")){ //앞으로 가기 일때
                if(nextStack.empty()) //앞으로가기 비활성일때
                    continue;
                prevStack.push(current.pop());
                current.clear();
                current.push(nextStack.pop());
            }
            else{  //특정 페이지 입장
                prevStack.push(current.pop());
                current.clear();
                current.push(actions[i]);
                nextStack.clear();
            }


        }
        result.add(prevStack);
        result.add(current);
        result.add(nextStack);
        return result;

    }
}
