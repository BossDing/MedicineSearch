package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JTextArea;

public class MyButtonActionListener implements ActionListener {
	private JTable jTable;
	private JTextArea jTextArea;
	public MyButtonActionListener(JTable jTable) {
		this.jTable = jTable;
	}
	public MyButtonActionListener(JTextArea jTextArea) {
		this.jTextArea = jTextArea;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		/*û�������*/
		if (this.jTable != null)
			jTable.setRowSelectionInterval(0, jTable.getSelectedRow() + 1);
		
		jTextArea.select(0, 5);
		jTextArea.requestFocus();
		
		// �ж��Ƿ�����һ�������û�д�ӡ�����������ʾ��
		//JOptionPane.showMessageDialog(MainFrame.this, "û���ҵ���һ��", "��ʾ", JOptionPane.CLOSED_OPTION);
	}
}
