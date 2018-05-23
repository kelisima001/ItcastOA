package cn.itcast.oa.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.opensymphony.xwork2.ActionContext;

public class User implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private Department department;
	private Set<Role> roles=new HashSet<Role>();
	private String loginName;//登录名
	private String password;//密码
	private String name;//真实姓名
	private String gender;//性别
	private String phoneNumber;//电话
	private String email;//邮件
	private String description;//描述
	
	/**
	 * 判断本用户是否有指定权限
	 */
	public boolean hasPrivilegeByName(String name){
		
		//超级管理员不用判断
		if(isAdmin()){
			return true;
		}
		//普通用户要判断是否含有这个权限
		for(Role role:roles){
			for(Privilege priv:role.getPrivileges()){
				if(priv.getName().equals(name)){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 判断本用户是否有指定url的权限
	 */
	@SuppressWarnings("unchecked")
	public boolean hasPrivilegeByUrl(String privUrl){
		
		//超级管理员不用判断
		if(isAdmin()){
			return true;
		}
		
		//取权限表所有的url
		List<String> allPrivilegeUrls=
			(List<String>) ActionContext.getContext()
			.getApplication().get("allPrivilegeUrls");
		
		//取0到?的字符串
		int pos = privUrl.indexOf("?");
		if (pos > -1) {
			privUrl = privUrl.substring(0, pos);
		}
		
		//去掉UI
		if(privUrl.endsWith("UI")){
			privUrl=privUrl.substring(0,privUrl.length()-2);
		}
		
		
		
		//判断allPrivilegeUrls是否包含privUrl,返回真
		if(!allPrivilegeUrls.contains(privUrl)){
			return true;
		}else{
			//普通用户要判断是否含有这个权限
			for(Role role:roles){
				/*if(isAministrater(role)){
					return true;
				}*/
				for(Privilege priv:role.getPrivileges()){
					if(privUrl.equals(priv.getUrl())){
						return true;
					}
				}
			}
			return false;
		}
		
		
		
		
	}
	
	private boolean isAministrater(Role role) {
		// 
		return "administrator".equals(role.getName());
	}

	/**
	 * 判断本用户是否是超级管理员
	 * @param name
	 * @return
	 */
	private boolean isAdmin(){
		return "admin".equals("loginName");
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

	

}
