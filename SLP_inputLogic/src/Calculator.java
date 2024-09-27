import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Calculator extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inputField;
	private JTextField postfixField;
	private JTextField answerField;
	String input;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
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
	public Calculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInputEquationHere = new JLabel("Input Equation here:");
		lblInputEquationHere.setBounds(10, 165, 169, 14);
		contentPane.add(lblInputEquationHere);
		
		JLabel Title = new JLabel("Postfix Calculator By Brendan Louey");
		Title.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Title.setBounds(10, 11, 292, 20);
		contentPane.add(Title);
		
		inputField = new JTextField();
		inputField.setBounds(10, 182, 281, 20);
		contentPane.add(inputField);
		inputField.setColumns(10);
		
		postfixField = new JTextField();
		postfixField.setEditable(false);
		postfixField.setBounds(10, 227, 281, 20);
		contentPane.add(postfixField);
		postfixField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Postfix Expression");
		lblNewLabel_1.setBounds(10, 212, 204, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Answer");
		lblNewLabel_2.setBounds(10, 247, 143, 14);
		contentPane.add(lblNewLabel_2);
		
		answerField = new JTextField();
		answerField.setEditable(false);
		answerField.setBounds(10, 269, 281, 20);
		contentPane.add(answerField);
		answerField.setColumns(10);
		
		JTextArea InfoArea = new JTextArea();
		InfoArea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		InfoArea.setEditable(false);
		InfoArea.setText("Enter the equation without any spaces\nbetween the elements of the equation.\r\nExample: 3^(12/6)\r\nValid operators are:\r\n*, /, +, -, ^.\r\nThe program does not check for errors.\nPress calculate to begin calculation");
		InfoArea.setBounds(10, 36, 237, 112);
		contentPane.add(InfoArea);
		
		JButton calculate = new JButton("Calculate");
		calculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			input = inputField.getText();
			InfixToPostfix postfix = new InfixToPostfix();
			String endstring = postfix.infixToPostfix(input);
			postfixField.setText(endstring);
			double result = Evaluate.evaluate(endstring);
			answerField.setText(""+result);
			repaint();
			}
		});
		calculate.setBounds(372, 182, 89, 20);
		contentPane.add(calculate);
	}
}
