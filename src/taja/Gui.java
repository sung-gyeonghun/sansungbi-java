package taja;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gui extends JFrame implements ActionListener, KeyListener {
	private Dimension dim = new Dimension(400, 200);
	private GridLayout firstGrid = new GridLayout(3, 3); // 3x3 �׸��巹�̾ƿ� ����
	private GridLayout secondGrid = new GridLayout(1, 2); // 1x2 �׸��巹�̾ƿ� ����
	private JFrame frame = new JFrame("������Ÿ�ڿ���"); // JFrame ����
	public JLabel[] arrJ = new JLabel[9]; // JLabel �迭 ����, �ϴ� ������ 5�� �Է��ϹǷ� 5��.
	public JButton start; // JButton ����
	public JTextField inputtext; // JTextField ����
	public HashMap<Integer, String> wordData = new HashMap<Integer, String>(); // �ؽ���
																				// ����,
																				// key��
																				// ����Ÿ��,
																				// ��
																				// ������
																				// StringŸ������
																				// ����

	public List<Integer> arr = new ArrayList<>(); // ��̸���Ʈ arr ����

	Record record1 = new Record(); // �����ġ Ŭ���� ����

	public Gui() {
		wordData.put(1, "�ϰ�õ"); // �ؽ��� ������ ����
		wordData.put(2, "�̰�õ"); // �ؽ��� ������ ����
		wordData.put(3, "�ﰡõ"); // �ؽ��� ������ ����
		wordData.put(4, "�簡õ"); // �ؽ��� ������ ����
		wordData.put(5, "����õ"); // �ؽ��� ������ ����
		wordData.put(6, "����õ"); // �ؽ��� ������ ����
		wordData.put(7, "ĥ��õ"); // �ؽ��� ������ ����
		wordData.put(8, "�Ȱ�õ"); // �ؽ��� ������ ����
		wordData.put(9, "��ȩ��õ"); // �ؽ��� ������ ����
		wordData.put(10, "�ʰ�õ"); // �ؽ��� ������ ����
		wordData.put(11, "���ϰ�õ"); // �ؽ��� ������ ����
		wordData.put(12, "���̰�õ"); // �ؽ��� ������ ����

		for (int i = 1; i < 13; i++) {
			arr.add(i);// ��̸���Ʈ�� 1����~12���� �Է�
		}

		Collections.shuffle(arr); // ��̸���Ʈ ������ ������.

		JPanel panel1 = new JPanel();
		panel1.setLayout(firstGrid); // panel1�� ���ǵ� ���̺��� 3x3�׸��巹�̾ƿ����� ����.
		for (int i = 0; i < arrJ.length; i++) {
			arrJ[i] = new JLabel(wordData.get(arr.get(i))); // JLabel�� ���ʴ�� ��������
															// ���Ե� ��̸���Ʈ Ű������
															// �ϴ�
															// �ؽ����� ������ �̸����� ����
			panel1.add(arrJ[i]);
		}

		JPanel panel3 = new JPanel();
		start = new JButton("�Է�");
		inputtext = new JTextField(1);
		inputtext.addKeyListener(this); // �ؽ�Ʈ�ʵ忡 Ű �̺�Ʈ �߰�(����)
		start.addActionListener(this);// ��ư�� �̺�Ʈ �߰�
		panel3.setLayout(secondGrid); // panel3�� 1x2 �׸��巹�̾ƿ� ����
		panel3.add(inputtext);
		panel3.add(start);

		JPanel panel4 = new JPanel();
		panel4.add(panel1);
		panel4.add(panel3);
		panel4.setLayout(new BoxLayout(panel4, BoxLayout.Y_AXIS)); // panel4��
																	// �г�1,3�����ؼ�
																	// Y������
																	// �ڽ����̾ƿ�

		frame.add(panel4);
		frame.setPreferredSize(dim); // �������� dimũ��� ����
		frame.pack();
		frame.setVisible(true);
		record1.run(); // �����ġ ����

	}

	@Override
	public void actionPerformed(ActionEvent e) { // ��ư�̺�Ʈ ����
		if (e.getSource() == start) { // ��ư�� ������
			removeAnswer();
			endAnswer();

		}
	}

	@Override
	public void keyPressed(KeyEvent e) { // Ű�̺�Ʈ ����
		// TODO Auto-generated method stub
		if (e.getKeyCode() == 10) // ���Ͱ� ������
			removeAnswer();
		endAnswer();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void removeAnswer() { // ����ó�� �޼ҵ�
		for (int i = 0; i < 9; i++) {
			if (inputtext.getText().equals(wordData.get(arr.get(i)))) // �Էµ� ����
																		// �ؽ�����
																		// ��� ����
																		// ��ġ�ϸ�
				arrJ[i].setVisible(false); // �� JLabel�� �Ⱥ��̰� �Ѵ�
		}
		inputtext.setText(""); // JLabel Visible False ��, TextLabel�� ��ĭ���� �ξ �ٷ�
								// �Է��Ҽ� �ְ� �Ѵ�.
	}

	public void endAnswer() { // ���� �� �޼ҵ�
		if (arrJ[0].isVisible() == false && arrJ[1].isVisible() == false && arrJ[2].isVisible() == false
				&& arrJ[3].isVisible() == false && arrJ[4].isVisible() == false && arrJ[5].isVisible() == false
				&& arrJ[6].isVisible() == false && arrJ[7].isVisible() == false && arrJ[8].isVisible() == false) { // ���
																													// JLabel��
																													// ������
																													// ������(��,
																													// �Ϸ�Ǹ�)
			record1.exit(); // �����ġ ����
			JOptionPane.showMessageDialog(start, "���  : " + record1.timerBuffer, "��", JOptionPane.INFORMATION_MESSAGE);
			// �޼����� ���� �˸���, ����� ����Ѵ�
			System.exit(0);// ���α׷�����

		}
	}

}
