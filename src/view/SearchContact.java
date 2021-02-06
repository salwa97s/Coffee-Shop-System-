package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import model.DataBase;
import model.Supplier;
import model.Worker;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class SearchContact extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private DefaultTableModel tableModel;
	private JScrollPane scrollPane;
	private String name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchContact frame = new SearchContact();
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
	public SearchContact() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SearchContact.class.getResource("/Search-icon.png")));
		setTitle("Search Contact");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setSize(1100, 691);
		setMinimumSize(new Dimension(1085 , 625));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelSearch = new JPanel();
		panelSearch.setBounds(0, 0, 1085, 625);
		contentPane.add(panelSearch);
		panelSearch.setLayout(null);
		
		JComboBox comboBoxSelection = new JComboBox();
		comboBoxSelection.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxSelection.setBounds(304, 101, 172, 43);
		panelSearch.add(comboBoxSelection);
		comboBoxSelection.addItem("Value to search");
		comboBoxSelection.addItem("ID");
		comboBoxSelection.addItem("First Name");
		comboBoxSelection.addItem("Last Name");
		comboBoxSelection.addItem("Phone");
		comboBoxSelection.addItem("Email");
		
		textField = new JTextField();
		textField.setBounds(509, 101, 319, 43);
		panelSearch.add(textField);
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 185, 1036, 426);
		panelSearch.add(scrollPane);
		scrollPane.setBackground(Color.WHITE);
		
		table = new JTable(tableModel);
		table.setRowHeight(30);
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		scrollPane.setViewportView(table);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(871, 103, 162, 43);
		panelSearch.add(btnSearch);
		btnSearch.setBackground(new Color(155,137,119));
		btnSearch.setFont(new Font("Stencil", Font.PLAIN, 18));
		
		JLabel lblNewLabel = new JLabel("Contacts");
		lblNewLabel.setBounds(25, 34, 225, 54);
		panelSearch.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 23));
		lblNewLabel.setIcon(new ImageIcon(SearchContact.class.getResource("/Search-icon.png")));
		
		JRadioButton rdbtnWorkers = new JRadioButton("Workers");
		rdbtnWorkers.setBounds(25, 103, 127, 43);
		panelSearch.add(rdbtnWorkers);
		rdbtnWorkers.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JRadioButton rdbtnSupplier = new JRadioButton("Supplier");
		rdbtnSupplier.setBounds(151, 103, 105, 43);
		panelSearch.add(rdbtnSupplier);
		rdbtnSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(rdbtnSupplier.isSelected())
				{
					rdbtnWorkers.setSelected(false);
					name = "Supplier";
				}
			}
		});
		rdbtnSupplier.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		rdbtnWorkers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(rdbtnWorkers.isSelected())
				{
					rdbtnSupplier.setSelected(false);
					name = "Worker";
				}
			}
		});
		
		String[] column_headers = {"ID", "First name", "Last name", "Phone", "Email"};
		tableModel = new DefaultTableModel(column_headers, 0);
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				clearTable();
				
					if((String)comboBoxSelection.getSelectedItem() == "Value to search" && textField.getText().trim().isEmpty()
							&& (rdbtnWorkers.isSelected() || rdbtnSupplier.isSelected()))
					{
							if(rdbtnWorkers.isSelected()) 
							{
								CreateWorkerTable("SELECT * FROM WORKER");
							}
						
							else if(rdbtnSupplier.isSelected())
							{
								CreateSupplierTable("SELECT * FROM Supplier");
							}
							
					}
					else if(comboBoxSelection.getSelectedItem() != "Value to search" && !textField.getText().trim().isEmpty())
					{
						if(rdbtnWorkers.isSelected()) 
						{
							switch((String)comboBoxSelection.getSelectedItem()) {
							case "ID":
								CreateWorkerTable("SELECT * FROM worker WHERE id ='"+ textField.getText()+"';");
								break;
							case "First Name":
								CreateWorkerTable("SELECT * FROM worker WHERE firstname ='"+ textField.getText()+"';");
								break;
							case "Last Name":
								CreateWorkerTable("SELECT * FROM worker WHERE lastname ='"+ textField.getText()+"';");
								break;
							case "Phone":
								CreateWorkerTable("SELECT * FROM worker WHERE phone ='"+ textField.getText()+"';");
								break;
							case "Email":
								CreateWorkerTable("SELECT * FROM worker WHERE email ='"+ textField.getText()+"';");
								break;
							}
						}
						
						if(rdbtnSupplier.isSelected())
						{
							switch((String)comboBoxSelection.getSelectedItem()) {
							case "ID":
								CreateSupplierTable("SELECT * FROM supplier WHERE supplier_id ='"+ textField.getText()+"';");
								break;
							case "First Name":
								CreateSupplierTable("SELECT * FROM supplier WHERE firstname ='"+ textField.getText()+"';");
								break;
							case "Last Name":
								CreateSupplierTable("SELECT * FROM supplier WHERE lastname ='"+ textField.getText()+"';");
								break;
							case "Phone":
								CreateSupplierTable("SELECT * FROM supplier WHERE phone ='"+ textField.getText()+"';");
								break;
							case "Email":
								CreateSupplierTable("SELECT * FROM supplier WHERE email ='"+ textField.getText()+"';");
								break;
							}
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "Some Data is missing");
					}
				
				textField.setText("");
			}
		});
	
	}
	
	private void ContactsTable()
	{
		table = new JTable(tableModel);
		table.setRowHeight(30);
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		scrollPane.setViewportView(table);
		getContentPane().add(scrollPane);
	}
	
	public void CreateWorkerTable(String i_Query)
	{
		ArrayList<Worker> workers;
		try {
			workers = DataBase.Workers(i_Query);
			for(Worker worker : workers)
			{
				String[] data = {worker.getM_ID(), worker.getM_FirstName(), worker.getM_LastName(), worker.getM_Telephone(), worker.getM_Email()};
				tableModel.addRow(data);
			}
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		ContactsTable();
	}
	
	private void CreateSupplierTable(String i_Query)
	{
		ArrayList<Supplier> suppliers;
		try {
			suppliers = DataBase.Suppliers(i_Query);
			for(Supplier supplier : suppliers)
			{
				String[] data = {supplier.getM_ID(), supplier.getM_FirstName(), supplier.getM_LastName(), supplier.getM_Telephone(), supplier.getM_Email()};
				tableModel.addRow(data);
			}
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		ContactsTable();
	}
	
	private void clearTable()
	{
		if(table!=null) 
		{
			DefaultTableModel dm = (DefaultTableModel)table.getModel();
			while(dm.getRowCount() > 0)
			{
				dm.removeRow(0);
			}
		}
	}
}
