package view;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MyListSelectionListener implements ListSelectionListener {
	private JTable jTable;
	private MainFrame mainFrame;
	public MyListSelectionListener(JTable jTable, MainFrame mainFrame) {
		this.jTable = jTable;
		this.mainFrame = mainFrame;
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		String keyword = (String) jTable.getValueAt(e.getLastIndex(), 0);// e.getLastIndex()���ظı���Table��������
		// ���￴������text�����ݷ����仯��Ӧ��д������
		String text = mainFrame.rightPane.getjTextArea().getText();
		mainFrame.setKeywordAndText(keyword, text);
		
	}
}
