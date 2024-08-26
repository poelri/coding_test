package study_baekjoon;

import java.util.Arrays;

public class Quiz09_03 {

        public int solution(int distance, int[] rocks, int n) {  // distance: 총 거리, rocks: 바위의 위치 배열, n: 제거할 바위의 개수
            int answer = 0;  // 최종 정답(최소 거리의 최대값)을 저장할 변수

            Arrays.sort(rocks);  // 바위 배열을 오름차순으로 정렬

            int left = 1;  // 최소 거리를 1로 설정 (이분 탐색의 시작점)
            int right = distance;  // 최대 거리를 전체 거리로 설정 (이분 탐색의 끝점)
            while(left <= right){  // 이분 탐색 시작
                int mid = (left + right)/2;  // 중간값(현재 최소 거리 후보)을 계산
                if(getRemovedRockCnt(rocks, mid, distance) <= n){  // 만약 제거해야 하는 바위 수가 n보다 작거나 같다면
                    answer = mid;  // 현재 중간값을 정답 후보로 설정
                    left = mid + 1;  // 최소 거리를 늘리기 위해 left를 mid+1로 설정
                } else {  // 제거해야 하는 바위 수가 n보다 크다면
                    right = mid - 1;  // 최소 거리를 줄이기 위해 right를 mid-1로 설정
                }
            }

            return answer;  // 최종적으로 구해진 최소 거리의 최대값을 반환
        }

        public int getRemovedRockCnt(int[] rocks, int mid, int distance){  // 주어진 mid 최소 거리를 만족하기 위해 제거해야 할 바위 수를 계산
            int before = 0;  // 이전 바위의 위치를 저장 (초기값은 출발점 0)
            int end = distance;  // 도착점의 위치를 저장

            int removeCnt = 0;  // 제거한 바위의 개수를 저장할 변수
            for(int i = 0; i < rocks.length; i++){  // 모든 바위를 순회
                if(rocks[i] - before < mid) {  // 현재 바위와 이전 바위 사이의 거리가 mid보다 작다면
                    removeCnt++;  // 바위를 제거하고 제거 수를 증가시킴
                    continue;  // 다음 바위로 넘어감
                }
                before = rocks[i];  // 현재 바위가 이전 바위가 됨
            }
            if(end - before < mid) removeCnt++;  // 마지막 지점까지의 거리도 검사하여 mid보다 작다면 제거

            return removeCnt;  // 최종적으로 제거한 바위의 개수를 반환
        }
    }


