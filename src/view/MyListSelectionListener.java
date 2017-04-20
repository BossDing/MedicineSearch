package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.MedicineBookList;

public class MyListSelectionListener implements ListSelectionListener {
	private JTable jLeftTable;
	private MainFrame mainFrame;

	public MyListSelectionListener(JTable jLeftTable, MainFrame mainFrame) {
		this.jLeftTable = jLeftTable;
		this.mainFrame = mainFrame;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		String keyword = (String) jLeftTable.getValueAt(e.getLastIndex(), 0);// e.getLastIndex()���ظı���Table��������
		// ���￴������text�����ݷ����仯��Ӧ��д������
		String text = mainFrame.rightPane.getjTextArea().getText();
		mainFrame.setKeywordAndText(keyword, text);
		// ��������
		Object[][] MedicineBookList = new MedicineBookList(mainFrame.keyword).toArray();
		// ����
		String[] mainColumnNames = mainFrame.leftPane.getMainColumnNames();
		
		mainFrame.leftPane.getLeftTable().removeAll();
		mainFrame.leftPane.getLeftTable();
		mainFrame.leftPane.getLeftTable().validate();
		mainFrame.leftPane.getLeftTable().updateUI();
		
//		// �����µ�JTable
//		MyJTable mainTable = new MyJTable(MedicineBookList, mainColumnNames, "MainTable");
//		mainFrame.leftPane.setMainTable(mainTable); // ����leftpane�е�MainTableֵ
//		
//		JScrollPane lMainScrollPane = new JScrollPane(mainTable);// ���µ�JTable�ŵ�Pane��
//		mainFrame.leftPane.setlMainScrollPane(lMainScrollPane); // ����leftPane�е�lMainScrollPane
//		JPanel lMainPanel = mainFrame.leftPane.getlMainPanel(); // ��ȡleftPane�е�lMainPanel
//		lMainPanel.add(lMainScrollPane, BorderLayout.CENTER); // ��lMainPanel�����lMainScrollPane����ʾ
		
		System.out.println("okok");
	}

}
