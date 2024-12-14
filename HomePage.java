package com.kod.home;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.kod.dsproject.Array;
import com.kod.dsproject.CircularQueue;
import com.kod.dsproject.DoublyLinkedList;
import com.kod.dsproject.Queue;
import com.kod.dsproject.SingleLinkedList;
import com.kod.dsproject.Stacks;

import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class HomePage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 644, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(187, 114, 1, 1);
		contentPane.add(table);
		
		JLabel heading = new JLabel("DATA STRUCTURES", SwingConstants.CENTER);
		heading.setBounds(187, 10, 265, 39);
		heading.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		contentPane.add(heading);
		
		JButton btnNewButton = new JButton("Array");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Array array = new Array();
				array.main(null);
				dispose(); // close the home frame
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(61, 79, 191, 66);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Queue");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Queue queue = new Queue();
				queue.main(null);
				dispose(); 
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBounds(61, 181, 191, 66);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("<html><div align='center'>SingleLinked<br>List</div></html>");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SingleLinkedList sl = new SingleLinkedList();
				sl.main(null);
				dispose(); 
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_2.setBounds(61, 293, 191, 66);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Stack");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stacks stack = new Stacks();
				stack.main(null);
				dispose(); 
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_3.setBounds(377, 79, 191, 66);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Circular Queue");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CircularQueue cl = new CircularQueue();
				cl.main(null);
				dispose(); 
			}
		});
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_4.setBounds(377, 181, 191, 66);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("<html><div align='center'>DoublyLinked<br>List</div></html>");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoublyLinkedList dl = new DoublyLinkedList();
				dl.main(null);
				dispose(); 
			}
		});
		btnNewButton_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_5.setBounds(377, 293, 191, 66);
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/datastructureimage.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, 0, 630, 417);
		contentPane.add(lblNewLabel);
		
		
	}
}