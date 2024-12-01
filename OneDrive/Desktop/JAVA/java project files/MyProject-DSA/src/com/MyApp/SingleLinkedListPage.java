package com.MyApp;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class SingleLinkedListPage extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField element;
    private JTextField delete;
    private JTextField display;
    private Image backgroundImage;

    // Head of the list
    private Node head;

    // Node class for Singly Linked List
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    SingleLinkedListPage frame = new SingleLinkedListPage();
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
    public SingleLinkedListPage() {
    	
    	 try {
             URL imageUrl = new URL("https://img.freepik.com/free-vector/vibrant-summer-ombre-background-vector_53876-105765.jpg?t=st=1732982138~exp=1732985738~hmac=f1cf1c885f6dfcdf6641edc05a5d227fd02df09b63a32d6627a66950d593acfd&w=900");
             backgroundImage = ImageIO.read(imageUrl);
         } catch (Exception e) {
             e.printStackTrace();
         }
    	
    	
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 1092, 693);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        
        
        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };   
        
        
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnBack = new JButton(" <<  Back ");
        btnBack.setForeground(new Color(255, 255, 255));
        btnBack.setBounds(988, 615, 150, 30);
        btnBack.setBackground(new Color(0, 0, 0));
        btnBack.setFont(new Font("Freestyle Script", Font.BOLD, 20));
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPage mainPage = new MainPage();
                mainPage.setVisible(true);
                setVisible(false);
            }
        });
        contentPane.add(btnBack);

        JLabel lblTitle = new JLabel("SINGLY LINKED LIST");
        lblTitle.setBounds(482, 78, 407, 38);
        lblTitle.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 32));
        contentPane.add(lblTitle);

        // TextField for Element Input
        element = new JTextField();
        element.setFont(new Font("Tw Cen MT", Font.PLAIN, 11));
        element.setBounds(509, 295, 125, 25);
        contentPane.add(element);
        element.setColumns(10);

        // Button to Insert Element at the End of the Linked List
        JButton btnInsert = new JButton("INSERT");
        btnInsert.setForeground(new Color(255, 255, 255));
        btnInsert.setBackground(new Color(100, 149, 237));
        btnInsert.setFont(new Font("Freestyle Script", Font.BOLD, 15));
        btnInsert.setBounds(670, 295, 125, 25);
        btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String elementText = element.getText().trim();
                    int elementValue = Integer.parseInt(elementText);

                    // If linked list is empty, initialize head
                    if (head == null) {
                        head = new Node(elementValue);
                    } else {
                        Node current = head;
                        // Traverse to the last node
                        while (current.next != null) {
                            current = current.next;
                        }
                        // Create a new node and add it at the end
                        current.next = new Node(elementValue);
                    }

                    JOptionPane.showMessageDialog(null, "Element " + elementValue + " inserted successfully.");

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });
        contentPane.add(btnInsert);

        // TextField for Delete Element Input (by value)
        delete = new JTextField();
        delete.setBounds(509, 384, 125, 25);
        delete.setColumns(10);
        contentPane.add(delete);

        // Button to Delete Element from the Linked List
        JButton btnDelete = new JButton("DELETE");
        btnDelete.setForeground(new Color(255, 255, 255));
        btnDelete.setBackground(new Color(220, 20, 60));
        btnDelete.setFont(new Font("Freestyle Script", Font.BOLD, 15));
        btnDelete.setBounds(670, 384, 125, 25);
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String deleteText = delete.getText().trim();
                    int deleteValue = Integer.parseInt(deleteText);

                    if (head == null) {
                        JOptionPane.showMessageDialog(null, "Linked list is empty. Nothing to delete.");
                        return;
                    }

                    // If head node needs to be deleted
                    if (head.data == deleteValue) {
                        head = head.next;
                    } else {
                        Node current = head;
                        Node prev = null;
                        // Traverse and find the node to delete
                        while (current != null && current.data != deleteValue) {
                            prev = current;
                            current = current.next;
                        }
                        // If node is not found
                        if (current == null) {
                            JOptionPane.showMessageDialog(null, "Element not found in the list.");
                            return;
                        }
                        // Delete the node
                        prev.next = current.next;
                    }

                    JOptionPane.showMessageDialog(null, "Element " + deleteValue + " deleted successfully.");

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });
        contentPane.add(btnDelete);

        // TextField for Display Linked List
        display = new JTextField();
        display.setBounds(587, 520, 360, 36);
        display.setColumns(10);
        contentPane.add(display);

        // Button to Display Linked List
        JButton btnDisplay = new JButton("DISPLAY");
        btnDisplay.setForeground(new Color(255, 255, 255));
        btnDisplay.setBackground(new Color(255, 140, 0));
        btnDisplay.setFont(new Font("Freestyle Script", Font.BOLD, 15));
        btnDisplay.setBounds(357, 519, 180, 38);
        btnDisplay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (head == null) {
                    JOptionPane.showMessageDialog(null, "Linked list is empty.");
                } else {
                    StringBuilder sb = new StringBuilder();
                    Node current = head;
                    while (current != null) {
                        sb.append(current.data).append(" ");
                        current = current.next;
                    }
                    display.setText(sb.toString());
                }
            }
        });
        contentPane.add(btnDisplay);
    }
}
