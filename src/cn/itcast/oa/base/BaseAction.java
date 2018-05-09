package cn.itcast.oa.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import cn.itcast.oa.domain.Department;
import cn.itcast.oa.service.DepartmentService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T>{

	protected Class<T> clazz;	//这是一个类型
	
	public BaseAction(){
		//通过反射得到t的真实类型
		ParameterizedType pt = 
				(ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz = (Class) pt.getActualTypeArguments()[0];
//		System.out.println("clazz:"+clazz.getName());
	}
	
	@Resource
	private T model;
	
	
	
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

	

	
}
