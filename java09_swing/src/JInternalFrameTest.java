import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

public class JInternalFrameTest extends JFrame implements ActionListener{
	JDesktopPane dp = new JDesktopPane();
	JInternalFrame if1, if2, if3;
	
	ImageIcon openII = new ImageIcon("img/open.png");
	ImageIcon saveII = new ImageIcon("img/save.png");
	ImageIcon boldII = new ImageIcon("img/bold.png");
	ImageIcon italicII = new ImageIcon("img/italic.png");
	JToolBar tb = new JToolBar();
		JButton openBtn = new JButton(openII);
		JButton saveBtn = new JButton(saveII);
		JButton foreColor = new JButton("글자색");
		
		//글꼴
		JToggleButton foreBold = new JToggleButton(boldII);
		JToggleButton foreItalic = new JToggleButton(italicII);
		JComboBox<String> foreFont = new JComboBox<String>();
		JComboBox<Integer> foreFontSize = new JComboBox<Integer>();
		DefaultComboBoxModel<String> fontModel = new DefaultComboBoxModel<String>();
		DefaultComboBoxModel<Integer> sizeModel = new DefaultComboBoxModel<Integer>();
		
	int bold = 0;
	int italic = 0;
		
	public JInternalFrameTest() {
		tb.add(openBtn);
		tb.add(saveBtn);
		tb.addSeparator();
		tb.add(foreColor);
		tb.add(foreBold);
		tb.add(foreItalic);
		tb.add(foreFont);
		tb.add(foreFontSize);
		
		add(BorderLayout.NORTH, tb);
		
		
		add(dp);
		
		
		if1 = new JInternalFrame();
		if1.setSize(300, 200);
		if1.setVisible(true);
		dp.add(if1);
		
		if2 = new JInternalFrame("메모장", true);
		if2.add(new JScrollPane(new JTextArea()));
		if2.setBounds(300,200,500, 400);
		if2.setVisible(true);
		dp.add(if2);
		
		if3 = new JInternalFrame("계산기", true, true,true,true);
		if3.add(new Calculator2());
		if3.setSize(400, 350);
		if3.setVisible(true);
		dp.add(if3);
		
		setVisible(true);
		try {
			if3.setSelected(true);
		} catch (PropertyVetoException e) {
			
			e.printStackTrace();
		}
		
		setSize(1200, 1000);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//계산기 프레임 활성화 시키기
		
		openBtn.addActionListener(this);
		saveBtn.addActionListener(this);
		foreColor.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj instanceof JButton) {
			if(obj==openBtn) {
				fileOpen();
			}else if(obj==saveBtn) {
				fileSave();
			}else if(obj==foreColor) {
				setFontFore();
			}
		}
	}
	public void fileOpen () {
		JFileChooser fc= new JFileChooser();
		if(fc.showOpenDialog(this) == fc.APPROVE_OPTION) {
			File f = fc.getSelectedFile();
			JTextArea ta = new JTextArea();
			try {
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
				while(true) {
					String readData =  br.readLine();
					if(readData==null)break;
					ta.append(readData+"\n");
				}
				JScrollPane sp2 = new JScrollPane(ta);
				JInternalFrame if5 = new JInternalFrame(f.getPath(),true,true,true,true);
				if5.add(sp2);
				dp.add(if5);
				if5.setSize(500,500);
				if5.setSelected(true);
				if5.setVisible(true);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void fileSave () {
		JFileChooser fc = new JFileChooser();
		if (fc.showSaveDialog(this)==fc.APPROVE_OPTION) {
			try {
			File f = fc.getSelectedFile();
				FileWriter fw = new FileWriter(f);
				JInternalFrame selectedIF = dp.getSelectedFrame();
				//현재 선택된  frame얻어오기
				JTextArea eventTa = (JTextArea)selectedIF.getFocusOwner();
				fw.write(eventTa.getText());
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void setFontFore() {
		JColorChooser cc = new JColorChooser(Color.GREEN);
		Color selectColor = cc.showDialog(this, "글자색", Color.PINK, true);
		
		JInternalFrame selectIF = dp.getSelectedFrame();
		JTextArea ta = (JTextArea)selectIF.getFocusOwner();
		ta.setForeground(selectColor);
		
	}
	public static void main(String[] args) {
		new JInternalFrameTest();
	}


}
