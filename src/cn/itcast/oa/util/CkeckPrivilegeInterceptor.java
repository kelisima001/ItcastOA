package cn.itcast.oa.util;

import cn.itcast.oa.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CkeckPrivilegeInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	public String intercept(ActionInvocation invocation) throws Exception {
		
		//获取信息user
		User user=(User) ActionContext.getContext().getSession().get("user");
		String namespace=invocation.getProxy().getNamespace();
		String actionName=invocation.getProxy().getActionName();
		String privUrl=namespace+actionName;//对应的权限url
		
		//如果是登陆或者登出,就放行
		/*
		if(a){
			
		}*/
		//如果未登陆,转到登陆页面
		if(user==null){
			boolean a=privUrl.startsWith("/userAction_login");
			if(a){
				return invocation.invoke();
			}else{
				return "loginUI";
			}
			
		}else{
		//如果已登陆,判断权限
			//如有权限,不拦截
			if(user.hasPrivilegeByUrl(privUrl)){
				return invocation.invoke();
			}else{
				//无权限,返回错误页面
				return "noPrivilege";
			}
		}
	}

}
