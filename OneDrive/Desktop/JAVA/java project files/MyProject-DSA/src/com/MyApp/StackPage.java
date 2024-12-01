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

public class StackPage extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel contentPane_1;
    private JTextField textField;
    private JTextField pushField;
    private JTextField displayField;

    private int[] stack;
    private int top = -1;
    private Image backgroundImage;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    StackPage frame = new StackPage();
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
    public StackPage() {
    	
    	 try {
             URL imageUrl = new URL("https://img.freepik.com/free-vector/vibrant-summer-ombre-background-vector_53876-105765.jpg?t=st=1732982138~exp=1732985738~hmac=f1cf1c885f6dfcdf6641edc05a5d227fd02df09b63a32d6627a66950d593acfd&w=900");
             backgroundImage = ImageIO.read(imageUrl);
         } catch (Exception e) {
             e.printStackTrace();
         }
    	
    	
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 1092, 693);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        
        
        contentPane = new JPanel();
        // Custom JPanel to draw the background image
        contentPane_1 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        
        
        contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane_1);

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
        contentPane_1.setLayout(null);
        contentPane_1.add(backButton);

        JLabel lblTitle = new JLabel("STACK DATA STRUCTURE");
        lblTitle.setBounds(482, 78, 407, 38);
        lblTitle.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 32));
        contentPane_1.add(lblTitle);

        JButton createButton = new JButton("CREATE STACK");
        createButton.setBackground(new Color(238, 130, 238));
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

                    stack = new int[size];
                    top = -1;
                    JOptionPane.showMessageDialog(null, "Stack of size " + size + " created successfully!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number.");
                }
            }
        });
        contentPane_1.add(createButton);

        textField = new JTextField();
        textField.setBounds(617, 221, 125, 25);
        contentPane_1.add(textField);
        textField.setColumns(10);

        JLabel lblEnterSize = new JLabel("ENTER SIZE");
        lblEnterSize.setBounds(482, 220, 90, 25);
        lblEnterSize.setFont(new Font("Tw Cen MT", Font.ITALIC, 15));
        contentPane_1.add(lblEnterSize);

        pushField = new JTextField();
        pushField.setFont(new Font("Tw Cen MT", Font.PLAIN, 11));
        pushField.setBounds(617, 295, 125, 25);
        contentPane_1.add(pushField);
        pushField.setColumns(10);

        JButton pushButton = new JButton("PUSH");
        pushButton.setForeground(new Color(255, 255, 255));
        pushButton.setBackground(new Color(34, 139, 34));
        pushButton.setFont(new Font("Freestyle Script", Font.BOLD, 15));
        pushButton.setBounds(822, 295, 125, 25);
        pushButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int element = Integer.parseInt(pushField.getText().trim());

                    if (stack == null) {
                        JOptionPane.showMessageDialog(null, "Please create a stack first.");
                        return;
                    }

                    if (top == stack.length - 1) {
                        JOptionPane.showMessageDialog(null, "Stack Overflow! Cannot push more elements.");
                        return;
                    }

                    stack[++top] = element;
                    JOptionPane.showMessageDialog(null, "Element " + element + " pushed onto the stack.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number.");
                }
            }
        });
        contentPane_1.add(pushButton);

        JButton popButton = new JButton("POP");
        popButton.setBackground(new Color(220, 20, 60));
        popButton.setForeground(new Color(255, 255, 255));
        popButton.setFont(new Font("Freestyle Script", Font.BOLD, 15));
        popButton.setBounds(822, 384, 125, 25);
        popButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (stack == null) {
                    JOptionPane.showMessageDialog(null, "Please create a stack first.");
                    return;
                }

                if (top == -1) {
                    JOptionPane.showMessageDialog(null, "Stack Underflow! The stack is empty.");
                    return;
                }

                int poppedElement = stack[top--];
                JOptionPane.showMessageDialog(null, "Element " + poppedElement + " popped from the stack.");
            }
        });
        contentPane_1.add(popButton);

        displayField = new JTextField();
        displayField.setBounds(587, 520, 360, 36);
        displayField.setColumns(10);
        contentPane_1.add(displayField);

        JButton displayButton = new JButton("DISPLAY");
        displayButton.setFont(new Font("Freestyle Script", Font.BOLD, 20));
        displayButton.setBackground(new Color(240, 128, 128));
        displayButton.setBounds(357, 519, 180, 38);
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (stack == null || top == -1) {
                    JOptionPane.showMessageDialog(null, "The stack is empty. Please push elements first.");
                    return;
                }

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i <= top; i++) {
                    sb.append(stack[i]).append(" ");
                }

                displayField.setText(sb.toString());
            }
        });
        contentPane_1.add(displayButton);
        
        JLabel lblElement = new JLabel("ELEMENT");
        lblElement.setFont(new Font("Tw Cen MT", Font.ITALIC, 15));
        lblElement.setBounds(482, 295, 90, 25);
        contentPane_1.add(lblElement);
    }
}
