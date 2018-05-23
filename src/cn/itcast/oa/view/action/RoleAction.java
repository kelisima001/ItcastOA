package cn.itcast.oa.view.action;

import java.util.HashSet;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Privilege;
import cn.itcast.oa.domain.Role;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role>{
	
	private static final long serialVersionUID = 144717824328093166L;
	private Long[] privilegeIds;

	/**列表*/
	public String list() throws Exception{
		List<Role> roleList=roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		return "list";
	}
	
	/**删除*/
	public String delete() throws Exception{
		roleService.delete(model.getId());
		return "toList";
	}
	
	/**添加页面*/
	public String addUI() throws Exception{
		return "saveUI";
	}
	
	/**添加*/
	public String add() throws Exception{
		//得到参数,封装成对象
		/*Role role=new Role();
		role.setName(name);
		role.setDescription(description);
		//保存到数据库中
		roleService.save(role);*/
		roleService.save(model);
		return "toList";
	}
	
	
	/**更新页面*/
	public String editUI() throws Exception{
		Role role=roleService.getById(model.getId());
		/*this.name=role.getName();
		this.description=role.getDescription();*/
		ActionContext.getContext().getValueStack().push(role);
		return "saveUI";
	}
	
	/**更新*/
	public String edit() throws Exception{
		Role role=roleService.getById(model.getId());
		
		/*role.setName(name);
		role.setDescription(description);*/
		role.setName(model.getName());
		role.setDescription(model.getDescription());
		roleService.update(role);
		return "toList";
	}
	
	/**权限页面*/
	public String setPrivilegeUI() throws Exception{
		//准备回显的数据
		Role role=roleService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(role);
		
		//
		if(role.getPrivileges()!=null){
			privilegeIds=new Long[role.getPrivileges().size()];//新建数组长度是role权限组的长度
			int index=0;
			for(Privilege priv:role.getPrivileges()){
				privilegeIds[index++]=priv.getId();//赋值,ids
			}
		}
		
		//准备数据privilegeList
		List<Privilege> privilegeList=privilegeService.findAll();
		ActionContext.getContext().put("privilegeList", privilegeList);
		
		return "setPrivilegeUI";
		
	}
	
	/**设置权限*/
	public String setPrivilege() throws Exception{
		//从数据库中获取原对象
		Role role=roleService.getById(model.getId());
		
		//设置要修改的属性
		List<Privilege> privilegeList=privilegeService.findById(privilegeIds);
		role.setPrivileges(new HashSet<Privilege>(privilegeList));
		//更新到数据库中
		roleService.update(role);
		
		return "toList";
	}

	//------------------------
	
	public Role getModel() {
		return model;
	}

	public void setModel(Role model) {
		this.model = model;
	}

	public Long[] getPrivilegeIds() {
		return privilegeIds;
	}

	public void setPrivilegeIds(Long[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
