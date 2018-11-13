package calc.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import calc.bean.CalcBean;
import calc.mode.CalcMode;

public class PreAction implements ActionListener {
	
	private static final String CALC="計算";
	
	private CalcBean temp;
	private CalcBean calcBean;
	private Map<String,JTextField> outs;
	
	public PreAction(CalcBean temp,Map<String,JTextField> outs) {
		this.temp=temp;
		this.outs=outs;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object source=e.getSource();
		String mode;
				
		//設定計算模式(JRadioButton)
		if(source instanceof JRadioButton) {
			mode=((JRadioButton)source).getText();
			for(CalcMode cm:CalcMode.values()) {
				if(mode.equals(cm.getMode())) {
					temp.setMode(cm);
				}
			}
		}
		
		//設定輸入值(JFormattedTextField)
		
		//設定計算動作
		if(source instanceof JButton) {
			mode=((JButton)source).getText();
			if(CALC.equals(mode)) {
				double sin=0;
				double cos=0;
				double tan=0;
				//輸入值
				Double degree=temp.getDegree();
				//判斷模式
				CalcMode calcMode=temp.getMode();
				if(calcMode.equals(CalcMode.ANGLE)) {
//					System.out.println("do angle");
					Double radian=degree*Math.PI/180;
					sin=Math.sin(radian);
					cos=Math.cos(radian);
					tan=Math.tan(radian);
					temp.setSinOut(sin);
					temp.setCosOut(cos);
					temp.setTanOut(tan);
				}else if (calcMode.equals(CalcMode.RADIAN)) {
//					System.out.println("do rad");
					sin=Math.sin(degree);
					cos=Math.cos(degree);
					tan=Math.tan(degree);
					temp.setSinOut(sin);
					temp.setCosOut(cos);
					temp.setTanOut(tan);
				}else {
					throw new RuntimeException("Wrong Mode");
				}
			}
			DecimalFormat df=new DecimalFormat("0.000");
			outs.get("sin").setText(df.format(temp.getSinOut()));
			outs.get("cos").setText(df.format(temp.getCosOut()));
			outs.get("tan").setText(df.format(temp.getTanOut()));
		}
		
		System.out.println("temp "+temp);
		System.out.println("calcBean "+calcBean);

	}

	public CalcBean getTemp() {
		return temp;
	}

	public void setTemp(CalcBean temp) {
		this.temp = temp;
	}

	public CalcBean getCalcBean() {
		return calcBean;
	}

	public void setCalcBean(CalcBean calcBean) {
		this.calcBean = calcBean;
	}

	public Map<String, JTextField> getOuts() {
		return outs;
	}

	public void setOuts(Map<String, JTextField> outs) {
		this.outs = outs;
	}

}
