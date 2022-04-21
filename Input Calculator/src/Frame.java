import java.lang.StringBuffer;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends Answer {

	Answer answer = new Answer();

	public Frame() {
	}

	JLabel text = new JLabel();
	JTextField panel = new JTextField();

	JButton number0 = new JButton("0");
	JButton number1 = new JButton("1");
	JButton number2 = new JButton("2");
	JButton number3 = new JButton("3");
	JButton number4 = new JButton("4");
	JButton number5 = new JButton("5");
	JButton number6 = new JButton("6");
	JButton number7 = new JButton("7");
	JButton number8 = new JButton("8");
	JButton number9 = new JButton("9");
	JButton addition = new JButton("+");
	JButton subtraction = new JButton("-");
	JButton multiplication = new JButton("*");
	JButton division = new JButton("÷");
	JButton equals = new JButton("=");
	JButton clear = new JButton("AC");
	JButton decimal = new JButton(".");

	public void makeFrame() {

		JFrame frame = new JFrame("Calculator");

		number7.setBounds(25, 55, 45, 45);
		number8.setBounds(75, 55, 45, 45);
		number9.setBounds(125, 55, 45, 45);
		addition.setBounds(175, 55, 45, 45);
		number4.setBounds(25, 105, 45, 45);
		number5.setBounds(75, 105, 45, 45);
		number6.setBounds(125, 105, 45, 45);
		subtraction.setBounds(175, 105, 45, 45);
		number1.setBounds(25, 155, 45, 45);
		number2.setBounds(75, 155, 45, 45);
		number3.setBounds(125, 155, 45, 45);
		multiplication.setBounds(175, 155, 45, 45);
		number0.setBounds(25, 205, 95, 45);
		division.setBounds(175, 205, 45, 45);
		equals.setBounds(25, 255, 95, 45);
		clear.setBounds(125, 255, 95, 45);
		panel.setBounds(25, 10, 195, 35);
		decimal.setBounds(125, 205, 45, 45);
		frame.add(number0);
		frame.add(number1);
		frame.add(number2);
		frame.add(number3);
		frame.add(number4);
		frame.add(number5);
		frame.add(number6);
		frame.add(number7);
		frame.add(number8);
		frame.add(number9);
		frame.add(addition);
		frame.add(subtraction);
		frame.add(multiplication);
		frame.add(division);
		frame.add(equals);
		frame.add(clear);
		frame.add(panel);
		frame.add(decimal);
		frame.setSize(263, 360);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	public void updateFrame(String value) {
		panel.setText(value);
	}

	public void pressButton(JButton jButton, StringBuffer temp, JTextField panel, String append, StringBuffer temp2) {
		jButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temp.append(append);
				temp2.append(append);
				String realTemp = temp2.toString();
				panel.setText(realTemp);
			}
		});
	}

	public void decimalButton(JButton jButton, StringBuffer temp, JTextField panel, String append, StringBuffer temp2) {
		jButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temp.append(append);
				temp2.append(append);
				String realTemp = temp2.toString();
				panel.setText(realTemp);
				decimal.setEnabled(false);
			}
		});
	}

	public static void disableButtons(Frame frame) {
		frame.number0.setEnabled(false);
		frame.number1.setEnabled(false);
		frame.number2.setEnabled(false);
		frame.number3.setEnabled(false);
		frame.number4.setEnabled(false);
		frame.number5.setEnabled(false);
		frame.number6.setEnabled(false);
		frame.number7.setEnabled(false);
		frame.number8.setEnabled(false);
		frame.number9.setEnabled(false);
	}

	public static void enableButtons(Frame frame) {
		frame.number0.setEnabled(true);
		frame.number1.setEnabled(true);
		frame.number2.setEnabled(true);
		frame.number3.setEnabled(true);
		frame.number4.setEnabled(true);
		frame.number5.setEnabled(true);
		frame.number6.setEnabled(true);
		frame.number7.setEnabled(true);
		frame.number8.setEnabled(true);
		frame.number9.setEnabled(true);
	}

	public void Button(Frame frame, JButton jButton, StringBuffer temp, JTextField panel, Answer answer,
			String operation, StringBuffer temp2) {
		jButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (temp.length() > 0) {

					String tempValue = temp.toString();
					answer.doubleAnswer += Double.parseDouble(tempValue);

					temp2.delete(0, temp2.length());

					temp.delete(0, temp.length());
					temp.append("0");

					// Temp2 parameter is used to display the same information as temporary without
					// the leading zero.

					String realTemp = temp2.toString();
					panel.setText(realTemp);

					// Sets an operation (below) that will be read by the equals button. If the
					// certain button (say, addition) is pressed, the operation will be set to
					// "addition"; When the equals button is pressed, the calculator will then add
					// the temporary value input.

					answer.operation = operation;

					// Disables all the buttons until the operation is complete
					addition.setEnabled(false);
					subtraction.setEnabled(false);
					multiplication.setEnabled(false);
					division.setEnabled(false);
					equals.setEnabled(true);
					decimal.setEnabled(true);
					enableButtons(frame);
				}
			}
		});
	}

	public void clear(Frame frame, JButton jButton, StringBuffer temp, JTextField panel, Answer answer,
			StringBuffer temp2) {
		jButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Clears the fields and restarts the temporary string buffer value
				answer.doubleAnswer = 0;
				answer.operation = "";

				temp.delete(0, temp.length());
				temp.append("0");

				temp2.delete(0, temp2.length());

				panel.setText("");

				addition.setEnabled(true);
				subtraction.setEnabled(true);
				multiplication.setEnabled(true);
				division.setEnabled(true);
				decimal.setEnabled(true);
				enableButtons(frame);
			}
		});
	}

	public void operation(StringBuffer temp, Answer answer, String operation, Frame frame) {
		double currentAnswer = 0;
		String tempValue = temp.toString();
		double value = Double.parseDouble(tempValue);
		// Taking the current temporary value and -- depending on the operation -- will
		// provide the operation and print out the answer.
		if (operation.equals("addition")) {
			currentAnswer = answer.doubleAnswer += value;
		} else if (operation.equals("subtraction")) {
			currentAnswer = answer.doubleAnswer -= value;
		} else if (operation.equals("multiplication")) {
			currentAnswer = answer.doubleAnswer *= value;
		} else if (operation.equals("division")) {
			if (value == 0) {
				frame.updateFrame("DIVIDE BY ZERO ERROR");
				addition.setEnabled(false);
				subtraction.setEnabled(false);
				multiplication.setEnabled(false);
				division.setEnabled(false);
				answer.doubleAnswer = 0;
				answer.operation = "";
			} else {
				currentAnswer = answer.doubleAnswer /= value;
			}
		}
		// Saves the answer to the Answer class field
		currentAnswer = (double) Math.round(currentAnswer * 100) / 100; // Rounds to two decimal places
		answer.doubleAnswer = currentAnswer;
		String finalAnswer = currentAnswer + "";
		if (!panel.getText().equals("DIVIDE BY ZERO ERROR")) {
			updateFrame(finalAnswer);
		}
		// Clears the temporary string buffer value
		temp.delete(0, temp.length());
		temp.append("0");
	}

}
