package view.listener;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import model.list.MedicineBookList;
import view.MainFrame;

public class MyLeftListSelectionListener implements ListSelectionListener {
	private JTable jLeftTable;
	private MainFrame mainFrame;

	public MyLeftListSelectionListener(JTable jLeftTable, MainFrame mainFrame) {
		this.jLeftTable = jLeftTable;
		this.mainFrame = mainFrame;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) { // ��e.getValueIsAdjusting()ֵΪtrue����˵����갴�²����������Ӵ��жϣ�����갴�º�̧�𶼻�ִ��
			String keyword = (String) jLeftTable.getValueAt(jLeftTable.getSelectedRow(), 0);
			String text = mainFrame.rightPanel.getjTextArea().getText();
			mainFrame.setKeywordAndText(keyword, text);
			// ��������
			Object[][] medicineBookList = new MedicineBookList(mainFrame.keyword).toArray();
			// ����
			String[] mainColumnNames = mainFrame.leftPanel.getMainColumnNames();
			DefaultTableModel dtm = new DefaultTableModel();
			dtm.setDataVector(medicineBookList, mainColumnNames);
			mainFrame.leftPanel.getMainTable().setModel(dtm);
			if (mainFrame.leftPanel.getMainTable().getRowCount() > 0)
				mainFrame.leftPanel.getMainTable().setRowSelectionInterval(0, 0);
		}
	}

}
