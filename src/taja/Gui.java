package taja;


import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gui extends JFrame implements ActionListener, KeyListener{
	Dimension dim = new Dimension(400,200);
	GridLayout firstGrid = new GridLayout(3, 3);
	GridLayout secondGrid = new GridLayout(1, 2);
	public JFrame frame = new JFrame("������Ÿ�ڿ���"); //JFrame ����
	public JLabel[] arrJ = new JLabel[9]; //JLabel �迭 ����, �ϴ� ������ 5�� �Է��ϹǷ� 5��.
	public JButton start; // JButton ����
	public JTextField inputtext; //JTextField ����
	public HashMap<Integer, String> newHash = new HashMap<Integer, String>(); //�ؽ��� ����, key�� ����Ÿ��, �� ������ StringŸ������ ����
	
	public int[] arr = new int[9]; //���� �迭 ����, �����Լ� ���� ��� ����
	Random random = new Random();
	Record record1 = new Record(); //�����ġ Ŭ���� ����
	Gui(){
		newHash.put(1, "�ϰ�õ"); //�ؽ��� ������ ����
		newHash.put(2, "�̰�õ"); //�ؽ��� ������ ����
		newHash.put(3, "�ﰡõ"); //�ؽ��� ������ ����
		newHash.put(4, "�簡õ"); //�ؽ��� ������ ����
		newHash.put(5, "����õ"); //�ؽ��� ������ ����
		newHash.put(6, "����õ"); //�ؽ��� ������ ����
		newHash.put(7, "����õ"); //�ؽ��� ������ ����
		newHash.put(8, "����õ"); //�ؽ��� ������ ����
		newHash.put(9, "����õ"); //�ؽ��� ������ ����
		for(int i = 0;i<arr.length;i++){
		arr[i] = random.nextInt(8)+1; //���� arr�迭�� 1~5�� �������� ����
		}
		JPanel panel1 = new JPanel();
		panel1.setLayout(firstGrid);  //panel1�� ���ǵ� ���̺��� X������ �ڽ����̾ƿ�
		for(int i = 0; i<arrJ.length; i++){ 
		arrJ[i] = new JLabel(newHash.get(arr[i])); //JLabel�� ���ʴ�� �������� ���Ե� �����迭�� Ű������ �ϴ� �ؽ����� ������ �̸����� ���� 
		panel1.add(arrJ[i]); 
		}

		
		JPanel panel3 = new JPanel();
		start = new JButton("�Է�");
		inputtext = new JTextField(1);
		inputtext.addKeyListener(this);
		start.addActionListener(this);//��ư�� �̺�Ʈ �߰�
		panel3.setLayout(secondGrid); //panel3�� X�� �ڽ����̾ƿ� �߰�
		panel3.add(inputtext);
		panel3.add(start);
		
		JPanel panel4 = new JPanel();
		panel4.add(panel1);
		panel4.add(panel3);
		panel4.setLayout(new BoxLayout(panel4,BoxLayout.Y_AXIS)); //panel4�� �г�1,3�����ؼ� Y������ �ڽ����̾ƿ�
		
		frame.add(panel4);
		frame.setPreferredSize(dim); //�������� dimũ��� ����
		frame.pack();
		frame.setVisible(true);
		record1.run(); //�����ġ ����
		
		 
		
	
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == start){
			removeAnswer();
			endAnswer();
			
		}
	}
	

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == 10)
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
	public void removeAnswer(){
		for(int i = 0; i < 9; i++){
			if(inputtext.getText().equals(newHash.get(arr[i]))) //�Էµ� ���� �ؽ����� ��� ���� ��ġ�ϸ�  
				arrJ[i].setVisible(false); // �� JLabel�� �Ⱥ��̰� �Ѵ�
			}
		inputtext.setText(""); //JLabel Visible False ��, TextLabel�� ��ĭ���� �ξ �ٷ� �Է��Ҽ� �ְ� �Ѵ�.
	}
	
	public void endAnswer(){
		if(arrJ[0].isVisible() == false && arrJ[1].isVisible() == false
				&& arrJ[2].isVisible() == false && arrJ[3].isVisible() == false
				&& arrJ[4].isVisible() == false && arrJ[5].isVisible() == false 
				&& arrJ[6].isVisible() == false
				&& arrJ[7].isVisible() == false && arrJ[8].isVisible() == false)
			{ // ��� JLabel�� ������ ������(��, �Ϸ�Ǹ�)
			record1.exit(); //�����ġ ����
			JOptionPane.showMessageDialog(start, "���  : " +record1.timerBuffer, "��", JOptionPane.INFORMATION_MESSAGE);
			//�޼����� ���� �˸���, ����� ����Ѵ�
			System.exit(0);//���α׷�����
		}
	}
	
}
