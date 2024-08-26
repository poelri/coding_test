package study_baekjoon;

import java.util.PriorityQueue;

public class Quiz08_02 {
        public int solution(int n, int k, int[] enemy) {
            // solution 메서드 선언 (n: 초기 방어력, k: 사용 가능한 스킬 횟수, enemy: 적 배열)
            int answer = 0;  // 방어할 수 있는 라운드 수를 저장할 변수 초기화

            if (k == enemy.length) {  // 스킬 횟수 k가 적 배열의 길이와 같다면
                return enemy.length;  // 모든 적을 막을 수 있으므로, 적의 수 전체를 반환
            }

            int count = 0;  // 사용한 스킬 횟수 초기화
            int remain = n;  // 남아 있는 방어력 초기화
            int i;  // 적 배열의 인덱스를 추적할 변수

            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> -(o1 - o2));
            // 내림차순 우선순위 큐 생성 (큰 수가 우선순위가 높음)

            for (i = 0; i < enemy.length; i++) {  // enemy 배열을 순회하며 각 적을 처리
                int current = enemy[i];  // 현재 적의 수를 current에 저장
                priorityQueue.add(current);  // 현재 적의 수를 우선순위 큐에 추가
                remain -= current;  // 현재 적을 막기 위해 방어력에서 current만큼 차감

                if (remain < 0) {  // 방어력이 0보다 작아지면 (현재 적을 막을 수 없으면)
                    if (count < k) {  // 스킬 사용 횟수가 남아 있다면
                        remain += priorityQueue.poll();  // 이전에 만난 가장 큰 적을 무력화하고, 방어력에 더함
                        count++;  // 사용한 스킬 횟수 증가
                    } else {  // 더 이상 스킬을 사용할 수 없다면
                        break;  // 반복문 종료 (게임 종료)
                    }
                }
            }

            answer = i;  // i는 반복문이 종료된 시점에서 방어할 수 있는 최대 라운드를 나타냄

            return answer;  // 방어할 수 있는 최대 라운드 수 반환
        }
    }

