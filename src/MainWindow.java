import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import services.MongoDbService;
import services.MsSqlService;
import services.MySqlService;
import services.OracleService;
import services.PostgreService;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JCheckBox;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow {

	private JFrame frmShDockerUi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmShDockerUi.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {

		try {
			// Set cross-platform Java L&F (also called "Metal")
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
		} catch (UnsupportedLookAndFeelException e) {
			// handle exception
		} catch (ClassNotFoundException e) {
			// handle exception
		} catch (InstantiationException e) {
			// handle exception
		} catch (IllegalAccessException e) {
			// handle exception
		}

		initialize();
		Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/assets/logo.png"));
		frmShDockerUi.setIconImage(img);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmShDockerUi = new JFrame();
		frmShDockerUi.setFont(new Font("FreeSans", Font.PLAIN, 13));
		frmShDockerUi.setTitle("Shell Docker UI");
		frmShDockerUi.setBounds(100, 100, 450, 420);
		frmShDockerUi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmShDockerUi.setLocationRelativeTo(null);
		frmShDockerUi.setResizable(false);

		JLayeredPane layeredPane = new JLayeredPane();
		frmShDockerUi.getContentPane().add(layeredPane, BorderLayout.CENTER);

		JLabel lblNewLabel = new JLabel("SQL Server");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNewLabel_1 = new JLabel("MySQL");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNewLabel_2 = new JLabel("Postgres");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNewLabel_3 = new JLabel("Oracle");
		lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNewLabel_4 = new JLabel("MongoDB");
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnStartMsSql = new JButton("Start");
		btnStartMsSql.setCursor(new Cursor(Cursor.HAND_CURSOR));

		JButton btnStopMsSql = new JButton("Stop");
		btnStopMsSql.setCursor(new Cursor(Cursor.HAND_CURSOR));

		JButton btnStopMySql = new JButton("Stop");
		btnStopMySql.setCursor(new Cursor(Cursor.HAND_CURSOR));

		JButton btnStartMySql = new JButton("Start");
		btnStartMySql.setCursor(new Cursor(Cursor.HAND_CURSOR));

		JButton btnStartPostgres = new JButton("Start");
		btnStartPostgres.setCursor(new Cursor(Cursor.HAND_CURSOR));

		JButton btnStopPostgres = new JButton("Stop");
		btnStopPostgres.setCursor(new Cursor(Cursor.HAND_CURSOR));

		JButton btnStartOracle = new JButton("Start");
		btnStartOracle.setCursor(new Cursor(Cursor.HAND_CURSOR));

		JButton btnStopOracle = new JButton("Stop");
		btnStopOracle.setCursor(new Cursor(Cursor.HAND_CURSOR));

		JButton btnStopMongoDb = new JButton("Stop");
		btnStopMongoDb.setCursor(new Cursor(Cursor.HAND_CURSOR));

		JButton btnStartMongoDb = new JButton("Start");
		btnStartMongoDb.setCursor(new Cursor(Cursor.HAND_CURSOR));

		JCheckBox checkBoxStopMongoDb = new JCheckBox("");
		checkBoxStopMongoDb.setToolTipText("MongoDB container is stopped");
		checkBoxStopMongoDb.setFont(new Font("Dialog", Font.BOLD, 14));
		checkBoxStopMongoDb.setEnabled(false);
		checkBoxStopMongoDb.setHorizontalAlignment(SwingConstants.CENTER);

		JCheckBox checkBoxStopOracle = new JCheckBox("");
		checkBoxStopOracle.setToolTipText("Oracle container is stopped");
		checkBoxStopOracle.setFont(new Font("Dialog", Font.BOLD, 14));
		checkBoxStopOracle.setEnabled(false);
		checkBoxStopOracle.setHorizontalAlignment(SwingConstants.CENTER);

		JCheckBox checkBoxStopPostgres = new JCheckBox("");
		checkBoxStopPostgres.setToolTipText("Postgres container is stopped");
		checkBoxStopPostgres.setFont(new Font("Dialog", Font.BOLD, 14));
		checkBoxStopPostgres.setEnabled(false);
		checkBoxStopPostgres.setHorizontalAlignment(SwingConstants.CENTER);

		JCheckBox checkBoxStopMySql = new JCheckBox("");
		checkBoxStopMySql.setToolTipText("MySQL container is stopped");
		checkBoxStopMySql.setFont(new Font("Dialog", Font.BOLD, 14));
		checkBoxStopMySql.setEnabled(false);
		checkBoxStopMySql.setHorizontalAlignment(SwingConstants.CENTER);

		JCheckBox checkBoxStopMsSql = new JCheckBox("");
		checkBoxStopMsSql.setToolTipText("SQL Server container is stopped");
		checkBoxStopMsSql.setFont(new Font("Dialog", Font.BOLD, 14));
		checkBoxStopMsSql.setEnabled(false);
		checkBoxStopMsSql.setHorizontalAlignment(SwingConstants.CENTER);

		JCheckBox checkBoxStartMongoDb = new JCheckBox("");
		checkBoxStartMongoDb.setToolTipText("MongoDBcontainer is running");
		checkBoxStartMongoDb.setFont(new Font("Dialog", Font.BOLD, 14));
		checkBoxStartMongoDb.setEnabled(false);
		checkBoxStartMongoDb.setHorizontalAlignment(SwingConstants.CENTER);

		JCheckBox checkBoxStartOracle = new JCheckBox("");
		checkBoxStartOracle.setToolTipText("Oracle container is running");
		checkBoxStartOracle.setFont(new Font("Dialog", Font.BOLD, 14));
		checkBoxStartOracle.setEnabled(false);
		checkBoxStartOracle.setHorizontalAlignment(SwingConstants.CENTER);

		JCheckBox checkBoxStartPostgres = new JCheckBox("");
		checkBoxStartPostgres.setToolTipText("Postgres container is running");
		checkBoxStartPostgres.setFont(new Font("Dialog", Font.BOLD, 14));
		checkBoxStartPostgres.setEnabled(false);
		checkBoxStartPostgres.setHorizontalAlignment(SwingConstants.CENTER);

		JCheckBox checkBoxStartMySql = new JCheckBox("");
		checkBoxStartMySql.setToolTipText("MySQL container is running");
		checkBoxStartMySql.setFont(new Font("Dialog", Font.BOLD, 14));
		checkBoxStartMySql.setEnabled(false);
		checkBoxStartMySql.setHorizontalAlignment(SwingConstants.CENTER);

		JCheckBox checkBoxStartMsSql = new JCheckBox("");
		checkBoxStartMsSql.setToolTipText("SQL Server container is running");
		checkBoxStartMsSql.setFont(new Font("Dialog", Font.BOLD, 14));
		checkBoxStartMsSql.setEnabled(false);
		checkBoxStartMsSql.setHorizontalAlignment(SwingConstants.CENTER);

		checkBoxStopMsSql.setSelected(true);
		checkBoxStopMySql.setSelected(true);
		checkBoxStopPostgres.setSelected(true);
		checkBoxStopOracle.setSelected(true);
		checkBoxStopMongoDb.setSelected(true);

		// Start SQL Server Service
		btnStartMsSql.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MsSqlService msSqlService = new MsSqlService();

				// Using thread to improve code speed
				Thread threadStartMsSql = new Thread(() -> {
					msSqlService.Start();
				});

				threadStartMsSql.start();

				checkBoxStartMsSql.setSelected(true);
				checkBoxStopMsSql.setSelected(false);
			}
		});

		// Stop SQL Server Service
		btnStopMsSql.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MsSqlService msSqlService = new MsSqlService();

				// Using thread to improve code speed
				Thread threadStopMsSql = new Thread(() -> {
					msSqlService.Stop();
				});

				threadStopMsSql.start();

				// Judges the other Container check boxes
				boolean mySqlContainerState = checkBoxStartMySql.isSelected();
				boolean postgreesContainerState = checkBoxStartPostgres.isSelected();
				boolean oracleContainerState = checkBoxStartOracle.isSelected();
				boolean mongoDBContainerState = checkBoxStartMongoDb.isSelected();

				int switchValue = (mySqlContainerState ? 1 : 0) | (postgreesContainerState ? 2 : 0)
						| (oracleContainerState ? 4 : 0) | (mongoDBContainerState ? 6 : 0);

				switch (switchValue) {

				default:
					checkBoxStartMySql.setSelected(false);
					checkBoxStopMySql.setSelected(true);

					checkBoxStartPostgres.setSelected(false);
					checkBoxStopPostgres.setSelected(true);

					checkBoxStartOracle.setSelected(false);
					checkBoxStopOracle.setSelected(true);

					checkBoxStartMongoDb.setSelected(false);
					checkBoxStopMongoDb.setSelected(true);
					break;
				}

				checkBoxStopMsSql.setSelected(true);
				checkBoxStartMsSql.setSelected(false);
			}
		});

		// Start MySQL Service
		btnStartMySql.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MySqlService mySqlService = new MySqlService();

				// Using thread to improve code speed
				Thread threadStartMySql = new Thread(() -> {
					mySqlService.Start();
				});

				threadStartMySql.start();

				checkBoxStartMySql.setSelected(true);
				checkBoxStopMySql.setSelected(false);
			}
		});

		// Stop MySQL Service
		btnStopMySql.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MySqlService mySqlService = new MySqlService();

				// Using thread to improve code speed
				Thread threadStopMySql = new Thread(() -> {
					mySqlService.Stop();
				});

				threadStopMySql.start();

				// Judges the other Container check boxes
				boolean msSqlContainerState = checkBoxStartMsSql.isSelected();
				boolean postgreesContainerState = checkBoxStartPostgres.isSelected();
				boolean oracleContainerState = checkBoxStartOracle.isSelected();
				boolean mongoDBContainerState = checkBoxStartMongoDb.isSelected();

				int switchValue = (msSqlContainerState ? 1 : 0) | (postgreesContainerState ? 2 : 0)
						| (oracleContainerState ? 4 : 0) | (mongoDBContainerState ? 6 : 0);

				switch (switchValue) {

				default:
					checkBoxStartMsSql.setSelected(false);
					checkBoxStopMsSql.setSelected(true);

					checkBoxStartPostgres.setSelected(false);
					checkBoxStopPostgres.setSelected(true);

					checkBoxStartOracle.setSelected(false);
					checkBoxStopOracle.setSelected(true);

					checkBoxStartMongoDb.setSelected(false);
					checkBoxStopMongoDb.setSelected(true);
					break;
				}

				checkBoxStopMySql.setSelected(true);
				checkBoxStartMySql.setSelected(false);
			}
		});

		// Start PostgreSQL Service
		btnStartPostgres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PostgreService postgreService = new PostgreService();

				// Using thread to improve code speed
				Thread threadStartPostgre = new Thread(() -> {
					postgreService.Start();
				});

				threadStartPostgre.start();

				checkBoxStartPostgres.setSelected(true);
				checkBoxStopPostgres.setSelected(false);
			}
		});

		// Stop PostgreSQL Service
		btnStopPostgres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PostgreService postgreService = new PostgreService();

				// Using thread to improve code speed
				Thread threadStopPostgre = new Thread(() -> {
					postgreService.Stop();
				});

				threadStopPostgre.start();

				// Judges the other Container check boxes
				boolean msSqlContainerState = checkBoxStartMsSql.isSelected();
				boolean mySqlContainerState = checkBoxStartMySql.isSelected();
				boolean oracleContainerState = checkBoxStartOracle.isSelected();
				boolean mongoDBContainerState = checkBoxStartMongoDb.isSelected();

				int switchValue = (msSqlContainerState ? 1 : 0) | (mySqlContainerState ? 2 : 0)
						| (oracleContainerState ? 4 : 0) | (mongoDBContainerState ? 6 : 0);

				switch (switchValue) {

				default:
					checkBoxStartMsSql.setSelected(false);
					checkBoxStopMsSql.setSelected(true);

					checkBoxStartMySql.setSelected(false);
					checkBoxStopMySql.setSelected(true);

					checkBoxStartOracle.setSelected(false);
					checkBoxStopOracle.setSelected(true);

					checkBoxStartMongoDb.setSelected(false);
					checkBoxStopMongoDb.setSelected(true);
					break;
				}

				checkBoxStopPostgres.setSelected(true);
				checkBoxStartPostgres.setSelected(false);
			}
		});

		// Start Oracle Service
		btnStartOracle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OracleService oracleService = new OracleService();

				// Using thread to improve code speed
				Thread threadStartOracle = new Thread(() -> {
					oracleService.Start();
				});

				threadStartOracle.start();

				checkBoxStartOracle.setSelected(true);
				checkBoxStopOracle.setSelected(false);
			}
		});

		// Stop Oracle Service
		btnStopOracle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OracleService oracleService = new OracleService();

				// Using thread to improve code speed
				Thread threadStopOracle = new Thread(() -> {
					oracleService.Stop();
				});

				threadStopOracle.start();

				// Judges the other Container check boxes
				boolean msSqlContainerState = checkBoxStartMsSql.isSelected();
				boolean mySqlContainerState = checkBoxStartMySql.isSelected();
				boolean postgreesContainerState = checkBoxStartPostgres.isSelected();

				boolean mongoDBContainerState = checkBoxStartMongoDb.isSelected();

				int switchValue = (msSqlContainerState ? 1 : 0) | (mySqlContainerState ? 2 : 0)
						| (postgreesContainerState ? 4 : 0) | (mongoDBContainerState ? 6 : 0);

				switch (switchValue) {

				default:
					checkBoxStartMsSql.setSelected(false);
					checkBoxStopMsSql.setSelected(true);

					checkBoxStartMySql.setSelected(false);
					checkBoxStopMySql.setSelected(true);

					checkBoxStartPostgres.setSelected(false);
					checkBoxStopPostgres.setSelected(true);

					checkBoxStartMongoDb.setSelected(false);
					checkBoxStopMongoDb.setSelected(true);
					break;
				}

				checkBoxStopOracle.setSelected(true);
				checkBoxStartOracle.setSelected(false);
			}
		});

		// Start MongoDB Service
		btnStartMongoDb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MongoDbService mongoDbService = new MongoDbService();

				// Using thread to improve code speed
				Thread threadStartMongoDb = new Thread(() -> {
					mongoDbService.Start();
				});

				threadStartMongoDb.start();

				checkBoxStartMongoDb.setSelected(true);
				checkBoxStopMongoDb.setSelected(false);
			}
		});

		// Stop MongoDB Service
		btnStopMongoDb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MongoDbService mongoDbService = new MongoDbService();

				// Using thread to improve code speed
				Thread threadStopMongoDb = new Thread(() -> {
					mongoDbService.Stop();
				});

				threadStopMongoDb.start();

				// Judges the other Container check boxes
				boolean msSqlContainerState = checkBoxStartMsSql.isSelected();
				boolean mySqlContainerState = checkBoxStartMySql.isSelected();
				boolean postgreesContainerState = checkBoxStartPostgres.isSelected();
				boolean oracleContainerState = checkBoxStartOracle.isSelected();

				int switchValue = (msSqlContainerState ? 1 : 0) | (mySqlContainerState ? 2 : 0)
						| (postgreesContainerState ? 4 : 0) | (oracleContainerState ? 6 : 0);

				switch (switchValue) {

				default:
					checkBoxStartMySql.setSelected(false);
					checkBoxStopMySql.setSelected(true);

					checkBoxStartPostgres.setSelected(false);
					checkBoxStopPostgres.setSelected(true);

					checkBoxStartOracle.setSelected(false);
					checkBoxStopOracle.setSelected(true);

					checkBoxStartPostgres.setSelected(false);
					checkBoxStopPostgres.setSelected(true);
					break;
				}

				checkBoxStopMongoDb.setSelected(true);
				checkBoxStartMongoDb.setSelected(false);
			}
		});

		JLabel label = new JLabel("-");

		JLabel label_1 = new JLabel("-");

		JLabel label_2 = new JLabel("-");

		JLabel label_3 = new JLabel("-");

		JLabel label_4 = new JLabel("-");
		GroupLayout gl_layeredPane = new GroupLayout(layeredPane);
		gl_layeredPane.setHorizontalGroup(
			gl_layeredPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_layeredPane.createSequentialGroup()
					.addGap(108)
					.addGroup(gl_layeredPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(checkBoxStartPostgres, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkBoxStartMySql, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkBoxStartMsSql, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkBoxStartOracle, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkBoxStartMongoDb, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_layeredPane.createSequentialGroup()
							.addGap(43)
							.addGroup(gl_layeredPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_layeredPane.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addGap(7))))
						.addGroup(gl_layeredPane.createSequentialGroup()
							.addGroup(gl_layeredPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_layeredPane.createSequentialGroup()
									.addComponent(btnStartMsSql, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
									.addGap(3)
									.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 5, GroupLayout.PREFERRED_SIZE)
									.addGap(3)
									.addComponent(btnStopMsSql, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_layeredPane.createSequentialGroup()
									.addComponent(btnStartPostgres, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
									.addGap(3)
									.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 5, GroupLayout.PREFERRED_SIZE)
									.addGap(3)
									.addComponent(btnStopPostgres, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_layeredPane.createSequentialGroup()
									.addComponent(btnStartMySql, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
									.addGap(3)
									.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 5, GroupLayout.PREFERRED_SIZE)
									.addGap(3)
									.addComponent(btnStopMySql, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_layeredPane.createSequentialGroup()
									.addComponent(btnStartOracle, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
									.addGap(3)
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 5, GroupLayout.PREFERRED_SIZE)
									.addGap(3)
									.addComponent(btnStopOracle, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_layeredPane.createSequentialGroup()
									.addComponent(btnStartMongoDb, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
									.addGap(3)
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 5, GroupLayout.PREFERRED_SIZE)
									.addGap(3)
									.addComponent(btnStopMongoDb, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_layeredPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(checkBoxStopMsSql, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_layeredPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(checkBoxStopMySql, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_layeredPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(checkBoxStopPostgres, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_layeredPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(checkBoxStopOracle, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_layeredPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(checkBoxStopMongoDb)))))
					.addContainerGap(140, Short.MAX_VALUE))
				.addGroup(gl_layeredPane.createSequentialGroup()
					.addGap(173)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
					.addGap(194))
				.addGroup(gl_layeredPane.createSequentialGroup()
					.addGap(189)
					.addComponent(lblNewLabel_3)
					.addContainerGap(209, Short.MAX_VALUE))
				.addGroup(gl_layeredPane.createSequentialGroup()
					.addGap(178)
					.addComponent(lblNewLabel_4)
					.addContainerGap(195, Short.MAX_VALUE))
		);
		gl_layeredPane.setVerticalGroup(
			gl_layeredPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_layeredPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_layeredPane.createSequentialGroup()
							.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_layeredPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(btnStartMsSql)
									.addComponent(btnStopMsSql))
								.addComponent(label_4))
							.addGap(17)
							.addComponent(lblNewLabel_1))
						.addComponent(checkBoxStartMsSql, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkBoxStopMsSql, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_layeredPane.createSequentialGroup()
							.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_layeredPane.createParallelGroup(Alignment.BASELINE, false)
									.addComponent(btnStopMySql)
									.addComponent(btnStartMySql))
								.addComponent(label_3))
							.addGap(24)
							.addComponent(lblNewLabel_2))
						.addComponent(checkBoxStartMySql, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkBoxStopMySql, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_layeredPane.createSequentialGroup()
							.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnStartPostgres)
								.addComponent(btnStopPostgres)
								.addComponent(label_2)
								.addComponent(checkBoxStartPostgres, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(lblNewLabel_3))
						.addComponent(checkBoxStopPostgres, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_layeredPane.createSequentialGroup()
							.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_layeredPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(btnStartOracle)
									.addComponent(btnStopOracle))
								.addComponent(label_1))
							.addGap(18)
							.addComponent(lblNewLabel_4))
						.addComponent(checkBoxStartOracle, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkBoxStopOracle, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addGroup(gl_layeredPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnStopMongoDb)
							.addComponent(btnStartMongoDb))
						.addComponent(checkBoxStartMongoDb, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkBoxStopMongoDb))
					.addGap(40))
		);
		layeredPane.setLayout(gl_layeredPane);
	}
}