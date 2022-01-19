package controller;

import java.util.ArrayList;
import java.util.HashMap;

import exception.MovieNameDuplicationException;
import exception.MovieNotFoundException;
import moviedto.MovieCategori;
import service.MovieModelService;
import view.EndFailView;
import view.EndView;

public class MovieSystemController {
	// ����� ����.
	// ����� ����.
	//

	private static MovieSystemController instance = new MovieSystemController();

	private MovieModelService service = MovieModelService.getInstance(); // ���񽺿� �ִ� getInstance�� �̿��Ͽ� ����� �� ����.

	private MovieSystemController() {
	}

	public static MovieSystemController getInstance() {
		return instance;
	}

	// hashMap
	// service.ActorMovieListAdd(aName) = ArrayList<String>

	public void actorMovieListAdd(String aName) { // �ֿ��
		try {
			HashMap<String, ArrayList<String>> aNameMovie = new HashMap<String, ArrayList<String>>();
			aNameMovie.put(aName, service.actorMovieListAdd(aName)); // ����� ����
			EndView.hashName(aNameMovie);
		} catch (MovieNotFoundException e) {
			e.printStackTrace();
			EndFailView.failView("������ ����� �Է����ּ���.");
		}
	}

	public void movieGenreListAdd(String aName) {
		try {
			HashMap<String, ArrayList<String>> genreMovie = new HashMap<String, ArrayList<String>>();
			genreMovie.put(aName, service.movieGenreListAdd(aName));
			EndView.hashName(genreMovie);
		} catch (MovieNotFoundException e) {
			e.printStackTrace();
			EndFailView.failView("������ ����� �Է����ּ���.");
		}
	}

	public void getMovieProject(String projectName) {
		try {
			EndView.movieView(service.getMovieProject(projectName));
		} catch (MovieNotFoundException e) {
			e.printStackTrace();
			EndFailView.failView(e.getMessage());
		}
	}

	public void getMovieProjectsList() {
		EndView.movieListView(service.getMovieProjectsList());
	}

	public void movieListCreate(MovieCategori project) {

		if (project != null) {
			try {
				service.movieListCreate(project);
			} catch (MovieNameDuplicationException e) {
				e.printStackTrace();
				EndFailView.failView(e.getMessage());
			}
		} else {
			EndFailView.failView("������ �� �ִ� �����Ͱ� �������� �ʽ��ϴ�.");
		}
	}

	public void movieListUpdata(String string, String replaceTime) {

		if (string != null && replaceTime != null) {
			try {
				service.movieListUpdata(string, replaceTime);
				EndView.movieView(service.getMovieProject(string));
			} catch (MovieNotFoundException e) {
				e.printStackTrace();
				EndFailView.failView(e.getMessage());
			}
		} else {
			EndFailView.failView("������ ����� �Է����ּ���.");
		}

	}

	public void actorInfoRead(String name) {
		try {
			EndView.moiveActorView(service.actorInfoRead(name));
		} catch (MovieNotFoundException e) {
			e.printStackTrace();
			EndFailView.failView(e.getMessage());
		}
	}

	public void movieListDelete(String movieName) {

		if (movieName != null) {
			try {
				service.MovieListDelete(movieName);
				EndView.successView("�����Ǿ����ϴ�.");
			} catch (MovieNotFoundException e) {
				e.printStackTrace();
				EndFailView.failView(e.getMessage());
			}
		} else {
			EndFailView.failView("�����ϱ����� ��ȭ�� �����ϴ�.");
		}

	}

} // Class End Point
