package project1;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JSpinner;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.JSeparator;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = -5060725585828913409L;
	
	private ShowList myShowList;
	private ShowList myTextFile;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	public MainPanel() {
		
		myShowList = new ShowList("./project1/netflixTopTenProcessed.txt");
		
		setBackground(new Color(0, 0, 0));
		setLayout(null);
		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(250, 67, 200, 200);
//		add(scrollPane);
//		
//		JTextArea textArea = new JTextArea();
//		scrollPane.setViewportView(textArea);
//		textArea.setText(myShowList.toString());
		
		JComboBox comboBox = new JComboBox();
		String[] ids = myShowList.toArray();
		comboBox.setModel(new DefaultComboBoxModel(ids));
		comboBox.setBounds(272, 117, 381, 37);
		add(comboBox);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("2022-09-04");
		lblNewJgoodiesTitle.setBackground(new Color(255, 255, 255));
		lblNewJgoodiesTitle.setForeground(new Color(0, 0, 0));
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewJgoodiesTitle.setBounds(375, 22, 111, 23);
		add(lblNewJgoodiesTitle);
		
		textField = new JTextField();
		textField.setBounds(369, 22, 117, 23);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Week: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setBounds(272, 14, 101, 37);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(42, 19, 117, 23);
		add(btnNewButton);
		
		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(250, 67, 200, 200);
//		add(scrollPane);
//		
//		JTextArea textArea = new JTextArea();
//		scrollPane.setViewportView(textArea);
//		textArea.setText(myShowList.toString());
		

		
		JButton btnNewButton_1 = new JButton("EDIT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				JEditorPane editorPane = new JEditorPane();
				editorPane.setBounds(42, 244, 117, 72);
				add(editorPane);
				
				JTextArea textArea = new JTextArea();
				textArea.setText(textField.getText());	
				editorPane.getText();
				}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(42, 53, 117, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("REMOVE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowList temporary = new ShowList();
				String temp4 = (String) comboBox.getSelectedItem();
				temporary = myShowList.myRemovedList(temp4);
				myShowList = temporary;
//				myShowList.myRemovedList(temp4);
				String[] ids3 = myShowList.toArray();
				comboBox.setModel(new DefaultComboBoxModel(ids3));
				comboBox.setBounds(272, 117, 381, 37);
				add(comboBox);
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.setBounds(42, 87, 117, 23);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("VIEW ALL");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ShowList temp = myShowList.nonPurged();
				String[] ids = temp.toArray();
				comboBox.setModel(new DefaultComboBoxModel(ids));
				comboBox.setBounds(272, 117, 381, 37);
				add(comboBox);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3.setBounds(42, 121, 117, 23);
		add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("GET SHOWS");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ShowList temp = myShowList.getShowsDateBased(textField.getText());
				String[] ids = temp.toArray();
				comboBox.setModel(new DefaultComboBoxModel(ids));
				comboBox.setBounds(272, 117, 381, 37);
				add(comboBox);
				lblNewJgoodiesTitle.revalidate();
			}
		});
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3_1.setBounds(515, 22, 138, 23);
		add(btnNewButton_3_1);
		
		JButton btnNewButton_3_2 = new JButton("VIEW PURGED");
		btnNewButton_3_2.setBackground(new Color(255, 255, 255));
		btnNewButton_3_2.setForeground(new Color(0, 0, 0));
		btnNewButton_3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ShowList tempList = myShowList.purgeList();
				String[] ids = tempList.toArray();
				comboBox.setModel(new DefaultComboBoxModel(ids));
				comboBox.setBounds(272, 117, 381, 37);
				add(comboBox);
			}
		});
		btnNewButton_3_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3_2.setBounds(31, 376, 138, 23);
		add(btnNewButton_3_2);
		
		JButton btnNewButton_1_1 = new JButton("PURGE");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = (String) comboBox.getSelectedItem();
				
				myShowList.purgeStringBased(temp);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1.setBounds(42, 155, 117, 23);
		add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("UNPURGE");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String temp2 = (String) comboBox.getSelectedItem();
				myShowList.unpurgeStringBased(temp2);
				
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1_1.setBounds(42, 189, 117, 23);
		add(btnNewButton_1_1_1);
		
		JLabel lblThemes = new JLabel("THEMES:");
		lblThemes.setForeground(Color.WHITE);
		lblThemes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblThemes.setBackground(Color.WHITE);
		lblThemes.setBounds(37, 416, 132, 46);
		add(lblThemes);
		
		
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Dark");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setBackground(new Color(0,0,0));
			}
		});
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBounds(105, 430, 111, 23);
		add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnLightTheme = new JRadioButton("Light");
		rdbtnLightTheme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setBackground(new Color(255,255,255));
			}
		});
		buttonGroup.add(rdbtnLightTheme);
		rdbtnLightTheme.setBounds(228, 430, 111, 23);
		add(rdbtnLightTheme);

		
		JLabel lblNewLabel_1 = new JLabel();
		Image img = new ImageIcon(this.getClass().getResource("/project1/icon2.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(203, 126, 587, 326);
		add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 223, 183, 161);
		add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(192, 223, 1, 2);
		add(separator_1);
		

		
		

	}
	public void doClose() {
		myShowList.doWrite("./textwrite.txt");
	}
}
