import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JSlider;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.awt.event.ActionEvent;

public class Encuesta extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Encuesta frame = new Encuesta();
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
	public Encuesta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 235, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sistema operativo:");
		lblNewLabel.setBounds(10, 11, 132, 14);
		contentPane.add(lblNewLabel);
		
		ButtonGroup bg = new ButtonGroup();
		
		JRadioButton rdbtnWindows = new JRadioButton("Windows");
		rdbtnWindows.setBounds(10, 32, 90, 23);
		contentPane.add(rdbtnWindows);
		
		JRadioButton rdbtnLinux = new JRadioButton("Linux");
		rdbtnLinux.setBounds(10, 58, 90, 23);
		contentPane.add(rdbtnLinux);
		
		JRadioButton rdbtnMac = new JRadioButton("Mac");
		rdbtnMac.setBounds(10, 86, 90, 23);
		contentPane.add(rdbtnMac);
		
		bg.add(rdbtnWindows);
		bg.add(rdbtnLinux);
		bg.add(rdbtnMac);
		
		JLabel lblNewLabel_1 = new JLabel("Especialidad:");
		lblNewLabel_1.setBounds(10, 116, 90, 14);
		contentPane.add(lblNewLabel_1);
		
		JCheckBox chckbxProgramacion = new JCheckBox("Programaci\u00F3n");
		chckbxProgramacion.setBounds(10, 137, 132, 23);
		contentPane.add(chckbxProgramacion);
		
		JCheckBox chckbxDiseoGrfico = new JCheckBox("Dise\u00F1o gr\u00E1fico");
		chckbxDiseoGrfico.setBounds(10, 163, 132, 23);
		contentPane.add(chckbxDiseoGrfico);
		
		JCheckBox chckbxAdministracin = new JCheckBox("Administraci\u00F3n");
		chckbxAdministracin.setBounds(10, 189, 132, 23);
		contentPane.add(chckbxAdministracin);
		
		JLabel lblNewLabel_2 = new JLabel("Horas dedicadas al ordenador:");
		lblNewLabel_2.setBounds(10, 219, 176, 14);
		contentPane.add(lblNewLabel_2);
		
		JSlider slider = new JSlider();
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(1);
		slider.setMinorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setValue(5);
		slider.setMaximum(10);
		slider.setBounds(10, 233, 200, 58);
		contentPane.add(slider);
		
		JButton btnNewButton = new JButton("Introducir datos");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (!bg.isSelected(null)) {
				
					String so = (rdbtnWindows.isSelected()?rdbtnWindows.getText():"") + 
							(rdbtnLinux.isSelected()?rdbtnLinux.getText():"") + 
							(rdbtnMac.isSelected()?rdbtnMac.getText():"");
					String especialidad = (chckbxProgramacion.isSelected()?chckbxProgramacion.getText():"");
					
					if (chckbxDiseoGrfico.isSelected()) {
						
						especialidad += (especialidad.isEmpty()?"":", ") + chckbxDiseoGrfico.getText();
						
					}
					
					if (chckbxAdministracin.isSelected()) {
						
						especialidad += (especialidad.isEmpty()?"":", ") + chckbxAdministracin.getText();
						
					}
					
					JOptionPane.showMessageDialog(null, "Sistema operativo: " + so + "\n" +
														"Especialidad/es: " + (especialidad.isEmpty()?"No tienes especialidades":especialidad) + "\n" +
														"Horas dedicadas al ordenador: " + slider.getValue() + " horas");
				
				} else {
					
					JOptionPane.showMessageDialog(null, "No has escogido SO", "Error", JOptionPane.ERROR_MESSAGE);
					
				}
				
			}
			
		});
		
		btnNewButton.setBounds(39, 302, 147, 23);
		contentPane.add(btnNewButton);
	}
}
