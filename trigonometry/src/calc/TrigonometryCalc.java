package calc;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.Timer;

import calc.action.PreAction;
import calc.bean.CalcBean;
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
		
		gbc.gridwidth=1;
		
		gbc.gridx=0;
		gbc.gridy=2;
		panel.add(radio1,gbc);
		gbc.gridx=1;
		gbc.gridy=2;
		panel.add(radio2,gbc);
		
		JLabel sin=new JLabel("SIN()");
		sin.setHorizontalAlignment(JLabel.CENTER);
		JLabel cos=new JLabel("COS()");
		cos.setHorizontalAlignment(JLabel.CENTER);
		JLabel tan=new JLabel("TAN()");
		tan.setHorizontalAlignment(JLabel.CENTER);
		
		JTextField sinOut=new JTextField();
		sinOut.setHorizontalAlignment(JLabel.LEFT);
		JTextField cosOut=new JTextField();
		cosOut.setHorizontalAlignment(JLabel.LEFT);
		JTextField tanOut=new JTextField();
		tanOut.setHorizontalAlignment(JLabel.LEFT);
		
		//打包計算結果欄位
		Map<String,JTextField> outs=new HashMap<>();
		outs.put("sin",sinOut);
		outs.put("cos",cosOut);
		outs.put("tan",tanOut);
				
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.gridy=4;
				
		JLabel empty1=new JLabel("計算");
		empty1.setHorizontalAlignment(JLabel.RIGHT);
		JLabel empty2=new JLabel("結果");
		empty2.setHorizontalAlignment(JLabel.LEFT);
		gbc.gridx=0;
		panel.add(empty1,gbc);
		gbc.gridx=1;
		panel.add(empty2,gbc);
				
		gbc.gridy=5;
				
		gbc.gridx=0;
		panel.add(sin,gbc);
		gbc.gridx=1;
		gbc.ipadx=70;
		panel.add(sinOut,gbc);
				
		gbc.gridy=6;
				
		gbc.gridx=0;
		panel.add(cos,gbc);
		gbc.gridx=1;
		gbc.ipadx=70;
		panel.add(cosOut,gbc);
				
		gbc.gridy=7;
				
		gbc.gridx=0;
		panel.add(tan,gbc);
		gbc.gridx=1;
		gbc.ipadx=70;
		panel.add(tanOut,gbc);
				
		gbc.gridy=8;
				
		gbc.fill=GridBagConstraints.NONE;
		JButton calc=new JButton("計算");
		gbc.gridwidth=2;
		gbc.gridx=0;
		gbc.ipadx=1;
		panel.add(calc,gbc);
		
		//設定初始值
		CalcBean cb=new CalcBean();
		PreAction listener=new PreAction(cb,outs);
		
		//程式剛開始時設定初始模式
		Timer startup=new Timer(0,new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				for(JRadioButton bt:radios) {
					if(bt.isSelected()==true) {
						String value=bt.getText();
								
						for(CalcMode cm:CalcMode.values()) {
							if(cm.getMode().equals(value)) {
								cb.setMode(cm);
							}
						}
					}
				}
				double degree=0;
						
				try {
					degree=Double.valueOf(text.getText());
				}catch(NumberFormatException ex) {
					degree=0;
				}
				cb.setDegree(degree);
				listener.setTemp(cb);
				System.out.println("initialization finished");
			}
		});
		startup.setRepeats(false);
		startup.start();
		
		//結束配置 顯示視窗
		frame.setVisible(true);

	}

}
