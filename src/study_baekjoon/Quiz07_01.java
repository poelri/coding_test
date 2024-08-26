package study_baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
/*
* 널리 잘 알려진 자료구조 중 최소 힙이 있다. 최소 힙을 이용하여 다음과 같은 연산을 지원하는 프로그램을 작성하시오.

배열에 자연수 x를 넣는다.
배열에서 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.
프로그램은 처음에 비어있는 배열에서 시작하게 된다.
입력값
9
0
12345678
1
2
0
0
0
0
32
* */

public class Quiz07_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력부터 받아보자
        int n = Integer.parseInt(br.readLine()); // 근데 이제 그게 첫 줄을 정수로 변환해서 n에 저장하는고지
        // 여기에 n=9
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); // 우선순위 큐를 만들까?
        StringBuilder sb = new StringBuilder(); // 메모리 사용 최적화 및 출력결과를 관리하기위해 이거 쓰자

        for (int i = 0; i < n; i++) { // n번 반복하고 n=9니까 9번 반복하는거지
            int x = Integer.parseInt(br.readLine()); // 정수로 변환해서 x에 넣어바
            if (x == 0) { // x 에 들어온게 0 이면
                if(pq.isEmpty()) // pq가 비어있을때
                    sb.append(0).append("\n"); // 스트링빌더인 sb에 0을 출력결과에 추가하고
            else
                sb.append(pq.poll()).append("\n"); // 비어있지 않다면, 우선순위 큐에서 가장 작은값을 제거하고 출력결과에 추가해
            }else {
                pq.add(x); // pq에 x 추가하고
            }
            // 첫 번째 입력: 0
            // 큐가 비어있으므로 sb에 0 추가
            // 큐 상태: []

            // 두 번째 입력: 12345678
            // 0이 아니므로 우선순위 큐에 12345678 추가
            // 큐 상태: [12345678]

            // 세 번째 입력: 1
            // 0이 아니므로 우선순위 큐에 1 추가
            // 큐 상태: [1, 12345678]

            // 네 번째 입력: 2
            // 0이 아니므로 우선순위 큐에 2 추가
            // 큐 상태: [1, 12345678, 2]

            // 다섯 번째 입력: 0
            // 큐에서 가장 작은 값인 1을 sb에 추가
            // 큐 상태: [2, 12345678]

            // 여섯 번째 입력: 0
            // 큐에서 가장 작은 값인 2를 sb에 추가
            // 큐 상태: [12345678]

            // 일곱 번째 입력: 0
            // 큐에서 가장 작은 값인 12345678을 sb에 추가
            // 큐 상태: []

            // 여덟 번째 입력: 0
            // 큐가 비어있으므로 sb에 0 추가
            // 큐 상태: []

            // 아홉 번째 입력: 32
            // 0이 아니므로 우선순위 큐에 32 추가
            // 큐 상태: [32]
        }
        System.out.println(sb); //sb에 저장된 결과를 한번에 출력해ㅔ
        // 최종 출력 결과:
        // 0
        // 1
        // 2
        // 12345678
        // 0
    }
}
