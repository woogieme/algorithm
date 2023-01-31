package Test_GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test {
	public static void main(String[] args) {
		JFrame f = new JFrame();
		JButton b = new JButton("눌러봐 ㅋㅋㅋㅋㅋㅋ");
		
//		b.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				System.out.println("누르란다고 누르냐 ");
//			}
//		});
		b.addActionListener(e->System.out.println("메롱"));
		f.add(b);
		
		f.setSize(300,400);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
