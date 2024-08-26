package study_baekjoon;

import java.util.PriorityQueue;

public class Quiz09_01 {
        public static void main(String[] args) { // 메인 메소드 시작
            int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1}; // 돌의 내구도를 나타내는 배열 초기화
            System.out.println(solution(stones, 3)); // solution 메소드를 호출하고 결과를 출력 (3은 최대 뛰어넘을 수 있는 돌의 수)
        }

        private static class Stone { // Stone 클래스 정의, 각 돌의 인덱스와 값을 저장하기 위해 사용
            int idx, val; // 돌의 인덱스와 값을 저장할 변수 선언

            public Stone(int idx, int val) { // Stone 클래스의 생성자, 인덱스와 값을 초기화
                this.idx = idx; // 인덱스 초기화
                this.val = val; // 값 초기화
            }
        }

        private static int solution(int[] stones, int k) { // solution 메소드, 돌의 내구도 배열과 최대 뛰어넘을 수 있는 돌의 수 k를 입력받음
            PriorityQueue<Stone> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.val, o1.val));
            // 최대값을 우선으로 하는 우선순위 큐 생성. 돌의 내구도가 높은 순으로 정렬

            for (int i = 0; i < k; i++) { // 처음 k개의 돌을 우선순위 큐에 추가
                pq.add(new Stone(i, stones[i])); // 현재 인덱스와 값을 가진 Stone 객체를 큐에 추가
            }

            int answer = pq.peek().val; // 초기 answer 값을 큐의 가장 큰 값으로 설정

            int now = k; // 현재 인덱스를 k로 초기화 (슬라이딩 윈도우의 끝)
            while (now < stones.length) { // now가 배열의 끝까지 반복
                pq.add(new Stone(now, stones[now])); // 현재 인덱스의 Stone 객체를 큐에 추가
                now++; // now를 다음 인덱스로 이동
                while (pq.peek().idx < now - k) pq.poll();
                // 큐의 첫 번째 원소의 인덱스가 슬라이딩 윈도우 범위 밖에 있으면 제거
                answer = Math.min(answer, pq.peek().val);
                // 현재 슬라이딩 윈도우 내에서의 최대값과 answer를 비교해 작은 값을 answer로 갱신
            }

            return answer; // 최소값인 answer 반환
        }

    }


