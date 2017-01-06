package mybatiseproject.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mybatiseproject.web.ServletUtil;

@Component
public class UserInfoUtil {
	@Autowired
	private ServletUtil web;
	
	public void setUserId(String userId) {
		HttpServletRequest hsr = web.getRequest();
		if(hsr == null)
			return;
		HttpSession session = hsr.getSession();
		if(session == null)
			return;
		session.setAttribute("UserId", userId);
	}
	
	public String getUserId(){
		HttpServletRequest hsr = web.getRequest();
		if(hsr == null)
			return null;
		HttpSession session = hsr.getSession();
		if(session == null)
			return null;
		return (String) session.getAttribute("UserId");
	}
}
