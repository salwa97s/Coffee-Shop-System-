package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.DataBase;
import model.FormUtils;
import model.FormUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RemoveContact extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldID;
	private JButton btnRemove;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveContact frame = new RemoveContact();
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
	public RemoveContact() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RemoveContact.class.getResource("/Remove-User-icon.png")));
		setTitle("Remove Contact");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 460, 379);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220,220,220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(460, 375));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblContactType = new JLabel("Contact Type");
		lblContactType.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblContactType.setBounds(34, 112, 142, 38);
		contentPane.add(lblContactType);
		
		JComboBox comboBoxContactType = new JComboBox();
		comboBoxContactType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxContactType.addItem("Choose");
		comboBoxContactType.addItem("Worker");
		comboBoxContactType.addItem("Supplier");
		comboBoxContactType.setBounds(191, 112, 221, 38);
		contentPane.add(comboBoxContactType);
		
		JLabel lblId = new JLabel("Enter ID");
		lblId.setFont(new Font("Stencil", Font.PLAIN, 20));
		lblId.setBounds(34, 183, 108, 38);
		contentPane.add(lblId);
		
		textFieldID = new JTextField();
		textFieldID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldID.setBounds(191, 181, 221, 38);
		contentPane.add(textFieldID);
		textFieldID.setColumns(10);
		
		btnRemove = new JButton("Remove");
		btnRemove.setBackground(new Color(155,137,119));
		btnRemove.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((String)comboBoxContactType.getSelectedItem() == "Choose" || !FormUtils.isNumeric(textFieldID.getText()))
				{
					JOptionPane.showMessageDialog(null, "Some data is missing");
				}
				else
				{
					try {
						if((String)comboBoxContactType.getSelectedItem() == "Worker") 
						{
							DataBase.UpdateData("DELETE FROM Worker WHERE id = '"+ textFieldID.getText() +"' ;");
						}
						else
						{
							DataBase.UpdateData("DELETE FROM supplier WHERE supplier_id = '"+ textFieldID.getText() +"' ;");
						}
						JOptionPane.showMessageDialog(null, "Contact Got Removed");
						contentPane.setVisible(false);
						dispose();
					}
					catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		btnRemove.setBounds(279, 260, 133, 44);
		contentPane.add(btnRemove);
		
		JLabel lblRemoveContact = new JLabel("Remove Contact");
		lblRemoveContact.setIcon(new ImageIcon(RemoveContact.class.getResource("/Remove-User-icon.png")));
		lblRemoveContact.setBackground(new Color(218, 165, 32));
		lblRemoveContact.setFont(new Font("Stencil", Font.PLAIN, 20));
		lblRemoveContact.setBounds(15, 16, 248, 55);
		contentPane.add(lblRemoveContact);
		
		JLabel lblIderor = new JLabel("");
		lblIderor.setForeground(Color.RED);
		lblIderor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIderor.setBounds(104, 260, 231, 25);
		contentPane.add(lblIderor);
	
		textFieldID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) 
			{
				if(FormUtils.isNumeric(textFieldID.getText()))
				{
					lblIderor.setText("");
				}
				else
				{
					lblIderor.setText("invalid input, digits only");
				}
			}
		});
	}
	
	public JButton getRemoveButton() {
		return this.btnRemove;
	}
}
