package services;

public abstract class ContainersService {
	private String userPath = System.getenv("HOME");

	public String getUserPath() {
		return userPath;
	}

	public void setUserPath(String userPath) {
		this.userPath = userPath;
	}

	public abstract void Start();

	public abstract void Stop();
}
