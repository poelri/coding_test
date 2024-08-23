package study_baekjoon;
import java.util.ArrayDeque;

public class Quiz02_02 {

    /*
    https://school.programmers.co.kr/learn/courses/30/lessons/17680

     */

        public int solution(int cacheSize, String[] cities) {
            int answer = 0;
            int hit = 1;
            int miss = 5;

            ArrayDeque<String> cache = new ArrayDeque<>();

            for (String city : cities) { // O(N) = 100,000
                city = city.toLowerCase(); //O(N) = 20 조건이 대소문자 구분 x니까 대문자든 소문자든 만들어주기
                if(cache.contains(city)) {//O(N * M) = 30 * 20 * 100,000
                    // city를 포함하면 hit를 더해주고 city를 지우고 맨 뒤로 추가
                    answer += hit;
                    cache.remove(city);
                    cache.addLast(city);
                } else { //cache에 city가 없으면 miss를 더해주고
                    // city를 데크 맨 마지막으로 추가 만약 데크에 공간이 없다면 맨 앞 인덱스 뽑아 사이즈 맞추기
                    answer += miss;
                    cache.addLast(city);
                    if(cache.size() > cacheSize) { //Deque의 사이즈가 주어진 cacheSize보다 사이즈가 크면
                        cache.pollFirst();
                    }
                }
            }

            return answer;
        }
    }

