package view.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.list.KeywordList;
import model.list.MedicineBookList;
import view.MainFrame;
import view.component.MyJTable;
import view.listener.MyLeftListSelectionListener;
import view.listener.MyMainListSelectionListener;

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
		MyLeftListSelectionListener mlsl = new MyLeftListSelectionListener(leftTable, mainFrame);
		leftTable.getSelectionModel().addListSelectionListener(mlsl);
		lLeftScrollPane = new JScrollPane(leftTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		lleftPanel.add(lLeftScrollPane, BorderLayout.CENTER);
		lleftPanel.setPreferredSize(new Dimension(160, 500));

		// �м�Panel
		mainLabelPanel.add(mainLabel);
		lMainPanel.add(mainLabelPanel, BorderLayout.NORTH);
		// �����м��������
		mainData = new MedicineBookList(mainFrame.keyword).toArray();
		mainTable = new MyJTable(mainData, mainColumnNames, "MainTable");
		mainTable.getSelectionModel().addListSelectionListener(new MyMainListSelectionListener(mainTable, mainFrame));

		lMainScrollPane = new JScrollPane(mainTable);
		lMainPanel.add(lMainScrollPane, BorderLayout.CENTER);
		lMainPanel.setPreferredSize(new Dimension(337, 500));

		// �趨����
		this.add(lleftPanel, BorderLayout.WEST);
		this.add(lMainPanel, BorderLayout.EAST);
	}

	public MyJTable getMainTable() {
		return mainTable;
	}

	public String[] getMainColumnNames() {
		return mainColumnNames;
	}
}
