import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class MiniCalculadora extends JFrame {

	private JPanel contentPane;
	private JTextField value1;
	private JTextField value2;
	private JTextField result;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MiniCalculadora frame = new MiniCalculadora();
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
	public MiniCalculadora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		value1 = new JTextField();
		value1.setBounds(10, 11, 86, 20);
		contentPane.add(value1);
		value1.setColumns(10);
		
		value2 = new JTextField();
		value2.setBounds(127, 11, 86, 20);
		contentPane.add(value2);
		value2.setColumns(10);
		
		result = new JTextField();
		result.setEditable(false);
		result.setBounds(258, 11, 86, 20);
		contentPane.add(result);
		result.setColumns(10);
		
		JButton btnNewResta = new JButton("-");
		btnNewResta.setBounds(55, 42, 41, 23);
		contentPane.add(btnNewResta);
		
		JButton btnNewSuma = new JButton("+");
		btnNewSuma.setBounds(10, 42, 41, 23);
		contentPane.add(btnNewSuma);
		
		JButton btnNewPlus = new JButton("*");
		btnNewPlus.setBounds(127, 42, 41, 23);
		contentPane.add(btnNewPlus);
		
		JButton btnNewDiv = new JButton("/");
		btnNewDiv.setBounds(172, 42, 41, 23);
		contentPane.add(btnNewDiv);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setBounds(258, 42, 86, 23);
		contentPane.add(btnEnter);
		
		JLabel lblOperator = new JLabel("?");
		lblOperator.setHorizontalAlignment(SwingConstants.CENTER);
		lblOperator.setBounds(96, 14, 32, 14);
		contentPane.add(lblOperator);
		
		JLabel lblNewLabel_1 = new JLabel("=");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(223, 14, 25, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewReset = new JButton("C");
		btnNewReset.setBounds(354, 10, 50, 21);
		contentPane.add(btnNewReset);
		
		btnNewSuma.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				lblOperator.setText(btnNewSuma.getText());
				
			}
			
		});
		
		btnNewResta.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				lblOperator.setText(btnNewResta.getText());
				
			}
			
		});
		
		btnNewPlus.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				lblOperator.setText(btnNewPlus.getText());
				
			}
			
		});
		
		btnNewDiv.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				lblOperator.setText(btnNewDiv.getText());
				
			}
			
		});
		
		btnEnter.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (!lblOperator.getText().equals("?")) {
					
					try {
						
						int number1 = Integer.parseInt(value1.getText());
						int number2 = Integer.parseInt(value2.getText());
						
						switch (lblOperator.getText()) {
						
						case "+":
							
							int suma = number1 + number2;
							result.setText("" + suma);
							break;
						
						case "-":
						
							int resta = number1 - number2;
							result.setText("" + resta);
							break;
							
						case "*":
							
							int plus = number1 * number2;
							result.setText("" + plus);
							break;
							
						case "/":
							
							try {
								
								int div = number1 / number2;
								result.setText("" + div);
								
							} catch (Exception exc) {
								
								result.setText("Err");
								break;
							
							}
				
						}
						
						value1.setEditable(false);
						value2.setEditable(false);
						btnNewSuma.setEnabled(false);
						btnNewResta.setEnabled(false);
						btnNewPlus.setEnabled(false);
						btnNewDiv.setEnabled(false);
						
					} catch (Exception ex) {
						
						JOptionPane.showMessageDialog(null, "Valores erroneos en los campos", "Error", JOptionPane.ERROR_MESSAGE);
						
					}
					
					
					
				} else {
					
					JOptionPane.showMessageDialog(null, "No has escogido el tipo de operacion que quieres hacer con los valores", "Error", JOptionPane.ERROR_MESSAGE);
					
				}
				
			}
			
		});
		
		btnNewReset.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				value1.setEditable(true);
				value2.setEditable(true);
				value1.setText("");
				value2.setText("");
				btnNewSuma.setEnabled(true);
				btnNewResta.setEnabled(true);
				btnNewPlus.setEnabled(true);
				btnNewDiv.setEnabled(true);
				lblOperator.setText("?");
				result.setText("");
				
			}
			
		});
		
	}

}
