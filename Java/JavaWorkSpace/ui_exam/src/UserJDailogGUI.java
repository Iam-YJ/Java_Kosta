
//UserJDailogGUI.java
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UserJDailogGUI extends JDialog implements ActionListener {

	JPanel pw = new JPanel(new GridLayout(4, 1));
	JPanel pc = new JPanel(new GridLayout(4, 1));
	JPanel ps = new JPanel();

	JLabel lable_user_no = new JLabel("USER_NO");
	JLabel lable_user_id = new JLabel("USER_ID");
	JLabel lable_password = new JLabel("PASSWORD");
	JLabel lable_nickname = new JLabel("NICKNAME");

	JTextField user_no = new JTextField(5);
	JTextField user_id = new JTextField(3);
	JTextField password = new JTextField(2);
	JTextField nickname = new JTextField(1);
		

	JButton confirm;
	JButton reset = new JButton("���");

	MenuJTabaleExam me;

	JPanel idCkP = new JPanel(new BorderLayout());
	JButton idCkBtn = new JButton("IDCheck");

	UserDefaultJTableDAO dao = new UserDefaultJTableDAO();

	public UserJDailogGUI(MenuJTabaleExam me, String index) {
		super(me, "���̾�α�");
		this.me = me;
		if (index.equals("����")) {
			confirm = new JButton(index);
		} else {
			confirm = new JButton("����");

			// text�ڽ��� ���õ� ���ڵ��� ���� �ֱ�
			int row = me.jt.getSelectedRow();// ���õ� ��
			user_no.setText(me.jt.getValueAt(row, 0).toString());
			user_id.setText(me.jt.getValueAt(row, 1).toString());
			password.setText(me.jt.getValueAt(row, 2).toString());
			nickname.setText(me.jt.getValueAt(row, 3).toString());

			// id text�ڽ� ��Ȱ��
			user_id.setEditable(false);

			// IDCheck��ư ��Ȱ��ȭ
			idCkBtn.setEnabled(false);
			
			
			
		}

		// Label�߰��κ�
		pw.add(lable_user_no);// ID
		pw.add(lable_user_id);// �̸�
		pw.add(lable_password);// ����
		pw.add(lable_nickname);// �ּ�

		idCkP.add(user_id, "Center");
		idCkP.add(idCkBtn, "East");

		// TextField �߰�

		//pc.add(idCkP);
		//pc.add(user_no);
		pc.add(user_id);
		pc.add(password);
		pc.add(nickname);

		ps.add(confirm);
		ps.add(reset);

		add(pw, "West");
		add(pc, "Center");
		add(ps, "South");

		setSize(400, 300);
		setVisible(true);

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		// �̺�Ʈ���
		confirm.addActionListener(this); // ����/���� �̺�Ʈ���
		reset.addActionListener(this); // ��� �̺�Ʈ���
		idCkBtn.addActionListener(this);// ID�ߺ�üũ �̺�Ʈ ���

	}// �����ڳ�

	/**
	 * ����/����/���� ��ɿ� ���� �κ�
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String btnLabel = e.getActionCommand();// �̺�Ʈ��ü ���� Label ��������

		if (btnLabel.equals("����")) {
			if (dao.userListInsert(this) > 0) {// ���Լ���
				messageBox(this, nickname.getText() + "�� ������帳�ϴ�.");
				dispose();// JDialog â�ݱ�

				dao.userSelectAll(me.dt);// ��緹�ڵ尡���ͼ� DefaultTableModel�� �ø���

				if (me.dt.getRowCount() > 0)
					me.jt.setRowSelectionInterval(0, 0);// ù��° �� ����

			} else {// ���Խ���
				messageBox(this, "���Ե��� �ʾҽ��ϴ�.");
			}

		} else if (btnLabel.equals("����")) {

			if (dao.userUpdate(this) > 0) {
				messageBox(this, "�����Ϸ�Ǿ����ϴ�.");
				dispose();
				dao.userSelectAll(me.dt);
				if (me.dt.getRowCount() > 0)
					me.jt.setRowSelectionInterval(0, 0);

			} else {
				messageBox(this, "�������� �ʾҽ��ϴ�.");
			}

		} else if (btnLabel.equals("���")) {
			dispose();

		} else if (btnLabel.equals("IDCheck")) {
			// id�ؽ�Ʈ�ڽ��� �� ������ �޼��� ��� ������ DB�����Ѵ�.
			if (user_id.getText().trim().equals("")) {
				messageBox(this, "ID�� �Է����ּ���.");
				user_id.requestFocus();// ��Ŀ���̵�
			} else {

				if (dao.getIdByCheck(user_id.getText())) { // �ߺ��ƴϴ�.(��밡��)
					messageBox(this, user_id.getText() + "�� ��밡���մϴ�.");
				} else { // �ߺ��̴�.
					messageBox(this, user_id.getText() + "�� �ߺ��Դϴ�.");

					user_id.setText("");// text�ڽ������
					user_id.requestFocus();// Ŀ������
				}

			}

		}

	}// actionPerformed��

	/**
	 * �޽����ڽ� ����ִ� �޼ҵ� �ۼ�
	 */
	public static void messageBox(Object obj, String message) {
		JOptionPane.showMessageDialog((Component) obj, message);
	}

}// Ŭ������