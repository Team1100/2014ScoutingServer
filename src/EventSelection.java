import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class EventSelection extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	private ScoutingServerAccessor server = new ScoutingServerAccessor();
	
	private DefaultListModel eventsModel = new DefaultListModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventSelection frame = new EventSelection();
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
	public EventSelection() {
		try {
			ArrayList<String> eventsList = new ArrayList<String>();
			ResultSet set = server.executeQuery("SELECT * FROM eventstable");
			while(set.next()) {
				eventsModel.addElement(set.getString("Event"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 274);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setSelectedIndex(-1);
		list.setModel(eventsModel);
		list.setBounds(10, 36, 158, 154);
		contentPane.add(list);
		
		JLabel lblSelectAnEvent = new JLabel("Select an Event");
		lblSelectAnEvent.setBounds(10, 11, 158, 14);
		contentPane.add(lblSelectAnEvent);
		
		JTextPane txtpnYouMustSelect = new JTextPane();
		txtpnYouMustSelect.setText("- You must select an event to continue!\r\n\r\n- If you do not see the event you want, run the event management program, and then restart this program.");
		txtpnYouMustSelect.setEditable(false);
		txtpnYouMustSelect.setBounds(178, 11, 158, 179);
		contentPane.add(txtpnYouMustSelect);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.setBackground(new Color(0, 128, 0));
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(list.getSelectedIndex()!=-1) {
					
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								Display frame = new Display((String) list.getSelectedValue());
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					dispose();
				}
			}
		});
		btnContinue.setBounds(10, 201, 158, 24);
		contentPane.add(btnContinue);
		
		textField = new JTextField();
		textField.setBounds(178, 216, 158, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblConsoleOutput = new JLabel("Console Output");
		lblConsoleOutput.setBounds(178, 201, 158, 14);
		contentPane.add(lblConsoleOutput);
	}
}
