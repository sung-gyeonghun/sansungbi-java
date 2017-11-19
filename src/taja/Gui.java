package taja;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gui extends JFrame{
	Dimension dim = new Dimension(1000,500);
	Dimension dim2 = new Dimension(200,20);
	public JFrame frame = new JFrame("������Ÿ�ڿ���"); //JFrame ����
	public JLabel[] arrJ = new JLabel[5]; //JLabel �迭 ����, �ϴ� ������ 5�� �Է��ϹǷ� 5��.
	public JButton start; // JButton ����
	public JTextField inputtext; //JTextField ����
	public HashMap<Integer, String> newHash = new HashMap<Integer, String>(); //�ؽ��� ����, key�� ����Ÿ��, �� ������ StringŸ������ ����
	
	public int[] arr = new int[5]; //���� �迭 ����, �����Լ� ���� ��� ����
	Random random = new Random();
	Record record1 = new Record(); //�����ġ Ŭ���� ����
	Gui(){
		newHash.put(1, "�ϰ�õ"); //�ؽ��� ������ ����
		newHash.put(2, "�̰�õ"); //�ؽ��� ������ ����
		newHash.put(3, "�ﰡõ"); //�ؽ��� ������ ����
		newHash.put(4, "�簡õ"); //�ؽ��� ������ ����
		newHash.put(5, "����õ"); //�ؽ��� ������ ����
		for(int i = 0;i<arr.length;i++){
		arr[i] = random.nextInt(4)+1; //���� arr�迭�� 1~5�� �������� ����
		}
		frame.setPreferredSize(dim); //�������� dimũ��� ����
		ButtonListener listner = new ButtonListener(); //��ư�̺�Ʈ Ŭ���� ����
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BoxLayout(panel1,BoxLayout.X_AXIS));  //panel1�� ���ǵ� ���̺��� X������ �ڽ����̾ƿ�
		for(int i = 0; i<arrJ.length; i++){ 
		arrJ[i] = new JLabel(newHash.get(arr[i])); //JLabel�� ���ʴ�� �������� ���Ե� �����迭�� Ű������ �ϴ� �ؽ����� ������ �̸����� ���� 
		panel1.add(arrJ[i]); 
		}

		
		JPanel panel3 = new JPanel();
		start = new JButton("�Է�");
		inputtext = new JTextField(1);
		start.addActionListener(listner); //��ư�� �̺�Ʈ �߰�
		panel3.setPreferredSize(dim2);
		panel3.setLayout(new BoxLayout(panel3,BoxLayout.X_AXIS)); //panel3�� X�� �ڽ����̾ƿ� �߰�
		panel3.add(inputtext, BorderLayout.WEST);
		panel3.add(start, BorderLayout.EAST);
		
		JPanel panel4 = new JPanel();
		panel4.add(panel1);
		panel4.add(panel3);
		panel4.setLayout(new BoxLayout(panel4,BoxLayout.Y_AXIS)); //panel4�� �г�1,3�����ؼ� Y������ �ڽ����̾ƿ�
		
		frame.add(panel4);
		frame.pack();
		frame.setVisible(true);
		record1.run(); //�����ġ ����
	
		
		
	}
	
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == start){
				
				for(int i = 0; i < 5; i++){
				if(inputtext.getText().equals(newHash.get(arr[i]))) //�Էµ� ���� �ؽ����� ��� ���� ��ġ�ϸ�  
					arrJ[i].setVisible(false); // �� JLabel�� �Ⱥ��̰� �Ѵ�
				}
				if(arrJ[0].isVisible() == false && arrJ[1].isVisible() == false
						&& arrJ[2].isVisible() == false && arrJ[3].isVisible() == false
						&& arrJ[4].isVisible() == false){ // ��� JLabel�� ������ ������(��, �Ϸ�Ǹ�)
					record1.exit(); //�����ġ ����
					JOptionPane.showMessageDialog(start, "��  "  + "�����  : " +record1.timerBuffer, "��", JOptionPane.INFORMATION_MESSAGE);
					//�޼����� ���� �˸���, ����� ����Ѵ�
				}
				
			}
		}
	}
		
}
