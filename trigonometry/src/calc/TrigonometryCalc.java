package calc;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TrigonometryCalc {

	public static void main(String[] args) {
		
		//版面配置
		JFrame frame=new JFrame("三角函數計算機 V1.0");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(260,250);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		JPanel panel=new JPanel(new GridBagLayout());
		frame.getContentPane().add(panel);
		GridBagConstraints gbc=new GridBagConstraints();
		
		//結束配置 顯示視窗
		frame.setVisible(true);

	}

}
