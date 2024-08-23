package study_baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Quiz04_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()); // reaLine으로 받아온 첫번째 라인 값을 n에 넣어

        int[] num = new int[N]; // 배열을 n의 수 만큼 만들어

        StringTokenizer st = new StringTokenizer(br.readLine()); // br에 들어온 값을 공백을 기준으로 잘라줘
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken()); // n만큼 num[i]에 공백으로 잘라온 애들을 넣어줘
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>(); // 디큐 배열 하나 만들구

        int[] answer = new int[N]; // 답이 거꾸로 나오니까 잠깐 답을 넣을 그릇도 하나 만들어 answer 배열을 [0, 0, 0, 0] 초기화

        for (int i = N - 1; i >= 0; i--) {
            // 배열은 0부터 시작하니까 n이 4면 배열인뎃스는 3까지잖아? 그니까 n-1 하자
            // 우리는 뒤에서 부터 답을 구하니까 점점앞으로 가야해 구래서 i--
            while (!stack.isEmpty() && stack.peekLast() <= num[i]) { 
                // for문이 도는 동안 스택이 비었는지 + 스택의 마지막에 있는 숫자가 num[i]보다 작거나 같은지 봐( 오큰수냐?)
                stack.pollLast();
                // MAX = O(N) 조건이 맞으면 스택에서 꺼내자
            }
            answer[i] = stack.isEmpty() ? -1 : stack.peekLast();
            // answer[i]가 비었어? 비었으면 -1 해주고 [3, 5, 2, 7] 일때 7은 -1이 나와야하니까.
            // 아니면 마지막에 있는 데이터가 오큰수라는 거지뭐
            stack.addLast(num[i]);
            // 스택에 넣어줘!
        }

        for (int i : answer) { // 이제 출력하자 ~~~
            bw.write(i + " ");
        }

        bw.flush(); // BufferedWriter로 받았으니까 System.out.print가 아니라 이걸로 출력해

    }
}
