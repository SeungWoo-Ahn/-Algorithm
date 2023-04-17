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
		
		// �帣�� key�� �Ͽ� �帣�� ������� �����մϴ�
		HashMap<String, Integer> map = new HashMap<>();
		for(int i=0; i<len; i++) {
			map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
		}
		
		// ������� ���� �帣���� �����մϴ�
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
			
			// �帣�� �ӽ� ����
			ArrayList<Music> list = new ArrayList<>();
			for(int i=0; i<len; i++) {
				if(genres[i].equals(o))
					list.add(new Music(o, plays[i], i));
			}
			
			// ����� �������� ����
			Collections.sort(list, (o1,o2) -> o2.play - o1.play);
			// �帣�� ������� ���� Music��ü�� �ִ� 2�� �����մϴ�
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
