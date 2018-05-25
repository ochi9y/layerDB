package domain;

public enum SexEnum {
	man("man"),
	woman("woman");

	private String sex;

	private SexEnum(String sex) {
		this.sex = sex;
	}

	public String getSex() {
		return sex;
	}
}
