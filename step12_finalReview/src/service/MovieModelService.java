package service;

import java.util.ArrayList;

import exception.MovieNameDuplicationException;
import exception.MovieNotFoundException;
import moviedto.ActorDTO;
import moviedto.MovieCategori;

public class MovieModelService {

	private ArrayList<MovieCategori> myMovie = new ArrayList<MovieCategori>(); // 전역변수 모든 곳에서 사용 가능.

//	 ArrayList<String> actorMovieList = new ArrayList<String>();

	private static MovieModelService instance = new MovieModelService();

	public static MovieModelService getInstance() {
		return instance;
	}

	public ArrayList<MovieCategori> getMovieProjectsList() {
		return myMovie;
	}

	public MovieCategori getMovieProject(String movieName) throws MovieNotFoundException {
		for (int i = 0; i < myMovie.size(); i++) {
			if (myMovie.get(i).getMovieInfo().getMovieName().equals(movieName)) {
				return myMovie.get(i);
			}
		}
		throw new MovieNotFoundException("해당 영화 미 존재");
	}

	public void movieListCreate(MovieCategori m) throws MovieNameDuplicationException {

		for (MovieCategori e : myMovie) {
			if (e.getMovieInfo().getMovieName().equals(m.getMovieInfo().getMovieName())) { // 비교
				throw new MovieNameDuplicationException("이미 존재하는 영화입니다.");
			}
		}
		myMovie.add(m);
	}

	// HashMap
	public ArrayList<String> actorMovieListAdd(String aName) throws MovieNotFoundException { // ex)aName = "최우식"
		// 최우식
		// HashSet 
		// HashMap 키값 벨류밧
		ArrayList<String> actorMovieList = new ArrayList<String>(); 		// 지역변수: 생성 시 초기화

		for (MovieCategori e : myMovie) {
			if (e.getMovieInfo().getMainActorName().equals(aName)) {
				actorMovieList.add(e.getMovieInfo().getMovieName()); 		// [기생충, 마녀]
			}
		}
		if (actorMovieList.isEmpty()) {
			throw new MovieNotFoundException("해당 배우 미 존재");
		}
		return actorMovieList; // ArrayList<String> 기생충, 마녀
	}

	// HashMap
	public ArrayList<String> movieGenreListAdd(String aGenre) throws MovieNotFoundException {

		ArrayList<String> genreMovieList = new ArrayList<String>();
		for (MovieCategori e : myMovie) {
			if (e.getMovieInfo().getMovieGenre().equals(aGenre)) {
				genreMovieList.add(e.getMovieInfo().getMovieName());
			}
		}
		if (genreMovieList.isEmpty()) {
			throw new MovieNotFoundException("해당 장르 미 존재");
		}
		return genreMovieList;
	}

	public ActorDTO actorInfoRead(String s) throws MovieNotFoundException {
		int count = myMovie.size();
		
		for (int i = 0; i < count; i++) {
			if (myMovie.get(i).getActorInfo().getActorName().equals(s)) {
				return myMovie.get(i).getActorInfo();
			}
		}
		throw new MovieNotFoundException("해당 영화 미 존재");
	}

	public void movieListUpdata(String s, String s1) throws MovieNotFoundException {

		for (MovieCategori e : myMovie) {
			if (e.getMovieInfo().getMovieName().equals(s)) {
				e.setMovieTime(s1);
				return;
			}
		}
		throw new MovieNotFoundException("해당 영화 미 존재");
	}

	public void MovieListDelete(String s) throws MovieNotFoundException {

		for (int i = 0; i < myMovie.size(); i++) {
			if (myMovie.get(i).getMovieInfo().getMovieName().equals(s)) {
				myMovie.remove(i);
				return;
			}
		}
		throw new MovieNotFoundException("해당 영화 미 존재");
	}

} // Class End Point
