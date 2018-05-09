package cn.itcast.oa.view.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.domain.User;
import cn.itcast.oa.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3666125199150566591L;
	@Resource
	private UserService userService;
	private User model=new User();
	
	/*private Long id;
	private String name;
	private String description;*/
	
	/**列表*/
	public String list() throws Exception{
		List<User> userList=userService.findAll();
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
		return "addUI";
	}
	
	/**添加*/
	public String add() throws Exception{
		//得到参数,封装成对象
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
		User user=userService.getById(model.getId());
		/*this.name=user.getName();
		this.description=user.getDescription();*/
		ActionContext.getContext().getValueStack().push(user);
		return "editUI";
	}
	
	/**更新*/
	public String edit() throws Exception{
		User user=userService.getById(model.getId());
		
		/*user.setName(name);
		user.setDescription(description);*/
		user.setName(model.getName());
		user.setDescription(model.getDescription());
		userService.update(user);
		return "toList";
	}
	
	public String initPass() throws Exception{
		
		User user=userService.getById(model.getId());
		user.setPassword("1234");
		userService.update(user);
		return "toList";
	}

	public User getModel() {
		return model;
	}

	public void setModel(User model) {
		this.model = model;
	}

	/*public Long getId() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}*/
	
	
}
