package view;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumn;

public class MyJTable extends JTable {
	private static final long serialVersionUID = 1L;
	public MyJTable(Object[][] rowData, Object[] columnNames, String tableName) {
		super(rowData, columnNames);
		this.setName(tableName);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// �����Ե�ѡ
		this.setRowSelectionInterval(0, 0);
		this.addMouseListener(new MyMouseOnTableAdapter(this));
	}
	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}
	/** 
	 * ���ر���е�ĳһ�� 
	 * @param table  ��� 
	 * @param index  Ҫ���ص��� ������
	 */ 
	protected void hideColumn(int index){ 
	    TableColumn tc= this.getColumnModel().getColumn(index); 
	    tc.setMaxWidth(0); 
	    tc.setPreferredWidth(0); 
	    tc.setMinWidth(0); 
	    tc.setWidth(0); 
	    this.getTableHeader().getColumnModel().getColumn(index).setMaxWidth(0); 
	    this.getTableHeader().getColumnModel().getColumn(index).setMinWidth(0); 
	}
}
