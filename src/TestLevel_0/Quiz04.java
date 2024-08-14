package TestLevel_0;
/*
* 덧셈, 뺄셈 수식들이 'X [연산자] Y = Z' 형태로 들어있는 문자열 배열 quiz가 매개변수로 주어집니다.
* 수식이 옳다면 "O"를 틀리다면 "X"를 순서대로 담은 배열을 return하도록 solution 함수를 완성해주세요.
* */
public class Quiz04 {
        public String[] solution(String[] quiz) {
            String[] answer = new String[quiz.length];

            for(int i =0; i<quiz.length; i++){
                String[] Arr = quiz[i].split(" ");

                int a = Integer.parseInt(Arr[0]);
                int b = Integer.parseInt(Arr[2]);
                int c = Integer.parseInt(Arr[4]);

                if(Arr[1].equals("+")){
                    if((a + b) == c){
                        answer[i] = "O";
                    }else{
                        answer[i] = "X";

                    }
                }
                if(Arr[1].equals("-")){
                    if((a - b) == c){
                        answer[i] = "O";
                    }else{
                        answer[i] = "X";
                    }
                }
            }

            return answer;
        }
    }

