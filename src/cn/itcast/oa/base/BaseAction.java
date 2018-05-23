package cn.itcast.oa.base;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;
import cn.itcast.oa.service.DepartmentService;
import cn.itcast.oa.service.ForumService;
import cn.itcast.oa.service.PrivilegeService;
import cn.itcast.oa.service.ProductService;
import cn.itcast.oa.service.RoleService;
import cn.itcast.oa.service.UserService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("unchecked")
public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T>{

	@Resource
	protected PrivilegeService privilegeService;
	@Resource
	protected RoleService roleService;
	@Resource
	protected UserService userService;
	@Resource
	protected DepartmentService departmentService;
	@Resource
	protected ForumService forumService;
	@Resource
	protected ProductService productService;
	
	protected Class<T> clazz;	//这是一个类型
	protected T model;
	
	public BaseAction(){
		try {
			
			//通过反射得到T的真实类型
			ParameterizedType pt = 
					(ParameterizedType) this.getClass().getGenericSuperclass();
			this.clazz = (Class) pt.getActualTypeArguments()[0];
			//生成model的实例
			model=(T)clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
//		System.out.println("clazz:"+clazz.getName());
	}
	
}
