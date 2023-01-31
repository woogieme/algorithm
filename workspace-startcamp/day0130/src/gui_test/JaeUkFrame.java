package gui_test;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Weather.WeatherDto;
import dom.WeatherDomParser_2;
import sax.WeatherSaxParser_2;

//Frame은 항상 꽉채움
//panel의 default는 적당한 크기로함 
//Frame은 게시판크기 , panel은 하나의 도화지
public class JaeUkFrame extends JFrame{
	private JButton button_seoul, button_busan;
	private JPanel panel1, panel2;
	private static String[] item = { "서울", "광주", "구미", "대전", "부울경" };
    private static String[] dong = { "1168064000", "2915573000", "4719060000", "3020052600", "2635061000" };
	public JaeUkFrame() {
		
		button_seoul = new JButton("서울");
		button_busan = new JButton("부산");
		
		button_seoul.addActionListener((e)->{
			WeatherSaxParser_2 p = new WeatherSaxParser_2("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone="+dong[0]);
			for(WeatherDto w:p.getWeatherList()) {
				System.out.println(w);
			}
		});
		System.out.println("-----------------------------");
		button_busan.addActionListener((e)->{
			WeatherSaxParser_2 p = new WeatherSaxParser_2("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone="+dong[4]);
			for(WeatherDto w:p.getWeatherList()) {
				System.out.println(w);
			}
		});
		System.out.println("-----------------------------");
		panel1 = new JPanel();
		panel1.setBackground(Color.red);
		
		panel1.add(button_seoul);
		
		
		panel2 = new JPanel();
		
		panel2.setBackground(Color.blue);
		panel2.add(button_busan);
		
		add(panel1,BorderLayout.NORTH); //frame에 add하기 <- 임시판떼기
		add(panel2,BorderLayout.CENTER);
		//add(button);
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
