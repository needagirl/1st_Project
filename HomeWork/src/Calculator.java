import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Optional;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calculator extends JFrame {
	JLabel text = new JLabel("0.0", JLabel.RIGHT);
	String nowText = "";

	public Calculator() {
		add(BorderLayout.NORTH, text);
		add(BorderLayout.CENTER, new MainBody());

		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}

	class Funtion extends JPanel implements ActionListener {
		JButton btn = new JButton();

		public Funtion() {
			setLayout(new GridLayout(1, 3));
			JButton b1 = new JButton("BackSpace");
			JButton b2 = new JButton("Clear");
			JButton b3 = new JButton("End");
			add(b1);
			add(b2);
			add(b3);
			b1.addActionListener(this);
			b2.addActionListener(this);
			b3.addActionListener(this);
		}

		public void actionPerformed(ActionEvent ae) {
			String event = ae.getActionCommand();
			if (event.equals("BackSpace")) {
				nowText = Optional.ofNullable(nowText).filter(s -> s.length() != 0)
						.map(s -> s.substring(0, s.length() - 1)).orElse(nowText);
				text.setText(nowText);
			} else if (event.equals("Clear")) {
				text.setText("0.0");
				nowText = "";
			} else if (event.equals("End")) {
				System.exit(0);
			}
		}
	}

	class MainBody extends JPanel {
		public MainBody() {
			setLayout(new BorderLayout());
			add(BorderLayout.NORTH, new Funtion());
			add(BorderLayout.CENTER, new Num());
		}
	}

	class Num extends JPanel implements ActionListener {
		JButton btn = new JButton();

		public Num() {
			setLayout(new GridLayout(4, 4));
			JButton b1 = new JButton("7");
			JButton b2 = new JButton("8");
			JButton b3 = new JButton("9");
			JButton b4 = new JButton("+");
			JButton b5 = new JButton("4");
			JButton b6 = new JButton("5");
			JButton b7 = new JButton("6");
			JButton b8 = new JButton("-");
			JButton b9 = new JButton("1");
			JButton b10 = new JButton("2");
			JButton b11 = new JButton("3");
			JButton b12 = new JButton("*");
			JButton b13 = new JButton("0");
			JButton b14 = new JButton(".");
			JButton b15 = new JButton("=");
			JButton b16 = new JButton("/");
			add(b1);
			add(b2);
			add(b3);
			add(b4);
			add(b5);
			add(b6);
			add(b7);
			add(b8);
			add(b9);
			add(b10);
			add(b11);
			add(b12);
			add(b13);
			add(b14);
			add(b15);
			add(b16);
			b1.addActionListener(this);
			b2.addActionListener(this);
			b3.addActionListener(this);
			b4.addActionListener(this);
			b5.addActionListener(this);
			b6.addActionListener(this);
			b7.addActionListener(this);
			b8.addActionListener(this);
			b9.addActionListener(this);
			b10.addActionListener(this);
			b11.addActionListener(this);
			b12.addActionListener(this);
			b13.addActionListener(this);
			b14.addActionListener(this);
			b15.addActionListener(this);
			b16.addActionListener(this);
		}

		public void actionPerformed(ActionEvent ae) {
			String event = ae.getActionCommand();
			if (event.equals("7")) {
				nowText = nowText + "7";
				text.setText(nowText);
			} else if (event.equals("8")) {
				nowText = nowText + "8";
				text.setText(nowText);
			} else if (event.equals("9")) {
				nowText = nowText + "9";
				text.setText(nowText);
			} else if (event.equals("+")) {
				nowText = nowText + "+";
				text.setText(nowText);
			} else if (event.equals("4")) {
				nowText = nowText + "4";
				text.setText(nowText);
			} else if (event.equals("5")) {
				nowText = nowText + "5";
				text.setText(nowText);
			} else if (event.equals("6")) {
				nowText = nowText + "6";
				text.setText(nowText);
			} else if (event.equals("-")) {
				nowText = nowText + "-";
				text.setText(nowText);
			} else if (event.equals("1")) {
				nowText = nowText + "1";
				text.setText(nowText);
			} else if (event.equals("2")) {
				nowText = nowText + "2";
				text.setText(nowText);
			} else if (event.equals("3")) {
				nowText = nowText + "3";
				text.setText(nowText);
			} else if (event.equals("*")) {
				nowText = nowText + "*";
				text.setText(nowText);
			} else if (event.equals("0")) {
				nowText = nowText + "0";
				text.setText(nowText);
			} else if (event.equals(".")) {
				nowText = nowText + ".";
				text.setText(nowText);
			} else if (event.equals("=")) {
				nowText = result(nowText);
				text.setText(nowText);
			} else if (event.equals("/")) {
				nowText = nowText + "/";
				text.setText(nowText);
			}
		}

		public String result(String nowText) {
			LinkedList<Integer> numList = new LinkedList<Integer>();
			LinkedList<Character> opList = new LinkedList<Character>();

			String s = nowText;

			String num = "";

			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);

				if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
					numList.add(Integer.parseInt(num));
					opList.add(ch);
					num = "";
					continue;
				}
				num += ch;
			}
			numList.add(Integer.parseInt(num));

			while (!opList.isEmpty()) {
				int prevNum = numList.poll();
				int nextNum = numList.poll();
				char op = opList.poll();

				if (op == '+') {
					numList.addFirst(prevNum + nextNum);
				} else if (op == '-') {
					numList.addFirst(prevNum - nextNum);
				} else if (op == '*') {
					numList.addFirst(prevNum * nextNum);
				} else if (op == '/') {
					numList.addFirst(prevNum / nextNum);
				}
			}
			return Integer.toString(numList.poll());
		}
	}

	public static void main(String[] args) {
		new Calculator();
	}

}
