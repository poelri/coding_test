package study_baekjoon;
import java.util.*;

/**
 * 지도개발팀에서 근무하는 제이지는 지도에서 도시 이름을 검색하면 해당 도시와 관련된 맛집 게시물들을 데이터베이스에서 읽어 보여주는 서비스를 개발하고 있다.
 * 이 프로그램의 테스팅 업무를 담당하고 있는 어피치는 서비스를 오픈하기 전 각 로직에 대한 성능 측정을 수행하였는데, 제이지가 작성한 부분 중 데이터베이스에서 게시물을 가져오는 부분의 실행시간이 너무 오래 걸린다는 것을 알게 되었다.
 * 어피치는 제이지에게 해당 로직을 개선하라고 닦달하기 시작하였고, 제이지는 DB 캐시를 적용하여 성능 개선을 시도하고 있지만 캐시 크기를 얼마로 해야 효율적인지 몰라 난감한 상황이다.
 *
 * 어피치에게 시달리는 제이지를 도와, DB 캐시를 적용할 때 캐시 크기에 따른 실행시간 측정 프로그램을 작성하시오.
 */
    class Quiz02_01 {
        public int solution(int cacheSize, String[] cities) {
            int answer = 0;

            ArrayList<String> cache = new ArrayList<>();

            if(cacheSize == 0){ //캐시 크기가 0이면
                return cities.length * 5;
            }

            for(int i=0;i<cities.length;i++){
                String city = cities[i].toUpperCase(); //대소문자 구분 안하니까

                if(cache.contains(city)){ //만약 있다면
                    cache.remove(city); //해당 도시 지우고
                    cache.add(city); //맨 뒤에 추가
                    answer+=1;
                }

                else{ //없다면
                    if(cache.size()==cacheSize){ //이미 캐시 꽉차있으면
                        cache.remove(0); //맨 앞 도시 지우고
                    }

                    //캐시가 다 안찼으면
                    cache.add(city); //맨 뒤에 추가
                    answer+=5;
                }
            }

            return answer;
        }
    }

