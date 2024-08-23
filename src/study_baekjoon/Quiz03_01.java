package study_baekjoon;

import java.util.ArrayDeque;

public class Quiz03_01 {
    boolean solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>(); // 디큐 하나 만들고
    for (int i = 0; i < s.length(); i++) { // s의 크기만큼 for 문 돌리고
    char now = s.charAt(i); // now에 넣어
    if(now =='('){ // now 에 들어온 값이 ( 이거야?
        stack.addLast(now); // 맞으면 stack에 넣고
    }else { // 아니면 그니까 ')' 이거 일때
        if(stack.isEmpty()){ // stack이 비었을때는
            return false; //  false를 뱉어
        }else { // 안비어있으면
            stack.pollLast(); // 짝이 맞는 다는 소리니까 stack에서 빼
        }
    }
}
    return stack.isEmpty();}} // 다 됐을때 stack이 비어있어? 있으면 true 아니야? false
