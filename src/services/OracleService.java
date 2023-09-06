package services;

import java.io.IOException;

import javax.swing.JOptionPane;

public class OracleService extends ContainersService {

	@Override
	public void Start() {
		String[] command = new String[] { "xfce4-terminal", "-e", getUserPath() + "/.StartOracle.sh" };

		ProcessBuilder processBuilder = new ProcessBuilder(command);

		try {
			processBuilder.start();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
		}

	}

	@Override
	public void Stop() {
		String[] command = new String[] { "xfce4-terminal", "-e", getUserPath() + "/.StopOracle.sh" };

		ProcessBuilder processBuilder = new ProcessBuilder(command);

		try {
			processBuilder.start();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
		}

	}

}
