package cn.itcast.oa.view.action;

import java.util.HashSet;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Department;
import cn.itcast.oa.domain.Role;
import cn.itcast.oa.domain.User;
import cn.itcast.oa.service.DepartmentService;
import cn.itcast.oa.util.DepartmentUtils;

import com.opensymphony.xwork2.ActionContext;
import org.apache.commons.codec.digest.DigestUtils;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User>{

	private static final long serialVersionUID = -3666125199150566591L;
	private Long departmentId;
	private Long[] roleIds;
	
	/**列表*/
	public String list() throws Exception{
		List<User> userList=userService.findAll();
		/*for(User user:userList){
			user.setDepartment()
		}*/
		ActionContext.getContext().put("userList", userList);
		return "list";
	}
	
	/**删除*/
	public String delete() throws Exception{
		userService.delete(model.getId());
		return "toList";
	}
	
	/**添加页面*/
	public String addUI() throws Exception{
		//准备数据departmentList
		//  应是显示树状列表,先使用列表
		List<Department> topList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtils.getAllDepartments(topList);
		ActionContext.getContext().put("departmentList", departmentList);
		//准备数据roleList
		List<Role> roleList=roleService.findAll();
		ActionContext.getContext().put("roleList",roleList);
		
		return "saveUI";
	}
	
	/**添加*/
	public String add() throws Exception{
		//得到参数,封装成对象
		model.setDepartment(departmentService.getById(departmentId));
		List<Role> roleList = roleService.findById(roleIds);
		model.setRoles(new HashSet<Role>(roleList));
		//设置默认密码为1234
		String md5Hex=DigestUtils.md5Hex("1234");
		
		model.setPassword(md5Hex);
		/*User user=new User();
		user.setName(name);
		user.setDescription(description);
		//保存到数据库中
		userService.save(user);*/
		userService.save(model);
		return "toList";
	}
	
	
	/**更新页面*/
	public String editUI() throws Exception{
		//准备数据departmentList,阶梯式部门列表
		List<Department> topList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtils.getAllDepartments(topList);
		ActionContext.getContext().put("departmentList", departmentList);
		//准备数据roleList
		List<Role> roleList=roleService.findAll();
		ActionContext.getContext().put("roleList",roleList);
		//准备回显的数据
		User user=userService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(user);
		if(user.getDepartment()!=null){
			departmentId=user.getDepartment().getId();
		}
		if(user.getRoles()!=null){
			roleIds=new Long[(user.getRoles().size())];
			int index=0;
			for(Role role:user.getRoles()){
				roleIds[index++]=role.getId();
			}
		}
		return "saveUI";
	}
	
	/**更新*/
	public String edit() throws Exception{
		//取出原对象
		User user=userService.getById(model.getId());
		//设置要修改的属性
		user.setLoginName(model.getLoginName());
		user.setDepartment(departmentService.getById(departmentId));
		user.setDescription(model.getDescription());
		user.setEmail(model.getEmail());
		user.setGender(model.getGender());
		user.setName(model.getName());
		
		user.setPhoneNumber(model.getPhoneNumber());
		List<Role> roleList=roleService.findById(roleIds);
		user.setRoles(new HashSet<Role>(roleList));
		//更新到数据库
		
		userService.update(user);
		return "toList";
	}
	
	public String initPass() throws Exception{
//		DigestUtils.
		User user=userService.getById(model.getId());
		String md5Hex=DigestUtils.md5Hex("1234");
		user.setPassword(md5Hex);
		userService.update(user);
		return "toList";
	}
	
	/**登陆页面*/
	public String loginUI() throws Exception{
		return "loginUI";
	}
	
	/**登陆*/
	public String login() throws Exception{
//		System.out.println(model.getLoginName()+model.getPassword());
		User user=userService.findByLoginNameAndPassword
				(model.getLoginName(),model.getPassword());
//		System.out.println(user);
		if(user==null){
			addFieldError("login","用户名或密码不正确");
			return "loginUI";
		}else{
			ActionContext.getContext().getSession().put("user", user);
			/*session.setAttribute("user", user);*/
			return "toIndex";
		}
		
	}
	
	public String logout() throws Exception{
		ActionContext.getContext().getSession().remove("user");
		return "logout";
	}

	//--
	
	public User getModel() {
		return model;
	}

	public void setModel(User model) {
		this.model = model;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(Long[] roleIds) {
		this.roleIds = roleIds;
	}

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
