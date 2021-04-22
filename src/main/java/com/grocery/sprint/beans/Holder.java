package com.grocery.sprint.beans;

public class Holder {

	private String firstName;
	private String lastName;
	private String loginId;
	private String password;
	private String mobileNo;
	private String email;
	private String question;
	private String answer;
	
	public Holder() {}
	
	public Holder(String firstName, String lastName, String loginId, String password, String mobileNo, String email,
			String question, String answer) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.loginId = loginId;
		this.password = password;
		this.mobileNo = mobileNo;
		this.email = email;
		this.question = question;
		this.answer = answer;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Holder [firstName=" + firstName + ", lastName=" + lastName + ", loginId="
				+ loginId + ", password=" + password + ", mobileNo=" + mobileNo + ", email=" + email + ", question="
				+ question + ", answer=" + answer + "]";
	}
}
