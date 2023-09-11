package application;

public class rent {
	String pid;
	String pprice;
	
	private final static rent INSTANCE = new rent();
	  
	  private rent() {}
	  
	  public static rent getInstance() {
		    return INSTANCE;
		  }
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPprice() {
		return pprice;
	}
	public void setPprice(String pprice) {
		this.pprice = pprice;
	}
}
