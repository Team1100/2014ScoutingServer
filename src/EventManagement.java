import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class EventManagement extends JFrame {

	private JPanel contentPane;
	private JList list = new JList();
	private JList list_1 = new JList();
	private JTextField textField_1;
	private JTextField textField;
	private JScrollPane scroll1 = new JScrollPane();
	private JScrollPane scroll2 = new JScrollPane();
	
	private DefaultListModel eventsModel = new DefaultListModel();
	private List<DefaultListModel> teamsModels = new ArrayList<DefaultListModel>();
	private DefaultListModel actualTeamsModel = new DefaultListModel();
	
	int count = 0;
	int selectedEvent = 0;
	int selectedTeam = 0;
	
	String table = "eventstable";
	
	private List<String> events = new ArrayList<String>();
	private List<List<String>> teams = new ArrayList<List<String>>();
	private ScoutingServerAccessor accessor = new ScoutingServerAccessor();
	
	private static EventManagement frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new EventManagement();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public EventManagement() {
		this.setTitle("Event and Team Overview");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 296);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEvents = new JLabel("Select an Event");
		lblEvents.setBounds(10, 11, 150, 14);
		contentPane.add(lblEvents);
		
		setThingsUp();
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				setList_1Model();
				System.out.println("Hello");
			}
		});
		setListModel();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(10, 36, 160, 181);
		
		JLabel lblAddAnEvent = new JLabel("Add an Event");
		lblAddAnEvent.setBounds(176, 11, 175, 14);
		contentPane.add(lblAddAnEvent);
		
		textField = new JTextField();
		textField.setBounds(176, 36, 175, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnAddEvent = new JButton("Add Event");
		btnAddEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO: Add event button
				try {
					if(!accessor.execute("INSERT INTO eventstable SET Event='"+textField.getText()+"'")) {
						setThingsUp();
						setListModel();
						setList_1Model();
						textField.setText("");
					} else {
						System.out.println("Something didn't work!");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAddEvent.setBackground(new Color(34, 139, 34));
		btnAddEvent.setBounds(176, 67, 175, 23);
		contentPane.add(btnAddEvent);
		
		JButton btnRemoveSelectedEvent = new JButton("Remove Selected Event");
		btnRemoveSelectedEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(frame, "Are you sure you want to delete "+list.getSelectedValue()+"? This cannot be undone!")==0) {
				try {
					if(list.getSelectedValue()!=null && list_1.getSelectedValue()!="No events found!" && !accessor.execute("DELETE FROM eventstable WHERE Event='"+list.getSelectedValue()+"'")) {
						try {
							accessor.execute("DELETE FROM " + table + " WHERE Event='"+list.getSelectedValue()+"'");
						} catch (SQLException ex) {
							ex.printStackTrace();
						}
						setThingsUp();
						setListModel();
						setList_1Model();
						textField.setText("");
					} else {
						System.out.println("Something didn't work!");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				}
			}
		});
		btnRemoveSelectedEvent.setBackground(new Color(255, 0, 0));
		btnRemoveSelectedEvent.setBounds(176, 101, 175, 23);
		contentPane.add(btnRemoveSelectedEvent);
		
		setList_1Model();
		list_1.setModel(actualTeamsModel);
		list_1.setBounds(361, 36, 160, 181);
		
		JLabel lblEditTeams = new JLabel("Edit Teams");
		lblEditTeams.setBounds(361, 11, 160, 14);
		contentPane.add(lblEditTeams);
		
		JLabel lblAddATeam = new JLabel("Add a Team");
		lblAddATeam.setBounds(180, 135, 171, 14);
		contentPane.add(lblAddATeam);
		
		JButton btnAddTeam = new JButton("Add Team");
		btnAddTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(!accessor.execute("UPDATE eventstable SET Teams=CONCAT(IFNULL(Teams,''), '~"+textField_1.getText()+"') WHERE Event='"+list.getSelectedValue()+"'")) {
						setThingsUp();
						setListModel();
						setList_1Model();
						textField_1.setText("");
					} else {
						System.out.println("Something didn't work!");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAddTeam.setBackground(new Color(34, 139, 34));
		btnAddTeam.setBounds(180, 186, 175, 23);
		contentPane.add(btnAddTeam);
		
		JButton btnRemoveSelectedTeam = new JButton("Remove Selected Team");
		btnRemoveSelectedTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(list_1.getSelectedValue()!=null && list_1.getSelectedValue()!="No teams found!" && !accessor.execute("UPDATE eventstable SET Teams=REPLACE(Teams,'~"+list_1.getSelectedValue()+"','') WHERE Event='"+list.getSelectedValue()+"';")) {
						try {
							if(JOptionPane.showConfirmDialog(frame, "Are you sure that you want to delete all data for team "+list_1.getSelectedValue()+" at event "+list.getSelectedValue()+"?")==0) {
								accessor.execute("DELETE FROM samplescoutingservertable WHERE TeamNumber='"+list_1.getSelectedValue()+"' AND Event='"+list.getSelectedValue()+"'");
							}
						} catch (SQLException ex) {
							ex.printStackTrace();
						}
						setThingsUp();
						setListModel();
						setList_1Model();
						textField_1.setText("");
					} else {
						System.out.println("Something didn't work!");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnRemoveSelectedTeam.setBackground(Color.RED);
		btnRemoveSelectedTeam.setBounds(180, 220, 175, 23);
		contentPane.add(btnRemoveSelectedTeam);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(180, 160, 175, 20);
		contentPane.add(textField_1);
		
		scroll1.setViewportView(list);
		scroll2.setViewportView(list_1);
		scroll1.setBounds(10, 36, 160, 181);
		scroll2.setBounds(361, 36, 160, 181);
		contentPane.add(scroll1);
		contentPane.add(scroll2);
		
		JButton clearEventButton = new JButton("Clear All Event Data");
		clearEventButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO: Clear event
				if(JOptionPane.showConfirmDialog(frame, "Are you sure that you want to delete all data for event "+list.getSelectedValue()+"?")==0) {
					try {
						accessor.execute("DELETE FROM " + table + " WHERE Event='"+list.getSelectedValue()+"'");
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		});
		clearEventButton.setBounds(10, 220, 160, 23);
		contentPane.add(clearEventButton);
		
		JButton clearTeamButton = new JButton("Clear All Team Data");
		clearTeamButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO: Clear team
				try {
					if(JOptionPane.showConfirmDialog(frame, "Are you sure that you want to delete all data for team "+list_1.getSelectedValue()+" at event "+list.getSelectedValue()+"?")==0) {
						accessor.execute("DELETE FROM servertransport01 WHERE TeamNumber='"+list_1.getSelectedValue()+"' AND Event='"+list.getSelectedValue()+"'");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		clearTeamButton.setBounds(361, 220, 160, 23);
		contentPane.add(clearTeamButton);
	}
	
	private void setList_1Model() {
		try {
			System.out.println(list.getSelectedIndex()+"  "+teamsModels.size());
			list_1.setModel(teamsModels.get(list.getSelectedIndex()));
			System.out.println("Success!");
		} catch(Exception e) {
			e.printStackTrace();
			DefaultListModel model = new DefaultListModel();
			model.add(0, "No teams found!");
			list_1.setModel(model);
		}
	}
	
	private void setListModel() {
		list.setModel(eventsModel);
		list.setSelectedIndex(selectedEvent);
	}
	
	private void setThingsUp() {
		selectedEvent = list.getSelectedIndex();
		selectedTeam = list_1.getSelectedIndex();
		eventsModel = new DefaultListModel();
		teamsModels = new ArrayList<DefaultListModel>();
		actualTeamsModel = new DefaultListModel();
		
		events = new ArrayList<String>();
		teams = new ArrayList<List<String>>();
		accessor = new ScoutingServerAccessor();
		try {
			ResultSet set = accessor.executeQuery("SELECT * FROM eventstable");
			while(set.next()) {
				events.add(set.getString("Event"));
				System.out.println(set.getString("Event"));
				ArrayList list = new ArrayList<String>();
				try {
					for(String s : set.getString("Teams").split("~")) {
						list.add(s);
					}
				} catch(Exception e){};
				teams.add(list);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		for(String s : events) {
			eventsModel.addElement(s);
		}
		int count = 0;
		for(List<String> arr : teams) {
			for(String s : arr) {
				try {
					teamsModels.get(count).addElement(s);
				} catch(Exception e) {
					try {
						System.out.println("PAY ATTENTION!");
						teamsModels.add(new DefaultListModel());
						teamsModels.get(count).addElement(s);
					} catch(Exception ex){};
				};
			}
			count++;
		}
		list.setSelectedIndex(selectedEvent);
		list_1.setSelectedIndex(selectedTeam);
	}
}
