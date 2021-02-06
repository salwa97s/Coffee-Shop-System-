package view;

import java.awt.BorderLayout;
import java.awt.Color;
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
import java.awt.ComponentOrientation;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

public class ValidityReport extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ValidityReport frame = new ValidityReport();
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
	public ValidityReport() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ValidityReport.class.getResource("/report-icon.png")));
		setTitle("ID'S Report");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 603);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.light"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblValidityReport = new JLabel("ID'S Report");
		lblValidityReport.setBackground(new Color(255, 255, 255));
		lblValidityReport.setIcon(new ImageIcon(UpdateProduct.class.getResource("/report-icon.png")));
		lblValidityReport.setFont(new Font("Dialog", Font.PLAIN, 23));
		lblValidityReport.setBounds(15, 25, 297, 45);
		contentPane.add(lblValidityReport);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setBounds(15, 86, 548, 445);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		
		JLabel lblDate = new JLabel("DATE");
		lblDate.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblDate.setBounds(447, 34, 192, 31);
		lblDate.setText(MainMenu.GetDate());
		contentPane.add(lblDate);
	}
	
	public void setTable(ResultSet result) {
		table.setRowHeight(30);
		table.setModel(DbUtils.resultSetToTableModel(result));
	}
}
