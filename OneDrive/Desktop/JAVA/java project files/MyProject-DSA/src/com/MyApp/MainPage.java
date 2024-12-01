package com.MyApp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MainPage extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Image backgroundImage;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MainPage frame = new MainPage();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public MainPage() {
        // Load the background image
        try {
            URL imageUrl = new URL("https://img.freepik.com/free-vector/vibrant-summer-ombre-background-vector_53876-105765.jpg?t=st=1732982138~exp=1732985738~hmac=f1cf1c885f6dfcdf6641edc05a5d227fd02df09b63a32d6627a66950d593acfd&w=900");
            backgroundImage = ImageIO.read(imageUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setBounds(100, 100, 978, 656);

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

        contentPane.setLayout(null);
        setContentPane(contentPane);

        JButton btnNewButton_5 = new JButton("Array");
        btnNewButton_5.setBackground(new Color(255, 127, 80));
        btnNewButton_5.setForeground(new Color(255, 255, 255));
        btnNewButton_5.setBounds(359, 259, 250, 45);
        btnNewButton_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayPage arrayPage = new ArrayPage(); // Open the ArrayPage when Array button is clicked
                arrayPage.setVisible(true);
                setVisible(false);
            }
        });

        JButton btnNewButton_4 = new JButton("Stack\r\n");
        btnNewButton_4.setForeground(new Color(255, 255, 255));
        btnNewButton_4.setBackground(new Color(220, 20, 60));
        btnNewButton_4.setFont(new Font("Freestyle Script", Font.PLAIN, 30));
        btnNewButton_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StackPage stackPage = new StackPage(); // Open the Stack Page when Stack button is clicked
                stackPage.setVisible(true);
                setVisible(false);
            }
        });

        btnNewButton_4.setBounds(764, 259, 250, 45);
        contentPane.add(btnNewButton_4);
        btnNewButton_5.setFont(new Font("Freestyle Script", Font.BOLD, 30));
        contentPane.add(btnNewButton_5);

        JButton btnNewButton_3 = new JButton("Queue");
        btnNewButton_3.setForeground(new Color(255, 255, 255));
        btnNewButton_3.setBackground(new Color(105, 105, 105));
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                QueuePage queuePage = new QueuePage(); // Open the Queue Page when Queue button is clicked
                queuePage.setVisible(true);
                setVisible(false);
            }
        });
        btnNewButton_3.setFont(new Font("Freestyle Script", Font.BOLD, 30));
        btnNewButton_3.setBounds(359, 361, 250, 45);
        contentPane.add(btnNewButton_3);

        JButton btnNewButton_2 = new JButton("Circular Queue\r\n\r\n");
        btnNewButton_2.setBackground(new Color(255, 182, 193));
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CircularQueuePage circularQueuePage = new CircularQueuePage();
                circularQueuePage.setVisible(true);
                setVisible(false);
            }
        });
        btnNewButton_2.setFont(new Font("Freestyle Script", Font.BOLD, 30));
        btnNewButton_2.setBounds(764, 361, 250, 45);
        contentPane.add(btnNewButton_2);

        JButton btnNewButton_1 = new JButton("Singly Linked-List");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SingleLinkedListPage singleLL = new SingleLinkedListPage();
                singleLL.setVisible(true);
                setVisible(false);
            }
        });
        btnNewButton_1.setBackground(new Color(255, 204, 51));
        btnNewButton_1.setForeground(new Color(0, 0, 0));
        btnNewButton_1.setFont(new Font("Freestyle Script", Font.BOLD, 30));
        btnNewButton_1.setBounds(359, 474, 250, 45);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton = new JButton("Double Linked-List\r\n");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DoublyLinkedListPage dll = new DoublyLinkedListPage();
                dll.setVisible(true);
                setVisible(false);
            }
        });
        btnNewButton.setBackground(new Color(218, 112, 214));
        btnNewButton.setFont(new Font("Freestyle Script", Font.BOLD, 30));
        btnNewButton.setBounds(764, 474, 250, 45);
        contentPane.add(btnNewButton);

        JLabel lblNewLabel = new JLabel("DATA STRUCTURES\r\n");
        lblNewLabel.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 32));
        lblNewLabel.setBounds(525, 76, 304, 38);
        contentPane.add(lblNewLabel);
    }
}
