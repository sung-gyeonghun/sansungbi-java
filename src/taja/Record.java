
package taja;

import java.io.IOException;


public class Record extends Thread{
  static String timerBuffer; // 04:11:15 ���� ��� �ð� ���ڿ��� ����� ���� ����
  static int oldTime; // Ÿ�̸Ӱ� ON �Ǿ��� ���� �ð��� ����ϰ� �ִ� ����

  public void run(){
	  stopwatch(1);
	  System.out.println("Timer ON! ���� Ű�� ������ �����մϴ�");
  }
  
  public void exit(){
	  stopwatch(0);
  }


  public static void stopwatch(int onOff) {
    if (onOff == 1) // Ÿ�̸� �ѱ�
      oldTime = (int) System.currentTimeMillis() / 1000;

    if (onOff == 0) // Ÿ�̸� ����, �ú��ʸ� timerBuffer �� ����
      secToHHMMSS(  ((int) System.currentTimeMillis() / 1000) - oldTime  );

  }


  // ������ �� �ð��� �ʴ���(sec)�� �Է� �޾�, "04:11:15" ���� ������ ���ڿ��� �ú��ʸ� ����
  public static void secToHHMMSS(int secs) {
    int hour, min, sec;

    sec  = secs % 60;
    min  = secs / 60 % 60;
    hour = secs / 3600;

    timerBuffer = String.format("%02d:%02d:%02d", hour, min, sec);
  }


  public static void pause() {
    try {
      System.in.read();
    } catch (IOException e) { }
  }


}