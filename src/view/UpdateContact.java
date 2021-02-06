package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.FormUtils;
import model.DataBase;
import model.Supplier;
import model.Worker;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UpdateContact extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldID;
	private JTextField textFieldFirstName;
	private JTextField textFieldLastName;
	private JTextField textFieldPhone;
	private JTextField textFieldEmail;
	private JButton btnSave,btnEdit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateContact frame = new UpdateContact();
					frame.setLocationRelativeTo(null);
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
	public UpdateContact() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(UpdateContact.class.getResource("/updateic.png")));
		setTitle("Update Contact");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 489, 655);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220,220,220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setMinimumSize(new Dimension(490, 655));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelData = new JPanel();
		panelData.setBackground(new Color(220,220,220));
		panelData.setBounds(40, 190, 408, 315);
		panelData.setVisible(false);
		contentPane.add(panelData);
		panelData.setLayout(null);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPhone.setBounds(0, 189, 83, 36);
		panelData.add(lblPhone);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(-1, 63, 84, 36);
		panelData.add(lblFirstName);
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		textFieldFirstName = new JTextField();
		textFieldFirstName.setBounds(137, 63, 198, 36);
		panelData.add(textFieldFirstName);
		textFieldFirstName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldFirstName.setColumns(10);
		
		textFieldLastName = new JTextField();
		textFieldLastName.setBounds(137, 125, 198, 36);
		panelData.add(textFieldLastName);
		textFieldLastName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldLastName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(-1, 125, 83, 36);
		panelData.add(lblLastName);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		textFieldPhone = new JTextField();
		textFieldPhone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldPhone.setBounds(137, 189, 198, 36);
		panelData.add(textFieldPhone);
		textFieldPhone.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(0, 251, 69, 36);
		panelData.add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldEmail.setBounds(137, 251, 198, 36);
		panelData.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblId_1 = new JLabel("ID");
		lblId_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblId_1.setBounds(0, 0, 83, 36);
		panelData.add(lblId_1);
		
		JLabel lblIDNumber = new JLabel("");
		lblIDNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIDNumber.setBounds(137, 0, 198, 36);
		panelData.add(lblIDNumber);
		
		JLabel lblFirstnameeror = new JLabel("");
		lblFirstnameeror.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFirstnameeror.setForeground(Color.RED);
		lblFirstnameeror.setBounds(137, 101, 256, 20);
		panelData.add(lblFirstnameeror);
		
		JLabel lblLastnameeror = new JLabel("");
		lblLastnameeror.setForeground(Color.RED);
		lblLastnameeror.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLastnameeror.setBounds(137, 160, 256, 26);
		panelData.add(lblLastnameeror);
		
		JLabel lblPhoneeror = new JLabel("");
		lblPhoneeror.setForeground(Color.RED);
		lblPhoneeror.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPhoneeror.setBounds(137, 225, 256, 22);
		panelData.add(lblPhoneeror);
		
		JLabel lblEmaileror = new JLabel("");
		lblEmaileror.setForeground(Color.RED);
		lblEmaileror.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmaileror.setBounds(137, 287, 256, 28);
		panelData.add(lblEmaileror);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(220,220,220));
		panel.setBounds(40, 190, 408, 315);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(0, 0, 95, 46);
		panel.add(lblId);
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		textFieldID = new JTextField();
		textFieldID.setBounds(142, 5, 196, 37);
		panel.add(textFieldID);
		textFieldID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldID.setColumns(10);
		
		JLabel lblIderor = new JLabel("");
		lblIderor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIderor.setForeground(Color.RED);
		lblIderor.setBounds(142, 50, 196, 20);
		panel.add(lblIderor);
		
		textFieldID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) 
			{
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
		
		textFieldLastName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) 
			{
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
				if(FormUtils.HasNoSpaces(textFieldEmail.getText()))
				{
					lblEmaileror.setText("");
				}
				else
				{
					lblEmaileror.setText("invalid input, no spaces!");
				}
			}
		});
		
		JComboBox comboBoxContactType = new JComboBox();
		comboBoxContactType.setBounds(40, 100, 253, 46);
		contentPane.add(comboBoxContactType);
		comboBoxContactType.addItem("Choose Contact");
		comboBoxContactType.addItem("Worker");
		comboBoxContactType.addItem("Supplier");
		comboBoxContactType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblUpdate = new JLabel("UPDATE");
		lblUpdate.setBounds(15, 16, 180, 68);
		contentPane.add(lblUpdate);
		lblUpdate.setIcon(new ImageIcon(UpdateContact.class.getResource("/updateic.png")));
		lblUpdate.setFont(new Font("Stencil", Font.PLAIN, 25));
		
		btnEdit = new JButton("Edit");
		btnEdit.setBounds(333, 102, 115, 45);
		btnEdit.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnEdit.setBackground(new Color(155,137,119));
		contentPane.add(btnEdit);
		
		btnSave = new JButton("Save");
		btnSave.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnSave.setBackground(new Color(155,137,119));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(!FormUtils.isAlphabet(textFieldFirstName.getText()) || !FormUtils.isAlphabet(textFieldLastName.getText()) 
						|| !FormUtils.isNumeric(textFieldPhone.getText()) || !FormUtils.HasNoSpaces(textFieldEmail.getText()))
				{
					JOptionPane.showMessageDialog(null, "incorrect data");
				}
				else
				{
					try {
						
						if(comboBoxContactType.getSelectedItem() == "Worker") {
							ArrayList<Worker> workers = DataBase.Workers("SELECT * FROM worker WHERE id = " + textFieldID.getText());
							workers.get(0).setWorkerFirst(textFieldFirstName.getText());
							workers.get(0).setWorkerLast(textFieldLastName.getText());
							workers.get(0).setWorkerEmail(textFieldEmail.getText());
							workers.get(0).setWorkerPhone(textFieldPhone.getText());
						}else {
							ArrayList<Supplier> suppliers = DataBase.Suppliers("SELECT * FROM SUPPLIER WHERE supplier_id = " + textFieldID.getText());
							suppliers.get(0).setsupplierFirst(textFieldFirstName.getText());
							suppliers.get(0).setsupplierLast(textFieldLastName.getText());
							suppliers.get(0).setsupplierEmail(textFieldEmail.getText());
							suppliers.get(0).setsupplierPhone(textFieldPhone.getText());
						}
						
						
						
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "data saved");
					textFieldID.setText("");
					textFieldFirstName.setText("");
					textFieldLastName.setText("");
					textFieldPhone.setText("");
					textFieldEmail.setText("");
					panel.setVisible(true);
					panelData.setVisible(false);
					btnSave.setEnabled(false);
				}
			}
		});
		btnSave.setBounds(333, 537, 115, 45);
		contentPane.add(btnSave);
		btnSave.setBackground(UIManager.getColor("Button.background"));
		btnSave.setEnabled(false);
		
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					if(comboBoxContactType.getSelectedItem() == "Choose Contact" || textFieldID.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(null, "some data is missing");
					}else {
						lblIDNumber.setText(textFieldID.getText());
					
						if(comboBoxContactType.getSelectedItem() == "Worker") 
						{
							if(!DataBase.IsDataExists("SELECT * FROM " + (String)comboBoxContactType.getSelectedItem() + " WHERE id = " + textFieldID.getText()))
							{
								JOptionPane.showMessageDialog(null, "Contact not exists");
							}else {
								ArrayList<Worker> workers = DataBase.Workers("SELECT * FROM WORKER WHERE id = " + textFieldID.getText());
								textFieldFirstName.setText(workers.get(0).getM_FirstName());
								textFieldLastName.setText(workers.get(0).getM_LastName());
								textFieldPhone.setText(workers.get(0).getM_Telephone());
								textFieldEmail.setText(workers.get(0).getM_Email());
							}
						}
						else{
							if(!DataBase.IsDataExists("SELECT * FROM " + (String)comboBoxContactType.getSelectedItem() + " WHERE supplier_id = " + textFieldID.getText()))
							{
								JOptionPane.showMessageDialog(null, "Contact not exists");
							}else {
								ArrayList<Supplier> suppliers = DataBase.Suppliers("SELECT * FROM SUPPLIER WHERE supplier_id = " + textFieldID.getText());
								textFieldFirstName.setText(suppliers.get(0).getM_FirstName());
								textFieldLastName.setText(suppliers.get(0).getM_LastName());
								textFieldPhone.setText(suppliers.get(0).getM_Telephone());
								textFieldEmail.setText(suppliers.get(0).getM_Email());
						      }
						}
						panelData.setVisible(true);
						panel.setVisible(false);
						btnSave.setEnabled(true);
					}
				}catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}	
			}
		});
	}
	
	public JButton getSaveButton() {
		return this.btnSave;
	}
	
	public JButton getEditButton() {
		return this.btnEdit;
	}
}
