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
import model.ProductsWithExpiryDate;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class RemoveProduct extends JFrame {

	private JPanel contentPane;
	private JButton btnRemove;
	private ArrayList<Product> products;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveProduct frame = new RemoveProduct();
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
	public RemoveProduct() {
		setTitle("Remove Product");
		setIconImage(Toolkit.getDefaultToolkit().getImage(RemoveProduct.class.getResource("/Remove-product-icon.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 802, 412);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220,220,220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblRemoveProduct = new JLabel("REMOVE PRODUCT");
		lblRemoveProduct.setBounds(20, 21, 297, 45);
		lblRemoveProduct.setIcon(new ImageIcon(RemoveProduct.class.getResource("/Remove-product-icon.png")));
		lblRemoveProduct.setFont(new Font("Dialog", Font.PLAIN, 23));
		
		JLabel lblProductId = new JLabel("product to remove");
		lblProductId.setBounds(20, 130, 225, 38);
		lblProductId.setFont(new Font("Dialog", Font.PLAIN, 20));
		
		JComboBox comboBoxProducts = new JComboBox();
		comboBoxProducts.addItem("choose product");
		for(eProductID product : eProductID.values())
		{
			comboBoxProducts.addItem(product);
		}
		comboBoxProducts.setBounds(284, 130, 297, 39);
		comboBoxProducts.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBoxProducts.setBackground(new Color(227,226,224));
		
		
		btnRemove = new JButton("REMOVE");
		btnRemove.setBounds(623, 125, 126, 43);
		btnRemove.setBackground(new Color(155,137,119));
		btnRemove.setFont(new Font("Dialog", Font.PLAIN, 18));
		contentPane.setLayout(null);
		contentPane.add(lblRemoveProduct);
		contentPane.add(lblProductId);
		contentPane.add(comboBoxProducts);
		contentPane.add(btnRemove);
		
		JPanel panelSeveralProductsWithSameId = new JPanel();
		panelSeveralProductsWithSameId.setBackground(new Color(220,220,220));
		panelSeveralProductsWithSameId.setBounds(20, 220, 711, 120);
		contentPane.add(panelSeveralProductsWithSameId);
		panelSeveralProductsWithSameId.setVisible(false);
		panelSeveralProductsWithSameId.setLayout(null);
		
		JLabel lblNumberofproducts = new JLabel("");
		lblNumberofproducts.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNumberofproducts.setBounds(0, 0, 696, 45);
		panelSeveralProductsWithSameId.add(lblNumberofproducts);
		
		JComboBox comboBoxDates = new JComboBox();
		comboBoxDates.setBounds(10, 65, 337, 39);
		comboBoxDates.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBoxDates.setBackground(new Color(227,226,224));
		panelSeveralProductsWithSameId.add(comboBoxDates);
		
		JButton btnRemove_1 = new JButton("Remove");
		btnRemove_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnRemove_1.setBackground(new Color(155,137,119));
		btnRemove_1.setBounds(423, 61, 115, 43);
		panelSeveralProductsWithSameId.add(btnRemove_1);
		
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					products = DataBase.Products("select * from product where product_id = " + ((eProductID)comboBoxProducts.getSelectedItem()).getNumVal());
					if(products.size()>1)
					{
						lblNumberofproducts.setText("there are " + products.size() + " product of this item, choose the date of the one you want to remove");
						for(Product pr : products)
						{
							comboBoxDates.addItem(((ProductsWithExpiryDate)pr).getM_ExpireDate());
						}
						panelSeveralProductsWithSameId.setVisible(true);
						btnRemove.setEnabled(false);
					}
					else
					{
						panelSeveralProductsWithSameId.setVisible(false);
						btnRemove.setEnabled(true);
						products.get(0).delete();
						JOptionPane.showMessageDialog(null, "product removed");
					}
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		btnRemove_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ArrayList<ProductInfo> productss = null;
				try {
					/*products = DataBase.Products("SELECT * from product WHERE product_id = '"+ ((eProductID)comboBoxProducts.getSelectedItem()).getNumVal() + "' and expiry_date = '" + (String)comboBoxDates.getSelectedItem()+"';");
					for(Product pr : products)
					{
						pr.delete();
						JOptionPane.showMessageDialog(null, "product removed");
					}*/
					DataBase.UpdateData("DELETE FROM product WHERE product_id = '" + ((eProductID)comboBoxProducts.getSelectedItem()).getNumVal() + "' and expiry_date = '" + (String)comboBoxDates.getSelectedItem()+"';");
					productss = DataBase.ProductInfo("SELECT * FROM product WHERE product_id = '" + ((eProductID)comboBoxProducts.getSelectedItem()).getNumVal() + "';");
					String str = productss.get(0).getProductName().toLowerCase();
					System.out.println(str);
					DataBase.UpdateData("DELETE FROM " + str + " WHERE product_id = '"+ ((eProductID)comboBoxProducts.getSelectedItem()).getNumVal() +"' and expiry_date = '" + (String)comboBoxDates.getSelectedItem()+"';");
					JOptionPane.showMessageDialog(null, "product removed");
					
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		comboBoxProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				panelSeveralProductsWithSameId.setVisible(false);
				btnRemove.setEnabled(true);
			}
		});
	}

	public JButton getRemoveButton() {
		return this.btnRemove;
	}
}
