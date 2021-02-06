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

import java.awt.Frame;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

public class SupplierReport extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupplierReport frame = new SupplierReport();
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
	public SupplierReport() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SupplierReport.class.getResource("/report-icon.png")));
		setTitle("Supplier Report");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1128, 462);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.light"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSupplierReport = new JLabel("Supplier Report");
		lblSupplierReport.setIcon(new ImageIcon(UpdateProduct.class.getResource("/report-icon.png")));
		lblSupplierReport.setFont(new Font("Dialog", Font.PLAIN, 23));
		lblSupplierReport.setBounds(23, 16, 297, 45);
		contentPane.add(lblSupplierReport);
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setBounds(23, 77, 1051, 299);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		
		JLabel lblDate = new JLabel("DATE");
		lblDate.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblDate.setBounds(967, 26, 124, 29);
		lblDate.setText(MainMenu.GetDate());
		contentPane.add(lblDate);
	}
	
	public void setTable(ResultSet result) {
		table.setModel(DbUtils.resultSetToTableModel(result));
	}
}
