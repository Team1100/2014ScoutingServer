import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;


public class Display extends JFrame {
	
	ScoutingServerAccessor server = new ScoutingServerAccessor();
	String table = "servertransport01";
	
	private JPanel contentPane;
	private JTextField scouterNameTextField;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_2;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JCheckBox catchCheckBox;
	private JCheckBox trussCatchCheckBox;
	private JCheckBox trussTossCheckBox;
	private JCheckBox unloadAutoCheckBox;
	private JComboBox autoBallScoreComboBox;
	private JCheckBox zoneChangeCheckBox;
	private JComboBox autoBallsComboBox;
	private JSpinner matchNumberSpinner;
	private JComboBox teamComboBox;
	private JEditorPane desc1Editor;
	private JEditorPane desc2Editor;
	private JEditorPane desc3Editor;
	private JSpinner cyclesSpinner;
	private JSpinner lowGoalsAttSpinner;
	private JSpinner lowGoalsSpinner;
	private JSpinner highGoalsAttSpinner;
	private JSpinner highGoalsSpinner;
	private JSpinner assistsSpinner;
	private JSpinner attCatchHPSpinner;
	private JSpinner catchHPSpinner;
	private JComboBox defenseComboBox;
	private JComboBox floorComboBox;
	private JTextField editorPane;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_33;
	private JTextField textField_34;
	private JTextField textField_35;
	private JTextField textField_36;
	private JTextField textField_37;
	private JTextField textField_38;
	private JTextField textField_39;
	private JButton btnSearch_1;
	private JTextField textField_40;
	private JEditorPane editorPane_1;
	private JEditorPane editorPane_2;
	private JEditorPane editorPane_6;
	private JComboBox comboBox;
	
	private String eventName;
	private String[] teamsList;
	private JSpinner idSpinner;
	private JEditorPane editorPane_3;
	private JEditorPane editorPane_4;
	private JEditorPane editorPane_5;

	/**
	 * Create the frame.
	 */
	public Display(String event) {
		setResizable(false);
		setTitle("Aerial Assist Scouting Entry and Analysis");
		eventName = event;
		try {
			ResultSet set = server.executeQuery("SELECT * FROM eventstable WHERE Event='"+eventName+"'");
			set.next();
			teamsList = set.getString("Teams").split("~");
		} catch (SQLException e2) {
			System.out.println("Error getting teams list!");
			e2.printStackTrace();
			System.exit(ERROR);
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 594, 562);
		contentPane.add(tabbedPane);
		
		JPanel dataEntryPanel = new JPanel();
		tabbedPane.addTab("Data Entry", null, dataEntryPanel, null);
		dataEntryPanel.setLayout(null);
		
		JLabel matchNumberLabel = new JLabel("Match Number");
		matchNumberLabel.setBounds(10, 11, 97, 14);
		dataEntryPanel.add(matchNumberLabel);
		
		matchNumberSpinner = new JSpinner();
		matchNumberSpinner.setModel(new SpinnerNumberModel(0, 0, 999, 1));
		matchNumberSpinner.setBounds(96, 8, 47, 20);
		dataEntryPanel.add(matchNumberSpinner);
		
		JLabel teamNumberLabel = new JLabel("Team Number");
		teamNumberLabel.setBounds(153, 11, 97, 14);
		dataEntryPanel.add(teamNumberLabel);
		
		teamComboBox = new JComboBox();
		teamComboBox.setModel(new DefaultComboBoxModel(teamsList));
		teamComboBox.setBounds(246, 8, 113, 20);
		dataEntryPanel.add(teamComboBox);
		
		JLabel scouterNameLabel = new JLabel("Scouter Name");
		scouterNameLabel.setBounds(369, 11, 89, 14);
		dataEntryPanel.add(scouterNameLabel);
		
		scouterNameTextField = new JTextField();
		scouterNameTextField.setBounds(455, 8, 121, 20);
		dataEntryPanel.add(scouterNameTextField);
		scouterNameTextField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 36, 589, 2);
		dataEntryPanel.add(separator);
		
		JLabel autoBallsLabel = new JLabel("Number Of Auto Balls");
		autoBallsLabel.setBounds(10, 49, 145, 14);
		dataEntryPanel.add(autoBallsLabel);
		
		autoBallsComboBox = new JComboBox();
		autoBallsComboBox.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3"}));
		autoBallsComboBox.setBounds(177, 49, 85, 20);
		dataEntryPanel.add(autoBallsComboBox);
		
		JLabel changeZoneBonusLabel = new JLabel("Change Zone Bonus");
		changeZoneBonusLabel.setBounds(10, 74, 145, 14);
		dataEntryPanel.add(changeZoneBonusLabel);
		
		JLabel autoBallScoreLabel = new JLabel("Auto Ball Score");
		autoBallScoreLabel.setBounds(10, 99, 145, 14);
		dataEntryPanel.add(autoBallScoreLabel);
		
		JLabel trussCatchLabel = new JLabel("Truss Catch?");
		trussCatchLabel.setBounds(10, 174, 145, 14);
		dataEntryPanel.add(trussCatchLabel);
		
		JLabel trussTossLabel = new JLabel("Truss Toss?");
		trussTossLabel.setBounds(10, 149, 145, 14);
		dataEntryPanel.add(trussTossLabel);
		
		JLabel ableToUnloadLabel = new JLabel("Able To Unload Auto Ball");
		ableToUnloadLabel.setBounds(10, 124, 145, 14);
		dataEntryPanel.add(ableToUnloadLabel);
		
		JLabel defensiveCapabilitiesLabel = new JLabel("Defensive Capabilities");
		defensiveCapabilitiesLabel.setBounds(10, 249, 145, 14);
		dataEntryPanel.add(defensiveCapabilitiesLabel);
		
		JLabel floorPickupLabel = new JLabel("Floor Pickup?");
		floorPickupLabel.setBounds(10, 224, 145, 14);
		dataEntryPanel.add(floorPickupLabel);
		
		JLabel airCatchLabel = new JLabel("Catch Balls In Air?");
		airCatchLabel.setBounds(10, 199, 145, 14);
		dataEntryPanel.add(airCatchLabel);
		
		JLabel assistsLabel = new JLabel("Number Of Assists");
		assistsLabel.setBounds(10, 324, 145, 14);
		dataEntryPanel.add(assistsLabel);
		
		JLabel attemptedCatchLabel = new JLabel("Attemped Catch From HP");
		attemptedCatchLabel.setBounds(10, 299, 145, 14);
		dataEntryPanel.add(attemptedCatchLabel);
		
		JLabel hpCatchLabel = new JLabel("Caught Ball From HP");
		hpCatchLabel.setBounds(10, 274, 145, 14);
		dataEntryPanel.add(hpCatchLabel);
		
		JLabel lowGoalsScoredLabel = new JLabel("Low Goals Scored");
		lowGoalsScoredLabel.setBounds(10, 399, 145, 14);
		dataEntryPanel.add(lowGoalsScoredLabel);
		
		JLabel highGoalsAttemptedLabel = new JLabel("High Goals Attempted");
		highGoalsAttemptedLabel.setBounds(10, 374, 145, 14);
		dataEntryPanel.add(highGoalsAttemptedLabel);
		
		JLabel highGoalsScoredLabel = new JLabel("High Goals Scored");
		highGoalsScoredLabel.setBounds(10, 349, 145, 14);
		dataEntryPanel.add(highGoalsScoredLabel);
		
		JLabel scoringCyclesLabel = new JLabel("Scoring Cycles Participated");
		scoringCyclesLabel.setBounds(10, 449, 157, 14);
		dataEntryPanel.add(scoringCyclesLabel);
		
		JLabel lowGoalsAttemptedLabel = new JLabel("Low Goals Attempted");
		lowGoalsAttemptedLabel.setBounds(10, 424, 145, 14);
		dataEntryPanel.add(lowGoalsAttemptedLabel);
		
		cyclesSpinner = new JSpinner();
		cyclesSpinner.setBounds(177, 446, 47, 20);
		dataEntryPanel.add(cyclesSpinner);
		
		lowGoalsAttSpinner = new JSpinner();
		lowGoalsAttSpinner.setBounds(177, 421, 47, 20);
		dataEntryPanel.add(lowGoalsAttSpinner);
		
		lowGoalsSpinner = new JSpinner();
		lowGoalsSpinner.setBounds(177, 396, 47, 20);
		dataEntryPanel.add(lowGoalsSpinner);
		
		highGoalsAttSpinner = new JSpinner();
		highGoalsAttSpinner.setBounds(177, 371, 47, 20);
		dataEntryPanel.add(highGoalsAttSpinner);
		
		highGoalsSpinner = new JSpinner();
		highGoalsSpinner.setBounds(177, 346, 47, 20);
		dataEntryPanel.add(highGoalsSpinner);
		
		assistsSpinner = new JSpinner();
		assistsSpinner.setBounds(177, 321, 47, 20);
		dataEntryPanel.add(assistsSpinner);
		
		attCatchHPSpinner = new JSpinner();
		attCatchHPSpinner.setBounds(177, 296, 47, 20);
		dataEntryPanel.add(attCatchHPSpinner);
		
		catchHPSpinner = new JSpinner();
		catchHPSpinner.setBounds(177, 271, 47, 20);
		dataEntryPanel.add(catchHPSpinner);
		
		defenseComboBox = new JComboBox();
		defenseComboBox.setModel(new DefaultComboBoxModel(new String[] {"None", "1", "2", "3", "4", "5"}));
		defenseComboBox.setBounds(177, 246, 85, 20);
		dataEntryPanel.add(defenseComboBox);
		
		floorComboBox = new JComboBox();
		floorComboBox.setModel(new DefaultComboBoxModel(new String[] {"None", "1", "2", "3", "4", "5"}));
		floorComboBox.setBounds(177, 221, 85, 20);
		dataEntryPanel.add(floorComboBox);
		
		catchCheckBox = new JCheckBox("");
		catchCheckBox.setBounds(177, 195, 29, 23);
		dataEntryPanel.add(catchCheckBox);
		
		trussCatchCheckBox = new JCheckBox("");
		trussCatchCheckBox.setBounds(177, 170, 29, 23);
		dataEntryPanel.add(trussCatchCheckBox);
		
		trussTossCheckBox = new JCheckBox("");
		trussTossCheckBox.setBounds(177, 145, 29, 23);
		dataEntryPanel.add(trussTossCheckBox);
		
		unloadAutoCheckBox = new JCheckBox("");
		unloadAutoCheckBox.setBounds(177, 120, 29, 23);
		dataEntryPanel.add(unloadAutoCheckBox);
		
		autoBallScoreComboBox = new JComboBox();
		autoBallScoreComboBox.setModel(new DefaultComboBoxModel(new String[] {"None", "Low", "High"}));
		autoBallScoreComboBox.setBounds(177, 96, 85, 20);
		dataEntryPanel.add(autoBallScoreComboBox);
		
		zoneChangeCheckBox = new JCheckBox("");
		zoneChangeCheckBox.setBounds(177, 70, 29, 23);
		dataEntryPanel.add(zoneChangeCheckBox);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(269, 36, 9, 437);
		dataEntryPanel.add(separator_1);
		
		desc1Editor = new JEditorPane();
		desc1Editor.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		desc1Editor.setBounds(288, 68, 288, 95);
		dataEntryPanel.add(desc1Editor);
		
		JLabel lblNewLabel = new JLabel("Describe the robots speed and stability");
		lblNewLabel.setBounds(288, 49, 288, 14);
		dataEntryPanel.add(lblNewLabel);
		
		desc2Editor = new JEditorPane();
		desc2Editor.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		desc2Editor.setBounds(288, 193, 288, 95);
		dataEntryPanel.add(desc2Editor);
		
		JLabel lblAreTheyAble = new JLabel("Are they able to sheild themselves?");
		lblAreTheyAble.setBounds(288, 174, 288, 14);
		dataEntryPanel.add(lblAreTheyAble);
		
		desc3Editor = new JEditorPane();
		desc3Editor.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		desc3Editor.setBounds(288, 318, 288, 145);
		dataEntryPanel.add(desc3Editor);
		
		JLabel lblOtherComments = new JLabel("Other comments");
		lblOtherComments.setBounds(288, 299, 288, 14);
		dataEntryPanel.add(lblOtherComments);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 474, 589, 2);
		dataEntryPanel.add(separator_2);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(10, 503, 349, 20);
		dataEntryPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblConsoleOutput = new JLabel("Console Output");
		lblConsoleOutput.setBounds(10, 478, 349, 14);
		dataEntryPanel.add(lblConsoleOutput);
		
		JButton btnClearFields = new JButton("Clear All Fields");
		btnClearFields.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearAllFields(true);
			}
		});
		btnClearFields.setBackground(new Color(255, 0, 0));
		btnClearFields.setBounds(369, 508, 207, 23);
		dataEntryPanel.add(btnClearFields);
		
		JButton btnEnterData = new JButton("Submit Data");
		btnEnterData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int matchNumber = (int) matchNumberSpinner.getValue();
				if(matchNumber==0) {
					textField.setText("Match should be greater than zero!");
					return;
				}
				int teamNumber = Integer.parseInt((String)teamComboBox.getSelectedItem());
				if(teamNumber==0) {
					textField.setText("Please select a team!");
					return;
				}
				String scouterName = scouterNameTextField.getText();
				if(scouterName.length()<=1) {
					textField.setText("Please enter a scouter name!");
					return;
				}
				int autoBallCount = (int) autoBallsComboBox.getSelectedIndex();
				int zoneChange = zoneChangeCheckBox.isSelected() ? 1 : 0;
				int autoScore = autoBallScoreComboBox.getSelectedIndex();
				int unloadAuto = unloadAutoCheckBox.isSelected() ? 1 : 0;
				int trussToss = trussTossCheckBox.isSelected() ? 1 : 0;
				int trussCatch = trussCatchCheckBox.isSelected() ? 1 : 0;
				int catchBalls = catchCheckBox.isSelected() ? 1 : 0;
				int floorPickup = floorComboBox.getSelectedIndex();
				int defense = defenseComboBox.getSelectedIndex();
				int caughtBallFromHP = (int) catchHPSpinner.getValue();
				int caughtBallFromHPAtt = (int) attCatchHPSpinner.getValue();
				int assists = (int) assistsSpinner.getValue();
				int highGoals = (int) highGoalsSpinner.getValue();
				int highGoalsAtt = (int) highGoalsAttSpinner.getValue();
				int lowGoals = (int) lowGoalsSpinner.getValue();
				int lowGoalsAtt = (int) lowGoalsAttSpinner.getValue();
				int scoringCycles = (int) cyclesSpinner.getValue();
				String desc1 = desc1Editor.getText();
				String desc2 = desc2Editor.getText();
				String desc3 = desc3Editor.getText();
				
				try {
					System.out.println("INSERT INTO " + table + " MatchNumber="+matchNumber+",TeamNumber="+teamNumber+",ScouterName='"+scouterName+"',NumberOfAutoBalls="+autoBallCount+",ChangeZoneBonus="+
							zoneChange+",AutoBallScore="+autoScore+",AbleToUnloadAutoBall="+unloadAuto+",TrussToss="+trussToss+",TrussCatch="+trussCatch+",CatchBallsInTheAir="+catchBalls+",FloorPickup="+floorPickup+
							",DefensiveCapabilities="+defense+",CaughtBallFromHuman="+caughtBallFromHP+",AttemptsToCatchFromHuman="+caughtBallFromHPAtt+",NumberOfAssists="+assists+",HighGoalsScored="+highGoals+",HighGoalsAttempted="
							+highGoalsAtt+",LowGoalsScored="+lowGoals+",LowGoalsAttempted="+lowGoalsAtt+",ScoringCycles="+scoringCycles+",RobotDescription='"+desc1+"',ProtectFromOpposingAlliancedBalls='"+desc2+"',Comments='"+desc3+"',"
									+ "Event='"+eventName+"'");
					server.execute("INSERT INTO " + table + " SET MatchNumber="+matchNumber+",TeamNumber="+teamNumber+",ScouterName='"+scouterName+"',NumberOfAutoBalls="+autoBallCount+",ChangeZoneBonus="+
				zoneChange+",AutoBallScore="+autoScore+",AbleToUnloadAutoBall="+unloadAuto+",TrussToss="+trussToss+",TrussCatch="+trussCatch+",CatchBallsInTheAir="+catchBalls+",FloorPickup="+floorPickup+
				",DefensiveCapabilities="+defense+",CaughtBallFromHuman="+caughtBallFromHP+",AttemptsToCatchFromHuman="+caughtBallFromHPAtt+",NumberOfAssists="+assists+",HighGoalsScored="+highGoals+",HighGoalsAttempted="
				+highGoalsAtt+",LowGoalsScored="+lowGoals+",LowGoalsAttempted="+lowGoalsAtt+",ScoringCycles="+scoringCycles+",RobotDescription='"+desc1+"',ProtectFromOpposingAlliancedBalls='"+desc2+"',Comments='"+desc3+"',"
						+ "Event='"+eventName+"'");
					textField.setText("Match number "+matchNumber+", with team "+teamComboBox.getSelectedItem()+" was sucessfully submitted!");
					clearAllFields(false);
				} catch (SQLException e1) {
					textField.setText("There was an error sumbitting match "+matchNumber+"!");
					e1.printStackTrace();
				}
			}
		});
		btnEnterData.setBackground(new Color(0, 128, 0));
		btnEnterData.setBounds(369, 480, 207, 23);
		dataEntryPanel.add(btnEnterData);
		
		JPanel dataRetrievalPanel = new JPanel();
		tabbedPane.addTab("Basic Data Retrieval", null, dataRetrievalPanel, null);
		dataRetrievalPanel.setLayout(null);
		
		JLabel label = new JLabel("Match Number");
		label.setBounds(10, 79, 97, 14);
		dataRetrievalPanel.add(label);
		
		JLabel label_1 = new JLabel("Team Number");
		label_1.setBounds(153, 79, 97, 14);
		dataRetrievalPanel.add(label_1);
		
		JLabel label_2 = new JLabel("Scouter Name");
		label_2.setBounds(369, 79, 89, 14);
		dataRetrievalPanel.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(455, 76, 121, 20);
		dataRetrievalPanel.add(textField_1);
		
		JLabel label_3 = new JLabel("Describe the robots speed and stability");
		label_3.setBounds(288, 117, 288, 14);
		dataRetrievalPanel.add(label_3);
		
		editorPane_3 = new JEditorPane();
		editorPane_3.setEditable(false);
		editorPane_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		editorPane_3.setBounds(288, 136, 288, 95);
		dataRetrievalPanel.add(editorPane_3);
		
		JLabel label_4 = new JLabel("Are they able to sheild themselves?");
		label_4.setBounds(288, 242, 288, 14);
		dataRetrievalPanel.add(label_4);
		
		editorPane_4 = new JEditorPane();
		editorPane_4.setEditable(false);
		editorPane_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		editorPane_4.setBounds(288, 261, 288, 95);
		dataRetrievalPanel.add(editorPane_4);
		
		JLabel label_5 = new JLabel("Other comments");
		label_5.setBounds(288, 367, 288, 14);
		dataRetrievalPanel.add(label_5);
		
		editorPane_5 = new JEditorPane();
		editorPane_5.setEditable(false);
		editorPane_5.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		editorPane_5.setBounds(288, 386, 288, 145);
		dataRetrievalPanel.add(editorPane_5);
		
		JLabel label_6 = new JLabel("Number Of Auto Balls");
		label_6.setBounds(10, 117, 145, 14);
		dataRetrievalPanel.add(label_6);
		
		JLabel label_7 = new JLabel("Change Zone Bonus");
		label_7.setBounds(10, 142, 145, 14);
		dataRetrievalPanel.add(label_7);
		
		JLabel label_8 = new JLabel("Auto Ball Score");
		label_8.setBounds(10, 167, 145, 14);
		dataRetrievalPanel.add(label_8);
		
		JLabel label_9 = new JLabel("Able To Unload Auto Ball");
		label_9.setBounds(10, 192, 145, 14);
		dataRetrievalPanel.add(label_9);
		
		JLabel label_10 = new JLabel("Truss Toss?");
		label_10.setBounds(10, 217, 145, 14);
		dataRetrievalPanel.add(label_10);
		
		JLabel label_11 = new JLabel("Truss Catch?");
		label_11.setBounds(10, 242, 145, 14);
		dataRetrievalPanel.add(label_11);
		
		JLabel label_12 = new JLabel("Catch Balls In Air?");
		label_12.setBounds(10, 267, 145, 14);
		dataRetrievalPanel.add(label_12);
		
		JLabel label_13 = new JLabel("Floor Pickup?");
		label_13.setBounds(10, 292, 145, 14);
		dataRetrievalPanel.add(label_13);
		
		JLabel label_14 = new JLabel("Defensive Capabilities");
		label_14.setBounds(10, 317, 145, 14);
		dataRetrievalPanel.add(label_14);
		
		JLabel label_15 = new JLabel("Caught Ball From HP");
		label_15.setBounds(10, 342, 145, 14);
		dataRetrievalPanel.add(label_15);
		
		JLabel label_16 = new JLabel("Attemped Catch From HP");
		label_16.setBounds(10, 367, 145, 14);
		dataRetrievalPanel.add(label_16);
		
		JLabel label_17 = new JLabel("Number Of Assists");
		label_17.setBounds(10, 392, 145, 14);
		dataRetrievalPanel.add(label_17);
		
		JLabel label_18 = new JLabel("High Goals Scored");
		label_18.setBounds(10, 417, 145, 14);
		dataRetrievalPanel.add(label_18);
		
		JLabel label_19 = new JLabel("High Goals Attempted");
		label_19.setBounds(10, 442, 145, 14);
		dataRetrievalPanel.add(label_19);
		
		JLabel label_20 = new JLabel("Low Goals Scored");
		label_20.setBounds(10, 467, 145, 14);
		dataRetrievalPanel.add(label_20);
		
		JLabel label_21 = new JLabel("Low Goals Attempted");
		label_21.setBounds(10, 492, 145, 14);
		dataRetrievalPanel.add(label_21);
		
		JLabel label_22 = new JLabel("Scoring Cycles Participated");
		label_22.setBounds(10, 517, 157, 14);
		dataRetrievalPanel.add(label_22);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(177, 489, 86, 20);
		dataRetrievalPanel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(177, 464, 86, 20);
		dataRetrievalPanel.add(textField_4);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(177, 514, 86, 20);
		dataRetrievalPanel.add(textField_2);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(177, 439, 86, 20);
		dataRetrievalPanel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(177, 414, 86, 20);
		dataRetrievalPanel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(177, 389, 86, 20);
		dataRetrievalPanel.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(177, 364, 86, 20);
		dataRetrievalPanel.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		textField_9.setBounds(177, 339, 86, 20);
		dataRetrievalPanel.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setEditable(false);
		textField_10.setColumns(10);
		textField_10.setBounds(177, 314, 86, 20);
		dataRetrievalPanel.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setEditable(false);
		textField_11.setColumns(10);
		textField_11.setBounds(177, 289, 86, 20);
		dataRetrievalPanel.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setEditable(false);
		textField_12.setColumns(10);
		textField_12.setBounds(177, 264, 86, 20);
		dataRetrievalPanel.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setEditable(false);
		textField_13.setColumns(10);
		textField_13.setBounds(177, 239, 86, 20);
		dataRetrievalPanel.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setEditable(false);
		textField_14.setColumns(10);
		textField_14.setBounds(177, 214, 86, 20);
		dataRetrievalPanel.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setEditable(false);
		textField_15.setColumns(10);
		textField_15.setBounds(177, 189, 86, 20);
		dataRetrievalPanel.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setEditable(false);
		textField_16.setColumns(10);
		textField_16.setBounds(177, 164, 86, 20);
		dataRetrievalPanel.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setEditable(false);
		textField_17.setColumns(10);
		textField_17.setBounds(177, 139, 86, 20);
		dataRetrievalPanel.add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setEditable(false);
		textField_18.setColumns(10);
		textField_18.setBounds(177, 114, 86, 20);
		dataRetrievalPanel.add(textField_18);
		
		textField_19 = new JTextField();
		textField_19.setEditable(false);
		textField_19.setColumns(10);
		textField_19.setBounds(96, 76, 53, 20);
		dataRetrievalPanel.add(textField_19);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(0, 66, 589, 2);
		dataRetrievalPanel.add(separator_3);
		
		textField_20 = new JTextField();
		textField_20.setEditable(false);
		textField_20.setColumns(10);
		textField_20.setBounds(242, 76, 126, 20);
		dataRetrievalPanel.add(textField_20);
		
		idSpinner = new JSpinner();
		idSpinner.setModel(new SpinnerNumberModel(0, 0, 9999, 1));
		idSpinner.setBounds(0, 19, 107, 14);
		dataRetrievalPanel.add(idSpinner);
		
		JButton btnFind = new JButton("Find");
		btnFind.setBackground(new Color(0, 128, 0));
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				find();
			}
		});
		btnFind.setBounds(279, 0, 150, 68);
		dataRetrievalPanel.add(btnFind);
		
		JButton btnDeleteData = new JButton("Delete Data");
		btnDeleteData.setBackground(new Color(255, 0, 0));
		btnDeleteData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you would like to delete this data?")==0) {
					try {
						server.execute("DELETE FROM " + table + " WHERE id="+idSpinner.getValue()+" AND Event='"+event+"'");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnDeleteData.setBounds(439, 0, 150, 33);
		dataRetrievalPanel.add(btnDeleteData);
		
		JButton btnEditData = new JButton("Edit Data");
		btnEditData.setBackground(new Color(255, 69, 0));
		btnEditData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO: Edit the data
				if(btnEditData.getText().equals("Edit Data")) {
					btnEditData.setText("Save Data");
					
				}
			}
		});
		btnEditData.setBounds(439, 35, 150, 33);
		dataRetrievalPanel.add(btnEditData);
		
		editorPane = new JTextField();
		editorPane.setEditable(false);
		editorPane.setBounds(0, 49, 107, 16);
		dataRetrievalPanel.add(editorPane);
		editorPane.setColumns(10);
		
		JLabel lblConsoleOutput_1 = new JLabel("Console Output");
		lblConsoleOutput_1.setBounds(0, 35, 107, 14);
		dataRetrievalPanel.add(lblConsoleOutput_1);
		
		JLabel lblEntryId = new JLabel("Entry ID");
		lblEntryId.setBounds(0, 0, 107, 14);
		dataRetrievalPanel.add(lblEntryId);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				idSpinner.setValue((int)idSpinner.getValue()+1);
				find();
			}
		});
		btnNext.setBackground(new Color(255, 99, 71));
		btnNext.setBounds(119, 0, 150, 33);
		dataRetrievalPanel.add(btnNext);
		
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if((int)idSpinner.getValue()-1>=0) {
					idSpinner.setValue((int)idSpinner.getValue()-1);
					find();
				}
			}
		});
		btnPrevious.setBackground(new Color(244, 164, 96));
		btnPrevious.setBounds(119, 35, 150, 33);
		dataRetrievalPanel.add(btnPrevious);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Advanced Data Retrieval", null, panel_1, null);
		panel_1.setLayout(null);
		
		JSlider slider = new JSlider();
		slider.setValue(0);
		slider.setSnapToTicks(true);
		slider.setMinorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setMaximum(3);
		slider.setBounds(179, 11, 159, 23);
		panel_1.add(slider);
		
		JLabel lblNumberOfAuto_1 = new JLabel("Number of Auto Balls");
		lblNumberOfAuto_1.setBounds(10, 11, 159, 14);
		panel_1.add(lblNumberOfAuto_1);
		
		JLabel lblChangeZoneBonus_1 = new JLabel("Change Zone Bonus");
		lblChangeZoneBonus_1.setBounds(10, 45, 159, 14);
		panel_1.add(lblChangeZoneBonus_1);
		
		JCheckBox checkBox = new JCheckBox("");
		checkBox.setBounds(179, 41, 27, 23);
		panel_1.add(checkBox);
		
		JSlider slider_1 = new JSlider();
		slider_1.setValue(0);
		slider_1.setSnapToTicks(true);
		slider_1.setPaintTicks(true);
		slider_1.setMinorTickSpacing(1);
		slider_1.setMaximum(2);
		slider_1.setBounds(179, 70, 159, 23);
		panel_1.add(slider_1);
		
		JLabel lblAutoBallScore_1 = new JLabel("Auto Ball Score");
		lblAutoBallScore_1.setBounds(10, 70, 159, 14);
		panel_1.add(lblAutoBallScore_1);
		
		JCheckBox checkBox_1 = new JCheckBox("");
		checkBox_1.setBounds(179, 100, 27, 23);
		panel_1.add(checkBox_1);
		
		JLabel lblAbleToUnload_1 = new JLabel("Able to Unload Autoball");
		lblAbleToUnload_1.setBounds(10, 104, 159, 14);
		panel_1.add(lblAbleToUnload_1);
		
		JCheckBox checkBox_2 = new JCheckBox("");
		checkBox_2.setBounds(179, 126, 27, 23);
		panel_1.add(checkBox_2);
		
		JLabel lblTrussToss = new JLabel("Truss Toss");
		lblTrussToss.setBounds(10, 130, 159, 14);
		panel_1.add(lblTrussToss);
		
		JCheckBox checkBox_3 = new JCheckBox("");
		checkBox_3.setBounds(179, 152, 27, 23);
		panel_1.add(checkBox_3);
		
		JLabel lblTrussCatch_1 = new JLabel("Truss Catch");
		lblTrussCatch_1.setBounds(10, 156, 159, 14);
		panel_1.add(lblTrussCatch_1);
		
		JSlider slider_2 = new JSlider();
		slider_2.setValue(0);
		slider_2.setSnapToTicks(true);
		slider_2.setPaintTicks(true);
		slider_2.setMinorTickSpacing(1);
		slider_2.setMaximum(5);
		slider_2.setBounds(179, 208, 159, 23);
		panel_1.add(slider_2);
		
		JLabel lblFloorPickup_1 = new JLabel("Floor Pickup");
		lblFloorPickup_1.setBounds(10, 208, 159, 14);
		panel_1.add(lblFloorPickup_1);
		
		JSlider slider_3 = new JSlider();
		slider_3.setMinorTickSpacing(1);
		slider_3.setValue(0);
		slider_3.setSnapToTicks(true);
		slider_3.setPaintTicks(true);
		slider_3.setMaximum(5);
		slider_3.setBounds(179, 242, 159, 23);
		panel_1.add(slider_3);
		
		JLabel lblDefensiveCapabilities_1 = new JLabel("Defensive Capabilities");
		lblDefensiveCapabilities_1.setBounds(10, 242, 159, 14);
		panel_1.add(lblDefensiveCapabilities_1);
		
		JCheckBox checkBox_4 = new JCheckBox("");
		checkBox_4.setBounds(179, 178, 27, 23);
		panel_1.add(checkBox_4);
		
		JLabel lblCatchBallsIn_1 = new JLabel("Catch Balls in Air");
		lblCatchBallsIn_1.setBounds(10, 182, 159, 14);
		panel_1.add(lblCatchBallsIn_1);
		
		JLabel lblCaughtBallFrom_1 = new JLabel("Caught Ball From HP");
		lblCaughtBallFrom_1.setBounds(10, 279, 159, 14);
		panel_1.add(lblCaughtBallFrom_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(179, 276, 29, 20);
		panel_1.add(spinner);
		
		JLabel label_26 = new JLabel("Caught Ball From HP");
		label_26.setBounds(10, 307, 159, 14);
		panel_1.add(label_26);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(179, 304, 29, 20);
		panel_1.add(spinner_1);
		
		JLabel label_27 = new JLabel("Caught Ball From HP");
		label_27.setBounds(10, 335, 159, 14);
		panel_1.add(label_27);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(179, 332, 29, 20);
		panel_1.add(spinner_2);
		
		JLabel label_28 = new JLabel("Caught Ball From HP");
		label_28.setBounds(10, 363, 159, 14);
		panel_1.add(label_28);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setBounds(179, 360, 29, 20);
		panel_1.add(spinner_3);
		
		JLabel label_29 = new JLabel("Caught Ball From HP");
		label_29.setBounds(10, 391, 159, 14);
		panel_1.add(label_29);
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.setBounds(179, 388, 29, 20);
		panel_1.add(spinner_4);
		
		JLabel label_30 = new JLabel("Caught Ball From HP");
		label_30.setBounds(10, 419, 159, 14);
		panel_1.add(label_30);
		
		JSpinner spinner_5 = new JSpinner();
		spinner_5.setBounds(179, 416, 29, 20);
		panel_1.add(spinner_5);
		
		JLabel label_31 = new JLabel("Caught Ball From HP");
		label_31.setBounds(10, 447, 159, 14);
		panel_1.add(label_31);
		
		JSpinner spinner_6 = new JSpinner();
		spinner_6.setBounds(179, 444, 29, 20);
		panel_1.add(spinner_6);
		
		JLabel label_32 = new JLabel("Caught Ball From HP");
		label_32.setBounds(10, 475, 159, 14);
		panel_1.add(label_32);
		
		JSpinner spinner_7 = new JSpinner();
		spinner_7.setBounds(179, 472, 29, 20);
		panel_1.add(spinner_7);
		
		JTextPane txtpnInTheFinal = new JTextPane();
		txtpnInTheFinal.setText("In the final version, this will have functionality, however because this version will never actually do anything, I found it hard to justify the need to make a functioning system for this if it would just have to be done again next year. This is what it would look like, and will for the final version.");
		txtpnInTheFinal.setEditable(false);
		txtpnInTheFinal.setBounds(218, 419, 361, 104);
		panel_1.add(txtpnInTheFinal);
		
		JButton btnSearch_2 = new JButton("Search");
		btnSearch_2.setBackground(new Color(0, 128, 0));
		btnSearch_2.setBounds(348, 11, 231, 23);
		panel_1.add(btnSearch_2);
		
		JButton btnResetSearchParameters = new JButton("Reset Search Parameters");
		btnResetSearchParameters.setBackground(new Color(255, 0, 0));
		btnResetSearchParameters.setBounds(348, 41, 231, 23);
		panel_1.add(btnResetSearchParameters);
		
		JLabel lblFoundTeams = new JLabel("Found Teams");
		lblFoundTeams.setBounds(348, 70, 231, 14);
		panel_1.add(lblFoundTeams);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Example Team 1", "Example Team 2", "Example Team 3", "Example Team 4"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(348, 100, 231, 261);
		panel_1.add(list);
		
		JButton btnSeeDetailedOverview = new JButton("See Detailed Overview");
		btnSeeDetailedOverview.setBackground(new Color(0, 255, 255));
		btnSeeDetailedOverview.setBounds(348, 372, 231, 23);
		panel_1.add(btnSeeDetailedOverview);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Team Information And Averages", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblEntryIds = new JLabel("Entry IDs");
		lblEntryIds.setBounds(279, 11, 173, 14);
		panel.add(lblEntryIds);
		
		JLabel lblMatchNumbers = new JLabel("Match Numbers");
		lblMatchNumbers.setBounds(279, 36, 173, 14);
		panel.add(lblMatchNumbers);
		
		JLabel lblNumberOfAuto = new JLabel("Number of Auto Balls");
		lblNumberOfAuto.setBounds(279, 61, 173, 14);
		panel.add(lblNumberOfAuto);
		
		textField_21 = new JTextField();
		textField_21.setEditable(false);
		textField_21.setBounds(462, 11, 117, 20);
		panel.add(textField_21);
		textField_21.setColumns(10);
		
		textField_22 = new JTextField();
		textField_22.setEditable(false);
		textField_22.setColumns(10);
		textField_22.setBounds(462, 39, 117, 20);
		panel.add(textField_22);
		
		textField_23 = new JTextField();
		textField_23.setEditable(false);
		textField_23.setColumns(10);
		textField_23.setBounds(462, 64, 117, 20);
		panel.add(textField_23);
		
		textField_24 = new JTextField();
		textField_24.setEditable(false);
		textField_24.setColumns(10);
		textField_24.setBounds(462, 142, 117, 20);
		panel.add(textField_24);
		
		JLabel lblAbleToUnload = new JLabel("Able To Unload Auto Ball");
		lblAbleToUnload.setBounds(279, 139, 173, 14);
		panel.add(lblAbleToUnload);
		
		JLabel lblAutoBallScore = new JLabel("Auto Ball Score");
		lblAutoBallScore.setBounds(279, 114, 173, 14);
		panel.add(lblAutoBallScore);
		
		textField_25 = new JTextField();
		textField_25.setEditable(false);
		textField_25.setColumns(10);
		textField_25.setBounds(462, 117, 117, 20);
		panel.add(textField_25);
		
		textField_26 = new JTextField();
		textField_26.setEditable(false);
		textField_26.setColumns(10);
		textField_26.setBounds(462, 89, 117, 20);
		panel.add(textField_26);
		
		JLabel lblChangeZoneBonus = new JLabel("Change Zone Bonus");
		lblChangeZoneBonus.setBounds(279, 89, 173, 14);
		panel.add(lblChangeZoneBonus);
		
		textField_27 = new JTextField();
		textField_27.setEditable(false);
		textField_27.setColumns(10);
		textField_27.setBounds(462, 220, 117, 20);
		panel.add(textField_27);
		
		JLabel lblCatchBallsIn = new JLabel("Catch Balls In The Air");
		lblCatchBallsIn.setBounds(279, 217, 173, 14);
		panel.add(lblCatchBallsIn);
		
		JLabel lblTrussCatch = new JLabel("Truss Catch");
		lblTrussCatch.setBounds(279, 192, 173, 14);
		panel.add(lblTrussCatch);
		
		textField_28 = new JTextField();
		textField_28.setEditable(false);
		textField_28.setColumns(10);
		textField_28.setBounds(462, 195, 117, 20);
		panel.add(textField_28);
		
		textField_29 = new JTextField();
		textField_29.setEditable(false);
		textField_29.setColumns(10);
		textField_29.setBounds(462, 167, 117, 20);
		panel.add(textField_29);
		
		JLabel lblTussToss = new JLabel("Truss Toss");
		lblTussToss.setBounds(279, 167, 173, 14);
		panel.add(lblTussToss);
		
		textField_30 = new JTextField();
		textField_30.setEditable(false);
		textField_30.setColumns(10);
		textField_30.setBounds(462, 298, 117, 20);
		panel.add(textField_30);
		
		JLabel lblCaughtBallFrom = new JLabel("Caught Ball From Human");
		lblCaughtBallFrom.setBounds(279, 295, 173, 14);
		panel.add(lblCaughtBallFrom);
		
		JLabel lblDefensiveCapabilities = new JLabel("Defensive Capabilities");
		lblDefensiveCapabilities.setBounds(279, 270, 173, 14);
		panel.add(lblDefensiveCapabilities);
		
		textField_31 = new JTextField();
		textField_31.setEditable(false);
		textField_31.setColumns(10);
		textField_31.setBounds(462, 273, 117, 20);
		panel.add(textField_31);
		
		textField_32 = new JTextField();
		textField_32.setEditable(false);
		textField_32.setColumns(10);
		textField_32.setBounds(462, 245, 117, 20);
		panel.add(textField_32);
		
		JLabel lblFloorPickup = new JLabel("Floor Pickup");
		lblFloorPickup.setBounds(279, 245, 173, 14);
		panel.add(lblFloorPickup);
		
		textField_33 = new JTextField();
		textField_33.setEditable(false);
		textField_33.setColumns(10);
		textField_33.setBounds(462, 376, 117, 20);
		panel.add(textField_33);
		
		JLabel lblHighGoalsScored = new JLabel("High Goals Scored");
		lblHighGoalsScored.setBounds(279, 373, 173, 14);
		panel.add(lblHighGoalsScored);
		
		JLabel lblNumberOfAssists = new JLabel("Number of Assists");
		lblNumberOfAssists.setBounds(279, 348, 173, 14);
		panel.add(lblNumberOfAssists);
		
		textField_34 = new JTextField();
		textField_34.setEditable(false);
		textField_34.setColumns(10);
		textField_34.setBounds(462, 351, 117, 20);
		panel.add(textField_34);
		
		textField_35 = new JTextField();
		textField_35.setEditable(false);
		textField_35.setColumns(10);
		textField_35.setBounds(462, 323, 117, 20);
		panel.add(textField_35);
		
		JLabel lblAttemptsToCatch = new JLabel("Attempts To Catch From Human");
		lblAttemptsToCatch.setBounds(279, 323, 188, 14);
		panel.add(lblAttemptsToCatch);
		
		textField_36 = new JTextField();
		textField_36.setEditable(false);
		textField_36.setColumns(10);
		textField_36.setBounds(462, 479, 117, 20);
		panel.add(textField_36);
		
		textField_37 = new JTextField();
		textField_37.setEditable(false);
		textField_37.setColumns(10);
		textField_37.setBounds(462, 454, 117, 20);
		panel.add(textField_37);
		
		textField_38 = new JTextField();
		textField_38.setEditable(false);
		textField_38.setColumns(10);
		textField_38.setBounds(462, 426, 117, 20);
		panel.add(textField_38);
		
		textField_39 = new JTextField();
		textField_39.setEditable(false);
		textField_39.setColumns(10);
		textField_39.setBounds(462, 401, 117, 20);
		panel.add(textField_39);
		
		JLabel lblHighGoalsAttempted = new JLabel("High Goals Attempted");
		lblHighGoalsAttempted.setBounds(279, 398, 173, 14);
		panel.add(lblHighGoalsAttempted);
		
		JLabel lblLowGoalsScored = new JLabel("Low Goals Scored");
		lblLowGoalsScored.setBounds(279, 426, 173, 14);
		panel.add(lblLowGoalsScored);
		
		JLabel lblLowGoalsAttempted = new JLabel("Low Goals Attempted");
		lblLowGoalsAttempted.setBounds(279, 451, 173, 14);
		panel.add(lblLowGoalsAttempted);
		
		JLabel lblScoringCycles = new JLabel("Scoring Cycles");
		lblScoringCycles.setBounds(279, 476, 173, 14);
		panel.add(lblScoringCycles);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setBounds(260, 0, 9, 534);
		panel.add(separator_4);
		
		btnSearch_1 = new JButton("Search");
		btnSearch_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO: Add in team information averages
				int teamNumber = Integer.parseInt((String) comboBox.getSelectedItem());
				ResultSet set;
				try {
					set = server.executeQuery("SELECT * FROM " + table + " WHERE TeamNumber="+teamNumber+" AND Event='"+eventName+"'");
				} catch (SQLException e1) {
					textField_40.setText("Error finding entries for team "+teamNumber+"!");
					return;
				}
				
				System.out.println("Howdy!");
				try {
					int count = 0;
					String entryIDS ="";
					String matchNumber = "";
					double numberOfAutoBalls = 0;
					int zoneYes = 0;
					int zoneNo = 0;
					int autoScoreHigh = 0;
					int autoScoreLow = 0;
					int autoScoreNo = 0;
					int unloadAutoYes = 0;
					int unloadAutoNo = 0;
					int trussTossYes = 0;
					int trussTossNo = 0;
					int trussCatchYes = 0;
					int trussCatchNo = 0;
					int catchAirYes = 0;
					int catchAirNo = 0;
					double floorPickup = 0;
					double defensiveCapabilities = 0;
					double catchHP = 0;
					double catchHPA = 0;
					double assists = 0;
					double highGoals = 0;
					double highGoalsA = 0;
					double lowGoals = 0;
					double lowGoalsA = 0;
					double scoringCycles = 0;
					String desc1 = "";
					String desc2 = "";
					String desc3 = "";
					
					
					while(set.next()) {
						count++;
						entryIDS += set.getInt("id")+",";
						matchNumber += set.getInt("MatchNumber")+",";
						numberOfAutoBalls += set.getInt("NumberOfAutoBalls");
						if(set.getInt("ChangeZoneBonus") == 0) {
							zoneNo++;
						} else {
							zoneYes++;
						}
						if(set.getInt("AutoBallScore")==0) {
							autoScoreNo++;
						} else if(set.getInt("AutoBallScore")==1) {
							autoScoreLow++;
						} else {
							autoScoreHigh++;
						}
						if(set.getInt("AbleToUnloadAutoBall")==0) {
							unloadAutoNo++;
						} else {
							unloadAutoYes++;
						}
						if(set.getInt("TrussToss")==0) {
							trussTossNo++;
						} else {
							trussTossYes++;
						}
						if(set.getInt("TrussCatch")==0) {
							trussCatchNo++;
						} else {
							trussCatchYes++;
						}
						if(set.getInt("CatchBallsInTheAir")==0) {
							catchAirNo++;
						} else {
							catchAirYes++;
						}
						floorPickup+=set.getInt("FloorPickup");
						defensiveCapabilities+=set.getInt("DefensiveCapabilities");
						catchHP+=set.getInt("CaughtBallFromHuman");
						catchHPA+=set.getInt("AttemptsToCatchFromHuman");
						assists+=set.getInt("NumberOfAssists");
						highGoals+=set.getInt("HighGoalsScored");
						highGoalsA+=set.getInt("HighGoalsAttempted");
						lowGoals+=set.getInt("LowGoalsScored");
						lowGoalsA+=set.getInt("LowGoalsAttempted");
						scoringCycles+=set.getInt("ScoringCycles");
						desc1+=set.getString("RobotDescription")+"\n\n\n";
						desc2+=set.getString("ProtectFromOpposingAlliancedBalls")+"\n\n\n";
						desc3+=set.getString("Comments")+"\n\n\n";
					}
					
					textField_21.setText(entryIDS);
					textField_22.setText(matchNumber);
					textField_23.setText(""+numberOfAutoBalls/count);
					textField_26.setText(zoneYes+" yes/"+zoneNo+" no");
					textField_25.setText(autoScoreHigh+" high/"+autoScoreLow+" low/"+autoScoreNo+" no");
					textField_24.setText(unloadAutoYes+" yes/"+unloadAutoNo+" no");
					textField_29.setText(trussTossYes+" yes/"+trussTossNo+" no");
					textField_28.setText(trussCatchYes+" yes/"+trussCatchNo+" no");
					textField_27.setText(catchAirYes+" yes/"+catchAirNo+" no");
					textField_32.setText(""+floorPickup/count);
					textField_31.setText(""+defensiveCapabilities/count);
					textField_30.setText(""+catchHP/count);
					textField_35.setText(""+catchHPA/count);
					textField_34.setText(""+assists/count);
					textField_33.setText(""+highGoals/count);
					textField_39.setText(""+highGoalsA/count);
					textField_38.setText(""+lowGoals/count);
					textField_37.setText(""+lowGoalsA/count);
					textField_36.setText(""+scoringCycles/count);
					editorPane_1.setText(desc1);
					editorPane_2.setText(desc2);
					editorPane_6.setText(desc3);
					
					editorPane.setText("Successful");
				} catch (SQLException e1) {
					editorPane.setText("Error Code 2");
					e1.printStackTrace();
				}
			}
		});
		btnSearch_1.setBackground(new Color(0, 128, 0));
		btnSearch_1.setForeground(new Color(0, 0, 0));
		btnSearch_1.setBounds(10, 57, 240, 23);
		panel.add(btnSearch_1);
		
		JLabel lblTeamNumber = new JLabel("Team Number");
		lblTeamNumber.setBounds(10, 11, 86, 14);
		panel.add(lblTeamNumber);
		
		textField_40 = new JTextField();
		textField_40.setEditable(false);
		textField_40.setBounds(116, 33, 134, 20);
		panel.add(textField_40);
		textField_40.setColumns(10);
		
		JLabel lblConsoleOutput_2 = new JLabel("Console Output");
		lblConsoleOutput_2.setBounds(116, 11, 134, 14);
		panel.add(lblConsoleOutput_2);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(0, 89, 260, 20);
		panel.add(separator_5);
		
		JLabel label_23 = new JLabel("Describe the robots speed and stability");
		label_23.setBounds(10, 91, 240, 14);
		panel.add(label_23);
		
		editorPane_1 = new JEditorPane();
		editorPane_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		editorPane_1.setEditable(false);
		editorPane_1.setBounds(10, 110, 240, 95);
		panel.add(editorPane_1);
		
		JLabel label_24 = new JLabel("Are they able to sheild themselves?");
		label_24.setBounds(10, 216, 240, 14);
		panel.add(label_24);
		
		editorPane_2 = new JEditorPane();
		editorPane_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		editorPane_2.setEditable(false);
		editorPane_2.setBounds(10, 235, 240, 95);
		panel.add(editorPane_2);
		
		JLabel label_25 = new JLabel("Other comments");
		label_25.setBounds(10, 341, 240, 14);
		panel.add(label_25);
		
		editorPane_6 = new JEditorPane();
		editorPane_6.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		editorPane_6.setEditable(false);
		editorPane_6.setBounds(10, 360, 240, 163);
		panel.add(editorPane_6);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(teamsList));
		comboBox.setBounds(10, 33, 96, 20);
		panel.add(comboBox);
	}
	
	private void clearAllFields(boolean confirm) {
		if(!confirm) {
			matchNumberSpinner.setValue(0);
			teamComboBox.setSelectedIndex(0);
			scouterNameTextField.setText("");
			autoBallsComboBox.setSelectedIndex(0);
			zoneChangeCheckBox.setSelected(false);
			autoBallScoreComboBox.setSelectedIndex(0);
			unloadAutoCheckBox.setSelected(false);
			trussTossCheckBox.setSelected(false);
			trussCatchCheckBox.setSelected(false);
			catchCheckBox.setSelected(false);
			floorComboBox.setSelectedIndex(0);
			defenseComboBox.setSelectedIndex(0);
			catchHPSpinner.setValue(0);
			attCatchHPSpinner.setValue(0);
			assistsSpinner.setValue(0);
			highGoalsSpinner.setValue(0);
			highGoalsAttSpinner.setValue(0);
			lowGoalsSpinner.setValue(0);
			lowGoalsAttSpinner.setValue(0);
			cyclesSpinner.setValue(0);
			desc1Editor.setText("");
			desc2Editor.setText("");
			desc3Editor.setText("");
		} else if(JOptionPane.showConfirmDialog(null, "Are you sure you would like to clear all the data entered so far?")==0) {
			matchNumberSpinner.setValue(0);
			teamComboBox.setSelectedIndex(0);
			scouterNameTextField.setText("");
			autoBallsComboBox.setSelectedIndex(0);
			zoneChangeCheckBox.setSelected(false);
			autoBallScoreComboBox.setSelectedIndex(0);
			unloadAutoCheckBox.setSelected(false);
			trussTossCheckBox.setSelected(false);
			trussCatchCheckBox.setSelected(false);
			catchCheckBox.setSelected(false);
			floorComboBox.setSelectedIndex(0);
			defenseComboBox.setSelectedIndex(0);
			catchHPSpinner.setValue(0);
			attCatchHPSpinner.setValue(0);
			assistsSpinner.setValue(0);
			highGoalsSpinner.setValue(0);
			highGoalsAttSpinner.setValue(0);
			lowGoalsSpinner.setValue(0);
			lowGoalsAttSpinner.setValue(0);
			cyclesSpinner.setValue(0);
			desc1Editor.setText("");
			desc2Editor.setText("");
			desc3Editor.setText("");
		}
	}
	
	private void find() {
		int id = (int) idSpinner.getValue();
		ResultSet set;
		try {
			set = server.executeQuery("SELECT * FROM " + table + " WHERE id="+id+" AND Event='"+eventName+"'");
		} catch (SQLException e1) {
			textField.setText("Error finding entry or event!");
			e1.printStackTrace();
			return;
		}
		
		System.out.println("Howdy!");
		try {
			set.next();
			textField_19.setText(""+set.getInt("MatchNumber"));
			textField_20.setText(""+set.getInt("TeamNumber"));
			textField_1.setText(set.getString("ScouterName"));
			textField_18.setText(""+set.getInt("NumberOfAutoBalls"));
			textField_17.setText(""+set.getInt("ChangeZoneBonus"));
			textField_16.setText(""+set.getInt("AutoBallScore"));
			textField_15.setText(""+set.getInt("AbleToUnloadAutoBall"));
			textField_14.setText(""+set.getInt("TrussToss"));
			textField_13.setText(""+set.getInt("TrussCatch"));
			textField_12.setText(""+set.getInt("CatchBallsInTheAir"));
			textField_11.setText(""+set.getInt("FloorPickup"));
			textField_10.setText(""+set.getInt("DefensiveCapabilities"));
			textField_9.setText(""+set.getInt("CaughtBallFromHuman"));
			textField_8.setText(""+set.getInt("AttemptsToCatchFromHuman"));
			textField_7.setText(""+set.getInt("NumberOfAssists"));
			textField_6.setText(""+set.getInt("HighGoalsScored"));
			textField_5.setText(""+set.getInt("HighGoalsAttempted"));
			textField_4.setText(""+set.getInt("LowGoalsScored"));
			textField_3.setText(""+set.getInt("LowGoalsAttempted"));
			textField_2.setText(""+set.getInt("ScoringCycles"));
			editorPane_3.setText(set.getString("RobotDescription"));
			editorPane_4.setText(set.getString("ProtectFromOpposingAlliancedBalls"));
			editorPane_5.setText(set.getString("Comments"));
			editorPane.setText("Successful");
		} catch (SQLException e1) {
			editorPane.setText("Error Code 2");
			e1.printStackTrace();
		}
	}
}
