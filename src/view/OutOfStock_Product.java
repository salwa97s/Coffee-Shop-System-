package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import model.DataBase;
import model.Supplier;
import model.Worker;
import net.proteanit.sql.DbUtils;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JScrollPane;

public class OutOfStock_Product extends JFrame {

	private JPanel contentPane;
	private JButton button_Close;
	private JButton btnOrder;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OutOfStock_Product frame = new OutOfStock_Product();
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
	public OutOfStock_Product() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(OutOfStock_Product.class.getResource("/Empty-icon.png")));
		setTitle("Out Of Stock");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 970, 582);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220,220,220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblOutOfStock = new JLabel("OUT OF STOCK PRODUCTS");
		lblOutOfStock.setBounds(17, 29, 378, 45);
		lblOutOfStock.setIcon(new ImageIcon(OutOfStock_Product.class.getResource("/Empty-icon.png")));
		lblOutOfStock.setFont(new Font("Dialog", Font.PLAIN, 23));
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setBounds(61, 102, 838, 326);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
	
		button_Close = new JButton("CLOSE");
		button_Close.setBounds(211, 460, 126, 43);
		button_Close.setBackground(new Color(155,137,119));
		button_Close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_Close.setFont(new Font("Dialog", Font.PLAIN, 18));
		
		btnOrder = new JButton("ORDER");
		btnOrder.setBounds(41, 460, 126, 43);
		btnOrder.setBackground(new Color(155,137,119));
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddOrder addOrder =  new AddOrder();
				addOrder.setVisible(true);
				addOrder.setLocationRelativeTo(null);
			}
		});
		btnOrder.setFont(new Font("Dialog", Font.PLAIN, 18));
		contentPane.setLayout(null);
		contentPane.add(lblOutOfStock);
		contentPane.add(btnOrder);
		contentPane.add(button_Close);
		
	}
	
	public void setTable(ResultSet result) {
		table.setRowHeight(30);
		table.setModel(DbUtils.resultSetToTableModel(result));
	}
}