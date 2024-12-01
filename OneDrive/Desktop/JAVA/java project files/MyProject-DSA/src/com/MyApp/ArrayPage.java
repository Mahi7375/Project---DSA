package com.MyApp;

import java.awt.Color;
import java.net.URL;

import javax.imageio.ImageIO;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;


public class ArrayPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField element;
	private JTextField index;

	private int[] array;
	private JTextField delete;
	private JTextField display;
    private Image backgroundImage;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ArrayPage frame = new ArrayPage();
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
	public ArrayPage() {
		
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

		JButton btnNewButton = new JButton(" <<  Back ");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(988, 615, 150, 30);
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainPage mainPage = new MainPage();
				mainPage.setVisible(true);
				setVisible(false);
			}
		});
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("ARRAY DATA STRUCTURE");
		lblNewLabel_1.setBounds(482, 78, 407, 38);
		lblNewLabel_1.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 32));
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton_1 = new JButton("CREATE\r\n");
		btnNewButton_1.setBackground(new Color(65, 105, 225));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Freestyle Script", Font.BOLD, 15));
		btnNewButton_1.setBounds(822, 221, 125, 25);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int input;

				try {
					input = Integer.parseInt(textField.getText().trim());
					if(input<=0) {
						JOptionPane.showMessageDialog(null, "Please enter a positive number greater than zero.");
						return;
					}

					array = new int[input];

					JOptionPane.showMessageDialog(null, "Array of size " + input + " is created succussfully ! ");
				} catch(NumberFormatException el) {
					JOptionPane.showMessageDialog(null, "Please enter a valid number.");

				} catch(Exception el) {
					JOptionPane.showMessageDialog(null, "Please Enter Valid Number");
				}
			}
		});
		contentPane.add(btnNewButton_1);

		textField = new JTextField();
		textField.setBounds(617, 221, 125, 25);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("ENTER SIZE ");
		lblNewLabel.setBounds(482, 220, 90, 25);
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.ITALIC, 15));
		contentPane.add(lblNewLabel);

		element = new JTextField();
		element.setFont(new Font("Tw Cen MT", Font.PLAIN, 11));
		element.setBounds(670, 295, 125, 25);
		contentPane.add(element);
		element.setColumns(10);

		JButton btnNewButton_1_1 = new JButton("INSERT");
		btnNewButton_1_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1_1.setBackground(new Color(46, 139, 87));
		btnNewButton_1_1.setFont(new Font("Freestyle Script", Font.BOLD, 15));
		btnNewButton_1_1.setBounds(851, 295, 125, 25);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// Getting the inputs

					String elementText = element.getText().trim();
					String indexinput = index.getText().trim();

				    int indexvalue = Integer.parseInt(indexinput);
				    int elementvalue = Integer.parseInt(elementText);

				    if(array == null) {
				    	JOptionPane.showMessageDialog(null, "Hey Buddy! Initialize an array first!");
				    	return;
				    }
				    if (indexvalue < 0 || indexvalue >= array.length) {
				    	JOptionPane.showMessageDialog(null, "Sorry Buddy! Index out of bounds!");
				       return;
				    }

			     	array[indexvalue] = elementvalue;
				    JOptionPane.showMessageDialog(null, "Hey yah !! Element " + elementvalue + " is inserted at index " + indexvalue );

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Please enter a valid number for index and element.");

				} catch (Exception ex ) {
					JOptionPane.showMessageDialog(null, "Hey Buddy,, error occured here : " + ex.getMessage());
				}

			}
		});
		contentPane.add(btnNewButton_1_1);

		index = new JTextField();
		index.setBounds(392, 294, 125, 25);
		index.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		index.setColumns(10);
		contentPane.add(index);

		JLabel lblEnterIndex = new JLabel("ENTER INDEX");
		lblEnterIndex.setBounds(257, 294, 125, 25);
		lblEnterIndex.setFont(new Font("Tw Cen MT", Font.ITALIC, 15));
		contentPane.add(lblEnterIndex);

		JLabel lblElement = new JLabel("ELEMENT");
		lblElement.setBounds(575, 294, 55, 25);
		lblElement.setFont(new Font("Tw Cen MT", Font.ITALIC, 15));
		contentPane.add(lblElement);

		JButton btnNewButton_1_1_1 = new JButton("DELETE");
		btnNewButton_1_1_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1_1_1.setBackground(new Color(220, 20, 60));
		btnNewButton_1_1_1.setFont(new Font("Freestyle Script", Font.BOLD, 15));
		btnNewButton_1_1_1.setBounds(670, 384, 125, 25);
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			      try {
	                    // Getting the inputs
	                    String indexinput = delete.getText().trim();

	                    int indexvalue = Integer.parseInt(indexinput);

	                    // Check if array is initialized
	                  
	                    if (isArrayEmpty(array)) {
	                    	JOptionPane.showMessageDialog(null, "Hey Buddy! Fill the array first!");
	                    	return;
	                    }
	                    
	                    

	                    // Check if the index is valid
	                    if (indexvalue < 0 || indexvalue >= array.length) {
	                        JOptionPane.showMessageDialog(null, "Sorry Buddy! Index out of bounds!");
	                        return;
	                    }

	                    // Delete the element by setting it to null
	                    array[indexvalue] = 0;

	                    // Show confirmation message
	                    JOptionPane.showMessageDialog(null, "Hey yah !! Element at index " + indexvalue + " has been deleted.");

	                } catch (NumberFormatException ex) {
	                    JOptionPane.showMessageDialog(null, "Please enter a valid number for index and element.");
	                } catch (Exception ex) {
	                    JOptionPane.showMessageDialog(null, "Hey Buddy,, error occurred here: " + ex.getMessage());
	                }
	            }

			private boolean isArrayEmpty(int[] array) {
				
				return array == null || array.length == 0;
			}
			
		});
		contentPane.add(btnNewButton_1_1_1);
		
		JLabel lblElement_1 = new JLabel("INDEX");
		lblElement_1.setBounds(387, 383, 67, 25);
		lblElement_1.setFont(new Font("Tw Cen MT", Font.ITALIC, 15));
		contentPane.add(lblElement_1);
		
		delete = new JTextField();
		delete.setBounds(509, 384, 125, 25);
		delete.setColumns(10);
		contentPane.add(delete);
		
		display = new JTextField();
		display.setBounds(587, 520, 360, 36);
		display.setColumns(10);
		contentPane.add(display);
		
		JButton btnNewButton_1_1_1_1 = new JButton("DISPLAY\r\n");
		btnNewButton_1_1_1_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1_1_1_1.setFont(new Font("Freestyle Script", Font.BOLD, 20));
		btnNewButton_1_1_1_1.setBackground(new Color(255, 127, 80));
		btnNewButton_1_1_1_1.setBounds(357, 519, 180, 38);
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  if (array == null || array.length == 0) {
			            JOptionPane.showMessageDialog(null, "Array is empty! Please initialize the array first.");
			        } else {
			            StringBuilder sb = new StringBuilder();
			            for (int i = 0; i < array.length; i++) {
			                sb.append(array[i] + " ");
			            }
			            
			            // Set the text to the JTextField 'display'
			            display.setText(sb.toString());
			        }
			    }				
			
		});
		contentPane.add(btnNewButton_1_1_1_1);
	}
}
