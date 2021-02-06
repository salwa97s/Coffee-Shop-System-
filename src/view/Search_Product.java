package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.DataBase;
import model.Product.eProductID;
import model.Supplier;
import net.proteanit.sql.DbUtils;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Toolkit;

public class Search_Product extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;
	private JScrollPane scrollPane;
	private JButton btnSearch;
	private JComboBox comboBoxData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search_Product frame = new Search_Product();
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
	public Search_Product() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Search_Product.class.getResource("/search.png")));
		setTitle("Search Product");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 831, 503);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220,220,220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setBounds(41, 183, 726, 200);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		table.setBackground(new Color(220,220,220));
		table.setRowHeight(30);

		
		JLabel lblSearchProduct = new JLabel("SEARCH PRODUCT");
		lblSearchProduct.setBounds(17, 18, 297, 45);
		lblSearchProduct.setIcon(new ImageIcon(Search_Product.class.getResource("/search.png")));
		lblSearchProduct.setFont(new Font("Dialog", Font.PLAIN, 23));
		
		JComboBox<String> comboBoxSearch = new JComboBox<String>();
		comboBoxSearch.addItem("search");
		comboBoxSearch.setBounds(41, 104, 211, 43);
		comboBoxSearch.setFont(new Font("Tahoma", Font.PLAIN, 19));
		comboBoxSearch.addItem("ID");
		comboBoxSearch.addItem("Name");
		comboBoxSearch.addItem("Supllier ID");
		
		btnSearch = new JButton("Search");
		btnSearch.setBounds(641, 105, 126, 43);
		btnSearch.setBackground(new Color(155,137,119));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxSearch.getSelectedItem() == "search" || comboBoxData.getSelectedItem() == "choose")
				{
					JOptionPane.showMessageDialog(null, "some data is missing");
				}
				else
				{
				try {
					switch ((String)comboBoxSearch.getSelectedItem()) {
					case "ID" : {
					String query = "select * from product where product_id = " + ((eProductID)comboBoxData.getSelectedItem()).getNumVal();
					ResultSet result;
					result = DataBase.GetResult(query);
					table.setModel(DbUtils.resultSetToTableModel(result));}
					break;
					case "Name": {
						String query = "select * from "+ (String)comboBoxData.getSelectedItem();
						ResultSet result;
						result = DataBase.GetResult(query);
						table.setModel(DbUtils.resultSetToTableModel(result));}
					break ; 
					case "Supllier ID" :  {
						String query = "select * from product where supplier_id = "+ (String)comboBoxData.getSelectedItem();
						ResultSet result;
						result = DataBase.GetResult(query);
						table.setModel(DbUtils.resultSetToTableModel(result));}
					break ;  
					}
				
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
				}
			}
		});
		btnSearch.setFont(new Font("Dialog", Font.PLAIN, 18));
		
		JButton button = new JButton("CLOSE");
		button.setBounds(576, 408, 126, 43);
		button.setBackground(new Color(155,137,119));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setFont(new Font("Dialog", Font.PLAIN, 18));
		contentPane.setLayout(null);
		contentPane.add(lblSearchProduct);
		
		contentPane.add(comboBoxSearch);
		contentPane.add(btnSearch);
		contentPane.add(button);
		
		comboBoxData = new JComboBox();
		comboBoxData.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxData.addItem("choose");
		comboBoxData.setBounds(312, 104, 211, 43);
		contentPane.add(comboBoxData);
		
		comboBoxSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				comboBoxData.removeAllItems();
				switch((String)comboBoxSearch.getSelectedItem())
				{
				case "ID":
					comboBoxData.addItem(eProductID.Chocolate_Cake);
					comboBoxData.addItem(eProductID.Vanilla_Cake);
					comboBoxData.addItem(eProductID.ChocolateChip_Cake);
					comboBoxData.addItem(eProductID.Cheese_Cake);
					comboBoxData.addItem(eProductID.Red_Mug_Coffee);
					comboBoxData.addItem(eProductID.Testers_Choice_Coffee);
					comboBoxData.addItem(eProductID.Turkish_Coffee);
					comboBoxData.addItem(eProductID.Small_Cup);
					comboBoxData.addItem(eProductID.Medium_Cup);
					comboBoxData.addItem(eProductID.Large_Cup);
					comboBoxData.addItem(eProductID.Chocolate_CupCake);
					comboBoxData.addItem(eProductID.Vanilla_CupCake);
					comboBoxData.addItem(eProductID.ChocolateChip_CupCake);
					comboBoxData.addItem(eProductID.Cheese_CupCake);
					comboBoxData.addItem(eProductID.Milk_One_liter_1_Fat);
					comboBoxData.addItem(eProductID.Milk_One_liter_1_Fat);
					comboBoxData.addItem(eProductID.Milk_Two_liter_1_Fat);
					comboBoxData.addItem(eProductID.Milk_One_liter_3_Fat);
					comboBoxData.addItem(eProductID.Milk_Two_liter_3_Fat);
					comboBoxData.addItem(eProductID.Soya_Milk_One_liter_1_Fat);
					comboBoxData.addItem(eProductID.Soya_Milk_Two_liter_1_Fat);
					comboBoxData.addItem(eProductID.Soya_Milk_One_liter_3_Fat);
					comboBoxData.addItem(eProductID.Soya_Milk_Two_liter_3_Fat);
					comboBoxData.addItem(eProductID.white_Sugar);
					comboBoxData.addItem(eProductID.Brown_Sugar);
					comboBoxData.addItem(eProductID.Stevia);
					comboBoxData.addItem(eProductID.teaspoon);
					comboBoxData.addItem(eProductID.other);
					break;
				case "Name":
					comboBoxData.addItem("product");
					comboBoxData.addItem("Cake");
					comboBoxData.addItem("Coffee");
					comboBoxData.addItem("Cup");
					comboBoxData.addItem("Cupcake");
					comboBoxData.addItem("milk");
					comboBoxData.addItem("sweeteners");
					comboBoxData.addItem("teaspoon");	
					break;

				case "Supllier ID":
					ArrayList<Supplier> suppliers = null;
					try {
						suppliers = DataBase.Suppliers("select * from supplier");
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					for(Supplier supplier : suppliers)
					{
						comboBoxData.addItem(supplier.getM_ID());
					}
					break;
				}
			}
		});
		
	}

	public JButton getSearchButton() {
		return this.btnSearch;
	}
}
