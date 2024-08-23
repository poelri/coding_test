package study_baekjoon;

import java.util.Stack;

public class Quiz03_02 {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>(); // 스택 하나 만들고
        for (int i = 0; i < s.length(); i++) { // s의 길이만큼 for문 돌리자
            char c = s.charAt(i); // c 에 s를 넣고
            if (c == '(') { // c 가 (가 맞아?
                stack.push(c); // stack에 c를 넣자
            }else if (c == ')') { // c가 )이면
                if (stack.isEmpty()) { // stack이 비어있는지 보고
                    return false; // 비어있는데 )가 들어가려고 하니까 false
                }
                stack.pop(); // 비어있지 않았으면 짝이 있다는 소리니까 같이꺼내
            }
        }
        return stack.isEmpty(); // 스택이 비었으면 tru 아니면 false
    }
}
