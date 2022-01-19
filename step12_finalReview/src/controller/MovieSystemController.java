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
	// 명령을 전달.
	// 명령을 수행.
	//

	private static MovieSystemController instance = new MovieSystemController();

	private MovieModelService service = MovieModelService.getInstance(); // 서비스에 있는 getInstance를 이용하여 사용할 수 있음.

	private MovieSystemController() {
	}

	public static MovieSystemController getInstance() {
		return instance;
	}

	// hashMap
	// service.ActorMovieListAdd(aName) = ArrayList<String>

	public void actorMovieListAdd(String aName) { // 최우식
		try {
			HashMap<String, ArrayList<String>> aNameMovie = new HashMap<String, ArrayList<String>>();
			aNameMovie.put(aName, service.actorMovieListAdd(aName)); // 기생충 마녀
			EndView.hashName(aNameMovie);
		} catch (MovieNotFoundException e) {
			e.printStackTrace();
			EndFailView.failView("정보를 제대로 입력해주세요.");
		}
	}

	public void movieGenreListAdd(String aName) {
		try {
			HashMap<String, ArrayList<String>> genreMovie = new HashMap<String, ArrayList<String>>();
			genreMovie.put(aName, service.movieGenreListAdd(aName));
			EndView.hashName(genreMovie);
		} catch (MovieNotFoundException e) {
			e.printStackTrace();
			EndFailView.failView("정보를 제대로 입력해주세요.");
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
			EndFailView.failView("저장할 수 있는 데이터가 존재하지 않습니다.");
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
			EndFailView.failView("정보를 제대로 입력해주세요.");
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
				EndView.successView("삭제되었습니다.");
			} catch (MovieNotFoundException e) {
				e.printStackTrace();
				EndFailView.failView(e.getMessage());
			}
		} else {
			EndFailView.failView("삭제하기위한 영화가 없습니다.");
		}

	}

} // Class End Point
