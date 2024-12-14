package com.kod.dsproject;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.kod.home.HomePage;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Stacks extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int s[];
	private int top=-1;
	private int size;
	private JTextField textField_2;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stacks frame = new Stacks();
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
	public Stacks() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel heading = new JLabel("Stack DS", SwingConstants.CENTER);
		heading.setForeground(new Color(0, 0, 0));
		heading.setBounds(191, 24, 192, 39);
		heading.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		contentPane.add(heading);
		
		JLabel sizeField = new JLabel("Size");
		sizeField.setForeground(new Color(0, 0, 0));
		sizeField.setFont(new Font("Times New Roman", Font.BOLD, 24));
		sizeField.setBounds(43, 101, 45, 28);
		contentPane.add(sizeField);
		
		JTextField textField = new JTextField();
		textField.setBounds(110, 106, 96, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel ElementField = new JLabel("Element");
		ElementField.setForeground(new Color(0, 0, 0));
		ElementField.setFont(new Font("Times New Roman", Font.BOLD, 22));
		ElementField.setBounds(10, 164, 78, 28);
		contentPane.add(ElementField);
		
		JTextField textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(110, 168, 96, 28);
		contentPane.add(textField_1);
		
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			        try {
			            String sizeText = textField.getText();
			            size = Integer.parseInt(sizeText);
			            s = new int[size];
			            top = -1; // Reset the stack
			            JOptionPane.showMessageDialog(contentPane, "Stack created successfully with size " + size);
			        } catch (NumberFormatException ex) {
			            JOptionPane.showMessageDialog(contentPane, "Invalid size. Please enter a valid integer.");
			        }
			    }
			});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton.setBounds(297, 97, 96, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Push");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				String elementText=textField_1.getText();
				
				int element=Integer.parseInt(elementText);
				
				if(s==null) {
					JOptionPane.showMessageDialog(contentPane,"Array is not created.Please create the array first.");
					return;
				}
				if(top==(size-1)) {
					JOptionPane.showMessageDialog(contentPane, "Stack Overflow: The stack is full and cannot accept more elements.", "Stack Full", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				s[++top]=element;
				
				JOptionPane.showMessageDialog(contentPane,"Element "+element+" pushed at top "+top);
				textField_1.setText("");
			
			} catch(NumberFormatException ex){
				JOptionPane.showMessageDialog(contentPane, "Invalid input. Please enter valid numbers for element and position.");
	        }
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_1.setBounds(297, 159, 96, 40);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("POS");
		lblNewLabel_2_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_2_1.setBounds(32, 238, 56, 24);
		contentPane.add(lblNewLabel_2_1);
		
		JTextField textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(110, 240, 96, 28);
		contentPane.add(textField_3);
		
		JButton btnNewButton_1_1_1 = new JButton("Get");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            if (s == null || top == -1) {
		                JOptionPane.showMessageDialog(contentPane, "Stack is empty or not created!");
		                return;
		            }
		            String positionText = textField_3.getText();
		            int position = Integer.parseInt(positionText);
		            if(position<1 || position>(top+1)) {
		            	JOptionPane.showMessageDialog(contentPane, "Invalid position! Enter a value between 1 and " + (top + 1));
		                return;
		            }
		            int element=s[position-1];
		            textField_2.setText(String.valueOf(element));
				}
				catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(contentPane, "Invalid input! Please enter a valid number for the position.");
		        }
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_1_1_1.setBounds(297, 231, 96, 40);
		contentPane.add(btnNewButton_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(476, 244, 96, 28);
		contentPane.add(textField_2);
		
		JButton btnNewButton_1_1 = new JButton("Pop");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (s == null) {
		                JOptionPane.showMessageDialog(contentPane, "Stack is not created. Please create the stack first.");
		                return;
		            }
					if (top == -1) {
		                JOptionPane.showMessageDialog(contentPane, 
		                    "Stack Underflow: The stack is empty and no elements to pop.", 
		                    "Stack Empty", 
		                    JOptionPane.WARNING_MESSAGE);
		                return;
		            }

		            int poppedElement=s[top];
		            top--;
		            JOptionPane.showMessageDialog(contentPane, "Element " + poppedElement + " popped from the stack.");
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(contentPane, "Invalid input. Please enter a valid position.");
		        }
				}
		});
		btnNewButton_1_1.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_1_1.setBounds(476, 159, 96, 40);
		contentPane.add(btnNewButton_1_1);
		
		JTextField textField_4 = new JTextField();
		textField_4.setBounds(73, 320, 316, 39);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton_1_2 = new JButton("Display");
		btnNewButton_1_2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Check if the stack is initialized and non-empty
		        if (s == null || top == -1) {
		            JOptionPane.showMessageDialog(contentPane, "Stack is empty!");
		            return;
		        }

		        // Build stack content as a string
		        StringBuilder stackContent = new StringBuilder();

		        // Traverse the stack from top to bottom
		        for (int i = top; i >= 0; i--) {
		            stackContent.append(s[i]);
		            if (i != 0) { // Add a space unless it's the last element
		                stackContent.append(" ");
		            }
		        }

		        // Display stack content in the text field
		        textField_4.setText(stackContent.toString());
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
		Image img = new ImageIcon(this.getClass().getResource("/stack.jpg")).getImage();
		lblNewLabel3.setIcon(new ImageIcon(img));
		lblNewLabel3.setBounds(0, 0, 628, 500);
		contentPane.add(lblNewLabel3);
		
		
	}
	
}
