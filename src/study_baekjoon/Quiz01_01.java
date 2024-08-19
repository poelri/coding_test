package study_baekjoon;

import java.util.Scanner;

/*
* 수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.
* 첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다. 둘째 줄에는 N개의 수가 주어진다.
* 수는 1,000보다 작거나 같은 자연수이다. 셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.
* 총 M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력한다.
* 제한
1 ≤ N ≤ 100,000
1 ≤ M ≤ 100,000
1 ≤ i ≤ j ≤ N
* */
public class Quiz01_01 {
        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();  // 첫 번째 입력: 수의 개수 N
            int m = sc.nextInt();  // 두 번째 입력: 구간의 수 M

            int[] array = new int[n];  // 크기가 N인 정수 배열 생성

            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();  // N개의 숫자를 입력 받아 배열에 저장
            }

            for (int i = 0; i < m; i++) {  // M번 반복하여 각 구간의 합을 계산
                int a = sc.nextInt();  // 구간의 시작점 a 입력
                int b = sc.nextInt();  // 구간의 끝점 b 입력
                int sum = 0;  // 각 구간마다 sum을 0으로 초기화

                for (int j = a - 1; j < b; j++) {  // a에서 b까지의 합을 구함
                    sum += array[j];
                }
                System.out.println(sum);  // 계산된 구간 합 출력
            }
        }
    }
