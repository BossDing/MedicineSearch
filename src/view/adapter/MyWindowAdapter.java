package view.adapter;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class MyWindowAdapter extends WindowAdapter {
	@Override
	public void windowClosing(WindowEvent e) {
		try {
			if (JOptionPane.showConfirmDialog(null, "�Ƿ��˳�?", "��ʾ",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		} catch (Exception e1) {
		}
	}
}
