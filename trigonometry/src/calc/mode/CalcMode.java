package calc.mode;

public enum CalcMode {
	
	ANGLE("角度"),
	RADIAN("弳度");
	
	private String str;
	
	private CalcMode(String str) {
		this.str=str;
	}
	
	public String getMode() {
		return this.str;
	}

}
