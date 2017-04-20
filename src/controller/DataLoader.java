package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import controller.util.ExcelFileReader;
import jxl.Cell;
import jxl.Sheet;
import jxl.read.biff.BiffException;
import model.Keyword;
import model.MedicineBook;

public class DataLoader {
	private ExcelFileReader efrLeft;
	private ExcelFileReader efrMain;

	private DataLoader() {
		try {
			efrLeft = new ExcelFileReader("data/��ҽ���ױ�ע���(RichEdit���473���ֺ�Ĭ��,��������).xls");
			efrMain = new ExcelFileReader("data/��ҽ�������߳�����ݱ�.xls");
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// System.out.println(efr);
		}
	}

	// ����ģʽ,����ʽ
	private static DataLoader instance = new DataLoader();

	public static DataLoader getInstance() {
		return instance;
	}

	// ����keyword����
	public List<Keyword> loadKeywordList() {
		List<Keyword> list = new ArrayList<>();

		Sheet currentSheet = efrLeft.getSheet(3); // ��3��Sheet�ǹؼ����б�
		for (int i = 1; i < currentSheet.getRows(); i++) {
			Cell[] cells = currentSheet.getRow(i);
			String word = (cells.length > 0) ? cells[0].getContents() : "";
			list.add(new Keyword(word, 0));
		}
		for (int i = 0; i < 3; i++) {
			currentSheet = efrLeft.getSheet(i);
			for (int j = 1; j < currentSheet.getRows(); j++) {
				int numY = 0;
				Cell[] cells = currentSheet.getRow(j);
				for (int k = 1; k < cells.length; k++) {
					if (cells[k].getContents().equals("Y"))
						numY++;
				}
				list.get(j - 1).setNum(list.get(j - 1).getNum() + numY);
			}
		}
		return list;
	}
	
	// ������������efrMain�в�����
	private MedicineBook getMedicineBook(String bookName) {
		Sheet sheet = efrMain.getSheet(0);
		for (int i = 1; i < sheet.getRows(); i++) {
			Cell[] row = sheet.getRow(i);
			if (row[0].getContents().equals(bookName)) {
				String author = row[1].getContents();
				String dynasty = row[2].getContents();
				String year = row[3].getContents();
				return new MedicineBook(bookName, author, dynasty, year);
			}
		}
		return null;
	}
	
	// 1.��ùؼ�����Ϊ����(����������ؼ���)
	// 2.��ѯ���ױ�ע���.xls Sheet1��2��3�ж�Ӧ�Ĺؼ��֣���ӦY����������
	// 3.ʹ������ļ����ƣ����������߳�����ݱ�.xls Sheet1���Ҷ�Ӧ���У����뵽MedicineBookList�С�
	// ����MedicineBook����
	public List<MedicineBook> loadMedicineBookList(String keyword) {
		List<MedicineBook> list = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			Cell[] row = null;
			Sheet sheet = efrLeft.getSheet(i);
			for (int j = 1; j < sheet.getRows(); j++) { // Ѱ�ҹؼ���������
				row = sheet.getRow(j);
				if (row.length > 0 && row[0].getContents().equals(keyword)) {
					break;
				}
			}
			Cell[] bookNames = sheet.getRow(0);// ��0�д�ŵ�������
			for (int j = 1; j < row.length; j++) {
				if (row[j].getContents().equals("Y")) {
					MedicineBook medicineBook = getMedicineBook(bookNames[j].getContents().substring(5));
					if (medicineBook != null) {
						list.add(medicineBook);
					}
				}
			}
		}
		return list;
	}
	
	

}
