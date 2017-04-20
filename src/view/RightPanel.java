package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controller.util.TextFileReader;

public class RightPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JPanel rightNorthPanel; // 右侧面板中的北侧面板
	private JScrollPane rightScrollPane; // 右侧面板中的Scroll面板
	private JLabel rightLabel; // 右侧面板中的北侧面板中的标签组件
	private JButton searchNextButton; // 右侧面板中的北侧面板中的按钮组件
	private JTextArea jTextArea; // 右侧面板中的中间Scroll面板中的TextArea组件

	public RightPanel(MainFrame mainFrame) {
		this.setLayout(new BorderLayout());
		rightNorthPanel = new JPanel(new GridLayout(1, 3));
		jTextArea = new JTextArea();
		rightLabel = new JLabel("文献文本");
		searchNextButton = new JButton("搜索/下一个");
		rightNorthPanel.add(new JLabel(""));
		rightNorthPanel.add(rightLabel);
		rightNorthPanel.add(searchNextButton);
		this.add(rightNorthPanel, BorderLayout.NORTH);
		jTextArea.setEditable(false); // 设置不可编辑
		
		//new TextFileReader().getBook("9194-竹林女科证治");
		
		jTextArea.setText("凤凰网资讯、凤凰网新闻24小时提供大陆、台湾、香港、国际重大新闻资讯,\n凤凰聚焦、热追踪、凤凰知道紧跟时事热点,军事、历史、社");
		rightScrollPane = new JScrollPane(jTextArea);
		this.add(rightScrollPane, BorderLayout.CENTER);
		// 初始化text
		// 初始化pattern和matcher
		mainFrame.setText(jTextArea.getText());
		// 该句一定要放在matcher = pattern.matcher(text);之后，否则空指针异常
		searchNextButton.addActionListener(
				new MyButtonActionListener(mainFrame, jTextArea, mainFrame.leftPane.getLeftTable(), mainFrame.getMatcher()));
	}

	public JTextArea getjTextArea() {
		return jTextArea;
	}
}
