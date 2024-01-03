package programmers.bagic_training.Level00;

public class Solution00_logicalOperation {
    /**
     * boolean 변수 x1, x2, x3, x4가 매개변수로 주어질 때, 다음의 식의 true/false를 return 하는 solution 함수를 작성해 주세요.
     *
     * (x1 ∨ x2) ∧ (x3 ∨ x4)
     *
     * v -> 하나라도 t 이면 t
     * ∧ -> 하나라도 f 면 f
     * @param x1
     * @param x2
     * @param x3
     * @param x4
     * @return
     */
    public boolean solution_basicLogic(boolean x1, boolean x2, boolean x3, boolean x4) {
        boolean answer = false;
        boolean f1_result = true;
        boolean f2_result = true;

        if(x1 == false && x2 == false) f1_result= false;
        if(x3 == false && x4 == false) f2_result =false;

        if(f1_result == true && f2_result == true) answer = true;



        return answer;
    }
}
