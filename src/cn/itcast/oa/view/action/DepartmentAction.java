package cn.itcast.oa.view.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.domain.Department;
import cn.itcast.oa.service.DepartmentService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2196887819367231800L;
	@Resource
	private DepartmentService departmentService;
	private Department model=new Department();
	
	/*private Long id;
	private String name;
	private String description;*/
	
	/**列表*/
	public String list() throws Exception{
		List<Department> departmentList=departmentService.findAll();
		ActionContext.getContext().put("departmentList", departmentList);
		return "list";
	}
	
	/**删除*/
	public String delete() throws Exception{
		departmentService.delete(model.getId());
		return "toList";
	}
	
	/**添加页面*/
	public String addUI() throws Exception{
		return "addUI";
	}
	
	/**添加*/
	public String add() throws Exception{
		//得到参数,封装成对象
		/*Role role=new Role();
		role.setName(name);
		role.setDescription(description);
		//保存到数据库中
		departmentService.save(role);*/
		departmentService.save(model);
		return "toList";
	}
	
	
	/**更新页面*/
	public String editUI() throws Exception{
		Department department=departmentService.getById(model.getId());
		/*this.name=role.getName();
		this.description=role.getDescription();*/
		ActionContext.getContext().getValueStack().push(department);
		return "editUI";
	}
	
	/**更新*/
	public String edit() throws Exception{
		Department department=departmentService.getById(model.getId());
		
		/*role.setName(name);
		role.setDescription(description);*/
		department.setName(model.getName());
		department.setDescription(model.getDescription());
		departmentService.update(department);
		return "toList";
	}

	public Department getModel() {
		return model;
	}

	public void setModel(Department model) {
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
