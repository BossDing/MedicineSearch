package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

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

	// �������� Ҫд��ģ�Ͳ����Ʋ�
	private void loadData() {
		// ������ʾ����
		leftData = new Object[50][2];
		for (int i = 0; i < leftData.length; i++) {
			leftData[i][0] = "�����";
			leftData[i][1] = "Sue";
		}
		mainData = new Object[50][4];
		for (int i = 0; i < mainData.length; i++) {
			mainData[i][0] = "���ݸ�Ŀ���ݸ�Ŀ���ݸ�Ŀ���ݸ�Ŀ���ݸ�Ŀ���ݸ�Ŀ";
			mainData[i][1] = "��ʱ��";
			mainData[i][2] = "��";
			mainData[i][3] = "1518��";
		}
	}

	public LeftPanel(MainFrame mainFrame) {
		this.setLayout(new BorderLayout());
		lMainPanel = new JPanel(new BorderLayout());
		lleftPanel = new JPanel(new BorderLayout());
		leftLabel = new JLabel("��عؼ���");
		mainLabel = new JLabel("��ҽ����");
		leftLabelPanel = new JPanel();
		mainLabelPanel = new JPanel();

		loadData();

		// ���Panel
		leftLabelPanel.add(leftLabel);
		lleftPanel.add(leftLabelPanel, BorderLayout.NORTH);
		leftTable = new MyJTable(leftData, leftColumnNames, "LeftTable");
		// ��ʼ��������keyword
		mainFrame.keyword = (String) leftTable.getValueAt(leftTable.getSelectedRow(), 0);
		// �趨���Table�иı��ʱ��ļ���
		leftTable.getSelectionModel().addListSelectionListener(new MyListSelectionListener(leftTable, mainFrame));
		lLeftScrollPane = new JScrollPane(leftTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		lleftPanel.add(lLeftScrollPane, BorderLayout.CENTER);
		lleftPanel.setPreferredSize(new Dimension(130, 500));

		// �м�Panel
		mainLabelPanel.add(mainLabel);
		lMainPanel.add(mainLabelPanel, BorderLayout.NORTH);
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
}
