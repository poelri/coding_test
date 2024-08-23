package study_baekjoon;

import java.util.ArrayDeque;

public class Quiz03_01 {
    boolean solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
    for (int i = 0; i < s.length(); i++) {
    char now = s.charAt(i);
    if(now =='('){
        stack.addLast(now);
    }else {
        if(stack.isEmpty()){
            return false;
        }else {
            stack.pollLast();
        }
    }
}
    return stack.isEmpty();}}
