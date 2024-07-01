package programmers.bagic_training.Level01;

public class Solution01_sortArr {
    /**
     * 각에서 0도 초과 90도 미만은 예각,
     * 90도는 직각, 90도 초과 180도 미만은 둔각 180도는 평각으로 분류합니다.
     * 각 angle이 매개변수로 주어질 때 예각일 때 1, 직각일 때 2, 둔각일 때 3, 평각일 때 4를 return하도록 solution 함수를 완성해주세요.
     *
     * 예각 : 0 < angle < 90
     * 직각 : angle = 90
     * 둔각 : 90 < angle < 180
     * 평각 : angle = 180
     * @param angle
     * @return
     */
    public static  int solution(int angle) {
        int answer = angle>0 && angle<90 ? 1 : (angle == 90 ? 2 : (angle>90 && angle<180 ? 3 : 4)) ;
        return answer;
    }


}
