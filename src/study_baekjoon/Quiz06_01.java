package study_baekjoon;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Stack;

public class Quiz06_01 {
    public int solution(String s) {
        int answer = 0;
        String new_s = s;
        for(int i = 0; i < s.length(); i++){
            if(checkString(new_s)) answer++;
            new_s = new_s.substring(1, s.length()) + new_s.charAt(0);
        }

        return answer;
    }

    boolean checkString(String s){
        Stack<Character> stack = new Stack<>(); // 스택 만들어
        for(int i = 0; i < s.length(); i++){ // 들어온 s의 길이만큼 for문 돌릴건데
            try{
                switch(s.charAt(i)){ // s[i]의 케이스가
                    case '[': // [이면
                        stack.add('['); // 스택에 추가하고
                        break; // 그다음꺼 ㄱㄱ
                    case ']': // ] 이면
                        if(stack.peek() != '[')// 스택의 맨위에 들어있는게 [ 가 아니면
                            return false; // 짝이 안맞으니까 false 리턴해
                        stack.pop(); //그렇지 않으면 [ 을 제거하고
                        break;
                    case '{': // { 이거라면
                        stack.add('{'); // { 추가하고
                        break;
                    case '}': // } 이거라면
                        if(stack.peek() != '{') // 스택 맨위에 {게 아니면
                            return false; // 짝이 안맞으니까 false 반환해
                        stack.pop(); // 그리고 {를 제거해
                        break;
                    case '(':
                        stack.add('(');
                        break;
                    case ')':
                        if(stack.peek() != '(')
                            return false;
                        stack.pop();
                        break;
                }
            } catch(Exception e){ //  예외가 발생하면
                return false; // 올바른 괄호가 아니므로 false를 반환
            }
        }
        return stack.isEmpty() ? true : false;
    }
}
