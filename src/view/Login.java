package view;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.sqlite.SQLiteConnection;

import model.DataBase;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.UIManager;

public class Login extends JFrame {

	private JPasswordField passwordTextField;
	private JTextField IDtextField;
	private JLayeredPane layeredPane;
	private JButton loginButton;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	/**
	 * Create the frame.
	 */
	public Login() 
	{
		setTitle("Coffee Shop Mnagement System");
		Dimension screen = new Dimension(760,510);
		setBounds(0, 0,screen.width,screen.height - 30);

	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1919, 994);
		contentPane.add(layeredPane);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(new Color(220,220,220));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(294, 340, 136, 39);
		layeredPane.add(btnNewButton);
		loginButton = btnNewButton;

		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		
		JLabel Password_Label = new JLabel("");
		Password_Label.setBounds(199, 248, 40, 40);
		layeredPane.add(Password_Label);
		Password_Label.setIcon(new ImageIcon(Login.class.getResource("/Lock.png")));
		
		passwordTextField = new JPasswordField();
		passwordTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordTextField.setBounds(254, 249, 211, 39);
		layeredPane.add(passwordTextField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(UIManager.getColor("Button.highlight"));
		lblPassword.setBounds(254, 219, 158, 39);
		layeredPane.add(lblPassword);
		lblPassword.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 22));
		
		JLabel ID_Label = new JLabel("");
		ID_Label.setBounds(196, 175, 53, 40);
		layeredPane.add(ID_Label);
		ID_Label.setIcon(new ImageIcon(Login.class.getResource("/User.png")));
		
		IDtextField = new JTextField();
		IDtextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		IDtextField.setBounds(254, 175, 215, 39);
		layeredPane.add(IDtextField);
		IDtextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setForeground(UIManager.getColor("Button.highlight"));
		lblNewLabel.setBounds(254, 154, 69, 20);
		layeredPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 22));
		
		JLabel LoginLogo = new JLabel("");
		LoginLogo.setBounds(294, 24, 136, 135);
		layeredPane.add(LoginLogo);
		LoginLogo.setIcon(new ImageIcon(Login.class.getResource("/coffeelogo.png")));
		
		JLabel backgraondImage = new JLabel("");
		backgraondImage.setIcon(new ImageIcon(Login.class.getResource("/backco.png")));
		backgraondImage.setBounds(0, -485, 1921, 1398);
		layeredPane.add(backgraondImage);
	}

	public JButton getLoginButton() {
		return loginButton;
	}
	
	public JTextField getIDText() {
		return IDtextField;
	}
	
	public JPasswordField getPasswardText() {
		return passwordTextField;
	}
}
