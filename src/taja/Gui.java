package taja;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gui extends JPanel implements ActionListener, KeyListener {
	private Dimension dim = new Dimension(400, 400);
	public JLabel[] arrJlabel = new JLabel[9]; /*
												 * JLabel �迭 ����, �ϴ� ������ 5�� �Է��ϹǷ�
												 * 5��.
												 */
	public JButton inputButton; // JButton ����
	public JButton startButton;
	public JTextField inputText; // JTextField ����
	public HashMap<Integer, String> wordData = new HashMap<Integer, String>();
	// �ؽ��� ����,key�� ����Ÿ��,�� ������ StringŸ������ ����
	public List<Integer> arr = new ArrayList<>(); // ��̸���Ʈ arr ����
	Random myRandom = new Random();
	totalPlayTime total_play_time = new totalPlayTime();
	public int tryCount = 0;
	public int correctCount = 0;
	
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
		//JPanel myPanel = new JPanel();
		setLayout(null); // myPanel�� ���ǵ� ���̺��� 3x3�׸��巹�̾ƿ����� ����.
		
		for (int i = 0; i < arrJlabel.length; i++) {
			arrJlabel[i] = new JLabel(
					wordData.get(arr.get(i))); /*
												 * JLabel�� ���ʴ�� �������� ���Ե� ��̸���Ʈ
												 * Ű������ �ϴ� �ؽ����� ������ �̸����� ����
												 */
			arrJlabel[i].setBounds(myRandom.nextInt(350), myRandom.nextInt(150) + 50 , 60, 50);
			add(arrJlabel[i]);
		}
		
		startButton = new JButton("�����ϱ�");
		startButton.addActionListener(this);
		startButton.setBounds(200, 200, 80, 80);
		add(startButton);
		total_play_time.playTime.setBounds(170, 0, 50, 20);
		add(total_play_time.playTime);
		inputButton = new JButton("�Է�");
		inputText = new JTextField(10);
		inputText.addKeyListener(this); // �ؽ�Ʈ�ʵ忡 Ű �̺�Ʈ �߰�(����)
		inputButton.addActionListener(this);// ��ư�� �̺�Ʈ �߰�
		inputButton.setBounds(305, 290, 70, 49);
		inputText.setBounds(0, 290, 300, 50);
		add(inputButton);
		add(inputText);
		stop();

	}

	@Override
	public void actionPerformed(ActionEvent e) { // ��ư�̺�Ʈ ����
		if (e.getSource() == inputButton) { // ��ư�� ������

			removeAnswer();
			endAnswer();

		} else if (e.getSource() == startButton) {
			start();

		}
	}

	@Override
	public void keyPressed(KeyEvent e) { // Ű�̺�Ʈ ����
		// TODO Auto-generated method stub
		if (e.getKeyCode() == 10) // ���Ͱ� ������
			tryCount++;
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
			if (inputText.getText().equals(
					wordData.get(arr.get(i)))) /* �Էµ� ���� �ؽ����� ��� ���� ��ġ�ϸ� */
				arrJlabel[i].setVisible(false); // �� JLabel�� �Ⱥ��̰� �Ѵ�
		}
		correctCount++;
		inputText.setText(""); /*
								 * JLabel Visible False ��, TextLabel�� ��ĭ���� �ξ �ٷ�
								 * �Է��Ҽ� �ְ� �Ѵ�.
								 */
		
	}

	public void endAnswer() { // ���� �� �޼ҵ�
		if (arrJlabel[0].isVisible() == false && arrJlabel[1].isVisible() == false && arrJlabel[2].isVisible() == false
				&& arrJlabel[3].isVisible() == false && arrJlabel[4].isVisible() == false
				&& arrJlabel[5].isVisible() == false && arrJlabel[6].isVisible() == false
				&& arrJlabel[7].isVisible() == false && arrJlabel[8].isVisible() == false) { // ���
			/* JLabel�� ������ ������(��,�Ϸ�Ǹ�) */
			total_play_time.stop();
			JOptionPane.showMessageDialog(inputButton, "���  : " + total_play_time.gamePlayTime + "���߷� : " + (correctCount % tryCount), "��",
					JOptionPane.INFORMATION_MESSAGE);
			// �޼����� ���� �˸���, ����� ����Ѵ�
			// getContentPane().removeAll();
			System.exit(0);// ���α׷�����

		}
	}

	public void start() {
		total_play_time.playTime.setVisible(true);
		total_play_time.start();
		for (int i = 0; i < 9; i++) {
			arrJlabel[i].setVisible(true);
		}
		inputButton.setVisible(true);
		inputText.setVisible(true);
		startButton.setVisible(false);

	}

	public void stop() {
		for (int i = 0; i < 9; i++) {
			arrJlabel[i].setVisible(false);
		}
		inputButton.setVisible(false);
		inputText.setVisible(false);
		total_play_time.playTime.setVisible(false);
	}
}
