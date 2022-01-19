package service;

import java.util.ArrayList;

import exception.MovieNameDuplicationException;
import exception.MovieNotFoundException;
import moviedto.ActorDTO;
import moviedto.MovieCategori;

public class MovieModelService {

	private ArrayList<MovieCategori> myMovie = new ArrayList<MovieCategori>(); // �������� ��� ������ ��� ����.

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
		throw new MovieNotFoundException("�ش� ��ȭ �� ����");
	}

	public void movieListCreate(MovieCategori m) throws MovieNameDuplicationException {

		for (MovieCategori e : myMovie) {
			if (e.getMovieInfo().getMovieName().equals(m.getMovieInfo().getMovieName())) { // ��
				throw new MovieNameDuplicationException("�̹� �����ϴ� ��ȭ�Դϴ�.");
			}
		}
		myMovie.add(m);
	}

	// HashMap
	public ArrayList<String> actorMovieListAdd(String aName) throws MovieNotFoundException { // ex)aName = "�ֿ��"
		// �ֿ��
		// HashSet 
		// HashMap Ű�� ������
		ArrayList<String> actorMovieList = new ArrayList<String>(); 		// ��������: ���� �� �ʱ�ȭ

		for (MovieCategori e : myMovie) {
			if (e.getMovieInfo().getMainActorName().equals(aName)) {
				actorMovieList.add(e.getMovieInfo().getMovieName()); 		// [�����, ����]
			}
		}
		if (actorMovieList.isEmpty()) {
			throw new MovieNotFoundException("�ش� ��� �� ����");
		}
		return actorMovieList; // ArrayList<String> �����, ����
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
			throw new MovieNotFoundException("�ش� �帣 �� ����");
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
		throw new MovieNotFoundException("�ش� ��ȭ �� ����");
	}

	public void movieListUpdata(String s, String s1) throws MovieNotFoundException {

		for (MovieCategori e : myMovie) {
			if (e.getMovieInfo().getMovieName().equals(s)) {
				e.setMovieTime(s1);
				return;
			}
		}
		throw new MovieNotFoundException("�ش� ��ȭ �� ����");
	}

	public void MovieListDelete(String s) throws MovieNotFoundException {

		for (int i = 0; i < myMovie.size(); i++) {
			if (myMovie.get(i).getMovieInfo().getMovieName().equals(s)) {
				myMovie.remove(i);
				return;
			}
		}
		throw new MovieNotFoundException("�ش� ��ȭ �� ����");
	}

} // Class End Point
