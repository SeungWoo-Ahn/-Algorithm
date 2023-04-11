package programmers;

public class NextBigNumber {
	
	static int solution(int n) {
		int answer = n;
		String binaryString = Integer.toBinaryString(n);
		int oneCnt = findOneCnt(binaryString); //2진수로 변환한 input의 1개수를 저장합니다
		
		// 1씩 증가시키며 해당 2진수의 1의 개수를 확인합니다
		while(true) {
			answer++;
			String eachBinaryString = Integer.toBinaryString(answer);
			int eachOneCnt = findOneCnt(eachBinaryString);
			
			if(oneCnt == eachOneCnt) break; //1의 개수가 같다면 해당 값을 반환합니다
		}
		
		return answer;
	}
	
	static int findOneCnt(String binaryString) {
		int cnt = 0;
		for(int i=0; i<binaryString.length(); i++) {
			if(binaryString.charAt(i)=='1') {
				cnt++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		System.out.println(solution(78));
	}

}
