package programmers;

import java.util.HashMap;

public class EnglishFollowUp {
	
	//끝말잇기가 되는지 확인합니다
	static boolean rightWord(String before, String now){
        return before.charAt(before.length()-1)==now.charAt(0);
    }
	
	static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashMap<String,Integer> map = new HashMap<>();
        //첫 단어를 저장합니다
        map.put(words[0],1);
        
        for(int i=1; i<words.length; i++){
            if(!rightWord(words[i-1],words[i])){
                answer[0] = i%n + 1;
                answer[1] = i/n + 1;
                return answer;
            }
            //단어 중복을 확인합니다
            if(map.getOrDefault(words[i],0)==0){
                map.put(words[i],1);
            } else {
                answer[0] = i%n + 1;
                answer[1] = i/n + 1;
                return answer;
            }
            
        }
        
        //정상적으로 끝말잇기가 끝난 경우
        answer[0] = 0;
        answer[1] = 0;
        return answer;
    }

	public static void main(String[] args) {
		String[] input = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		int[] result = solution(3, input);
		System.out.println(result[0]+" "+result[1]);
	}

}
