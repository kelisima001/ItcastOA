package cn.itcast.oa.domain;

import java.util.HashSet;
import java.util.Set;

public class Privilege  implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;//权限名称
	private String icon;
	private String url;//权限地址
	private Set<Role> roles=new HashSet<Role>();
//	private String icon;
	private Privilege parent;//上级权限
	private Set<Privilege> children=new HashSet<Privilege>();//下级权限们
	
	public Privilege() {
	}
	
	public Privilege(String name,String icon, String url, Privilege parent) {
		this.name = name;
		this.icon = icon;
		this.url = url;
		this.parent = parent;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public Privilege getParent() {
		return parent;
	}
	public void setParent(Privilege parent) {
		this.parent = parent;
	}
	public Set<Privilege> getChildren() {
		return children;
	}
	public void setChildren(Set<Privilege> children) {
		this.children = children;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	
	
	
}
