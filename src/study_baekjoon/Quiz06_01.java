package study_baekjoon;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Stack;

public class Quiz06_01 {
    public int solution(String s) {
        int answer = 0;
        String new_s = s;
        for(int i = 0; i < s.length(); i++){
            if(checkString(new_s)) // 밑에 메서드가 유효한 괄호 문자열인지 검사하는 메서드
                answer++; // 그래서 유효하면 answer를 ++ 해줄거임
            new_s = new_s.substring(1, s.length()) + new_s.charAt(0);
            // substring은 문자열의 일부를 추출하는데 사용
            // 인덱스 번호 1 부터 문자열의 끝가지 반환해
            // 문자열 회전이란 결국에는 abcd가 bcda로 변환하는거임
        }

        return answer;
    }

    // 왜 두개의 메서드를 사용해야 했을까?
    // 각 메서드가 하나의 역할에 집중할 수 있도록 하기 위해서
    // 재사용하기 좋으니까
    // solution 메서드는 전체적인 흐름을 관리하는 거고 , checkString 메서드는 특정작업을 수행하는것.

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
