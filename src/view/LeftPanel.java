package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.KeywordList;
import model.MedicineBookList;

public class LeftPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private MyJTable leftTable; // �����
	private MyJTable mainTable; // �м�ı��
	private JPanel lleftPanel; // �������е�������
	private JPanel lMainPanel; // �������е��Ҳ����
	// ��ͷ
	private String[] leftColumnNames = { "�ؼ���", "������" }; // �������е��������б��ı�ͷ
	private String[] mainColumnNames = { "��ҽ������", "����", "����", "���" }; // �������е��Ҳ�����б��ı�ͷ
	private JPanel leftLabelPanel; // �������е��������еı�ǩ���
	private JPanel mainLabelPanel; // �������е��Ҳ�����еı�ǩ���
	private JScrollPane lLeftScrollPane; // �������е��������е�Scroll���
	private JScrollPane lMainScrollPane; // �������е��Ҳ�����е�Scroll���
	private JLabel leftLabel; // �������е�������ı����ǩ����еı�ǩ���
	private JLabel mainLabel; // �������е��Ҳ����ı����ǩ����еı�ǩ���
	
	private Object[][] leftData; // �������е��������б�������
	private Object[][] mainData; // �������е��Ҳ�����б�������
	
	public LeftPanel(MainFrame mainFrame) {
		this.setLayout(new BorderLayout());
		lMainPanel = new JPanel(new BorderLayout());
		lleftPanel = new JPanel(new BorderLayout());
		leftLabel = new JLabel("��عؼ���");
		mainLabel = new JLabel("��ҽ����");
		leftLabelPanel = new JPanel();
		mainLabelPanel = new JPanel();
		// �������������
		leftData = new KeywordList().toArray();
		
		// ���Panel
		leftLabelPanel.add(leftLabel);
		lleftPanel.add(leftLabelPanel, BorderLayout.NORTH);
		leftTable = new MyJTable(leftData, leftColumnNames, "LeftTable");
		// ��ʼ��������keyword
		mainFrame.keyword = (String) leftTable.getValueAt(leftTable.getSelectedRow(), 0);
		// �趨���Table�иı��ʱ��ļ���
		MyListSelectionListener mlsl = new MyListSelectionListener(leftTable, mainFrame);
		leftTable.getSelectionModel().addListSelectionListener(mlsl);
		lLeftScrollPane = new JScrollPane(leftTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		lleftPanel.add(lLeftScrollPane, BorderLayout.CENTER);
		lleftPanel.setPreferredSize(new Dimension(130, 500));

		// �м�Panel
		mainLabelPanel.add(mainLabel);
		lMainPanel.add(mainLabelPanel, BorderLayout.NORTH);
		// �����м��������
		mainData = new MedicineBookList(mainFrame.keyword).toArray();
		mainTable = new MyJTable(mainData, mainColumnNames, "MainTable");
		
		lMainScrollPane = new JScrollPane(mainTable);
		lMainPanel.add(lMainScrollPane, BorderLayout.CENTER);
		lMainPanel.setPreferredSize(new Dimension(267, 500));

		// �趨����
		this.add(lleftPanel, BorderLayout.WEST);
		this.add(lMainPanel, BorderLayout.EAST);
	}
	public JTable getLeftTable() {
		return leftTable;
	}
	public void setMainTable(MyJTable mainTable) {
		this.mainTable = mainTable;
	}
	public void setMainData(Object[][] mainData) {
		this.mainData = mainData;
	}
	public String[] getMainColumnNames() {
		return mainColumnNames;
	}
	public JPanel getlMainPanel() {
		return lMainPanel;
	}
	public void setlMainScrollPane(JScrollPane lMainScrollPane) {
		this.lMainScrollPane = lMainScrollPane;
	}
	
	
}
