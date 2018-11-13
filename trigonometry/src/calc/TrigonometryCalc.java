package calc;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import calc.mode.CalcMode;

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
		
		JLabel title=new JLabel("請於下方輸入數值");
		title.setHorizontalAlignment(JLabel.CENTER);
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.gridwidth=2;
		gbc.gridx=0;
		gbc.gridy=0;
		panel.add(title,gbc);
		
		NumberFormat nf=NumberFormat.getNumberInstance();
		nf.setGroupingUsed(false);
		JFormattedTextField text=new JFormattedTextField(nf);
		
//		JTextField input=new JTextField();
		gbc.fill=GridBagConstraints.CENTER;
		gbc.gridwidth=2;
		gbc.gridx=0;
		gbc.gridy=1;
		gbc.ipadx=30;
		panel.add(text,gbc);
		
		gbc.fill=GridBagConstraints.CENTER;
		List<JRadioButton> radios=new ArrayList<>();
		JRadioButton radio1=new JRadioButton(CalcMode.ANGLE.getMode());
		JRadioButton radio2=new JRadioButton(CalcMode.RADIAN.getMode());
		
		radio1.setHorizontalAlignment(JRadioButton.CENTER);
		radio2.setHorizontalAlignment(JRadioButton.CENTER);
		ButtonGroup group=new ButtonGroup();
		group.add(radio1);
		group.add(radio2);
		radio1.setSelected(true);
		
		radios.add(radio1);
		radios.add(radio2);
		
		//結束配置 顯示視窗
		frame.setVisible(true);

	}

}
