package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class MyButtonActionListener implements ActionListener {
	private JTextArea jTextArea;
	private MainFrame mainFrame;
	public MyButtonActionListener(JTable jTable) {
	}
	public MyButtonActionListener(MainFrame mainFrame, JTextArea jTextArea) {
		this.mainFrame = mainFrame;
		this.jTextArea = jTextArea;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Matcher matcher = mainFrame.getMatcher();
		if (matcher.find()) {
			int start = matcher.start();
			int end = matcher.end();
			//System.out.println(start + "," + end);
			jTextArea.select(start, end);
			jTextArea.requestFocus();
		} else {
			// �ж��Ƿ�����һ�������û�д�ӡ�����������ʾ��
			JOptionPane.showMessageDialog(this.mainFrame, "û���ҵ���һ��", "��ʾ", JOptionPane.CLOSED_OPTION);
		}
	}
}
