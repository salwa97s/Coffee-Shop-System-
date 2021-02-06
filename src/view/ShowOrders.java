package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.sun.prism.paint.Color;

import model.DataBase;
import net.proteanit.sql.DbUtils;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class ShowOrders extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowOrders frame = new ShowOrders();
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
	public ShowOrders() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ShowOrders.class.getResource("/Show-icon.png")));
		setTitle("Orders");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 901, 578);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.setIgnoreRepaint(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	
			
		JLabel lblProductReport = new JLabel("Orders Table ");
		lblProductReport.setIgnoreRepaint(true);
		lblProductReport.setBounds(42, 33, 297, 45);
		lblProductReport.setIcon(new ImageIcon(UpdateProduct.class.getResource("/Show-icon.png")));
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
		lblDate.setFont(new Font("Dialog", Font.PLAIN, 23));
		lblDate.setBounds(717, 40, 192, 31);
		lblDate.setText(MainMenu.GetDate());
		contentPane.add(lblDate);
	}
	
	public void setTable(ResultSet result) {
		table.setRowHeight(30);
		table.setModel(DbUtils.resultSetToTableModel(result));
	}
}
