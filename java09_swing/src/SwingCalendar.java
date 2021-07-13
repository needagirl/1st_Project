import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingCalendar extends JFrame implements ActionListener{
	Font fnt = new Font("굴림체", Font.BOLD, 20);
	Calendar now = Calendar.getInstance();

	//Frame-North
	JPanel frmNorth = new JPanel();
		JButton prevMonth = new JButton("◀");
		JButton nextMonth = new JButton("▶");
		JLabel yearLbl = new JLabel("년 ");
		JLabel monthLbl = new JLabel("월 ");
		
		JComboBox<Integer> yearCombo = new JComboBox<Integer>();
		DefaultComboBoxModel<Integer> yearModel = new DefaultComboBoxModel<Integer>();
		
		JComboBox<Integer> monthCombo = new JComboBox<Integer>();
		DefaultComboBoxModel<Integer> monthModel = new DefaultComboBoxModel<Integer>();
	//Frame-Center
	JPanel frmCenter = new JPanel(new BorderLayout());
		JPanel weekTitlePane = new JPanel(new GridLayout(1,7));
		JPanel dayPane = new JPanel(new GridLayout(0,7));
		
	public SwingCalendar() {
		super("계산기");
		
		//Frame-North
		prevMonth.setFont(fnt);
		nextMonth.setFont(fnt);
		yearLbl.setFont(fnt);
		monthLbl.setFont(fnt);
		yearCombo.setFont(fnt);
		monthCombo.setFont(fnt);
		
		frmNorth.add(prevMonth);
		
		//년도 리스트
		int nowYear = setNowYear();
		yearCombo.setModel(yearModel);
		yearCombo.setSelectedItem(nowYear);//현재년도 선택
		frmNorth.add(yearCombo);
		frmNorth.add(yearLbl);
		
		//월 리스트
		int nowMonth = setNowMonth();
		monthCombo.setModel(monthModel);
		monthCombo.setSelectedItem(nowMonth+1);
		frmNorth.add(monthCombo);
		
		frmNorth.add(monthLbl);
		frmNorth.add(nextMonth);
		
		add(BorderLayout.NORTH, frmNorth);
		
		//Frame-Center
		frmCenter.add(BorderLayout.NORTH, weekTitlePane);
		frmCenter.add(dayPane);
		add(frmCenter);
		
		//요일명 만들기
		setWeekTitle();
		
		//날짜
		//해당월의 1일에 대한 요일
		int week = getOneDayWeek(nowYear, nowMonth);
		// 해당월의 마지막날
		int lastDay = now.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		setSpaceLabel(week);
		setDayLabel(nowYear, nowMonth, lastDay);
		
		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//이벤트 등록
		prevMonth.addActionListener(this);
		nextMonth.addActionListener(this);
		yearCombo.addActionListener(this);
		monthCombo.addActionListener(this);
		
	}
	
	
	public int setNowYear() {
		int year = now.get(Calendar.YEAR);
		for (int i = year+20; i >= year-100; i--) {
			yearModel.addElement(i);
		}
		return year;
	}
	public int setNowMonth() {
		for (int i = 1; i <= 12; i++) {
			monthModel.addElement(i);
		}
		return now.get(Calendar.MONTH);
	}
	
	public void setWeekTitle() {
		String weekName = "일월화수목금토";
		for (int i = 0; i < weekName.length(); i++) {
			JLabel lbl = new JLabel(weekName.substring(i,i+1), JLabel.CENTER);
			lbl.setFont(fnt);
			if(i==0) lbl.setForeground(Color.RED);
			if(i==6) lbl.setForeground(Color.BLUE);
			weekTitlePane.add(lbl);
		}
	}
	
	public int getOneDayWeek(int y, int m) {
		now.set(y, m, 1);
		return now.get(Calendar.DAY_OF_WEEK);
	}
	//공백을 추가하는 라벨
	public void setSpaceLabel(int w) {
		for(int i = 1; i<w; i++) {
			JLabel lbl = new JLabel(" ");
			dayPane.add(lbl);
		}
	}
	//날짜 추가하는 라벨
	public void setDayLabel(int year, int month, int lastDay) {
		for (int day = 1; day <= lastDay; day++) {
			JLabel lbl = new JLabel(String.valueOf(day),JLabel.CENTER);
			lbl.setFont(fnt);
			now.set(year, month, day);
			int week = now.get(Calendar.DAY_OF_WEEK);
			if(week==1) lbl.setForeground(Color.RED);
			if(week==7) lbl.setForeground(Color.BLUE);
			dayPane.add(lbl);
		}
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		//객체가 어떤 클래스로 생성되었는지 비교하는 연산자
		if(obj instanceof JButton) {
			//왼쪽,오른쪽버튼
			if(obj == prevMonth) {
				setPrevMonth();
			}else if(obj == nextMonth) {
				setNextMonth();
			}
		}else if(obj instanceof JComboBox) {
			setNewDate();
		}
	}
	public void setNewDate() {
		int year = (Integer)yearCombo.getSelectedItem();
		int month = (int)monthCombo.getSelectedItem();
		now.set(year,month-1,1);
		dayPane.removeAll();
		dayPane.setVisible(false);
		dayPane.setVisible(true);
		setSpaceLabel(now.get(Calendar.DAY_OF_WEEK));
		setDayLabel(year, month-1, now.getActualMaximum(Calendar.DAY_OF_MONTH));
	}
	//왼쪽버튼일때
	public void setPrevMonth() {
		//현재 콤보박스에 선택된 값을 가져와야함
		int y = (Integer)yearCombo.getSelectedItem();
		int m = (int)monthCombo.getSelectedItem();
		if(m==1) {//1월이면 년도를 감소하고 월은 12월로 변경
			y--;
			m=12;
		}else {
			m--;
		}
		setButtonEvent(y, m);
	}
	//오른쪽버튼일때
	public void setNextMonth() {
		int y = (Integer)yearCombo.getSelectedItem();
		int m = (int)monthCombo.getSelectedItem();
		if(m==12) {//1월이면 년도를 감소하고 월은 12월로 변경
			y++;
			m=1;
		}else {
			m++;
		}
		setButtonEvent(y, m);
	}
	public void setButtonEvent(int y, int m) {
		//comboBox의 기존이벤트제거
		yearCombo.removeActionListener(this);
		monthCombo.removeActionListener(this);
		yearCombo.setSelectedItem(y);
		monthCombo.setSelectedItem(m);
		setNewDate();
		yearCombo.addActionListener(this);
		monthCombo.addActionListener(this);
		
	}
	
	public static void main(String[] args) {
		new SwingCalendar();
	}



}
