package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import model.DataBase;
import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;
import javax.swing.*;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;


public class ProductReport extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public  Connection connection = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductReport frame = new ProductReport();
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
	public ProductReport() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ProductReport.class.getResource("/report-icon.png")));
		setTitle("Product Report");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 901, 578);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.light"));
		contentPane.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.setIgnoreRepaint(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		JLabel lblProductReport = new JLabel("Product Report");
		lblProductReport.setIcon(new ImageIcon(UpdateProduct.class.getResource("/report-icon.png")));
		lblProductReport.setIgnoreRepaint(true);
		lblProductReport.setBounds(28, 16, 297, 45);
		lblProductReport.setFont(new Font("Dialog", Font.PLAIN, 23));
		GridBagConstraints gbc_lblProductreportjava = new GridBagConstraints();
		gbc_lblProductreportjava.insets = new Insets(0, 0, 5, 5);
		gbc_lblProductreportjava.gridx = 0;
		gbc_lblProductreportjava.gridy = 0;
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 33));
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setBounds(28, 98, 835, 407);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridx = 3;
		gbc_scrollPane.gridy = 2;
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setIgnoreRepaint(true);
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		
		contentPane.setLayout(null);
		contentPane.add(lblProductReport);
		contentPane.add(scrollPane);
		
		JLabel lblDate = new JLabel("DATE");
		lblDate.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblDate.setBounds(732, 25, 192, 31);
		lblDate.setText(MainMenu.GetDate());
		contentPane.add(lblDate);
	}
	
	public void setTable(ResultSet result) {
		table.setModel(DbUtils.resultSetToTableModel(result));
	}
}
