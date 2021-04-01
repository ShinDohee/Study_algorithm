package programers.codeTest.java8;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * progresses	speeds	return
 * [93, 30, 55]	[1, 30, 5]	[2, 1]
 * [95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]
 *
 *
 */
public class Skill_develop_Solution {
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> an = new ArrayList<Integer>();
        List<Integer> end_date = new ArrayList<Integer>();

        for (int i = 0; i < progresses.length; i++) {
           int endDate = endDate = ((100-progresses[i])/speeds[i]);
            if((100-progresses[i])%speeds[i] !=0) {
                endDate +=1;
            }

            end_date.add(i, endDate);
        }
        int count =0;
        int tempNumber =end_date.get(0);

        for (int n:end_date ) {
            if(n<=tempNumber) {
               count++;
           }else {
                tempNumber = n;
                an.add(count);
                count =1;
            }


        }

        if(count !=0) an.add(count);

        an.forEach(s-> System.out.println("a의  ==>>>>"+s));
        answer = an.stream().mapToInt(i->i).toArray();

        return answer;
    }

    public static void main(String[] args) {
        int [] progresses = {93, 30, 55};
        int [] speeds={1,30,5};

            solution(progresses, speeds);
    }
}
