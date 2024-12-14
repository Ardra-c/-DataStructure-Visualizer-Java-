package com.kod.dsproject;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.kod.home.HomePage;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Array extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private int arr[];


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Array frame = new Array();
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
	public Array() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel heading = new JLabel("Array DS", SwingConstants.CENTER);
		heading.setForeground(new Color(0, 0, 0));
		heading.setBounds(191, 24, 192, 39);
		heading.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		contentPane.add(heading);
		
		JLabel sizeField = new JLabel("Size");
		sizeField.setForeground(new Color(0, 0, 0));
		sizeField.setFont(new Font("Times New Roman", Font.BOLD, 24));
		sizeField.setBounds(43, 101, 45, 28);
		contentPane.add(sizeField);
		
		textField = new JTextField();
		textField.setBounds(110, 106, 96, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel ElementField = new JLabel("Element");
		ElementField.setForeground(new Color(0, 0, 0));
		ElementField.setFont(new Font("Times New Roman", Font.BOLD, 22));
		ElementField.setBounds(10, 164, 78, 28);
		contentPane.add(ElementField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(110, 168, 96, 28);
		contentPane.add(textField_1);
		
		JLabel Position1 = new JLabel("POS");
		Position1.setForeground(new Color(0, 0, 0));
		Position1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		Position1.setBounds(236, 168, 56, 24);
		contentPane.add(Position1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(297, 168, 96, 28);
		contentPane.add(textField_2);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				String sizeText = textField.getText();
				int size = Integer.parseInt(sizeText);
				
				  arr = createArray(size);
				 JOptionPane.showMessageDialog(contentPane, "Array Created Successfully");
			
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(contentPane, "Invalid size. Please enter an integer.");
			}
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton.setBounds(297, 97, 96, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Insert");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				String elementText=textField_1.getText();
				String positionText =textField_2.getText();
				
				int element=Integer.parseInt(elementText);
				int position=Integer.parseInt(positionText);
				
				if(arr==null) {
					JOptionPane.showMessageDialog(contentPane,"Array is not created.Please create the array first.");
					return;
				}
				if(position<0 || position>=arr.length) {
					JOptionPane.showMessageDialog(contentPane,"Invalid position. Please enter a valid position (0 to " + (arr.length - 1) + ").");
					return;
				}
				arr[position]=element;
				JOptionPane.showMessageDialog(contentPane,"Element "+element+" inserted at position "+position);
				
			} catch(NumberFormatException ex){
				JOptionPane.showMessageDialog(contentPane, "Invalid input. Please enter valid numbers for element and position.");
	        }
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_1.setBounds(428, 159, 96, 40);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("POS");
		lblNewLabel_2_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_2_1.setBounds(32, 238, 56, 24);
		contentPane.add(lblNewLabel_2_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(110, 240, 96, 28);
		contentPane.add(textField_3);
		
		JButton btnNewButton_1_1 = new JButton("Delete");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String positionText = textField_3.getText();
					
					if(positionText.isEmpty()) {
						JOptionPane.showMessageDialog(contentPane, "Please enter the position to delete.");
		                return;
					}
					int position=Integer.parseInt(positionText);
					
					if (position < 0 || position >= arr.length) {
		                JOptionPane.showMessageDialog(contentPane, "Invalid position. Please enter a valid position (0 to " + (arr.length - 1) + ").");
		                return;
		            }
					arr[position] = 0;

		            JOptionPane.showMessageDialog(contentPane, "Element at position " + position + " deleted successfully.");
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(contentPane, "Invalid input. Please enter a valid position.");
		        }
				}
		});
		btnNewButton_1_1.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_1_1.setBounds(297, 231, 96, 40);
		contentPane.add(btnNewButton_1_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(73, 320, 316, 39);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton_1_2 = new JButton("Display");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (arr == null) {
		            JOptionPane.showMessageDialog(contentPane, "Array is not created. Please create the array first.");
		            return;
		        }
				StringBuilder arrayContent = new StringBuilder();
				for(int i=0;i<arr.length;i++) {
					arrayContent.append(arr[i]);
					if(i!=arr.length-1) {
						arrayContent.append(" ");
					}
				}
				textField_4.setText(arrayContent.toString());
			}
		});
		btnNewButton_1_2.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_1_2.setBounds(428, 320, 96, 40);
		contentPane.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_1_2 = new JButton("Back");
		btnNewButton_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage home = new HomePage();
				home.main(null);
				dispose();
			}
		});
		btnNewButton_1_1_2.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_1_1_2.setBounds(230, 380, 96, 40);
		contentPane.add(btnNewButton_1_1_2);
		
		JLabel lblNewLabel3 = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/Array.jpg")).getImage();
		lblNewLabel3.setIcon(new ImageIcon(img));
		lblNewLabel3.setBounds(0, 0, 602, 441);
		contentPane.add(lblNewLabel3);
	}	
		


	public static  int[] createArray(int size) {
							int arr[]=new int[size];
							return arr;
			}
}
