package programmers;

public class NextBigNumber {
	
	static int solution(int n) {
		int answer = n;
		String binaryString = Integer.toBinaryString(n);
		int oneCnt = findOneCnt(binaryString); //2������ ��ȯ�� input�� 1������ �����մϴ�
		
		// 1�� ������Ű�� �ش� 2������ 1�� ������ Ȯ���մϴ�
		while(true) {
			answer++;
			String eachBinaryString = Integer.toBinaryString(answer);
			int eachOneCnt = findOneCnt(eachBinaryString);
			
			if(oneCnt == eachOneCnt) break; //1�� ������ ���ٸ� �ش� ���� ��ȯ�մϴ�
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
