import java.lang.StringBuffer;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends Frame {

	public static void main(String[] args) {

		// Program that uses a string buffer / parsing. Will append certain numbers to
		// the string
		// buffer based on the buttons, and display the value.
		// Once the string buffer has its value, an operation button will clear the
		// buffer for another value to be inserted.
		// After the second value has been added and the equals button has been pressed,
		// will undergo the operation and
		// generate the answer.

		StringBuffer tempValue = new StringBuffer("0");
		StringBuffer displayTemp = new StringBuffer("");

		Frame frame = new Frame();
		frame.makeFrame();
		frame.updateFrame("0");

		// Functionality of the buttons; The buttons are supposed to append values to
		// the temporary string buffer and display the current number.

		frame.pressButton(frame.number0, tempValue, frame.panel, "0", displayTemp);
		frame.pressButton(frame.number1, tempValue, frame.panel, "1", displayTemp);
		frame.pressButton(frame.number2, tempValue, frame.panel, "2", displayTemp);
		frame.pressButton(frame.number3, tempValue, frame.panel, "3", displayTemp);
		frame.pressButton(frame.number4, tempValue, frame.panel, "4", displayTemp);
		frame.pressButton(frame.number5, tempValue, frame.panel, "5", displayTemp);
		frame.pressButton(frame.number6, tempValue, frame.panel, "6", displayTemp);
		frame.pressButton(frame.number7, tempValue, frame.panel, "7", displayTemp);
		frame.pressButton(frame.number8, tempValue, frame.panel, "8", displayTemp);
		frame.pressButton(frame.number9, tempValue, frame.panel, "9", displayTemp);
		frame.decimalButton(frame.decimal, tempValue, frame.panel, ".", displayTemp);

		// Functionality of the operation buttons below; Created with every button
		// changing
		// the operation to the respective string. The equals button will read the
		// string and will perform the certain operation.

		frame.equals.setEnabled(false);
		frame.Button(frame, frame.addition, tempValue, frame.panel, frame.answer, "addition", displayTemp);
		frame.Button(frame, frame.subtraction, tempValue, frame.panel, frame.answer, "subtraction", displayTemp);
		frame.Button(frame, frame.multiplication, tempValue, frame.panel, frame.answer, "multiplication", displayTemp);
		frame.Button(frame, frame.division, tempValue, frame.panel, frame.answer, "division", displayTemp);

		frame.clear(frame, frame.clear, tempValue, frame.panel, frame.answer, displayTemp);

		frame.equals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.addition.setEnabled(true);
				frame.subtraction.setEnabled(true);
				frame.multiplication.setEnabled(true);
				frame.division.setEnabled(true);
				frame.equals.setEnabled(false);
				frame.decimal.setEnabled(false);

				disableButtons(frame);

				if (frame.answer.operation.equals("addition")) {
					frame.operation(tempValue, frame.answer, "addition", frame);
				}
				if (frame.answer.operation.equals("subtraction")) {
					frame.operation(tempValue, frame.answer, "subtraction", frame);
				}
				if (frame.answer.operation.equals("multiplication")) {
					frame.operation(tempValue, frame.answer, "multiplication", frame);
				}
				if (frame.answer.operation.equals("division")) {
					frame.operation(tempValue, frame.answer, "division", frame);
				}
			}
		});
	}
}
