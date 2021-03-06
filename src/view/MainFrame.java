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
		// 初始化组件
		// 加载数据
		// 左侧Panel
		this.leftPanel = new LeftPanel(this);
		// 右侧Panel
		this.rightPanel = new RightPanel(this);
		// 设定JFrame属性
		this.setFrame();
	}

	// 设定Frame面板
	private void setFrame() {
		// 设定JFrame的总体布局
		this.setLayout(new GridLayout(1, 2));
		// 向JFrame面板中添加面板组件
		this.add(leftPanel);
		this.add(rightPanel);
		this.addWindowListener(new MyWindowAdapter());
		this.setTitle("基础检测子系统");
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
