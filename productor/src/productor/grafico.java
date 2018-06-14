package productor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class grafico {

	private JFrame frame;
	private JTextField textField_1;

	buffer buffer;
	Semaphore semaforo = new Semaphore(1);

	Consumidor c1, c2;
	Productor p1, p2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					grafico window = new grafico();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public grafico() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 594, 345);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("INICIAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				p1 = new Productor("Productor 1", buffer, semaforo);
				p1.start();

			}
		});
		btnNewButton.setBounds(111, 26, 89, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("PARAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				p1.suspend();
			}
		});
		btnNewButton_1.setBounds(111, 70, 89, 23);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("INICIAR");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				p2 = new Productor("Productor 2", buffer, semaforo);
				p2.start();

			}
		});
		btnNewButton_2.setBounds(111, 175, 89, 23);
		frame.getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("PARAR");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				p2.suspend();
			}
		});
		btnNewButton_3.setBounds(111, 229, 89, 23);
		frame.getContentPane().add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("INICIAR");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				c1 = new Consumidor("Consumidor 1", buffer, semaforo);
				c1.start();
			}
		});
		btnNewButton_4.setBounds(367, 26, 89, 23);
		frame.getContentPane().add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("PARAR");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				c1.suspend();

			}
		});
		btnNewButton_5.setBounds(367, 70, 89, 23);
		frame.getContentPane().add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("INICIAR");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				c2 = new Consumidor("Consumidor 2", buffer, semaforo);
				c2.start();
			}
		});
		btnNewButton_6.setBounds(367, 175, 89, 23);
		frame.getContentPane().add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton("PARAR");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				c2.suspend();
			}
		});
		btnNewButton_7.setBounds(367, 229, 89, 23);
		frame.getContentPane().add(btnNewButton_7);

		JLabel lblProductor = new JLabel("productor1");
		lblProductor.setBounds(32, 55, 64, 14);
		frame.getContentPane().add(lblProductor);

		JLabel lblProductor_1 = new JLabel("productor2");
		lblProductor_1.setBounds(32, 205, 64, 14);
		frame.getContentPane().add(lblProductor_1);

		JLabel lblConsumidor = new JLabel("consumidor1");
		lblConsumidor.setBounds(483, 55, 61, 14);
		frame.getContentPane().add(lblConsumidor);

		JLabel lblConsumidor_1 = new JLabel("consumidor2");
		lblConsumidor_1.setBounds(483, 205, 61, 14);
		frame.getContentPane().add(lblConsumidor_1);

		textField_1 = new JTextField();
		textField_1.setBounds(195, 127, 193, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JLabel lblBuffer = new JLabel("buffer");
		lblBuffer.setBounds(266, 102, 43, 14);
		frame.getContentPane().add(lblBuffer);

		buffer = new buffer(textField_1);
		
		JLabel lblProductorConsumidor = new JLabel("PRODUCTOR CONSUMIDOR");
		lblProductorConsumidor.setBounds(209, 11, 160, 14);
		frame.getContentPane().add(lblProductorConsumidor);
	}
}
