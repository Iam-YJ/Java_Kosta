package test;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Frame extends JFrame implements ActionListener {

	int screenWidth;
	int screenHeight;
	JButton btn1, btn2, btn3, btn4, btn5, btn6;
	JPanel panel1, panel2, panelInput, panelOutput, mainPanel, panelSubmit;
	JTextArea textOutputArea, textInputArea;
	JLabel word, mean;
	JTextField wordWord, meanMean;

	Frame() {
		this("������ �ܾ��� ");
	}

	public void init() {
		mainPanel = new JPanel();
		panel1 = new JPanel();
		panelSubmit = new JPanel();

		btn1 = new JButton("�ܾ��� ����");
		btn1.addActionListener(this);

		btn2 = new JButton("�ְ��� ����");
		btn2.addActionListener(this);

		btn3 = new JButton("������ ����");
		btn3.addActionListener(this);

		btn4 = new JButton("�ܾ� �߰�");
		btn4.addActionListener(this);

		btn5 = new JButton("�ܾ� Ž��");
		btn5.addActionListener(this);

		panel1.add(btn1);
		panel1.add(btn2);
		panel1.add(btn3);
		panel1.add(btn4);
		panel1.add(btn5);

		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(panel1);
		panelInput = new JPanel();
		panelOutput = new JPanel();
		textOutputArea = new JTextArea();
		textInputArea = new JTextArea();
		JScrollPane scrollPaneOutput = new JScrollPane(textOutputArea);
		scrollPaneOutput.setPreferredSize(new Dimension(screenWidth, screenHeight / 3));

		mainPanel.add(scrollPaneOutput);
		mainPanel.add(textInputArea);
		mainPanel.add(panelSubmit);

		Container container = this.getContentPane();
		container.add(mainPanel, BorderLayout.NORTH);

	}

	Frame(String title) {
		super(title);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		this.screenWidth = screenSize.width;
		this.screenHeight = screenSize.height;

		init();
		find();

		this.setSize(screenWidth / 2, screenHeight / 2);
		// ũ��� ȭ�鿡 ���缭 (1/2��)
		this.setLocation(screenWidth / 4, screenHeight / 4);
		// ��ġ�� ȭ�鿡 ���缭 (1/4 ��ġ)
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setVisible(true);

	}

	void find() {
		mainPanel = new JPanel();
		word = new JLabel("�ܾ�:");
		wordWord = new JTextField(10);
		mean = new JLabel("�ǹ�:");
		meanMean = new JTextField(10);


		mainPanel.add(word);
		mainPanel.add(wordWord);
		mainPanel.add(mean);
		mainPanel.add(meanMean);
		
		this.add(mainPanel, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
