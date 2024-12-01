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

public class DoublyLinkedListPage extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField element;
    private JTextField delete;
    private JTextField display;
    private JTextField elementAt;
    private JTextField findElement;
    private JTextField insertBegin;

    // Head and Tail of the list
    private Node head, tail;
    private JTextField position;
    private Image backgroundImage;

    // Node class for Doubly Linked List
    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
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
                    DoublyLinkedListPage frame = new DoublyLinkedListPage();
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
    public DoublyLinkedListPage() {
    	
    	  try {
              URL imageUrl = new URL("https://img.freepik.com/free-vector/vibrant-summer-ombre-background-vector_53876-105765.jpg?t=st=1732982138~exp=1732985738~hmac=f1cf1c885f6dfcdf6641edc05a5d227fd02df09b63a32d6627a66950d593acfd&w=900");
              backgroundImage = ImageIO.read(imageUrl);
          } catch (Exception e) {
              e.printStackTrace();
          }
    	  
    	  
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 1092, 693);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        
        // Custom JPanel to draw the background image
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

        JLabel lblTitle = new JLabel("DOUBLY LINKED LIST");
        lblTitle.setBounds(482, 78, 407, 38);
        lblTitle.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 32));
        contentPane.add(lblTitle);

        // TextField for Element Input
        element = new JTextField();
        element.setFont(new Font("Tw Cen MT", Font.PLAIN, 11));
        element.setBounds(509, 308, 125, 25);
        contentPane.add(element);
        element.setColumns(10);

        // Button to Insert Element at the End of the Linked List
        JButton btnInsert = new JButton("INSERT");
        btnInsert.setForeground(new Color(255, 255, 255));
        btnInsert.setBackground(new Color(0, 128, 0));
        btnInsert.setFont(new Font("Freestyle Script", Font.BOLD, 15));
        btnInsert.setBounds(670, 305, 125, 30);
        btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String elementText = element.getText().trim();
                    int elementValue = Integer.parseInt(elementText);

                    Node newNode = new Node(elementValue);

                    // If linked list is empty, initialize both head and tail
                    if (head == null) {
                        head = tail = newNode;
                    } else {
                        // Insert at the end of the doubly linked list
                        tail.next = newNode;
                        newNode.prev = tail;
                        tail = newNode;
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
        delete.setBounds(509, 359, 125, 25);
        delete.setColumns(10);
        contentPane.add(delete);

        // Button to Delete Element from the Linked List
        JButton btnDelete = new JButton("DELETE");
        btnDelete.setForeground(new Color(255, 255, 255));
        btnDelete.setBackground(new Color(220, 20, 60));
        btnDelete.setFont(new Font("Freestyle Script", Font.BOLD, 15));
        btnDelete.setBounds(670, 356, 125, 30);
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

                    Node current = head;

                    // If deleting the head node
                    if (head.data == deleteValue) {
                        if (head.next != null) {
                            head = head.next;
                            head.prev = null;
                        } else {
                            head = tail = null;
                        }
                    } else {
                        // Traverse the list to find the node to delete
                        while (current != null && current.data != deleteValue) {
                            current = current.next;
                        }

                        if (current == null) {
                            JOptionPane.showMessageDialog(null, "Element not found in the list.");
                            return;
                        }

                        // If deleting the tail node
                        if (current.next == null) {
                            tail = current.prev;
                            tail.next = null;
                        } else {
                            // Delete node from the middle
                            current.prev.next = current.next;
                            current.next.prev = current.prev;
                        }
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
        btnDisplay.setFont(new Font("Freestyle Script", Font.BOLD, 20));
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

        // TextField for Insert at Beginning Input
        insertBegin = new JTextField();
        insertBegin.setBounds(509, 250, 125, 25);
        insertBegin.setColumns(10);
        contentPane.add(insertBegin);

        // Button to Insert Element at the Beginning
        JButton btnInsertBegin = new JButton("INSERT BEGIN");
        btnInsertBegin.setBackground(new Color(135, 206, 250));
        btnInsertBegin.setFont(new Font("Freestyle Script", Font.BOLD, 15));
        btnInsertBegin.setBounds(670, 250, 125, 30);
        btnInsertBegin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String elementText = insertBegin.getText().trim();
                    int elementValue = Integer.parseInt(elementText);

                    Node newNode = new Node(elementValue);

                    // If linked list is empty, initialize both head and tail
                    if (head == null) {
                        head = tail = newNode;
                    } else {
                        // Insert at the beginning of the list
                        newNode.next = head;
                        head.prev = newNode;
                        head = newNode;
                    }

                    JOptionPane.showMessageDialog(null, "Element " + elementValue + " inserted at the beginning.");

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });
        contentPane.add(btnInsertBegin);

        // TextField for Insert at Specific Position
        elementAt = new JTextField();
        elementAt.setBounds(509, 410, 125, 25);
        elementAt.setColumns(10);
        contentPane.add(elementAt);

        // Button to Insert Element at Specific Position
        JButton btnInsertPosition = new JButton("INSERT AT POSITION");
        btnInsertPosition.setBackground(new Color(255, 192, 203));
        btnInsertPosition.setFont(new Font("Freestyle Script", Font.BOLD, 15));
        btnInsertPosition.setBounds(657, 407, 150, 30);
        btnInsertPosition.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 try {
                     // Get position and element from respective text fields
                     String positionText = position.getText().trim();  // This is the text field for position
                     String elementText = elementAt.getText().trim(); // This is the text field for the element

                     // Validate that both fields are not empty
                     if (positionText.isEmpty() || elementText.isEmpty()) {
                         JOptionPane.showMessageDialog(null, "Both position and element must be provided.");
                         return;
                     }

                     // Convert the inputs from String to integer
                     int positionValue = Integer.parseInt(positionText);  // Renamed the local variable to positionValue
                     int elementValue = Integer.parseInt(elementText);

                     Node newNode = new Node(elementValue);

                     // Insert at the beginning of the list if position is 1
                     if (positionValue == 1) { // Changed position to positionValue
                         newNode.next = head;
                         if (head != null) {
                             head.prev = newNode;
                         }
                         head = newNode;
                     } else {
                         Node current = head;
                         for (int i = 1; i < positionValue - 1 && current != null; i++) { // Changed position to positionValue
                             current = current.next;
                         }

                         if (current == null) {
                             JOptionPane.showMessageDialog(null, "Position is out of bounds.");
                             return;
                         }

                         newNode.next = current.next;
                         if (current.next != null) {
                             current.next.prev = newNode;
                         }
                         current.next = newNode;
                         newNode.prev = current;
                     }

                     JOptionPane.showMessageDialog(null, "Element " + elementValue + " inserted at position " + positionValue);

                 } catch (NumberFormatException ex) {
                     JOptionPane.showMessageDialog(null, "Please enter valid numbers.");
                 }
             }
         });
        contentPane.add(btnInsertPosition);

        // TextField for Find Element
        findElement = new JTextField();
        findElement.setBounds(509, 459, 125, 25);
        findElement.setColumns(10);
        contentPane.add(findElement);

        // Button to Find Element
        JButton btnFind = new JButton("FIND ELEMENT\r\n\r\n");
        btnFind.setBackground(new Color(147, 112, 219));
        btnFind.setFont(new Font("Freestyle Script", Font.BOLD, 15));
        btnFind.setBounds(670, 459, 125, 25);
        btnFind.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String findText = findElement.getText().trim();
                    int findValue = Integer.parseInt(findText);

                    if (head == null) {
                        JOptionPane.showMessageDialog(null, "Linked list is empty.");
                        return;
                    }

                    Node current = head;
                    boolean found = false;

                    while (current != null) {
                        if (current.data == findValue) {
                            found = true;
                            break;
                        }
                        current = current.next;
                    }

                    if (found) {
                        JOptionPane.showMessageDialog(null, "Element " + findValue + " found in the list.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Element " + findValue + " not found.");
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number.");
                }
            }
        });
        contentPane.add(btnFind);
        
        position = new JTextField();
        position.setColumns(10);
        position.setBounds(277, 410, 125, 25);
        contentPane.add(position);
        
        JLabel lblNewLabel = new JLabel("ELEMENT");
        lblNewLabel.setFont(new Font("Freestyle Script", Font.BOLD, 15));
        lblNewLabel.setBounds(427, 415, 72, 14);
        contentPane.add(lblNewLabel);
        
        JLabel lblIndex = new JLabel("POSITION\r\n");
        lblIndex.setFont(new Font("Freestyle Script", Font.BOLD, 15));
        lblIndex.setBounds(195, 415, 72, 14);
        contentPane.add(lblIndex);
    }
}
