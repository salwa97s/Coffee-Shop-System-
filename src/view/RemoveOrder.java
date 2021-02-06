package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.DataBase;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class RemoveOrder extends JFrame {

	private JPanel contentPane;
	private JButton btnRemove;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveOrder frame = new RemoveOrder();
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
	public RemoveOrder() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RemoveOrder.class.getResource("/removeic.png")));
		setTitle("Remove Order");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 459, 402);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220,220,220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		JLabel lblDeleteOrder = new JLabel("DELETE ORDER");
		lblDeleteOrder.setBounds(15, 16, 298, 61);
		lblDeleteOrder.setIcon(new ImageIcon(AddProduct.class.getResource("/removeic.png")));
		lblDeleteOrder.setFont(new Font("Stencil", Font.PLAIN, 30));
		contentPane.add(lblDeleteOrder);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(165, 130, 201, 36);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(comboBox);
		
		
		JLabel lblOrderid = new JLabel("Order_ID");
		lblOrderid.setBounds(34, 132, 113, 36);
		lblOrderid.setFont(new Font("Stencil", Font.PLAIN, 18));
		contentPane.add(lblOrderid);
		
		JCheckBox chckbxDoYouWant = new JCheckBox("Do You want to update a Product");
		chckbxDoYouWant.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxDoYouWant.setForeground(Color.BLACK);
		chckbxDoYouWant.setBounds(34, 208, 332, 25);
		chckbxDoYouWant.setBackground(new Color(220,220,220));
		contentPane.add(chckbxDoYouWant);
		chckbxDoYouWant.setEnabled(false);
		
		btnRemove = new JButton("REMOVE");
		btnRemove.setBounds(280, 285, 124, 36);
		btnRemove.setBackground(new Color(155,137,119));
		btnRemove.setFont(new Font("Dialog", Font.PLAIN, 18));
		contentPane.add(btnRemove);
		btnRemove.setEnabled(true);
		
		//to fill combobox with order_ids
		try {
			   
			String query = "SELECT order_id FROM orders";
			ResultSet result = DataBase.GetResult(query);

			while(result.next()) 
			comboBox.addItem(result.getString(1));
			

			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
		    }
		
		  comboBox.setSelectedIndex(-1);
		  
		  JButton btnUpdate = new JButton("Update");
		  btnUpdate.setFont(new Font("Dialog", Font.PLAIN, 18));
		  btnUpdate.setEnabled(false);
		  btnUpdate.setBackground(new Color(155, 137, 119));
		  btnUpdate.setBounds(124, 285, 124, 36);
		  contentPane.add(btnUpdate);
		  comboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
            	chckbxDoYouWant.setEnabled(true);
       		    
            }
	
		});	
	//-------------------------------------------------------------------------	
		chckbxDoYouWant.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		        	btnUpdate.setEnabled(true);
		        } else {//checkbox has been deselected
		        	btnUpdate.setEnabled(false);
		        };
		    }
		});
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateProduct updateP =  new UpdateProduct();
				updateP.setVisible(true);
				updateP.setLocationRelativeTo(null);
			}
		});
		
	//-----------------------------------------------------------------------------	
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String state="null";
			try {	
				
				String order_str=comboBox.getSelectedItem().toString();
				String query="delete from orders where order_id='"+order_str+"';";
				DataBase.UpdateData(query);
				JOptionPane.showMessageDialog(null, "Order removed. Email sent to supplier.");
				contentPane.setVisible(false);
				dispose();
						
				}
			  catch (Exception e) {
  				JOptionPane.showMessageDialog(null, "Error. Close and try again.");
  		    }
			
		}
			
	});
		
		
		
	}

	public JButton getRemoveButton() {
		return this.btnRemove;
	}
}
