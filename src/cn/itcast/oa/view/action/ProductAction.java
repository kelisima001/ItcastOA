package cn.itcast.oa.view.action;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Department;
import cn.itcast.oa.domain.Product;

@Controller
@Scope("prototype")
public class ProductAction extends BaseAction<Product>{

	private static final long serialVersionUID = 1L;
	private Long[] departmentIds;

	/**列表*/
	public String list() throws Exception{
		
//		准备数据formList
		List<Product> productList=productService.findAll();
		ActionContext.getContext().put("productList", productList);
		return "list";
	}
	
	/**删除*/
	public String delete() throws Exception{
		productService.delete(model.getId());
		return "toList";
	}
	
	/**添加页面*/
	public String addUI() throws Exception{
		//准备数据departmentList
		//  应是显示树状列表,先使用列表
		//准备数据roleList
		
		return "saveUI";
	}
	
	/**添加*/
	public String add() throws Exception{
		//得到参数,封装成对象
		//设置默认密码为1234
		//保存到数据库中
		productService.save(model);
		return "toList";
	}
	
	
	/**更新页面*/
	public String editUI() throws Exception{
		//准备数据departmentList
		List<Department> departmentList=departmentService.findAll();
		ActionContext.getContext().put("departmentList", departmentList);
		//准备数据roleList
		//准备回显的数据
		Product product = productService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(product);
		
		if(product.getDepartments()!=null){
			departmentIds=new Long[(product.getDepartments().size())];
			int index=0;
			for(Department department:product.getDepartments()){
				departmentIds[index++]=department.getId();
			}
		}
		return "saveUI";
	}
	
	/**更新*/
	public String edit() throws Exception{
		//取出原对象
		Product product = productService.getById(model.getId());
		//设置要修改的属性
		product.setName(model.getName());
		product.setDescription(model.getDescription());
		/*product.setUrl(model.getUrl());*/
		product.setUpdateTime(new Date());
		product.setDepartments(model.getDepartments());
		List<Department> departmentList=departmentService.findById(departmentIds);
		product.setDepartments(new HashSet<Department>(departmentList));
		//更新到数据库
		productService.update(product);
		return "toList";
	}

	
	
	//------------------------
	@Override
	public Product getModel() {
		return model;
	}

	public Long[] getDepartmentIds() {
		return departmentIds;
	}

	public void setDepartmentIds(Long[] departmentIds) {
		this.departmentIds = departmentIds;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
