package com.kod.dsproject;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CircularQueue extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_3;
	private int q[];
	private int size;
	private int front=-1;
	private int rear=-1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CircularQueue frame = new CircularQueue();
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
	public CircularQueue() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel heading = new JLabel("Circular Queue", SwingConstants.CENTER);
		heading.setForeground(new Color(0, 0, 0));
		heading.setBounds(128, 32, 254, 31);
		heading.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		contentPane.add(heading);
		
		JLabel ElementField = new JLabel("Size");
		ElementField.setForeground(new Color(0, 0, 0));
		ElementField.setFont(new Font("Times New Roman", Font.BOLD, 22));
		ElementField.setBounds(23, 108, 78, 28);
		contentPane.add(ElementField);
		
		JTextField textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(128, 108, 96, 32);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            String sizeText = textField_1.getText();
		            size = Integer.parseInt(sizeText);
		            q = new int[size];
		            rear = -1; // Reset the stack
		            JOptionPane.showMessageDialog(contentPane, "Queue created successfully with size " + size);
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(contentPane, "Invalid size. Please enter a valid integer.");
		        }
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 17));
		btnNewButton.setBounds(298, 101, 109, 44);
		contentPane.add(btnNewButton);
		
		JLabel ElementField_1 = new JLabel("Element");
		ElementField_1.setForeground(Color.BLACK);
		ElementField_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		ElementField_1.setBounds(23, 192, 78, 28);
		contentPane.add(ElementField_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(128, 192, 96, 32);
		contentPane.add(textField);
		
		JButton btnNewButton_1 = new JButton("Enqueue");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(q==null) {
						JOptionPane.showMessageDialog(contentPane, "Queue is not created. Please create the queue first.", "Error", JOptionPane.ERROR_MESSAGE);
		                return;
					}
					 if ((rear + 1) % size == front) {
			                // Queue is full (circular condition)
			                JOptionPane.showMessageDialog(contentPane, "Queue Overflow: The queue is full.", "Error", JOptionPane.ERROR_MESSAGE);
			                return;
			            }
					 String elementText = textField.getText(); 
			         int element = Integer.parseInt(elementText);
			         
			         if (front == -1) {
			                // First element to be inserted
			                front = 0;
			                rear = 0;
			            } else {
			                // Move rear to the next position in a circular manner
			                rear = (rear + 1) % size;
			            }
			         q[rear] = element; // Insert the element
			            JOptionPane.showMessageDialog(contentPane, "Element " + element + " inserted successfully at position " + rear, "Success", JOptionPane.INFORMATION_MESSAGE);
			        } catch (NumberFormatException ex) {
			            JOptionPane.showMessageDialog(contentPane, "Invalid input! Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
			        } catch (Exception ex) {
			            JOptionPane.showMessageDialog(contentPane, "An unexpected error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			        }
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 17));
		btnNewButton_1.setBounds(298, 185, 109, 44);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Dequeue");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (q == null) {
		                JOptionPane.showMessageDialog(contentPane, "Queue is not created. Please create the queue first.", "Error", JOptionPane.ERROR_MESSAGE);
		                return;
				}
					 if (front == -1) {
			                // Queue is empty
			                JOptionPane.showMessageDialog(contentPane, "Queue Underflow: The queue is empty and no element can be deleted.", "Error", JOptionPane.ERROR_MESSAGE);
			                return;
			            }

			            int dequeuedElement = q[front];
			            if (front == rear) {
			                // Only one element in the queue, reset the queue
			                front = -1;
			                rear = -1;
			            } else {
			                // Move the front pointer to the next position in a circular manner
			                front = (front + 1) % size;
			            }

			            // Display the removed element
			            JOptionPane.showMessageDialog(contentPane, "Element " + dequeuedElement + " removed successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
			            textField.setText(String.valueOf(dequeuedElement));
			        } catch (Exception ex) {
			            JOptionPane.showMessageDialog(contentPane, "An unexpected error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			        }
			}
		});
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 17));
		btnNewButton_2.setBounds(445, 185, 109, 44);
		contentPane.add(btnNewButton_2);
		
		JTextField textField_2 = new JTextField();
		textField_2.setBounds(72, 284, 316, 39);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Peek");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            if (q == null) {
		                JOptionPane.showMessageDialog(contentPane, "Queue is not created. Please create the queue first.", "Error", JOptionPane.ERROR_MESSAGE);
		                return;
		            }

		            if (front == -1) {
		                // Queue is empty
		                textField_2.setText("Queue is empty. No element to peek.");
		                return;
		            }

		            // Set the element at the front to textField_2
		            textField_2.setText("Element at the front: " + q[front]);
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(contentPane, "An unexpected error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        }
			}
		});
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 17));
		btnNewButton_3.setBounds(438, 272, 118, 51);
		contentPane.add(btnNewButton_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(72, 378, 316, 39);
		contentPane.add(textField_3);
		
		JButton btnNewButton_3_1 = new JButton("Display");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 if (q == null) {
			                JOptionPane.showMessageDialog(contentPane, "Queue is not created. Please create the queue first.", "Error", JOptionPane.ERROR_MESSAGE);
			                return;
			            }
					if(front==-1) {
						textField_3.setText("Queue is empty.");
		                return;
					}
					StringBuilder queueContent = new StringBuilder();

		            int i = front;
		            while (true) {
		                queueContent.append(q[i]).append(" ");
		                if (i == rear) {
		                    break;
		                }
		                i = (i + 1) % q.length; // Circular increment
		            }

		            textField_3.setText(queueContent.toString().trim());
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(contentPane, "An unexpected error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_3_1.setFont(new Font("Arial", Font.BOLD, 17));
		btnNewButton_3_1.setBounds(438, 366, 118, 51);
		contentPane.add(btnNewButton_3_1);
		
		JButton btnNewButton_3_2 = new JButton("Back");
		btnNewButton_3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage home = new HomePage();
				home.main(null);
				dispose();
			}
		});
		btnNewButton_3_2.setFont(new Font("Arial", Font.BOLD, 17));
		btnNewButton_3_2.setBounds(217, 462, 118, 51);
		contentPane.add(btnNewButton_3_2);

		JLabel lblNewLabel3 = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/Array.jpg")).getImage();
		lblNewLabel3.setIcon(new ImageIcon(img));
		lblNewLabel3.setBounds(0, -28, 589, 570);
		contentPane.add(lblNewLabel3);
		
	}

}
