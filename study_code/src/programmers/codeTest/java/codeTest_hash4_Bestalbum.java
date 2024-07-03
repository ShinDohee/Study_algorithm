package programmers.codeTest.java;


import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class codeTest_hash4_Bestalbum {

	public static HashMap<Integer, String> category_PlaysCount = new HashMap<Integer, String>(); //장르별 총 플레이횟수
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
		// 장르별 총 재생 횟수를 저장할 Map
		Map<String, Integer> genreTotalPlays = new HashMap<>();
		// 각 노래의 장르와 인덱스, 재생 횟수를 매핑한 리스트
		List<Song> songs = new ArrayList<>();

		// 입력 데이터 처리
		for (int i = 0; i < genres.length; i++) {
			String genre = genres[i];
			int play = plays[i];
			genreTotalPlays.put(genre, genreTotalPlays.getOrDefault(genre, 0) + play);
			songs.add(new Song(i, genre, play));
		}

		// 장르별로 노래를 재생 횟수 순으로 정렬한 후, 최대 2곡씩 선택
		List<Integer> bestAlbum = genreTotalPlays.keySet().stream()
				.sorted((g1, g2) -> genreTotalPlays.get(g2) - genreTotalPlays.get(g1)) // 장르별 재생 횟수 내림차순 정렬
				.flatMap(genre -> songs.stream()
						.filter(song -> song.getGenre().equals(genre))
						.sorted(Comparator.comparingInt(Song::getPlayCount).reversed().thenComparingInt(Song::getIndex))
						.limit(2)
						.map(Song::getIndex))
				.collect(Collectors.toList());

		return bestAlbum.stream().mapToInt(Integer::intValue).toArray();

	}


	static class Song {
		private int index;
		private String genre;
		private int playCount;

		public Song(int index, String genre, int playCount) {
			this.index = index;
			this.genre = genre;
			this.playCount = playCount;
		}

		public int getIndex() {
			return index;
		}

		public String getGenre() {
			return genre;
		}

		public int getPlayCount() {
			return playCount;
		}
	}



	public static void main(String[] args) {
		String[] genres = { "classic", "pop", "classic", "classic", "pop" }; // 재생횟수

		int[] plays = { 500, 600, 150, 800, 2500 };

		solution(genres, plays);

	}

	// 노래를 나타내는 클래스



}
