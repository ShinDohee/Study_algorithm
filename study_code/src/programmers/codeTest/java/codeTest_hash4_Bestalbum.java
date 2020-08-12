package programmers.codeTest.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class codeTest_hash4_Bestalbum {

	public static HashSet<String> genres_set = new HashSet<String>(); // 장르 중복 제거 
	public static HashMap<Integer, String> category_Plays = new HashMap<Integer, String>(); //장르별 총 플레이횟수 
	public static HashMap<Integer, String> category_gCount = new HashMap<Integer, String>(); //장르별 총노래수

//	public static HashMap<Integer, Integer> map_player = new HashMap<Integer, Integer>();
//	public static HashMap<String, Integer> map_genres = new HashMap<String, Integer>();
	public static ArrayList<Map<String, Integer>> list_titalInfo; // map 리스트로 변경 

	// 장르- 재생횟수 (중복제거)\ -> 재생횟수가 높은거 부터

	// if( 선택한 장르일 경우 )-> 재생횟수 genres -arraylist로 변환 -> 오름차순 정렬 -> 2개 값 추출 -> 그리고
	// player index 추출
	// 해당 장르의 재생횟수 list 로 저장 후 -> 오름 차순 -> 앞에 2값 찾아서
	//

	public static int[] solution(String[] genres, int[] plays) {

		int idx=0;
		int size =0;

		list_titalInfo =  new ArrayList<Map<String, Integer>>(genres.length);
		// 장르, 재생횟수 arraylist 으로 변경 
		for (int i = 0; i < plays.length; i++) {
			Map<String, Integer> emtpy = new HashMap<String, Integer>();
			emtpy.put(genres[i], plays[i]);
			list_titalInfo.add(i, emtpy );

			
			genres_set.add(genres[i]);

		}

		// 장르별 재생횟수 총합 
		for (String x: genres_set) {
			int count =0;
			int song_count=0;
			for(int i = 0; i < list_titalInfo.size(); i++) {
				if(list_titalInfo.get(i).get(x) != null) {
					count += list_titalInfo.get(i).get(x);
					song_count++;
					
				}
			}
			category_Plays.put(count, x);
			category_gCount.put(song_count, x);
			if(song_count >= 2) {
				size += 2;
			}else {
				size += 1;
			}
		}
		
		System.out.println(size);
		int[] answer = new int  [size];
		//중복 제거 및  총합 내림차순으로 
		List<Entry<Integer, String>> list_entries = new ArrayList<Entry<Integer, String>>(category_Plays.entrySet());

		Collections.sort(list_entries, new Comparator<Entry<Integer, String>>() {
			@Override
			public int compare(Entry<Integer, String> o1, Entry<Integer, String> o2) {
				// TODO Auto-generated method stub
				return o2.getKey().compareTo(o1.getKey());
			}
		});
		

		for (Entry<Integer, String> entry : list_entries) { // 장르
			ArrayList array_players = new ArrayList();
			for (int i = 0; i < genres.length; i++) {
				if(genres[i] == entry.getValue()) {
					array_players.add(plays[i]);
				}
			}
			
			Collections.sort(array_players);
			Collections.reverse(array_players);


			
			for (int i = 0; i < 2; i++) {
				Object vs_num = array_players.get(i);
				for (int j = 0; j < list_titalInfo.size(); j++) {
					Map map2 = list_titalInfo.get(j);
					if(map2.values().contains(vs_num)) {
						
						answer[idx] = j;
						idx++;
						}
				}

			}
		
		}

			
		return answer;
	}

	public static void main(String[] args) {
		String[] genres = { "classic", "pop", "classic", "classic", "pop" }; // 재생횟수

		int[] plays = { 500, 600, 150, 800, 2500 };

		solution(genres, plays);

	}



}
