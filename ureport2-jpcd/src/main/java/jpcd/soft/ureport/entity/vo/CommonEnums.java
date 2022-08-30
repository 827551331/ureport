package jpcd.soft.ureport.entity.vo;

public enum CommonEnums {
	
	SUCCESS("ok","SUCCESS" ,"操作成功"), 
	FAIL("no","FAIL","操作失败"), 
	TIMEOUT("timeout","TIMEOUT","超时"), 
	EXCEPTION("error","ERROR","系统错误"),
	SYSTEM("SYSTEM","SYSTEM","系统用户"),//默认系统操作用户
	TRUE("1","TRUE","是"),//真
	FALSE("0","FALSE","否"),//假
	DEFAULT_ROLE_ID("999999999","default_role_id","默认角色编号"),//默认角色
	DEFAULT_PASSWORD("123456","default_password","默认密码");//默认密码

	private String value;
	private String key;
	private String message;
	
	// 构造方法
	private CommonEnums(String value, String key, String message) {
		this.value = value;
		this.key = key;
		this.message = message;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
