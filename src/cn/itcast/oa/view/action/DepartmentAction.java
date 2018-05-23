package cn.itcast.oa.view.action;

import java.util.HashSet;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Department;
import cn.itcast.oa.domain.Product;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department>{

	private static final long serialVersionUID = -2196887819367231800L;
	private Long parentId;
	private Long[] productIds;
	
	/**列表*/
	public String list() throws Exception{
		List<Department> departmentList=null;
		if(parentId==null){
			departmentList=departmentService.findTopList();
		}else{
			departmentList=departmentService.findChildren(parentId);
			Department parent=departmentService.getById(parentId);
			ActionContext.getContext().put("parent", parent);
		}
				
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
		//准备数据departmentList
		List<Department> departmentList=departmentService.findAll();
		ActionContext.getContext().put("departmentList", departmentList);
		//准备数据productList
		List<Product> productList=productService.findAll();
		ActionContext.getContext().put("productList", productList);
		return "saveUI";
	}
	
	/**添加*/
	public String add() throws Exception{
		//得到参数,封装成对象
		/*Role role=new Role();
		role.setName(name);
		role.setDescription(description);
		
		departmentService.save(role);*/
		//新建对象并封装属性,可以使用model
		model.setParent(departmentService.getById(parentId));
		//保存到数据库中
		departmentService.save(model);
		return "toList";
	}
	
	
	/**更新页面*/
	public String editUI() throws Exception{
		//准备数据departmentList
		List<Department> departmentList=departmentService.findAll();
		ActionContext.getContext().put("departmentList", departmentList);
		//准备数据productList
		List<Product> productList=productService.findAll();
		ActionContext.getContext().put("productList", productList);
		//准备回显的数据
		Department department=departmentService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(department);
		/*this.name=role.getName();
		this.description=role.getDescription();*/
		//新建对象并封装属性,可以使用model
		/*department.setName(model.getName());
		department.setDescription(model.getDescription());
		department.setParent(departmentService.getById(parentId));//上级部门
		*/
		if(department.getParent()!=null){
			parentId=department.getParent().getId();
		}
		if(department.getProducts()!=null){
			productIds=new Long[(department.getProducts().size())];
			int index=0;
			for(Product product:department.getProducts()){
				productIds[index++]=product.getId();
			}
		}
		return "saveUI";
	}
	
	/**更新*/
	public String edit() throws Exception{
		//取出对象
		Department department=departmentService.getById(model.getId());
		
		/*role.setName(name);
		role.setDescription(description);*/
		//设置需要修改的属性
		department.setName(model.getName());
		department.setDescription(model.getDescription());
		department.setParent(departmentService.getById(parentId));//上级部门
		List<Product> products=productService.findById(productIds);
		department.setProducts(new HashSet<Product>(products));
		//跟新
		departmentService.update(department);
		return "toList";
	}
	
	public Department getModel() {
		return model;
	}

	public void setModel(Department model) {
		this.model = model;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Long[] getProductIds() {
		return productIds;
	}

	public void setProductIds(Long[] productIds) {
		this.productIds = productIds;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	

	
	
	
}
