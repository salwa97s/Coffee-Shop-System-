package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.security.auth.NTNumericCredential;

import model.DataBase;
import model.FormUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.security.auth.NTNumericCredential;

import model.DataBase;
import model.FormUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddContact extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldID;
	private JTextField textFieldFirstName;
	private JTextField textFieldLastName;
	private JTextField textFieldPhone;
	private JTextField textFieldEmail;
	private JTextField textFieldPassword;
	private JButton btnAdd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddContact frame = new AddContact();
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
	public AddContact() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddContact.class.getResource("/Add-User-icon.png")));
		setTitle("Add Contact");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 540, 798);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220,220,220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(540, 798));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConstantType = new JLabel("Constant Type:");
		lblConstantType.setForeground(new Color(0, 0, 0));
		lblConstantType.setFont(new Font("Stencil", Font.PLAIN, 20));
		lblConstantType.setBounds(31, 131, 183, 38);
		contentPane.add(lblConstantType);
		
		JComboBox comboBoxContactType = new JComboBox();
		comboBoxContactType.setBackground(new Color(255, 255, 255));
		comboBoxContactType.addItem("Contact Type");
		comboBoxContactType.addItem("Worker");
		comboBoxContactType.addItem("Supplier");
		comboBoxContactType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxContactType.setBounds(232, 131, 174, 38);
		contentPane.add(comboBoxContactType);
		
		JLabel lblID = new JLabel("ID");
		lblID.setForeground(new Color(0, 0, 0));
		lblID.setFont(new Font("Stencil", Font.PLAIN, 20));
		lblID.setBounds(31, 196, 140, 38);
		contentPane.add(lblID);
		
		textFieldID = new JTextField();
		textFieldID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldID.setBounds(232, 197, 208, 38);
		contentPane.add(textFieldID);
		textFieldID.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setForeground(new Color(0, 0, 0));
		lblFirstName.setFont(new Font("Stencil", Font.PLAIN, 20));
		lblFirstName.setBounds(31, 271, 140, 38);
		contentPane.add(lblFirstName);
		
		textFieldFirstName = new JTextField();
		textFieldFirstName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldFirstName.setBounds(232, 272, 208, 38);
		contentPane.add(textFieldFirstName);
		textFieldFirstName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(new Color(0, 0, 0));
		lblLastName.setFont(new Font("Stencil", Font.PLAIN, 20));
		lblLastName.setBounds(31, 344, 119, 37);
		contentPane.add(lblLastName);
		
		textFieldLastName = new JTextField();
		textFieldLastName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldLastName.setBounds(232, 344, 208, 38);
		contentPane.add(textFieldLastName);
		textFieldLastName.setColumns(10);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setForeground(new Color(0, 0, 0));
		lblPhone.setFont(new Font("Stencil", Font.PLAIN, 20));
		lblPhone.setBounds(31, 418, 119, 37);
		contentPane.add(lblPhone);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldPhone.setBounds(232, 418, 208, 38);
		contentPane.add(textFieldPhone);
		textFieldPhone.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(0, 0, 0));
		lblEmail.setFont(new Font("Stencil", Font.PLAIN, 20));
		lblEmail.setBounds(31, 489, 119, 38);
		contentPane.add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldEmail.setBounds(232, 490, 208, 38);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblAddContact = new JLabel("ADD CONTACT");
		lblAddContact.setIcon(new ImageIcon(AddContact.class.getResource("/Add-User-icon.png")));
		lblAddContact.setForeground(new Color(0, 0, 0));
		lblAddContact.setFont(new Font("Dialog", Font.PLAIN, 23));
		lblAddContact.setBounds(15, 34, 297, 45);
		contentPane.add(lblAddContact);
		
		btnAdd = new JButton("ADD");
		btnAdd.setBackground(new Color(155,137,119));
		btnAdd.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnAdd.setBounds(314, 683, 126, 43);
		contentPane.add(btnAdd);
		btnAdd.setEnabled(false);
		
		JPanel panelWorker = new JPanel();
		panelWorker.setBackground(new Color(220,220,220));
		panelWorker.setBounds(31, 572, 461, 71);
		contentPane.add(panelWorker);
		panelWorker.setLayout(null);
		panelWorker.setVisible(false);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(0, 0, 0));
		lblPassword.setBounds(0, -1, 132, 38);
		lblPassword.setFont(new Font("Stencil", Font.PLAIN, 20));
		panelWorker.add(lblPassword);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldPassword.setBounds(200, 0, 207, 38);
		panelWorker.add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		JLabel lblPassworderror = new JLabel("");
		lblPassworderror.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassworderror.setForeground(Color.RED);
		lblPassworderror.setBounds(200, 41, 207, 30);
		panelWorker.add(lblPassworderror);
		
		JLabel lblIderor = new JLabel("");
		lblIderor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIderor.setForeground(Color.RED);
		lblIderor.setBounds(232, 239, 208, 26);
		contentPane.add(lblIderor);
		
		JLabel lblFirstnameeror = new JLabel("");
		lblFirstnameeror.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFirstnameeror.setForeground(Color.RED);
		lblFirstnameeror.setBounds(232, 312, 208, 26);
		contentPane.add(lblFirstnameeror);
		
		JLabel lblLastnameeror = new JLabel("");
		lblLastnameeror.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLastnameeror.setForeground(Color.RED);
		lblLastnameeror.setBounds(232, 387, 208, 26);
		contentPane.add(lblLastnameeror);
		
		JLabel lblPhoneeror = new JLabel("");
		lblPhoneeror.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPhoneeror.setForeground(Color.RED);
		lblPhoneeror.setBounds(232, 458, 208, 26);
		contentPane.add(lblPhoneeror);
		
		JLabel lblEmaileror = new JLabel("");
		lblEmaileror.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmaileror.setForeground(Color.RED);
		lblEmaileror.setBounds(232, 530, 208, 26);
		contentPane.add(lblEmaileror);
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				comboBoxContactType.setEnabled(false);
				try {
					if((String)comboBoxContactType.getSelectedItem() == "Contact Type" || !FormUtils.isNumeric(textFieldID.getText()) ||
							!FormUtils.isAlphabet(textFieldFirstName.getText()) || !FormUtils.isAlphabet(textFieldLastName.getText()) ||
							!FormUtils.isNumeric(textFieldPhone.getText()) || !FormUtils.HasNoSpaces(textFieldEmail.getText()) || 
							(panelWorker.isVisible() && !FormUtils.isAlphaNumeric(textFieldPassword.getText())))
					{
						JOptionPane.showMessageDialog(null, "some data is incorrect");
					}
					else 
					{
						if(DataBase.IsDataExists("SELECT * FROM WORKER WHERE ID =" + textFieldID.getText()) )
						{
							JOptionPane.showMessageDialog(null, (String)comboBoxContactType.getSelectedItem() + " already exists");
						}
						else
						{
							if(comboBoxContactType.getSelectedItem() == "Worker") 
							{
								DataBase.UpdateData("INSERT INTO Worker (id, firstname, lastname, password , phone, email) "
										+ "VALUES ( '"+ textFieldID.getText() +"' , '"+textFieldFirstName.getText()+"' , '"
										+textFieldLastName.getText()+"' , '"+ textFieldPassword.getText() +"' , '"+
										textFieldPhone.getText()+"' , '"+textFieldEmail.getText()+"' );");
							}
							else
							{
								DataBase.UpdateData("INSERT INTO Supplier (supplier_id, firstname, lastname, phone, email) "
										+ "VALUES ( '"+ textFieldID.getText() +"' , '"+textFieldFirstName.getText()+"' , '"
										+textFieldLastName.getText()+"' , '"+textFieldPhone.getText()+"' , '"+textFieldEmail.getText()+"' );");
							}
							
							JOptionPane.showMessageDialog(null, "contact added");
							textFieldID.setText("");
							textFieldFirstName.setText(""); 	
							textFieldLastName.setText("");
							textFieldPhone.setText(""); 
							textFieldEmail.setText(""); 
							textFieldPassword.setText("");
						}
					}
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				comboBoxContactType.setEnabled(true);
			}
		});
		
		comboBoxContactType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((String)comboBoxContactType.getSelectedItem() == "Contact Type")
				{
					panelWorker.setVisible(false);
					btnAdd.setEnabled(false);
				}
				else if((String)comboBoxContactType.getSelectedItem() == "Worker") 
				{
					panelWorker.setVisible(true);
					btnAdd.setEnabled(true);
				}
				else
				{
					panelWorker.setVisible(false);
					btnAdd.setEnabled(true);
				}
			}
		});
		
		textFieldID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) 
			{
				lblIderor.setText("");
				if(FormUtils.isNumeric(textFieldID.getText()))
				{
					lblIderor.setText("");
				}
				else
				{
					lblIderor.setText("invalid input, digits only!");
				}
			}
		});
		
		textFieldFirstName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) 
			{
				lblIderor.setText("");
				if(FormUtils.isAlphabet(textFieldFirstName.getText()))
				{
					lblFirstnameeror.setText("");
				}
				else
				{
					lblFirstnameeror.setText("invalid input, letters only!");
				}
			}
		});
		
		textFieldLastName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				lblIderor.setText("");
				if(FormUtils.isAlphabet(textFieldLastName.getText()))
				{
					lblLastnameeror.setText("");
				}
				else
				{
					lblLastnameeror.setText("invalid input, letters only!");
				}
			}
		});
		
		textFieldPhone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e)
			{
				lblIderor.setText("");
				if(FormUtils.isNumeric(textFieldPhone.getText()))
				{
					lblPhoneeror.setText("");
				}
				else
				{
					lblPhoneeror.setText("invalid input, digits only!");
				}
			}
		});
		
		textFieldEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) 
			{
				lblIderor.setText("");
				if(FormUtils.isNumeric(textFieldPhone.getText()))
				{
					lblEmaileror.setText("");
				}
				else
				{
					lblEmaileror.setText("invalid input, no spaces!");
				}
			}
		});
		
		textFieldPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) 
			{
				lblIderor.setText("");
				if(FormUtils.isAlphaNumeric(textFieldPassword.getText()))
				{
					lblPassworderror.setText("");
				}
				else
				{
					lblPassworderror.setText("invalid input, digits and letters only!");
				}
			}
		});
	}

	public JButton getAddButton() {
		return this.btnAdd;
	}
}
