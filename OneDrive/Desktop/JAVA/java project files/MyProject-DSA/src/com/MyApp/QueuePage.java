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

public class QueuePage extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField enqueueField;
    private JTextField displayField;

    private int[] queue;
    private int front = -1;
    private int rear = -1;
    private Image backgroundImage;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    QueuePage frame = new QueuePage();
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
    public QueuePage() {
    	
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

        JButton backButton = new JButton(" << Back ");
        backButton.setForeground(new Color(255, 255, 255));
        backButton.setBounds(988, 615, 150, 30);
        backButton.setBackground(new Color(0, 0, 0));
        backButton.setFont(new Font("Freestyle Script", Font.BOLD, 20));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPage mainPage = new MainPage();
                mainPage.setVisible(true);
                setVisible(false);
            }
        });
        contentPane.setLayout(null);
        contentPane.add(backButton);

        JLabel lblTitle = new JLabel("QUEUE DATA STRUCTURE");
        lblTitle.setBounds(482, 78, 450, 38);
        lblTitle.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 32));
        contentPane.add(lblTitle);

        JButton createButton = new JButton("CREATE QUEUE");
        createButton.setForeground(new Color(255, 255, 255));
        createButton.setBackground(new Color(218, 165, 32));
        createButton.setBounds(822, 221, 125, 25);
        createButton.setFont(new Font("Freestyle Script", Font.BOLD, 15));
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int size = Integer.parseInt(textField.getText().trim());
                    if (size <= 0) {
                        JOptionPane.showMessageDialog(null, "Please enter a positive number greater than zero.");
                        return;
                    }

                    queue = new int[size];
                    front = rear = -1;
                    JOptionPane.showMessageDialog(null, "Queue of size " + size + " created successfully!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number.");
                }
            }
        });
        contentPane.add(createButton);

        textField = new JTextField();
        textField.setBounds(617, 221, 125, 25);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblEnterSize = new JLabel("ENTER SIZE");
        lblEnterSize.setBounds(482, 220, 90, 25);
        lblEnterSize.setFont(new Font("Tw Cen MT", Font.ITALIC, 15));
        contentPane.add(lblEnterSize);

        enqueueField = new JTextField();
        enqueueField.setFont(new Font("Tw Cen MT", Font.PLAIN, 11));
        enqueueField.setBounds(617, 295, 125, 25);
        contentPane.add(enqueueField);
        enqueueField.setColumns(10);

        JButton enqueueButton = new JButton("ENQUEUE");
        enqueueButton.setForeground(new Color(0, 0, 0));
        enqueueButton.setFont(new Font("Freestyle Script", Font.BOLD, 15));
        enqueueButton.setBackground(new Color(0, 255, 127));
        enqueueButton.setBounds(822, 295, 125, 25);
        enqueueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int element = Integer.parseInt(enqueueField.getText().trim());

                    if (queue == null) {
                        JOptionPane.showMessageDialog(null, " Hey buddy! Please create a queue first.");
                        return;
                    }

                    if (rear == queue.length - 1) { // checking for queue overflow
                        JOptionPane.showMessageDialog(null, "Queue Overflow! Cannot enqueue more elements.");
                        return;
                    }

                    if (front == -1) {
                        front = 0;
                    }

                    rear++;
                    queue[rear] = element;
                    JOptionPane.showMessageDialog(null, "Element " + element + " enqueued into the queue.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number.");
                }
            }
        });
        contentPane.add(enqueueButton);

        JButton dequeueButton = new JButton("DEQUEUE");
        dequeueButton.setFont(new Font("Freestyle Script", Font.BOLD, 15));
        dequeueButton.setBackground(new Color(220, 20, 60));
        dequeueButton.setForeground(new Color(255, 255, 255));
        dequeueButton.setBounds(822, 384, 125, 25);
        dequeueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (queue == null) {
                    JOptionPane.showMessageDialog(null, "Please create a queue first.");
                    return;
                }

                if (front == -1 ||  front > rear) {
                    JOptionPane.showMessageDialog(null, "Queue Underflow! The queue is empty.");
                    return;
                }

                int dequeuedElement = queue[front];
                front++;
                if (front > rear) {
                    front = rear = -1;
                } 
                JOptionPane.showMessageDialog(null, "Element " + dequeuedElement + " dequeued from the queue.");
            }
        });
        contentPane.add(dequeueButton);

        displayField = new JTextField();
        displayField.setBounds(587, 520, 360, 36);
        displayField.setColumns(10);
        contentPane.add(displayField);

        JButton displayButton = new JButton("DISPLAY");
        displayButton.setForeground(new Color(0, 0, 0));
        displayButton.setBackground(new Color(173, 216, 230));
        displayButton.setFont(new Font("Freestyle Script", Font.BOLD, 20));
        displayButton.setBounds(357, 519, 180, 38);
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (queue == null || front == -1 || front > rear) {
                    JOptionPane.showMessageDialog(null, " Hey Buddy! The queue is empty. Please enqueue elements first.");
                    return;
                }

                StringBuilder sb = new StringBuilder();
               
                for(int i = front; i <= rear; i++) { // Linear traversal of the queue
                	sb.append(queue[i]).append(" ");
                }              

                displayField.setText(sb.toString());
            }
        });
        contentPane.add(displayButton);
        
        JLabel lblElement = new JLabel("ELEMENT");
        lblElement.setFont(new Font("Tw Cen MT", Font.ITALIC, 15));
        lblElement.setBounds(482, 295, 90, 25);
        contentPane.add(lblElement);
    }
}
