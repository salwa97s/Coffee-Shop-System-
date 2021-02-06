package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.DataBase;
import model.Order;
import model.Supplier;
import model.test;
import model.Product.eCategory;
import model.Product.eProductID;
import model.ProductInfo;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.SpinnerNumberModel;

public class AddOrder extends JFrame {

	private JPanel contentPane;
	private JLabel lblProductId;
	private JLabel lblAmount;
	JComboBox comboBoxCategory;
	private JButton btnOk;
	private JSpinner spinner;
	private LocalDate date;
	public static String product_id;
	public static String order_id;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddOrder frame = new AddOrder();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	private ArrayList<Supplier> suppliers = new ArrayList<Supplier>();

	/**
	 * Create the frame.
	 */
	public AddOrder() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddProduct.class.getResource("/addic.png")));
		setTitle("Add Order");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//
		setBounds(100, 100, 487, 526);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220,220,220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMakeOrder = new JLabel("ADD ORDER");
		
		lblMakeOrder.setBounds(15, 16, 298, 61);
		lblMakeOrder.setIcon(new ImageIcon(AddProduct.class.getResource("/addic.png")));
		lblMakeOrder.setFont(new Font("Stencil", Font.PLAIN, 30));
		contentPane.add(lblMakeOrder);
		
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(35, 124, 113, 36);
		lblCategory.setFont(new Font("Stencil", Font.PLAIN, 18));
		contentPane.add(lblCategory);
		
		
		lblProductId = new JLabel("Product ");
		lblProductId.setBounds(35, 189, 113, 36);
		lblProductId.setFont(new Font("Stencil", Font.PLAIN, 18));
		contentPane.add(lblProductId);
		
		lblAmount = new JLabel("Amount");
		lblAmount.setBounds(35, 250, 113, 36);
		lblAmount.setFont(new Font("Stencil", Font.PLAIN, 18));
		contentPane.add(lblAmount);
		
		JLabel lblSupplier = new JLabel("Supplier");
		lblSupplier.setBounds(35, 308, 113, 36);
		lblSupplier.setFont(new Font("Stencil", Font.PLAIN, 18));
		contentPane.add(lblSupplier);
		
		JLabel lblKgunits = new JLabel("kg/units");
		lblKgunits.setBounds(267, 259, 56, 16);
		contentPane.add(lblKgunits);
		
	
		//-----------------------------------------------
		
		//to set random order number	
		Random random = new Random();
		int randomNumber = random.nextInt(900) + 100;
		order_id=String.valueOf(randomNumber);  
			
		
		JComboBox comboBoxProduct = new JComboBox();
		comboBoxProduct.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxProduct.setBounds(187, 187,  201, 36);
		contentPane.add(comboBoxProduct);
		comboBoxProduct.setEnabled(false);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 500, 1));
		spinner.setBounds(187, 256, 65, 22);
		contentPane.add(spinner);
		spinner.setEnabled(false);
		
		
		JComboBox comboBoxSupplier = new JComboBox();
		comboBoxSupplier.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxSupplier.setBounds(187, 306, 201, 36);
		contentPane.add(comboBoxSupplier);
		comboBoxSupplier.setSelectedIndex(-1);

		/*try {
			suppliers= DataBase.Suppliers("select * from supplier");
			for(Supplier supplier : suppliers)
			{
				comboBoxSupplier.addItem(supplier.getM_ID());
			}
		} catch (ClassNotFoundException | SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}*/
	
		
		
		btnOk = new JButton("OK");
		contentPane.add(btnOk);
		btnOk.setBounds(316, 397, 126, 43);
		btnOk.setBackground(new Color(155,137,119));
		btnOk.setFont(new Font("Dialog", Font.PLAIN, 18));
		
		
		String[] categories= {"Coffee","Desert","Milk","Sweetener","Other"};
		comboBoxCategory = new JComboBox(categories);
		comboBoxCategory.setBounds(187, 122, 201, 36);
		comboBoxCategory.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxCategory .setSelectedIndex(-1);
		
		contentPane.add(comboBoxCategory);
		
		
		comboBoxCategory.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				spinner.setEnabled(true);
				comboBoxProduct.setEnabled(true);
				String categorystr=comboBoxCategory.getSelectedItem().toString();
				
				ArrayList<ProductInfo> products = null;
				try {
					comboBoxProduct.removeAllItems();
					//comboBoxProduct.addItem("choose");
					products = DataBase.ProductInfo("SELECT * from product");
        			/*String query = "SELECT product_id from orders where category =desert" ;
        			ResultSet result = DataBase.GetResult(query);
        			while(result.next()) 
        			System.out.println(result.getString(1));
        			comboBoxProduct.addItem(result.getString(1));*/			
        			}
        			catch (Exception e) {
        				JOptionPane.showMessageDialog(null, e.getMessage());
        		    }
				

				for(ProductInfo o : products) {
					if(o.getCategory().equals(categorystr)) {
					   comboBoxProduct.addItem(o.getProductID());
					}
				}		
			}
			
		});
		
		//choose category
		/*comboBoxCategory.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                //enables the button when an item is selected
            	comboBoxProduct.setEnabled(true);
                String category_str=comboBoxCategory.getSelectedItem().toString();
 
            		   try {
            			   
            		    comboBoxProduct.removeAllItems();
            			String query = "select product_name from product where category='"+ category_str
            						+"';";
            			ResultSet result = DataBase.GetResult(query);
            			while(result.next()) 
            			comboBoxProduct.addItem(result.getString(1));
            			 				
            			}
            			catch (Exception e) {
            				JOptionPane.showMessageDialog(null, e.getMessage());
            		    }
            		  
            }
	
		});	
		*/
		
		//choose product
		comboBoxProduct.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                //enables the spinner when an item is selected
            	spinner.setEnabled(true);
            	comboBoxSupplier.setEnabled(true);
            	String product_name_str=comboBoxProduct.getSelectedItem().toString();
            	  try {
       			   
            		comboBoxSupplier.removeAllItems();
            		suppliers= DataBase.Suppliers("select * from supplier");
            		for(Supplier supplier : suppliers)
            		{
            			comboBoxSupplier.addItem(supplier.getM_ID());
            		}	
          			}
          			catch (Exception e) {
          				JOptionPane.showMessageDialog(null, e.getMessage());
          		    }
            }
	
		});	
	
	   
	    
		btnOk.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if(spinner.getValue().equals(0))
				{
					JOptionPane.showMessageDialog(null, "Fill amount.");
				}
				else {	
				try {	
					date = LocalDate.now();
					String state="inProgress";
					DataBase.UpdateData("INSERT INTO orders (order_id, product_id,supplier_id, amount, order_date, order_state, category) "
							+ "VALUES ( '"+ order_id +"' , '"+((String)comboBoxProduct.getSelectedItem())+"' , '"
							+comboBoxSupplier.getSelectedItem().toString()+"' , '"+ spinner.getValue()+"' , '"+
							 date +"' , '"+state+"','"+comboBoxCategory.getSelectedItem().toString()+"'  );");	
					
					DataBase.UpdateData("UPDATE outofstock SET"+" order_state = '"+state+"' WHERE product_id = '" + ((String)comboBoxProduct.getSelectedItem()) + "';");
					 
					JOptionPane.showMessageDialog(null, "Order Sent to Supplier");
					contentPane.setVisible(false);
					dispose();
					}	 
				catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error. Close and try again.");
					}
				}
			}
		});
	}

	public JButton getOKButton() {
		return this.btnOk;
	}
}
