package cn.itcast.oa.util;

import java.util.Collection;
import java.util.List;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.itcast.oa.domain.Privilege;
import cn.itcast.oa.service.PrivilegeService;

@Component
public class InitListener implements ServletContextListener{

	public void contextDestroyed(ServletContextEvent sce) {
		
	}

	public void contextInitialized(ServletContextEvent sce) {
		//获取与容器相关的service对象(不能@Resource)
//				System.out.println(sce);
		ApplicationContext ac=
			WebApplicationContextUtils.getWebApplicationContext
			(sce.getServletContext());
		PrivilegeService privilegeService=
			(PrivilegeService) ac.getBean("privilegeServiceImpl");
		
		//准备数据topPrivilegeList
		List<Privilege> topPrivilegeList=privilegeService.findTopList();
//				System.out.println(topPrivilegeList);
		sce.getServletContext().setAttribute("topPrivilegeList", topPrivilegeList);
		System.out.println("已准备topPrivilegeList");
		
		//准备数据allPrivilegeUrls
		List<String> allPrivilegeUrls=privilegeService.getAllPrivUrls();
		sce.getServletContext().setAttribute("allPrivilegeUrls", allPrivilegeUrls);
		System.out.println("已准备allPrivilegeUrls");
	}

	
}
