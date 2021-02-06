package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.Cake;
import model.Coffee;
import model.Cup;
import model.Cupcake;
import model.DataBase;
import model.Milk;
import model.Product;
import model.Product.eCategory;
import model.Product.eProductID;
import model.ProductsWithExpiryDate;
import model.ProductsWithNoExpiryDate;
import model.Supplier;
import model.Sweeteners;
import model.Teaspoon;

public class AddProduct extends JFrame {

	private JPanel contentPane;
	private JButton btn_Add;
	private  Connection s_Connection = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProduct frame = new AddProduct();
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
	private ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
	private String expiryDate = null;
	private JTextField textFieldProductName;
	
	public AddProduct() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddProduct.class.getResource("/Add-product-icon.png")));
		setTitle("Add Product");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 480, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220,220,220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAddProduct = new JLabel("ADD PRODUCT");
		lblAddProduct.setBounds(20, 21, 297, 45);
		lblAddProduct.setIcon(new ImageIcon(AddProduct.class.getResource("/Add-product-icon.png")));
		lblAddProduct.setFont(new Font("Stencil", Font.PLAIN, 30));
		
		JLabel lblProduct = new JLabel("Product");
		lblProduct.setBounds(15, 110, 113, 36);
		lblProduct.setFont(new Font("Stencil", Font.PLAIN, 18));
		
		btn_Add = new JButton("ADD");
		btn_Add.setBounds(20, 605, 126, 43);
		btn_Add.setBackground(new Color(155,137,119));
		btn_Add.setFont(new Font("Dialog", Font.PLAIN, 18));
		
		JButton button_CLOSE = new JButton("CLOSE");
		button_CLOSE.setBounds(191, 605, 126, 43);
		button_CLOSE.setBackground(new Color(155,137,119));
		button_CLOSE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button_CLOSE.setFont(new Font("Dialog", Font.PLAIN, 18));
		contentPane.setLayout(null);
		contentPane.add(lblAddProduct);
		contentPane.add(lblProduct);
		contentPane.add(btn_Add);
		contentPane.add(button_CLOSE);
		
		JComboBox comboBoxProduct = new JComboBox();
		comboBoxProduct.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxProduct.addItem("choose product");
		comboBoxProduct.addItem("Cake");
		comboBoxProduct.addItem("Coffee");
		comboBoxProduct.addItem("Cup");
		comboBoxProduct.addItem("Cupcake");
		comboBoxProduct.addItem("Milk");
		comboBoxProduct.addItem("Sweeteners");
		comboBoxProduct.addItem("Teaspoon");
		comboBoxProduct.addItem("Other");
		comboBoxProduct.setBounds(179, 110, 201, 36);
		contentPane.add(comboBoxProduct);
		
		JLabel lblProductID = new JLabel("Product ID");
		lblProductID.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblProductID.setBounds(15, 175, 108, 36);
		contentPane.add(lblProductID);
		
		JComboBox comboBoxProductID = new JComboBox();
		comboBoxProductID.addItem("choose");
		comboBoxProductID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxProductID.setBounds(179, 175, 201, 36);
		contentPane.add(comboBoxProductID);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblAmount.setBounds(15, 305, 108, 36);
		contentPane.add(lblAmount);
		
		JSpinner spinnerAmount = new JSpinner();
		spinnerAmount.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) 
			{
				if((int)spinnerAmount.getValue() < 0)
				{
					JOptionPane.showMessageDialog(null, "invalid amount, should be >=0");
					spinnerAmount.setValue(0);
				}
			}
		});
		spinnerAmount.setFont(new Font("Tahoma", Font.PLAIN, 18));
		spinnerAmount.setBounds(179, 305, 201, 36);
		contentPane.add(spinnerAmount);
		
		JLabel lblSupplier = new JLabel("Supplier");
		lblSupplier.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblSupplier.setBounds(15, 240, 113, 36);
		contentPane.add(lblSupplier);
		
		JComboBox comboBoxSuppliersList = new JComboBox();
		comboBoxSuppliersList.addItem("choose supplier");
		comboBoxSuppliersList.setFont(new Font("Tahoma", Font.PLAIN, 18));
		try {
			suppliers= DataBase.Suppliers("select * from supplier");
			for(Supplier supplier : suppliers)
			{
				comboBoxSuppliersList.addItem(supplier.getM_ID());
			}
		} catch (ClassNotFoundException | SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		comboBoxSuppliersList.setBounds(179, 240, 201, 36);
		contentPane.add(comboBoxSuppliersList);
		
		JLabel lblExpiryDate = new JLabel("Expiry date");
		lblExpiryDate.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblExpiryDate.setBounds(15, 370, 126, 36);
		contentPane.add(lblExpiryDate);
		
		JSpinner spinnerDate = new JSpinner();
		spinnerDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		spinnerDate.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_YEAR));
		spinnerDate.setEditor(new JSpinner.DateEditor(spinnerDate, "dd/MM/yyyy"));

		spinnerDate.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) 
			{
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				try {
					if(!ProductsWithExpiryDate.IsExpired(format.format(spinnerDate.getValue())))
					{
						expiryDate = format.format(spinnerDate.getValue());
					}
					else
					{
						JOptionPane.showMessageDialog(null, "the date you entered is expired date");
					}
				} catch (HeadlessException | ParseException e) {
					e.printStackTrace();
				}
			}
		});
		spinnerDate.setBounds(179, 370, 201, 36);
		spinnerDate.setEnabled(false);
		contentPane.add(spinnerDate);
		
		JPanel panelNewProductData = new JPanel();
		panelNewProductData.setBackground(new Color(220,220,220));
		panelNewProductData.setBounds(15, 411, 365, 178);
		contentPane.add(panelNewProductData);
		panelNewProductData.setLayout(null);
		
		JLabel lblProductName = new JLabel("Product name");
		lblProductName.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblProductName.setBounds(0, 51, 139, 38);
		panelNewProductData.add(lblProductName);
		
		textFieldProductName = new JTextField();
		textFieldProductName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldProductName.setBounds(166, 49, 199, 38);
		panelNewProductData.add(textFieldProductName);
		textFieldProductName.setColumns(10);
		
		JCheckBox chckbxDateRequired = new JCheckBox("Date Required");
		chckbxDateRequired.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) 
			{
				if(chckbxDateRequired.isSelected())
				{
					spinnerDate.setEnabled(true);
				}
				else
				{
					spinnerDate.setEnabled(false);
				}
			}
		});
		chckbxDateRequired.setBackground(new Color(255, 255, 240));
		chckbxDateRequired.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxDateRequired.setBounds(0, 0, 164, 29);
		panelNewProductData.add(chckbxDateRequired);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblCategory.setBounds(0, 113, 139, 38);
		panelNewProductData.add(lblCategory);
		
		JComboBox comboBoxCategory = new JComboBox();
		comboBoxCategory.addItem("choose category");
		comboBoxCategory.addItem(eCategory.Coffee);
		comboBoxCategory.addItem(eCategory.Milk);
		comboBoxCategory.addItem(eCategory.Desert);
		comboBoxCategory.addItem(eCategory.Other);
		comboBoxCategory.setBounds(166, 113, 199, 38);
		panelNewProductData.setVisible(false);
		panelNewProductData.add(comboBoxCategory);
		
		comboBoxProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBoxProduct.getSelectedItem() == "choose product")
				{
					comboBoxProductID.setEnabled(false);
					spinnerAmount.setEnabled(false);
					spinnerDate.setEnabled(false);
				}
				else
				{
					comboBoxProductID.removeAllItems();
					comboBoxProductID.addItem("choose");
					spinnerAmount.setEnabled(true);
					switch((String)comboBoxProduct.getSelectedItem())
					{
					case "Cake":
						comboBoxProductID.addItem(eProductID.Chocolate_Cake);
						comboBoxProductID.addItem(eProductID.ChocolateChip_Cake);
						comboBoxProductID.addItem(eProductID.Vanilla_Cake);
						comboBoxProductID.addItem(eProductID.Cheese_Cake);
						spinnerDate.setEnabled(true);
						panelNewProductData.setVisible(false);
						break;
					case "Coffee":
						comboBoxProductID.addItem(eProductID.Red_Mug_Coffee);
						comboBoxProductID.addItem(eProductID.Testers_Choice_Coffee);
						comboBoxProductID.addItem(eProductID.Turkish_Coffee);
						spinnerDate.setEnabled(true);
						panelNewProductData.setVisible(false);
						break;
					case "Cup":
						comboBoxProductID.addItem(eProductID.Small_Cup);
						comboBoxProductID.addItem(eProductID.Medium_Cup);
						comboBoxProductID.addItem(eProductID.Large_Cup);
						spinnerDate.setEnabled(false);
						panelNewProductData.setVisible(false);
						break;
					case "Cupcake":
						comboBoxProductID.addItem(eProductID.Chocolate_CupCake);
						comboBoxProductID.addItem(eProductID.ChocolateChip_CupCake);
						comboBoxProductID.addItem(eProductID.Vanilla_CupCake);
						comboBoxProductID.addItem(eProductID.Cheese_CupCake);
						spinnerDate.setEnabled(true);
						panelNewProductData.setVisible(false);
						break;
					case "Milk":
						comboBoxProductID.addItem(eProductID.Milk_One_liter_1_Fat);
						comboBoxProductID.addItem(eProductID.Milk_One_liter_3_Fat);
						comboBoxProductID.addItem(eProductID.Milk_Two_liter_1_Fat);
						comboBoxProductID.addItem(eProductID.Milk_Two_liter_3_Fat);
						comboBoxProductID.addItem(eProductID.Soya_Milk_One_liter_1_Fat);
						comboBoxProductID.addItem(eProductID.Soya_Milk_One_liter_3_Fat);
						comboBoxProductID.addItem(eProductID.Soya_Milk_Two_liter_1_Fat);
						comboBoxProductID.addItem(eProductID.Soya_Milk_Two_liter_3_Fat);
						spinnerDate.setEnabled(true);
						panelNewProductData.setVisible(false);
						break;
					case "Sweeteners":
						comboBoxProductID.addItem(eProductID.white_Sugar);
						comboBoxProductID.addItem(eProductID.Brown_Sugar);
						comboBoxProductID.addItem(eProductID.Stevia);
						spinnerDate.setEnabled(true);
						panelNewProductData.setVisible(false);
						break;
					case "Teaspoon":
						comboBoxProductID.addItem(eProductID.teaspoon);
						spinnerDate.setEnabled(false);
						panelNewProductData.setVisible(false);
						break;
					case "Other":
						comboBoxProductID.addItem(eProductID.other);
						spinnerDate.setEnabled(false);
						panelNewProductData.setVisible(true);
					}
				}
			}
		});
		
		btn_Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					int value = (Integer) spinnerAmount.getValue();
	

						try {
							if(spinnerDate.isEnabled() && (DataBase.IsDataExists("select * from product where product_id = "
									+ ((eProductID)comboBoxProductID.getSelectedItem()).getNumVal() 
									+ " and expiry_date = '" + expiryDate + "';")) ||
									(!spinnerDate.isEnabled() && DataBase.IsDataExists("select * from product where product_id = "
											+ ((eProductID)comboBoxProductID.getSelectedItem()).getNumVal()))) 
							{
								JOptionPane.showMessageDialog(null, "product already exists");
							}

							else
							{
							Product product = null;
							Supplier productSupplier = null;
							for(Supplier supplier : suppliers)
							{
								if(supplier.getM_ID() == (String)comboBoxSuppliersList.getSelectedItem())
								{
									productSupplier = supplier;
								}
							}
							
							switch((String)comboBoxProduct.getSelectedItem())
							{
							case"Cake":
								product = new Cake((eProductID)comboBoxProductID.getSelectedItem(), expiryDate, value , productSupplier);
								product.Add();	
								break;
							case "Coffee":
								product = new Coffee((eProductID)comboBoxProductID.getSelectedItem(), expiryDate, value , productSupplier);
								product.Add();	
								break;
							case "Cup":
								product = new Cup((eProductID)comboBoxProductID.getSelectedItem(), value , productSupplier);
								product.Add();	
								break;
							case "Cupcake":
								product = new Cupcake((eProductID)comboBoxProductID.getSelectedItem(), expiryDate, value , productSupplier);
								product.Add();	
								break;
							case "Milk":
								product = new Milk((eProductID)comboBoxProductID.getSelectedItem(), expiryDate, value , productSupplier);
								product.Add();	
								break;
							case "Sweeteners":
								product = new Sweeteners((eProductID)comboBoxProductID.getSelectedItem(), expiryDate, value , productSupplier);
								product.Add();	
								break;
							case "Teaspoon":
								product = new Teaspoon((eProductID)comboBoxProductID.getSelectedItem(), value , productSupplier);
								product.Add();	
								break;	
							case "Other":
								if(chckbxDateRequired.isSelected())
								{
									product = new ProductsWithExpiryDate((eProductID)comboBoxProductID.getSelectedItem(), textFieldProductName.getText(), expiryDate, value, productSupplier, (eCategory)comboBoxCategory.getSelectedItem());
									product.Add();	
								}
								else
								{
									product = new ProductsWithNoExpiryDate((eProductID)comboBoxProductID.getSelectedItem(), textFieldProductName.getText(), value , productSupplier, (eCategory)comboBoxCategory.getSelectedItem());
									product.Add();
								}
								break;
							}
							JOptionPane.showMessageDialog(null, "Product added");

							}
						} catch (HeadlessException | ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			}
	
		});
	}
	
	public JButton getAddButton() {
		return this.btn_Add;
	}
}
