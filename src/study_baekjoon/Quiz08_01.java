package study_baekjoon;

import java.util.Collections;
import java.util.PriorityQueue;

public class Quiz08_01 {
        public static int solution(int n, int k, int[] enemy) {  // solution 메서드 선언 (n: 초기 방어력, k: 사용 가능한 스킬 횟수, enemy: 적 배열)
            int answer = 0;  // 방어할 수 있는 라운드 수를 저장할 변수 초기화

            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            // 내림차순 우선순위 큐 생성 (가장 큰 수가 우선순위가 높음)

            for (int e : enemy) {  // enemy 배열을 순회하며 각 적의 수를 e에 저장
                pq.add(e);  // 현재 적의 수를 우선순위 큐에 추가
                if (k > 0 && n < e) {  // 스킬을 사용할 수 있고(n보다 큰 적이 등장했을 때), 스킬이 남아있다면
                    n += pq.poll();  // 우선순위 큐에서 가장 큰 값을 꺼내어(이전의 가장 큰 적을 무력화) n에 더함 (방어력 증가)
                    k--;  // 스킬 사용 횟수 1 감소
                }
                n -= e;  // 현재 적의 수만큼 n에서 차감 (방어력 감소)
                if (n < 0)  // 방어력이 0보다 작아지면 (적을 막지 못하면)
                    break;  // 반복문 종료 (게임 종료)
                answer++;  // 방어 성공한 라운드 수 증가
            }

            return answer;  // 방어할 수 있는 최대 라운드 수 반환
        }
    }
