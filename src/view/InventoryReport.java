package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.DataBase;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import java.awt.Color;

public class InventoryReport extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventoryReport frame = new InventoryReport();
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
	public InventoryReport() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InventoryReport.class.getResource("/report-icon.png")));
		setTitle("Inventory Report");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 734, 637);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.light"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInventoryReport = new JLabel("Inventory Report");
		lblInventoryReport.setForeground(Color.BLACK);
		lblInventoryReport.setIcon(new ImageIcon(UpdateProduct.class.getResource("/report-icon.png")));
		lblInventoryReport.setFont(new Font("Dialog", Font.PLAIN, 23));
		lblInventoryReport.setBounds(15, 16,297, 45);
		contentPane.add(lblInventoryReport);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setBounds(43, 90, 661, 479);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setViewportView(table);
		
		JLabel lblDate = new JLabel("DATE");
		lblDate.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblDate.setBounds(586, 30, 131, 21);
		lblDate.setText(MainMenu.GetDate());
		contentPane.add(lblDate);
	}
	
	public void setTable(ResultSet result) {
		table.setRowHeight(30);
		table.setModel(DbUtils.resultSetToTableModel(result));
	}
}
