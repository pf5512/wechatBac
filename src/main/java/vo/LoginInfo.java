package vo;

import org.springframework.stereotype.Component;

@Component
public class LoginInfo {
private String id;
private String userName;
private String password;
private String nickName;
private String sex;
private String phone;
private String portrait;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getNickName() {
	return nickName;
}
public void setNickName(String nickName) {
	this.nickName = nickName;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getPortrait() {
	return portrait;
}
public void setPortrait(String portrait) {
	this.portrait = portrait;
}

}
