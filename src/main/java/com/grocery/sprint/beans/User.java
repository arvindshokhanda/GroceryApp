package com.grocery.sprint.beans;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_info")
public class User  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long userId;
	private String firstName;
	private String lastName;
	private String loginId;
	private String mobileNo;
	private String email;
	private String question;
	private String answer;
	
	public User() {}
	
	public User(long userId, String firstName, String lastName, String loginId, String mobileNo,
			String email, String question, String answer) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.loginId = loginId;
		this.mobileNo = mobileNo;
		this.email = email;
		this.question = question;
		this.answer = answer;
	}

	public User(String firstName, String lastName, String loginId, String mobileNo, String email,
			String question, String answer) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.loginId = loginId;
		this.mobileNo = mobileNo;
		this.email = email;
		this.question = question;
		this.answer = answer;
	}

	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
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
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", loginId=" + loginId
				+ ", mobileNo=" + mobileNo + ", email=" + email + ", question=" + question
				+ ", answer=" + answer + "]";
	}
	
}