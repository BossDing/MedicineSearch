package view;

import java.awt.GridLayout;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;

import view.adapter.MyWindowAdapter;
import view.panel.LeftPanel;
import view.panel.RightPanel;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	public LeftPanel leftPanel;
	public RightPanel rightPanel;
	public String keyword;
	public String bookName;
	public String text;
	private Pattern pattern;
	private Matcher matcher;
	
	public MainFrame() {
		// ��ʼ�����
		// ��������
		// ���Panel
		this.leftPanel = new LeftPanel(this);
		// �Ҳ�Panel
		this.rightPanel = new RightPanel(this);
		// �趨JFrame����
		this.setFrame();
	}

	// �趨Frame���
	private void setFrame() {
		// �趨JFrame�����岼��
		this.setLayout(new GridLayout(1, 2));
		// ��JFrame��������������
		this.add(leftPanel);
		this.add(rightPanel);
		this.addWindowListener(new MyWindowAdapter());
		this.setTitle("���������ϵͳ");
		this.setSize(1000, 600);
		this.setResizable(false);
		this.setVisible(true);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

/*	public void setKeyword(String keyword) {
		this.keyword = keyword;
		this.updateMatcherPattern(keyword, text);
	}*/

	public void setText(String text) {
		this.text = text;
		this.updateMatcherPattern(keyword, text);
	}
	
	public void setKeywordAndText(String keyword, String text) {
		this.keyword = keyword;
		this.text = text;
		this.updateMatcherPattern(keyword, text);
	}

	public Matcher getMatcher() {
		return matcher;
	}
	
	private void updateMatcherPattern(String keyword, String text) {
		this.pattern = Pattern.compile(keyword);
		this.matcher = pattern.matcher(text);
	}
}
