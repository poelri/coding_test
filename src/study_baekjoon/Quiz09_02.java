package study_baekjoon;

import java.util.ArrayDeque;
import java.util.Deque;

public class Quiz09_02 {
        public int solution(int[] stones, int k) {
            int len = stones.length;  // 돌 배열의 길이를 저장합니다.

            // 인덱스 정보만 담는다.
            Deque<Integer> dq = new ArrayDeque<>();  // Deque를 사용하여 슬라이딩 윈도우에서 최대값을 저장하는 데 사용할 것입니다.

            int max = Integer.MAX_VALUE;  // 최대값 중에서 최소값을 찾기 위해 초기값을 무한대로 설정합니다.

            for(int i = 0; i < len; ++i){  // 배열의 각 요소를 순회합니다.

                // 윈도우에서 벗어난 원소 제거
                while(!dq.isEmpty() && dq.peekFirst() <= i - k) {
                    dq.pollFirst();  // 현재 윈도우에서 벗어난 인덱스를 Deque에서 제거합니다.
                }

                // 새로운 원소가 기존의 원소들보다 크면, 작은 원소들 제거
                while(!dq.isEmpty() && stones[dq.peekLast()] < stones[i]) {
                    dq.pollLast();  // Deque의 마지막 원소가 현재 원소보다 작으면 제거하여 최대값만 남깁니다.
                }

                dq.addLast(i);  // 현재 원소의 인덱스를 Deque에 추가합니다.

                // 각 윈도우에서 최대값 중 최소가 마지막으로 건너뛰어 갈 수 있는 사람 수이다.
                if(i >= k - 1) {  // 슬라이딩 윈도우가 완전히 형성된 시점부터
                    max = Math.min(max, stones[dq.peekFirst()]);  // 현재 윈도우의 최대값과 기존의 최대값 중 최소값을 저장합니다.
                }
            }

            return max;  // 최종적으로 가능한 최소값(건널 수 있는 최대 사람 수)을 반환합니다.
        }
    }


