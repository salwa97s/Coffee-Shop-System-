package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.DataBase;
import model.Product;
import model.ProductInfo;
import model.Product.eProductID;
import model.Supplier;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.JSpinner;

public class UpdateProduct extends JFrame {

	private JPanel MainPanel;
	private JButton btn_Edit,btn_Done;
	private  Connection connection = null;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateProduct frame = new UpdateProduct();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private ArrayList<Product> products;
	private ArrayList<Supplier> suppliers;
	/**
	 * Create the frame.
	 */
	public UpdateProduct() {
		try {
			suppliers = DataBase.Suppliers("select * from supplier");
		} catch (ClassNotFoundException | SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		setIconImage(Toolkit.getDefaultToolkit().getImage(UpdateProduct.class.getResource("/edit-icon.png")));
		setTitle("Update Product");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 672, 683);
		MainPanel = new JPanel();
		MainPanel.setBackground(new Color(220,220,220));
		MainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(MainPanel);
		
		JLabel lblUpdateProduct = new JLabel("UPDATE PRODUCT");
		lblUpdateProduct.setBounds(20, 21, 297, 45);
		lblUpdateProduct.setIcon(new ImageIcon(UpdateProduct.class.getResource("/edit-icon.png")));
		lblUpdateProduct.setFont(new Font("Dialog", Font.PLAIN, 23));
		
		JLabel lblProduct = new JLabel("Choose Product");
		lblProduct.setBounds(20, 82, 155, 50);
		lblProduct.setFont(new Font("Stencil", Font.PLAIN, 18));
		
		btn_Edit = new JButton("Edit");
		btn_Edit.setBounds(481, 90, 126, 43);
		btn_Edit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_Edit.setBackground(new Color(155,137,119));
		
		JPanel panel_updates = new JPanel();
		panel_updates.setBounds(20, 162, 587, 419);
		panel_updates.setBackground(new Color(220,220,220));
		panel_updates.setVisible(false);
		
		JLabel label = new JLabel("Product ID");
		label.setBounds(15, 16, 140, 38);
		label.setFont(new Font("Dialog", Font.PLAIN, 20));
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setBounds(15, 63, 140, 38);
		lblProductName.setFont(new Font("Dialog", Font.PLAIN, 20));
		
		JLabel lblProductAmount = new JLabel("Amount");
		lblProductAmount.setBounds(15, 211, 140, 38);
		lblProductAmount.setFont(new Font("Dialog", Font.PLAIN, 20));
		
		JLabel lblSupplierId = new JLabel("Supplier ID");
		lblSupplierId.setBounds(15, 270, 140, 38);
		lblSupplierId.setFont(new Font("Dialog", Font.PLAIN, 20));
		
		JLabel lblProductCategory = new JLabel("Category");
		lblProductCategory.setBounds(15, 110, 140, 38);
		lblProductCategory.setFont(new Font("Dialog", Font.PLAIN, 20));
		
		btn_Done = new JButton("Done");
		btn_Done.setBounds(329, 360, 126, 43);
		btn_Done.setFont(new Font("Dialog", Font.PLAIN, 18));
		btn_Done.setBackground(new Color(155,137,119));
		MainPanel.setLayout(null);
		MainPanel.add(lblUpdateProduct);
		MainPanel.add(lblProduct);
		MainPanel.add(btn_Edit);
		MainPanel.add(panel_updates);
		panel_updates.setLayout(null);
		panel_updates.add(label);
		panel_updates.add(lblProductName);
		panel_updates.add(lblProductAmount);
		panel_updates.add(lblProductCategory);
		panel_updates.add(lblSupplierId);
		panel_updates.add(btn_Done);
		
		JComboBox comboBoxSupplier = new JComboBox();
		comboBoxSupplier.addItem("choose");
		comboBoxSupplier.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxSupplier.setBounds(209, 271, 246, 38);
		panel_updates.add(comboBoxSupplier);
		
		JSpinner SpinnerAmount = new JSpinner();
		SpinnerAmount.setFont(new Font("Tahoma", Font.PLAIN, 18));
		SpinnerAmount.setBounds(209, 211, 246, 38);
		panel_updates.add(SpinnerAmount);
		
		JLabel lblProductId = new JLabel("");
		lblProductId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProductId.setBounds(209, 16, 246, 38);
		panel_updates.add(lblProductId);
		
		JLabel lblName = new JLabel("");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setBounds(209, 63, 246, 38);
		panel_updates.add(lblName);
		
		JLabel lblCategory = new JLabel("");
		lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCategory.setBounds(209, 110, 246, 38);
		panel_updates.add(lblCategory);
		
		JLabel lblsupplieridold = new JLabel("");
		lblsupplieridold.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblsupplieridold.setBounds(470, 270, 86, 38);
		panel_updates.add(lblsupplieridold);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Choose");
		for(eProductID product : eProductID.values())
		{
			comboBox.addItem(product);
		}
		
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setBounds(207, 87, 226, 45);
		MainPanel.add(comboBox);
		
		btn_Edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Supplier supp : suppliers)
				{
					comboBoxSupplier.addItem(supp.getM_ID());
				}
				panel_updates.setVisible(true);
				ArrayList<ProductInfo> productsinfo = null;
				
				
				try {
					productsinfo = DataBase.ProductInfo("SELECT * FROM product WHERE product_id = '" + ((eProductID)comboBox.getSelectedItem()).getNumVal() + "';");
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
				
				if(productsinfo.size()!= 0) {
					lblName.setText(productsinfo.get(0).getProductName());
					lblCategory.setText(productsinfo.get(0).getCategory());
					lblProductId.setText(productsinfo.get(0).getProductID()); 
					lblsupplieridold.setText(productsinfo.get(0).getSuplierID());
					SpinnerAmount.setValue(Integer.parseInt(productsinfo.get(0).getAmount()));
				}
				else {
					panel_updates.setVisible(false);
					JOptionPane.showMessageDialog(null, "product does not exist");
				}
				
				
				/*try {
					products = DataBase.Products("select * from product");
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
				lblName.setText(products.get(0).getM_Name());
				lblCategory.setText(products.get(0).getM_Category().toString());
				lblProductId.setText(Integer.toString(products.get(0).getM_ProductID().getNumVal())); 
				SpinnerAmount.setValue(products.get(0).getM_Amount());*/
			}	
		});
		
		btn_Done.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				ArrayList<ProductInfo> productsinfo = null;
				try {
					productsinfo = DataBase.ProductInfo("SELECT * FROM product WHERE product_id = '" + ((eProductID)comboBox.getSelectedItem()).getNumVal() + "';");
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
				int t = (int)SpinnerAmount.getValue();
				productsinfo.get(0).setAmount(""+t+"");
				for(Supplier supp : suppliers)
				{
					if(supp.getM_ID() == comboBoxSupplier.getSelectedItem())
					{
						String s = (String) comboBoxSupplier.getSelectedItem();
						productsinfo.get(0).setSuplierID(s);
					}
				}
				
				/*
				products.get(0).setM_Amount((int)SpinnerAmount.getValue());
				for(Supplier supp : suppliers)
				{
					if(supp.getM_ID() == comboBoxSupplier.getSelectedItem())
					{
						products.get(0).setM_Supplier(supp);
					}
				}*/
				JOptionPane.showMessageDialog(null, "Product got edited");
			}
		});
	}

	public JButton getEnterButton() {
		return this.btn_Edit;
	}
	
	public JButton getDoneButton() {
		return this.btn_Done;
	}
}
