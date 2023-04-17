package programmers.Hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Music {
	String genre;
	int play;
	int idx;
	public Music(String genre, int play, int idx) {
		this.genre = genre;
		this.play = play;
		this.idx = idx;
	}
}

public class BestAlbum {
		
	static int[] solution(String[] genres, int[] plays) {
		int[] answer = {};
		
		int len = genres.length;
		
		// 장르를 key로 하여 장르별 재생수를 저장합니다
		HashMap<String, Integer> map = new HashMap<>();
		for(int i=0; i<len; i++) {
			map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
		}
		
		// 재생수가 많은 장르부터 정렬합니다
		ArrayList<String> orderGenre = new ArrayList<>();
		while(map.size()!=0) {
			
			int max = -1;
			String maxKey = "";
			for(String key : map.keySet()) {
				if(map.get(key) > max) {
					max = map.get(key);
					maxKey = key;
				}
			}
			
			orderGenre.add(maxKey);
			map.remove(maxKey);
		}
		
		
		ArrayList<Music> musics = new ArrayList<>();
		for(String o : orderGenre) {
			
			// 장르별 임시 저장
			ArrayList<Music> list = new ArrayList<>();
			for(int i=0; i<len; i++) {
				if(genres[i].equals(o))
					list.add(new Music(o, plays[i], i));
			}
			
			// 재생수 내림차순 정렬
			Collections.sort(list, (o1,o2) -> o2.play - o1.play);
			// 장르별 재생수가 많은 Music객체를 최대 2개 저장합니다
			musics.add(list.get(0));
			if(list.size()>1) musics.add(list.get(1));
		}
		
		answer = new int[musics.size()];
		for(int i=0; i<answer.length; i++) {
			answer[i] = musics.get(i).idx;
		}
		
		
		return answer;
	}

	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		int[] answer = solution(genres, plays);
		for(int i: answer) {
			System.out.print(i+ " ");
		}
	}
	

}
