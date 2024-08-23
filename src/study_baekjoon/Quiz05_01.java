package study_baekjoon;

import java.io.*;
import java.util.Arrays;

public class Quiz05_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력
        int N = Integer.parseInt(br.readLine()); // n에 br을 한줄읽어서 정수로 만들어서 넣어

        int[] input = new int[N]; // 배열을 n의 크기만큼 만들고

        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(br.readLine()); // for문을 n만큼 돌려서 input배열에 br을 한줄씩 정수로 넣어
        }

        Arrays.sort(input); // input배열을 오름차순 정렬 ㄱㄱ 하고

        for (int i = 0; i < N; i++) {
            bw.write(input[i] + "\n"); // bw로 input을 BufferedWriter 사용해서 출력하장
        }

        bw.flush(); // BufferedWriter에 있는 데이터 모두 출력해!
    }
}
