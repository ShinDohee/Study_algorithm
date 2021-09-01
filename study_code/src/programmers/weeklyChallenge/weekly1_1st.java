package programmers.weeklyChallenge;

public class weekly1_1st {

    /**
     *
     * 입출력 예
     * price	money	count	result
     * 3	20	4	10
     * 입출력 예 설명
     * 입출력 예 #1
     * 이용금액이 3인 놀이기구를 4번 타고 싶은 고객이 현재 가진 금액이 20이라면, 총 필요한 놀이기구의 이용 금액은 30 (= 3+6+9+12) 이 되어 10만큼 부족하므로 10을 return 합니다.
     * @param price
     * @param money
     * @param count
     * @return
     */
    public long solution(int price, int money, int count) {
        long answer = -1;
        long sum =0;

        for(long i =1; i < count+1 ; i++){
           sum += price*i;
        }
        return ( sum-money>0 ? sum-money :0 );
    }


    public static void main(String[] args) {

    }
}
