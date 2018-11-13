package calc.bean;

import calc.mode.CalcMode;

public class CalcBean {
	
	private Double degree;
	private CalcMode mode;
	private Double sinOut;
	private Double cosOut;
	private Double tanOut;
	
	public Double getDegree() {
		return degree;
	}
	public void setDegree(Double degree) {
		this.degree = degree;
	}
	public CalcMode getMode() {
		return mode;
	}
	public void setMode(CalcMode mode) {
		this.mode = mode;
	}
	public Double getSinOut() {
		return sinOut;
	}
	public void setSinOut(Double sinOut) {
		this.sinOut = sinOut;
	}
	public Double getCosOut() {
		return cosOut;
	}
	public void setCosOut(Double cosOut) {
		this.cosOut = cosOut;
	}
	public Double getTanOut() {
		return tanOut;
	}
	public void setTanOut(Double tanOut) {
		this.tanOut = tanOut;
	}
	
	@Override
	public String toString() {
		return "CalcBean [degree=" + degree + ", mode=" + mode + ", sinOut=" + sinOut + ", cosOut=" + cosOut
				+ ", tanOut=" + tanOut + "]";
	}

}
