package jp.co.sss.crud.dto;

public class Department {
	
	private int deptId;
	private String deptName;
	
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	@Override
	public String toString() {
		return "部署ID：" + deptId + "部署名：" + deptName;
	}

}
