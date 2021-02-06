package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import model.DataBase;
import model.Product;
import model.ProductChangedObservable;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.awt.List;
import java.awt.CardLayout;

import java.sql.*;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class MainMenu extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;
	private JPanel productObserverNullPanel;
	private JPanel productObserverNotNullPanel;
	private JLabel lblWokerName;
	private JButton btnMain,btnStock,btnOrders,btnReport,btnContacts;
	private JButton btnAddProducts,btnRemoveProduct,btnUpdateProduct,btnOutOfStock,btnSearchProduct,btnAddOrder,btnRemoveOrder,btnShowOrders;
	private JButton btnProductReport,btnSupplierReport,btnInventoryReport,btnValidityReport,btnSearch,btnAddContact,btnRemoveContact,btnUpdate;
	private JButton btnLogOut;
	public static ProductChangedObservable productObservable = new ProductChangedObservable();
	public static ProductChangedObserver productObserver;
	
	/**
	 * create Observer class;
	 */
	public class ProductChangedObserver implements Observer {
		
		private Product changedProduct;
		private ArrayList<Product> productList = new ArrayList<Product>();
		private  int minimumAmount = 50;
		
		@Override
	    public void update(Observable o, Object product) {
			changedProduct = (Product) product;
			if(changedProduct.getM_Amount() < minimumAmount) {
				productList.add(changedProduct);
				changePaneMain();
			}
		}
		
		public int getM_minimumAmount() {
			return minimumAmount;
		}
		
		public void setM_minimumAmount(int minimumAmount) {
			this.minimumAmount = minimumAmount;
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
		productObserver = new ProductChangedObserver();
		productObservable.addObserver(productObserver);
		setResizable(false);
		setTitle("Coffee Shop Inventory Managmeny System");
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0,screen.width,screen.height - 30);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane LogoPanel = new JLayeredPane();
		//LogoPanel.setForeground(Color.WHITE);
		LogoPanel.setBounds(0, 0, 1898, 77);
		LogoPanel.setBackground(new Color(170,168,167));
		contentPane.add(LogoPanel);
		
		JLabel lblNewLabel = new JLabel("Coffee Shop Inventory Management System");
		lblNewLabel.setIcon(new ImageIcon(MainMenu.class.getResource("/coffeeic.png")));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setBounds(436, 0, 898, 92);
		LogoPanel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 35));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(170,168,167));
		panel.setBounds(1900, 90, -1900, -90);
		LogoPanel.add(panel);
		
		btnLogOut = new JButton("Log Out");
		btnLogOut.setBackground(SystemColor.inactiveCaptionBorder);
		btnLogOut.setBorderPainted(false);
		btnLogOut.setIcon(new ImageIcon(MainMenu.class.getResource("/Logout-icon.png")));
		btnLogOut.setFont(new Font("Stencil", Font.PLAIN, 20));
		btnLogOut.setBounds(1697, 27, 172, 45);
		LogoPanel.add(btnLogOut);
		
		JPanel panel_Background = new JPanel();
		panel_Background.setBackground(new Color(255, 255, 255));
		panel_Background.setBounds(1069, 79, 852, 917);
		contentPane.add(panel_Background);
		panel_Background.setLayout(null);
		
		JLabel labelBackfround = new JLabel("");
		labelBackfround.setIcon(new ImageIcon(MainMenu.class.getResource("/background1.png")));
		labelBackfround.setBounds(-1567, 0, 2404, 933);
		panel_Background.add(labelBackfround);
		
		JLayeredPane DescriptionLayeredPaneI = new JLayeredPane();
		DescriptionLayeredPaneI.setBounds(279, 79, 792, 562);
		contentPane.add(DescriptionLayeredPaneI);
		DescriptionLayeredPaneI.setLayout(new CardLayout(0, 0));
		
		JPanel panel_Main = new JPanel();
		panel_Main.setBackground(new Color(44, 44, 44));
		DescriptionLayeredPaneI.add(panel_Main, "name_390897810716191");
		panel_Main.setLayout(null);
		
		JLabel lblTime = new JLabel("TIME");
		lblTime.setForeground(new Color(227, 226, 224));
		lblTime.setFont(new Font("Stencil", Font.PLAIN, 25));
		lblTime.setBounds(174, 13, 129, 53);
		panel_Main.add(lblTime);
		
		JLabel lblDate = new JLabel("DATE");
		lblDate.setForeground(new Color(227, 226, 224));
		lblDate.setFont(new Font("Stencil", Font.PLAIN, 25));
		lblDate.setBounds(15, 13, 144, 53);
		panel_Main.add(lblDate);
		
		lblWokerName = new JLabel("WokerName");
		lblWokerName.setForeground(new Color(227, 226, 224));
		lblWokerName.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		lblWokerName.setBounds(401, 16, 314, 40);
		lblWokerName.setText("Worker");
		panel_Main.add(lblWokerName);
		
		JLabel lblWorker = new JLabel("Worker :");
		lblWorker.setForeground(new Color(227, 226, 224));
		lblWorker.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		lblWorker.setBounds(315, 16, 110, 40);
		panel_Main.add(lblWorker);
		
		JLayeredPane ProductObserverLayeredPane = new JLayeredPane();
		ProductObserverLayeredPane.setBounds(50, 118, 691, 402);
		panel_Main.add(ProductObserverLayeredPane);
		ProductObserverLayeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel_ProductObserverNull = new JPanel();
		ProductObserverLayeredPane.add(panel_ProductObserverNull, "name_1403806678124");
		panel_ProductObserverNull.setBackground(new Color(220,220,220));
		productObserverNullPanel = panel_ProductObserverNull;
		panel_ProductObserverNull.setLayout(null);
		
		JLabel lblInventoryFull = new JLabel("The Inventory Full!");
		lblInventoryFull.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblInventoryFull.setBounds(195, 128, 283, 86);
		panel_ProductObserverNull.add(lblInventoryFull);
		
		JPanel panel_ProductObserverNotNull = new JPanel();
		ProductObserverLayeredPane.add(panel_ProductObserverNotNull, "name_1408391071265");
		panel_ProductObserverNotNull.setBackground(new Color(220,220,220));
		productObserverNotNullPanel = panel_ProductObserverNotNull;
		panel_ProductObserverNotNull.setLayout(null);
		
		JLabel lblMustOrder = new JLabel("Must Order Today:");
		lblMustOrder.setForeground(new Color(72, 72, 74));
		lblMustOrder.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblMustOrder.setBounds(217, 0, 252, 66);
		panel_ProductObserverNotNull.add(lblMustOrder);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 69, 0));
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 17));
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setBounds(12, 69, 667, 320);
		panel_ProductObserverNotNull.add(scrollPane);
		
		String[] column_headers = {"Product ID", "Category","Amount"};
		tableModel = new DefaultTableModel(column_headers, 0);
		table = new JTable(tableModel);
		table.setRowHeight(30);
		table.getColumnModel().getColumn(0).setPreferredWidth(280);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		table.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPane.setViewportView(table);
		setProductObserverLayerdPane();
		
		Thread clock = new Thread()
		{
			public void run() 
			{
				try {
					for(;;) {
						Calendar cal = new GregorianCalendar(); 
						int second = cal.get(Calendar.SECOND);
						int minute = cal.get(Calendar.MINUTE);
						int hour = cal.get(Calendar.HOUR_OF_DAY);
						
						lblTime.setText(hour + ":" + minute + ":" + second);
						lblDate.setText(GetDate());
						
						sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		clock.start();
		
		JPanel panel_Stock = new JPanel();
		panel_Stock.setBackground(new Color(44, 44, 44));
		DescriptionLayeredPaneI.add(panel_Stock, "name_390897845093396");
		panel_Stock.setLayout(null);
		panel_Stock.setVisible(false);
		
		JPanel panel_StockTitle = new JPanel();
		panel_StockTitle.setBounds(0, 0, 792, 69);
		panel_StockTitle.setBackground(new Color(227, 226, 224));
		panel_Stock.add(panel_StockTitle);
		panel_StockTitle.setLayout(null);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setFont(new Font("Stencil", Font.PLAIN, 23));
		lblStock.setBounds(0, 0, 107, 69);
		panel_StockTitle.add(lblStock);

		
		btnOutOfStock = new JButton("Out Of Stock");
		//btnOutOfStock.setForeground(new Color(226,227,224));
		btnOutOfStock.setHorizontalAlignment(SwingConstants.LEFT);
		btnOutOfStock.setIcon(new ImageIcon(MainMenu.class.getResource("/Empty-icon.png")));
		btnOutOfStock.setBounds(419, 263, 279, 89);
		panel_Stock.add(btnOutOfStock);
		btnOutOfStock.setBackground(new Color(155,137,119));
		btnOutOfStock.setBorderPainted(false);
		btnOutOfStock.setFont(new Font("Stencil", Font.PLAIN, 20));
		
		btnAddProducts = new JButton("Add Products");
		btnAddProducts.setBorderPainted(false);
		btnAddProducts.setHorizontalAlignment(SwingConstants.LEFT);
		btnAddProducts.setIcon(new ImageIcon(MainMenu.class.getResource("/Add-Product-icon.png")));
		btnAddProducts.setFont(new Font("Stencil", Font.PLAIN, 20));
		btnAddProducts.setBounds(44, 120, 279, 89);
		panel_Stock.add(btnAddProducts);
		//btnAddProducts.setBorderPainted(true);
		//btnAddProducts.setBorder(new LineBorder(Color.WHITE));
		btnAddProducts.setBackground(new Color(155,137,119));
		
		btnRemoveProduct = new JButton("Remove Product");
		btnRemoveProduct.setBorderPainted(false);
		btnRemoveProduct.setHorizontalAlignment(SwingConstants.LEFT);
		btnRemoveProduct.setIcon(new ImageIcon(MainMenu.class.getResource("/Remove-product-icon.png")));
		btnRemoveProduct.setBackground(new Color(150,118,87));
		btnRemoveProduct.setFont(new Font("Stencil", Font.PLAIN, 20));
		btnRemoveProduct.setBounds(419, 120, 279, 89);
		panel_Stock.add(btnRemoveProduct);
		
		btnUpdateProduct = new JButton("Update");
		btnUpdateProduct.setBorderPainted(false);
		btnUpdateProduct.setHorizontalAlignment(SwingConstants.LEFT);
		btnUpdateProduct.setIcon(new ImageIcon(MainMenu.class.getResource("/edit-icon.png")));
		btnUpdateProduct.setBackground(new Color(150,118,87));
		btnUpdateProduct.setFont(new Font("Stencil", Font.PLAIN, 20));
		btnUpdateProduct.setBounds(44, 263, 279, 89);
		panel_Stock.add(btnUpdateProduct);
		
		btnSearchProduct = new JButton("Search");
		btnSearchProduct.setBorderPainted(false);
		btnSearchProduct.setHorizontalAlignment(SwingConstants.LEFT);
		btnSearchProduct.setIcon(new ImageIcon(MainMenu.class.getResource("/search.png")));
		btnSearchProduct.setBackground(new Color(150,118,87));
		btnSearchProduct.setFont(new Font("Stencil", Font.PLAIN, 20));
		btnSearchProduct.setBounds(223, 402, 279, 89);
		panel_Stock.add(btnSearchProduct);
		
		JPanel panel_Orders = new JPanel();
		panel_Orders.setBackground(new Color(44, 44, 44));
		DescriptionLayeredPaneI.add(panel_Orders, "name_390897879205540");
		panel_Orders.setLayout(null);
		panel_Orders.setVisible(false);
		
		JPanel panel_OrderTitle = new JPanel();
		panel_OrderTitle.setBackground(new Color(227, 226, 224));
		panel_OrderTitle.setBounds(0, 0, 792, 71);
		panel_Orders.add(panel_OrderTitle);
		panel_OrderTitle.setLayout(null);
		
		JLabel lblOrdersTitle = new JLabel("Orders");
		lblOrdersTitle.setFont(new Font("Stencil", Font.PLAIN, 23));
		lblOrdersTitle.setBounds(0, 0, 100, 71);
		panel_OrderTitle.add(lblOrdersTitle);
		
		

		btnAddOrder = new JButton("Add Order");
		btnAddOrder.setBorderPainted(false);
		btnAddOrder.setFont(new Font("Stencil", Font.PLAIN, 20));
		btnAddOrder.setBackground(new Color(150,118,87));
		btnAddOrder.setIcon(new ImageIcon(MainMenu.class.getResource("/Add-Cart-icon.png")));
		btnAddOrder.setHorizontalAlignment(SwingConstants.LEFT);
		btnAddOrder.setBounds(59, 155, 261, 121);
		panel_Orders.add(btnAddOrder);
		
		btnRemoveOrder = new JButton("Remove Order");
		btnRemoveOrder.setBorderPainted(false);
		btnRemoveOrder.setBackground(new Color(150,118,87));
		btnRemoveOrder.setHorizontalAlignment(SwingConstants.LEFT);
		btnRemoveOrder.setFont(new Font("Stencil", Font.PLAIN, 20));
		btnRemoveOrder.setIcon(new ImageIcon(MainMenu.class.getResource("/Remove-Cart-icon.png")));
		btnRemoveOrder.setBounds(426, 155, 261, 121);
		panel_Orders.add(btnRemoveOrder);
		
		
		btnShowOrders = new JButton("Show");
		btnShowOrders.setBorderPainted(false);
		btnShowOrders.setBackground(new Color(155,137,119));
		btnShowOrders.setFont(new Font("Stencil", Font.PLAIN, 20));
		btnShowOrders.setIcon(new ImageIcon(MainMenu.class.getResource("/Show-icon.png")));
		btnShowOrders.setHorizontalAlignment(SwingConstants.LEFT);
		btnShowOrders.setBounds(241, 334, 261, 121);
		panel_Orders.add(btnShowOrders);
		
		JPanel panel_Report = new JPanel();
		panel_Report.setBackground(new Color(44, 44, 44));
		DescriptionLayeredPaneI.add(panel_Report, "name_390897910634973");
		panel_Report.setLayout(null);
		panel_Report.setVisible(false);
		
		JPanel panel_ReportTitle = new JPanel();
		panel_ReportTitle.setBackground(new Color(227, 226, 224));
		panel_ReportTitle.setBounds(0, 0, 792, 69);
		panel_Report.add(panel_ReportTitle);
		panel_ReportTitle.setLayout(null);
		
		JLabel lblReport = new JLabel("Report");
		lblReport.setFont(new Font("Stencil", Font.PLAIN, 23));
		lblReport.setBounds(0, 0, 123, 69);
		panel_ReportTitle.add(lblReport);
		
		JPanel panel_Contacts = new JPanel();
		panel_Contacts.setBackground(new Color(44,44,44));
		DescriptionLayeredPaneI.add(panel_Contacts, "name_390897939933719");
		panel_Contacts.setLayout(null);
		panel_Contacts.setVisible(false);
		
		JPanel panel_ContactsTitle = new JPanel();
		panel_ContactsTitle.setBounds(0, 0, 792, 71);
		panel_ContactsTitle.setBackground(new Color(227, 226, 224));
		panel_Contacts.add(panel_ContactsTitle);
		panel_ContactsTitle.setLayout(null);
		
		JLabel lblContacts = new JLabel("Contacts");
		lblContacts.setFont(new Font("Stencil", Font.PLAIN, 25));
		lblContacts.setBounds(0, 0, 165, 71);
		panel_ContactsTitle.add(lblContacts);
		
		btnAddContact = new JButton("Add Contact");
		btnAddContact.setBorderPainted(false);
		btnAddContact.setHorizontalAlignment(SwingConstants.LEFT);
		btnAddContact.setFont(new Font("Stencil", Font.PLAIN, 20));
		btnAddContact.setIcon(new ImageIcon(MainMenu.class.getResource("/Add-User-icon.png")));
		btnAddContact.setBackground(new Color(155,137,119));
		btnAddContact.setBounds(428, 165, 259, 124);
		panel_Contacts.add(btnAddContact);
		
		btnRemoveContact = new JButton("Remove Contact");
		btnRemoveContact.setBorderPainted(false);
		btnRemoveContact.setHorizontalAlignment(SwingConstants.LEFT);
		btnRemoveContact.setIcon(new ImageIcon(MainMenu.class.getResource("/Remove-User-icon.png")));
		btnRemoveContact.setBackground(new Color(155,137,119));
		btnRemoveContact.setFont(new Font("Stencil", Font.PLAIN, 20));
		btnRemoveContact.setBounds(86, 358, 259, 124);
		panel_Contacts.add(btnRemoveContact);
		
		btnSearch = new JButton("Search");
		btnSearch.setBorderPainted(false);
		btnSearch.setHorizontalAlignment(SwingConstants.LEFT);
		btnSearch.setIcon(new ImageIcon(MainMenu.class.getResource("/Search-icon.png")));
		btnSearch.setBackground(new Color(150,118,87));
		btnSearch.setFont(new Font("Stencil", Font.PLAIN, 20));
		btnSearch.setBounds(86, 165, 259, 124);
		panel_Contacts.add(btnSearch);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setBorderPainted(false);
		btnUpdate.setHorizontalAlignment(SwingConstants.LEFT);
		btnUpdate.setIcon(new ImageIcon(MainMenu.class.getResource("/Show-icon.png")));
		btnUpdate.setBackground(new Color(150,118,87));
		btnUpdate.setFont(new Font("Stencil", Font.PLAIN, 20));
		btnUpdate.setBounds(428, 358, 259, 124);
		panel_Contacts.add(btnUpdate);
		
		JLayeredPane NotificationLayeredPane = new JLayeredPane();
		NotificationLayeredPane.setBounds(279, 643, 792, 351);
		contentPane.add(NotificationLayeredPane);
		NotificationLayeredPane.setLayout(null);
		
		JPanel panel_Notification = new JPanel();
		panel_Notification.setFocusTraversalKeysEnabled(false);
		panel_Notification.setBounds(0, 0, 797, 362);
		NotificationLayeredPane.add(panel_Notification);
		panel_Notification.setBackground(new Color(59,59,58));
		panel_Notification.setLayout(null);
		
		JLabel lblNotification = new JLabel("Notification");
		lblNotification.setForeground(new Color(227, 226, 224));
		lblNotification.setFont(new Font("Snap ITC", Font.PLAIN, 23));
		lblNotification.setBounds(15, 16, 204, 51);
		panel_Notification.add(lblNotification);
		
		JLayeredPane MenuLayeredPane = new JLayeredPane();
		MenuLayeredPane.setBounds(0, 79, 279, 917);
		contentPane.add(MenuLayeredPane);
		MenuLayeredPane.setLayout(null);
		
		JPanel panel_MenuOptions = new JPanel();
		panel_MenuOptions.setBackground(new Color(227, 226, 224));
		panel_MenuOptions.setBounds(0, 0, 279, 917);
		MenuLayeredPane.add(panel_MenuOptions);
		panel_MenuOptions.setLayout(null);
		
		btnMain = new JButton("Main");
		btnMain.setBounds(0, 0, 274, 111);
		panel_MenuOptions.add(btnMain);
		btnMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_Main.setVisible(true);
				panel_Stock.setVisible(false);
				panel_Contacts.setVisible(false);
				panel_Orders.setVisible(false);
				panel_Report.setVisible(false);
			}
		});
		btnMain.setBackground(new Color(227, 226, 224));
		btnMain.setBorderPainted(false);
		btnMain.setHorizontalAlignment(SwingConstants.LEFT);
		btnMain.setIcon(new ImageIcon(MainMenu.class.getResource("/Very-Basic-Menu-icon.png")));
		btnMain.setFont(new Font("Stencil", Font.PLAIN, 25));
		
		btnStock = new JButton("Stock");
		btnStock.setBounds(0, 111, 274, 111);
		panel_MenuOptions.add(btnStock);
		btnStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_Stock.setVisible(true);
				panel_Main.setVisible(false);
				panel_Contacts.setVisible(false);
				panel_Orders.setVisible(false);
				panel_Report.setVisible(false);
			}
		});
		btnStock.setBackground(new Color(227, 226, 224));
		btnStock.setBorderPainted(false);
		btnStock.setHorizontalAlignment(SwingConstants.LEFT);
		btnStock.setIcon(new ImageIcon(MainMenu.class.getResource("/stockic.png")));
		btnStock.setFont(new Font("Stencil", Font.PLAIN, 25));
		
		btnOrders = new JButton("ORDERS");
		btnOrders.setBounds(0, 222, 274, 111);
		panel_MenuOptions.add(btnOrders);
		btnOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_Orders.setVisible(true);
				panel_Main.setVisible(false);
				panel_Stock.setVisible(false);
				panel_Contacts.setVisible(false);
				panel_Report.setVisible(false);
			}
		});
		btnOrders.setBackground(new Color(227, 226, 224));
		btnOrders.setBorderPainted(false);
		btnOrders.setIcon(new ImageIcon(MainMenu.class.getResource("/orderic.png")));
		btnOrders.setFont(new Font("Stencil", Font.PLAIN, 25));
		btnOrders.setHorizontalAlignment(SwingConstants.LEFT);
		
		btnContacts = new JButton("Contacts");
		btnContacts.setBounds(0, 444, 274, 111);
		panel_MenuOptions.add(btnContacts);
		btnContacts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_Contacts.setVisible(true);
				panel_Main.setVisible(false);
				panel_Stock.setVisible(false);
				panel_Orders.setVisible(false);
				panel_Report.setVisible(false);
			}
		});
		btnContacts.setBackground(new Color(227, 226, 224));
		btnContacts.setBorderPainted(false);
		btnContacts.setHorizontalAlignment(SwingConstants.LEFT);
		btnContacts.setIcon(new ImageIcon(MainMenu.class.getResource("/contactsic.png")));
		btnContacts.setFont(new Font("Stencil", Font.PLAIN, 25));
		
		btnReport = new JButton("Report");
		btnReport.setBounds(0, 333, 274, 111);
		panel_MenuOptions.add(btnReport);
		btnReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_Report.setVisible(true);
				panel_Main.setVisible(false);
				panel_Stock.setVisible(false);
				panel_Contacts.setVisible(false);
				panel_Orders.setVisible(false);
			}
		});
		btnReport.setBorderPainted(false);
		btnReport.setHorizontalAlignment(SwingConstants.LEFT);
		btnReport.setIcon(new ImageIcon(MainMenu.class.getResource("/reportic.png")));
		btnReport.setFont(new Font("Stencil", Font.PLAIN, 25));
		btnReport.setBackground(new Color(227, 226, 224));
		
		btnProductReport = new JButton("Product Report");
		btnProductReport.setBorderPainted(false);
		btnProductReport.setBackground(new Color(155,137,119));
		btnProductReport.setIcon(new ImageIcon(MainMenu.class.getResource("/report-icon.png")));
		btnProductReport.setHorizontalAlignment(SwingConstants.LEFT);
		btnProductReport.setFont(new Font("Stencil", Font.PLAIN, 20));
		btnProductReport.setBounds(60, 154, 313, 115);
		panel_Report.add(btnProductReport);
		
		btnSupplierReport = new JButton("Supplier Report");
		btnSupplierReport.setBorderPainted(false);
		btnSupplierReport.setBackground(new Color(150,118,87));
		btnSupplierReport.setIcon(new ImageIcon(MainMenu.class.getResource("/report-icon.png")));
		btnSupplierReport.setHorizontalAlignment(SwingConstants.LEFT);
		btnSupplierReport.setFont(new Font("Stencil", Font.PLAIN, 20));
		btnSupplierReport.setBounds(437, 154, 313, 115);
		panel_Report.add(btnSupplierReport);
		
		btnInventoryReport = new JButton("Inventory Report");
		btnInventoryReport.setBorderPainted(false);
		btnInventoryReport.setBackground(new Color(150,118,87));
		btnInventoryReport.setIcon(new ImageIcon(MainMenu.class.getResource("/report-icon.png")));
		btnInventoryReport.setHorizontalAlignment(SwingConstants.LEFT);
		btnInventoryReport.setFont(new Font("Stencil", Font.PLAIN, 20));
		btnInventoryReport.setBounds(60, 325, 313, 115);
		panel_Report.add(btnInventoryReport);
		
		btnValidityReport = new JButton("ID'S Report");
		btnValidityReport.setBorderPainted(false);
		btnValidityReport.setBackground(new Color(155,137,119));
		btnValidityReport.setIcon(new ImageIcon(MainMenu.class.getResource("/report-icon.png")));
		btnValidityReport.setFont(new Font("Stencil", Font.PLAIN, 20));
		btnValidityReport.setHorizontalAlignment(SwingConstants.LEFT);
		btnValidityReport.setBounds(437, 325, 313, 115);
		panel_Report.add(btnValidityReport);
	}
	
	public static String GetDate() {			
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				
		return dateFormat.format(date);
	}

	private void changePaneMain() {
		if (productObserver.productList == null) {
			productObserverNullPanel.setVisible(true);
			productObserverNotNullPanel.setVisible(false);
		}
		else {
			productObserverNullPanel.setVisible(false);
			productObserverNotNullPanel.setVisible(true);
			updateTable(); 
		}
	}

	private void setProductObserverLayerdPane() {
		try {
			String query = "select * from product";
			ArrayList<Product> productList = DataBase.Products(query);
			for (Product product : productList) {
				productObservable.notifyProductChanged(Integer.toString(product.getM_ProductID().getNumVal()));
				}
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
		    }
	}
	
	private void updateTable() {
		String query;
		boolean isOrdered;
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
        table.setRowSorter(sorter);
        ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
        sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
        sortKeys.add(new RowSorter.SortKey(2, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);
		try {
			clearTable();
			for(Product product : productObserver.productList) {
				query ="select * from orders where product_id = " + product.getM_ProductID().getNumVal();
				isOrdered = DataBase.IsDataExists(query);
				if(!isOrdered) {
				String[] data = {product.getM_ProductID().getNumVal()+" - "+product.getM_ProductID(),""+product.getM_Category(),""+product.getM_Amount()};
				tableModel.addRow(data);
				}
			}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
	    }
	}
	
	private void clearTable() {
		if(table!=null) 
		{
			DefaultTableModel dm = (DefaultTableModel)table.getModel();
			while(dm.getRowCount() > 0)
			{
				dm.removeRow(0);
			}
		}
	}
	
	public void setWorkerName(String workerName) {
		lblWokerName.setText(workerName);
	}
	
	public JButton getbtnAddProducts() {
		return this.btnAddProducts;
	}
	public JButton getbtnRemoveProduct() {
		return this.btnRemoveProduct;
	}
	public JButton getbtnUpdateProduct() {
		return this.btnUpdateProduct;
	}
	public JButton getbtnOutOfStock() {
		return this.btnOutOfStock;
	}
	public JButton getbtnSearchProduct() {
		return this.btnSearchProduct;
	}
	public JButton getbtnAddOrder() {
		return this.btnAddOrder;
	}
	public JButton getbtnRemoveOrder() {
		return this.btnRemoveOrder;
	}
	public JButton getbtnShowOrders() {
		return this.btnShowOrders;
	}
	public JButton getbtnProductReport() {
		return this.btnProductReport;
	}
	public JButton getbtnSupplierReport() {
		return this.btnSupplierReport;
	}
	public JButton getbtnInventoryReport() {
		return this.btnInventoryReport;
	}
	public JButton getbtnValidityReport() {
		return this.btnValidityReport;
	}
	public JButton getbtnSearch() {
		return this.btnSearch;
	}
	public JButton getbtnAddContact() {
		return this.btnAddContact;
	}
	public JButton getbtnRemoveContact() {
		return this.btnRemoveContact;
	}
	public JButton getbtnUpdate() {
		return this.btnUpdate;
	}
	public JButton getLogOutbtn() {
		return this.btnLogOut;
	}
}
