package cn.itcast.oa.domain;

import java.util.HashSet;
import java.util.Set;

public class Department  implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private Set<User> users=new HashSet<User>();//员工
	private Department parent;//父部门
	private Set<Department> children=
		new HashSet<Department>();//子部门
	private String name;//部门名
	private String description;//描述
	private Set<Product> products=new HashSet<Product>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public Department getParent() {
		return parent;
	}
	public void setParent(Department parent) {
		this.parent = parent;
	}
	public Set<Department> getChildren() {
		return children;
	}
	public void setChildren(Set<Department> children) {
		this.children = children;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
