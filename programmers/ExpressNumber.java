package programmers;

public class ExpressNumber {
	
	static int solution(int n) {
		int answer = 0;
		for(int i=1; i<=n; i++) {
			int sum = 0;
			for(int j=i; j<=n; j++) {
				sum += j;
				if(sum == n){
					answer++;
					break;
				}
				if(sum > n) break;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(15));
	}

}
