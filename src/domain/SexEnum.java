package domain;

public enum SexEnum {
	man("男"),
	woman("女");

	private String sex;

	private SexEnum(String sex) {
		this.sex = sex;
	}

	public String getSex() {
		return sex;
	}
}
