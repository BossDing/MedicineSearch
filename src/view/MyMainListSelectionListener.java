package view;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.util.TextFileReader;

public class MyMainListSelectionListener implements ListSelectionListener {

	private JTable jMainTable;
	private MainFrame mainFrame;

	public MyMainListSelectionListener(JTable jMainTable, MainFrame mainFrame) {
		this.jMainTable = jMainTable;
		this.mainFrame = mainFrame;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) { // ��e.getValueIsAdjusting()ֵΪtrue����˵����갴�²����������Ӵ��жϣ�����갴�º�̧�𶼻�ִ��
			int index = jMainTable.getSelectedRow() > -1 ? jMainTable.getSelectedRow() : 0;
			String bookName = (String) jMainTable.getValueAt(index, 0); // ��ȡ����
			String context = TextFileReader.getInstance().getBook(bookName).getContext();
			mainFrame.rightPane.getjTextArea().setText(context);
			mainFrame.rightPane.getjTextArea().setCaretPosition(0);
			mainFrame.setKeywordAndText(mainFrame.keyword, context);
			
		}
	}

}
