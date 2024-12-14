package com.kod.dsproject;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.kod.home.HomePage;

import java.awt.Color;

public class Queue extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int q[];
	private int size;
	private int front=-1;
	private int rear=-1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Queue frame = new Queue();
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
	public Queue() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel heading = new JLabel("Queue DS", SwingConstants.CENTER);
		heading.setForeground(new Color(0, 0, 0));
		heading.setBounds(201, 25, 192, 39);
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
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			        try {
			            String sizeText = textField.getText();
			            size = Integer.parseInt(sizeText);
			            q = new int[size];
			            rear = -1; // Reset the stack
			            JOptionPane.showMessageDialog(contentPane, "Queue created successfully with size " + size);
			        } catch (NumberFormatException ex) {
			            JOptionPane.showMessageDialog(contentPane, "Invalid size. Please enter a valid integer.");
			        }
			    }
			});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton.setBounds(297, 97, 96, 40);
		contentPane.add(btnNewButton);
		
		JLabel ElementField = new JLabel("Element");
		ElementField.setForeground(new Color(0, 0, 0));
		ElementField.setFont(new Font("Times New Roman", Font.BOLD, 22));
		ElementField.setBounds(10, 164, 78, 28);
		contentPane.add(ElementField);
		
		JTextField textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(110, 168, 96, 28);
		contentPane.add(textField_1);
		
		JButton btnNewButton_1 = new JButton("Enqueue");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(q==null) {
						JOptionPane.showMessageDialog(contentPane, "Queue is not created. Please create the queue first.");
		                return;
					}
					String elementText = textField_1.getText();
					int element=Integer.parseInt(elementText);
					
					if(rear==size-1) {
						JOptionPane.showMessageDialog(contentPane, "Queue Overflow: Unable to insert the element as the queue is full.", "Queue Full", JOptionPane.WARNING_MESSAGE);
						return;
					}
					q[++rear]=element;
					JOptionPane.showMessageDialog(contentPane, "Element " + element + " inserted successfully at position " + (rear + 1) + ".");
		            textField_1.setText("");
				} catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(contentPane, "Invalid input! Please enter a valid integer.", "Input Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_1.setBounds(297, 164, 106, 40);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Dequeue");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (q == null) {
		                JOptionPane.showMessageDialog(contentPane, "Queue is not created. Please create the queue first.");
		                return;
		            }
					if(rear==-1 || front==(size-1)) {
						JOptionPane.showMessageDialog(contentPane, "Queue Underflow: The queue is empty and no element can be deleted.", "Queue Empty", JOptionPane.WARNING_MESSAGE);
							return;
					}
					++front;
					int deletedElement = q[front];
					q[front]=0;
					
					 if (front == rear) {
			                front = -1; // Reset front
			                rear = -1; // Reset rear
			            }
					JOptionPane.showMessageDialog(contentPane, "Element " + deletedElement + " deleted successfully.");
		            textField_1.setText(String.valueOf(deletedElement));
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(contentPane, "An unexpected error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			}
		});
		btnNewButton_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_1_1.setBounds(480, 164, 106, 40);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("POS");
		lblNewLabel_2_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_2_1.setBounds(32, 238, 56, 24);
		contentPane.add(lblNewLabel_2_1);
		
		JTextField textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(110, 240, 96, 28);
		contentPane.add(textField_3);
		
		JButton btnNewButton_2 = new JButton("Get");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(rear==-1 || front==(size-1)) {
						JOptionPane.showMessageDialog(contentPane, "Queue Underflow: The queue is empty and no element can be deleted.", "Queue Empty", JOptionPane.WARNING_MESSAGE);
							return;
					}
					String positionText = textField_3.getText();
		            int position = Integer.parseInt(positionText);
		            if (position < 1 || position > (rear - front)) {
		                JOptionPane.showMessageDialog(contentPane, "Invalid position! Enter a value between 1 and " + (rear - front));
		                return;
		            }
		            int element=q[position-1];
		            textField_2.setText(String.valueOf(element));
				}
				catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(contentPane, "Invalid input! Please enter a valid number for the position.");
		        }
			}
		});
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_2.setBounds(297, 231, 96, 40);
		contentPane.add(btnNewButton_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(480, 244, 96, 28);
		contentPane.add(textField_2);
		
		JTextField textField_4 = new JTextField();
		textField_4.setBounds(73, 320, 316, 39);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton_2_1 = new JButton("Display");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(rear==-1 || front==(size-1)) {
						JOptionPane.showMessageDialog(contentPane, "Queue Underflow: The queue is empty and no element can be deleted.", "Queue Empty", JOptionPane.WARNING_MESSAGE);
							return;
					}
					 StringBuilder queueContent = new StringBuilder();
					 for(int i=0;i<=rear;i++) {
						 queueContent.append(q[i]+" ");
						 if (i != 0) { // Add a space unless it's the last element
				                queueContent.append(" ");
				            }
						 textField_4.setText(queueContent.toString());
				}
			}
		});
		btnNewButton_2_1.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_2_1.setBounds(480, 320, 106, 40);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage home = new HomePage();
				home.main(null);
				dispose();
			}
		});
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_3.setBounds(247, 391, 96, 40);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel3 = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/array.jpg")).getImage();
		lblNewLabel3.setIcon(new ImageIcon(img));
		lblNewLabel3.setBounds(-111, 0, 788, 474);
		contentPane.add(lblNewLabel3);
		
		
		
	}
}
