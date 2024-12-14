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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.kod.home.HomePage;

public class SingleLinkedList extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	class Node {
        Node pl;
        int data;
        Node nl;
    }
	Node first=null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SingleLinkedList frame = new SingleLinkedList();
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
	public SingleLinkedList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel heading = new JLabel("SingleLinked List", SwingConstants.CENTER);
		heading.setForeground(new Color(0, 0, 0));
		heading.setBounds(170, 23, 233, 31);
		heading.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		contentPane.add(heading);
		
		JLabel ElementField_1 = new JLabel("Element");
		ElementField_1.setForeground(Color.BLACK);
		ElementField_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		ElementField_1.setBounds(25, 94, 78, 28);
		contentPane.add(ElementField_1);
		
		JTextField textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(130, 90, 96, 32);
		contentPane.add(textField);
		
		JButton btnNewButton = new JButton("<html><div align='center'>Insert<br>at Front</div></html>");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    String elementText = textField.getText();
                    if (elementText.isEmpty()) {
                        JOptionPane.showMessageDialog(contentPane, "Input field is empty! Please enter a value.", "Error", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    int element = Integer.parseInt(elementText);

                    Node newNode = new Node();
                    newNode.data = element;
                    newNode.pl = null;
                    newNode.nl = null;

                    if (first == null) {
                        first = newNode;
                    } else {
                        newNode.nl = first;
                        first.pl = newNode;
                        first = newNode;
                    }
                    JOptionPane.showMessageDialog(contentPane, "Element " + element + " inserted at the front successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(contentPane, "Invalid input! Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
                }
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 17));
		btnNewButton.setBounds(268, 82, 109, 51);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("<html><div align='center'>Insert<br>at Rear</div></html>");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    String elementText = textField.getText();
                    if (elementText.isEmpty()) {
                        JOptionPane.showMessageDialog(contentPane, "Input field is empty! Please enter a value.", "Error", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    int element = Integer.parseInt(elementText);

                    Node newNode = new Node();
                    newNode.data = element;
                    newNode.pl = null;
                    newNode.nl = null;

                    if (first == null) {
                        first = newNode;
                        JOptionPane.showMessageDialog(contentPane, "Element " + element + " added as the first node.");
                    } else {
                        Node temp = first;
                        while (temp.nl != null) {
                            temp = temp.nl;
                        }
                        temp.nl = newNode;
                        newNode.pl = temp;
                        JOptionPane.showMessageDialog(contentPane, "Element " + element + " added successfully to the linked list.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(contentPane, "Invalid input! Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
                }
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 17));
		btnNewButton_1.setBounds(415, 82, 109, 51);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("<html><div align='center'>Delete<br>From Front</div></html>");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    if (first == null) {
                        JOptionPane.showMessageDialog(contentPane, "The list is empty. No elements to delete.", "Error", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    if (first.nl == null) {
                        JOptionPane.showMessageDialog(contentPane, "Element " + first.data + " deleted. The list is now empty.");
                        first = null;
                    } else {
                        JOptionPane.showMessageDialog(contentPane, "Element " + first.data + " deleted from the front.");
                        first = first.nl;
                        first.pl = null;
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(contentPane, "An unexpected error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
			}
		});
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 17));
		btnNewButton_2.setBounds(130, 183, 138, 51);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("<html><div align='center'>Delete<br>From Rear</div></html>");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    if (first == null) {
                        JOptionPane.showMessageDialog(contentPane, "The list is empty! Nothing to delete.", "Error", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    if (first.nl == null) {
                        JOptionPane.showMessageDialog(contentPane, "Element " + first.data + " deleted. The list is now empty.", "List Empty", JOptionPane.INFORMATION_MESSAGE);
                        first = null;
                    } else {
                        Node temp = first;
                        while (temp.nl != null) {
                            temp = temp.nl;
                        }
                        JOptionPane.showMessageDialog(contentPane, "Element " + temp.data + " deleted from the rear successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        temp.pl.nl = null;
                        temp.pl = null;
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(contentPane, "An unexpected error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
			}
		});
		btnNewButton_2_1.setFont(new Font("Arial", Font.BOLD, 17));
		btnNewButton_2_1.setBounds(330, 183, 123, 51);
		contentPane.add(btnNewButton_2_1);
		
		JTextField textField_2 = new JTextField();
		textField_2.setBounds(72, 284, 316, 39);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("<html><div align='center'>Display<br>Forward</div></html>");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    if (first == null) {
                        JOptionPane.showMessageDialog(contentPane, "The list is empty. No elements to display.", "Information", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                    Node temp = first;
                    StringBuilder listContent = new StringBuilder();
                    while (temp != null) {
                        listContent.append(temp.data).append(" ");
                        temp = temp.nl;
                    }
                    textField_2.setText(listContent.toString().trim());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(contentPane, "An unexpected error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
			}
		});
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 17));
		btnNewButton_3.setBounds(438, 272, 109, 51);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_31 = new JButton("Back");
		btnNewButton_31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage home = new HomePage();
				home.main(null);
				dispose();
			}
		});
		btnNewButton_31.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_31.setBounds(222, 426, 96, 40);
		contentPane.add(btnNewButton_31);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(72, 356, 316, 39);
		contentPane.add(textField_1);
		
		JButton btnNewButton_3_1 = new JButton("<html><div align='center'>Display<br>Reverse</div></html>");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    if (first == null) {
                        JOptionPane.showMessageDialog(contentPane, "The list is empty. No elements to display.", "Information", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                    Node temp = first;
                    while (temp.nl != null) {
                        temp = temp.nl;
                    }
                    StringBuilder listContent = new StringBuilder();
                    while (temp != null) {
                        listContent.append(temp.data).append(" ");
                        temp = temp.pl;
                    }
                    textField_1.setText(listContent.toString().trim());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(contentPane, "An unexpected error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
			}
		});
		btnNewButton_3_1.setFont(new Font("Arial", Font.BOLD, 17));
		btnNewButton_3_1.setBounds(438, 345, 109, 51);
		contentPane.add(btnNewButton_3_1);
		
		JLabel lblNewLabel3 = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/Array.jpg")).getImage();
		lblNewLabel3.setIcon(new ImageIcon(img));
		lblNewLabel3.setBounds(0, -28, 577, 531);
		contentPane.add(lblNewLabel3);
		
		
		
		
	}
}
