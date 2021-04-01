package programers.codeTest.java8;

import java.util.Arrays;
import java.util.List;

/**
 * "CBD"	["BACDE", "CBADF", "AECB", "BDA"]	2
 *
 */
public class SkillTree_Solution {
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        List<String> list = Arrays.asList(skill_trees);
;
        list.stream().forEach(s -> System.out.println(s));


        return answer;
    }

    public static void main(String[] args) {
        String skill ="CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        solution(skill, skill_trees);
    }
}
