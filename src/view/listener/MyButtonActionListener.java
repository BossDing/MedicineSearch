package view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;

import javax.swing.JOptionPane;

import view.MainFrame;

public class MyButtonActionListener implements ActionListener {
	private MainFrame mainFrame;

	public MyButtonActionListener(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Matcher matcher = mainFrame.getMatcher();
		if (matcher.find()) {
			int start = matcher.start();
			int end = matcher.end();
			//System.out.println(start + "," + end);
			mainFrame.rightPanel.getjTextArea().select(start, end);
			mainFrame.rightPanel.getjTextArea().requestFocus();
		} else {
			// �ж��Ƿ�����һ�������û�д�ӡ�����������ʾ��
			JOptionPane.showMessageDialog(this.mainFrame, "û���ҵ���һ��", "��ʾ", JOptionPane.CLOSED_OPTION);
		}
	}
}
