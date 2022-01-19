package moviedto;

public class MovieDTO {

	private String movieName;
	private String mainActorName;
	private int runningTime;
	private String movieGenre;

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMainActorName() {
		return mainActorName;
	}

	public void setMainActorName(String mainActorName) {
		this.mainActorName = mainActorName;
	}

	public int getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("��ȭ �� : ");
		builder.append(movieName);
		builder.append(", �ֿ� ��� : ");
		builder.append(mainActorName);
		builder.append(", �� ��ȭ �ð� : ");
		builder.append(runningTime);
		builder.append(", �帣 : ");
		builder.append(movieGenre);
		return builder.toString();
	}

	public MovieDTO(String movieName, String mainActorName, int runningTime, String movieGenre) {
		super();
		this.movieName = movieName;
		this.mainActorName = mainActorName;
		this.runningTime = runningTime;
		this.movieGenre = movieGenre;
	}

	public MovieDTO() {
		super();
	}

} // Class End Point
