package programers.codeTest.java8;

/**
 *1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.v
 *2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.v
 * 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.v
 *4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다. v
 *5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
 * 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
 *      만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
 *7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
 *
 */
public class Recomand_solution {
    public static String solution(String new_id) {
        String answer = new_id.toLowerCase()
                .replaceAll("[^a-z0-9._-]", "")
                .replaceAll("\\.+","\\.")
                .replaceAll("^[.]|[.]$", "") ; // 1단계 ->2단계 ->3단계 -> 4단계
        System.out.println(answer);

        System.out.println("5단계 전 사이즈 "+answer.length());
        if(!(answer.length()>0)) answer = "a";//5단계

        System.out.println("6단계 전 사이즈 "+answer.length());
        if(answer.length()>15)
        {
            answer = answer.substring(0, 15).replaceAll("^[.]|[.]$", "");

        }

        System.out.println("7단계 전 사이즈 "+answer.length()+ " ///// "+answer);
        if(answer.length()<3) {
            System.out.println(answer.length());
            while (answer.length()!=3){
                String lastCharacter = answer.substring(answer.length()-1);
                answer += lastCharacter;
            }

        }





        return answer;
    }
    public static void main(String[] args) {
        String x =
//                "...!@BaT#*..y.abcdefghijklm"
//        "123_.def"
//        "z-+.^."
//        "=.="



                "abcdefghijklmn.p"
                ;

        System.out.println(solution(x));

    }

}
