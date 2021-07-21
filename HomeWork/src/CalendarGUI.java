import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalendarGUI extends JFrame implements ActionListener {
	Calendar now = Calendar.getInstance();
	Calendar cal = Calendar.getInstance();
	int year = cal.get(Calendar.YEAR);
	int month = cal.get(Calendar.MONTH);

	Font fnt = new Font("고딕", Font.BOLD, 25);

	JPanel paneBtn = new JPanel();
	JPanel paneBody = new JPanel(new BorderLayout());
	JPanel paneWeek = new JPanel(new GridLayout(1, 7, 1, 1));
	JPanel paneDay = new JPanel(new GridLayout(0, 7, 1, 1));
	JButton pre = new JButton("◀");
	JButton next = new JButton("▶");
	JComboBox setYear;
	JComboBox setMonth;


	public CalendarGUI() {
		add(BorderLayout.NORTH, paneBtn);
		add(paneBody);
		paneBody.add(BorderLayout.NORTH, paneWeek);
		paneBody.add(paneDay);

		cal.set(year, month, 1);

		setButton();
		dayOfWeek();
		printDay();

		setTitle("카렌다");
		setBounds(700, 300, 500, 500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		pre.addActionListener(this);
		next.addActionListener(this);
		setYear.addActionListener(this);
		setMonth.addActionListener(this);
	}

	public void setButton() {
		JLabel yearLbl = new JLabel("년  ", JLabel.LEFT);
		JLabel monthLbl = new JLabel("월  ", JLabel.LEFT);

		Vector<Integer> year = new Vector<Integer>(200);
		for (int i = now.getWeekYear() - 100; i < now.getWeekYear() + 101; i++) {
			year.add(i);
		}
		setYear = new JComboBox<Integer>(year);
		setYear.setSelectedItem(now.getWeekYear());
		Vector<Integer> month = new Vector<Integer>(12);
		for (int i = 0; i < month.capacity(); i++) {
			month.add(i + 1);
		}
		setMonth = new JComboBox<Integer>(month);
		setMonth.setSelectedItem(now.get(Calendar.MONTH) + 1);

		pre.setFont(fnt);
		setYear.setFont(fnt);
		yearLbl.setFont(fnt);
		setMonth.setFont(fnt);
		monthLbl.setFont(fnt);
		next.setFont(fnt);
		paneBtn.add(pre);
		paneBtn.add(setYear);
		paneBtn.add(yearLbl);
		paneBtn.add(setMonth);
		paneBtn.add(monthLbl);
		paneBtn.add(next);

	}

	public void dayOfWeek() {
		String dayOfWeek[] = { "일", "월", "화", "수", "목", "금", "토" };
		Font fnt = new Font("맑은 고딕", Font.PLAIN, 25);
		for (int i = 0; i < dayOfWeek.length; i++) {
			JButton btn = new JButton(dayOfWeek[i]);
			btn.setFont(fnt);
			btn.setBorderPainted(false);
			btn.setFocusPainted(false);
			if (i == 0) {
				btn.setForeground(Color.RED);
			} else if (i == 6) {
				btn.setForeground(Color.BLUE);
			} else {
				btn.setForeground(Color.BLACK);
			}
			btn.setBackground(new Color(240, 240, 240));
			paneWeek.add(btn);
		}
	}

	public void printDay() {
		int lastDay = cal.getActualMaximum(Calendar.DATE);
		int firstDay = cal.get(Calendar.DAY_OF_WEEK);

		for (int i = 1; i < firstDay; i++) {
			JButton blank = new JButton(" ");
			blank.setBackground(new Color(240, 240, 240));
			blank.setEnabled(false);
			paneDay.add(blank);
			blank.setBorderPainted(false);
		}

		for (int i = 0; i < lastDay; i++) {
			JButton dayBtn = new JButton(Integer.toString(i + 1));
			dayBtn.setFont(fnt);
			dayBtn.setBackground(new Color(240, 240, 240));
			if (firstDay % 7 == 0) {
				dayBtn.setForeground(new Color(0, 0, 250));
				firstDay = 0;
			} else if (firstDay == 1) {
				dayBtn.setForeground(new Color(250, 0, 0));
			}
			firstDay++;
			paneDay.add(dayBtn);
			dayBtn.setBorderPainted(false);
			dayBtn.setFocusPainted(false);
		}
	}

	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if (obj instanceof JButton) {
			change(ae.getActionCommand());
		} else if (obj instanceof JComboBox) {
			year = (int) setYear.getSelectedItem();
			month = ((int) setMonth.getSelectedItem()) - 1;
		}
		cal.set(year, month, 1);
		paneDay.removeAll();
		paneDay.setVisible(false);
		printDay();
		paneDay.setVisible(true);
	}

	public void change(String changeMonth) {
		setYear.removeActionListener(this);
		setMonth.removeActionListener(this);
		if (changeMonth.equals("◀")) {
			if (month == 1) {
				month = 12;
				year --;
			}else {
				month--;
			}
		} else {
			if (month == 12) {
				month = 1;
				year ++;
			}else {
				month ++;
			}
		}
		setYear.setSelectedItem(year);
		setMonth.setSelectedItem(month);
		setYear.addActionListener(this);
		setMonth.addActionListener(this);
	}

	public static void main(String[] args) {
		new CalendarGUI();
	}

}
