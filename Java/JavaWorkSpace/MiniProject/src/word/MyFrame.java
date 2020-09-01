package word;

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

public class MyFrame extends JFrame implements ActionListener {

	int screenWidth;
	int screenHeight;
	JButton btn1, btn2, btn3, btn4, btn5, btn6;
	JPanel panel, panelInput, panelOutput, mainPanel, panelSubmit;
	JTextArea textOutputArea, textInputArea;
	ShortAnswer shortanswer;
	DB db;
	Set<Word> wordlist;
	JLabel word, mean;
	JTextField wordWord, meanMean;

	MyFrame() {
		this("�������� �ܾ���");
	}

	public void init() {
		db = new DB();
		db.Run();
		wordlist = db.getWordlist();
		mainPanel = new JPanel();
		panel = new JPanel();
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

		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(btn5);

		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(panel);
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

	MyFrame(String title) {
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

		Image img = kit.getImage("image/wordpic.JPG");
		this.setIconImage(img);
		// ������ �̹��� �ҷ����� ���

		this.setVisible(true);
		this.shortanswer = new ShortAnswer(wordlist, this);
	}

	void find() {
		mainPanel = new JPanel();
		word = new JLabel("�ܾ�:");
		wordWord = new JTextField(10);
		mean = new JLabel("�ǹ�:");
		meanMean = new JTextField(10);
		wordWord.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					System.out.println(wordWord.getText());
					String answer = db.select(wordWord.getText());
					System.out.println(answer);
					if (answer.equals("")) {
						answer = "�ܾ �������� �ʽ��ϴ�.\n";
					}
					textOutputArea.append(answer);
				} catch (NullPointerException e) {
					JOptionPane.showMessageDialog(null, "�߸��� �Է��Դϴ�.", "�޽���", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		meanMean.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					db.connectDB();
					db.registerWord(wordWord.getText(), meanMean.getText());
					db.readWord();
					wordlist = db.getWordlist();
					db.closeDB();
					textOutputArea.append("�ܾ ��ϵǾ����ϴ� ==> " + wordWord.getText() + " : " + meanMean.getText());
				} catch (NullPointerException e) {
					JOptionPane.showMessageDialog(null, "�߸��� �Է��Դϴ�.", "�޽���", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		mainPanel.add(word);
		mainPanel.add(wordWord);
		mainPanel.add(mean);
		mainPanel.add(meanMean);
		this.add(mainPanel, BorderLayout.SOUTH);
	}

//	@Override 
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {

			String tmp = "";
			for (Word w : wordlist) {
				tmp += w.toString() + "\n";
			}

			textOutputArea.setText(tmp);

		} else if (e.getSource() == btn2) {

			String tmp = "";
			tmp = " ===== ���ܾ� ���� ===== ";
			textOutputArea.append(tmp + "\n");
			tmp = " ==�ְ��� ������ �����մϴ�==";
			textOutputArea.append(tmp + "\n");

			textOutputArea.append("hi2");
			
		} else if (e.getSource() == btn3) {
			String tmp = "�ڹ� �ܼ�â���� ������ ������\n";

			System.out.println("-----���ܾ� ����-----");
			System.out.println(" 1. �ְ��� / 2. ������ ");
			System.out.print("�޴��� �Է��ϼ��� : ");
			System.out.println();

		} else if (e.getSource() == btn4) {
			String tmp = "�߰��� �ܾ �Է��ϼ���" + "\n" + "�ǹ� �Է� �� ����\n";
			textOutputArea.setText(tmp);

		} else if (e.getSource() == btn5) {
			String tmp = "�Ʒ� �ܾ�â���� �˻��ϼ���(��/��)" + "\n" + "�˻� �� ����\n";
			textOutputArea.setText(tmp);
		} else if (e.getSource() == btn6) {

		}

//		
	}

}
