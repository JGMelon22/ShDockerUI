package Services;

import java.io.IOException;

public class MsSqlService extends ContainersService {
	@Override
	public void Start() {

		// Invoke a Linux terminal emulator passing a custom shell script as parameter
		String[] command = new String[] { "xfce4-terminal", "-e", getUserPath() + "/.StartDocker.sh" };

		ProcessBuilder processBuilder = new ProcessBuilder(command);

		try {
			processBuilder.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void Stop() {
		String[] command = new String[] { "xfce4-terminal", "-e", getUserPath() + "/.StopDocker.sh" };

		ProcessBuilder processBuilder = new ProcessBuilder(command);

		try {
			processBuilder.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
