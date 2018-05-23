package cn.itcast.oa.view.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class HomeAction extends ActionSupport{

	
	
	/**主页*/
	public String index() throws Exception{
		
		return "index";
	}
	
	/**上*/
	public String top() throws Exception{
		
		return "top";
	}
	
	/**左*/
	public String left() throws Exception{
		
		return "left";
	}
	
	/**右*/
	public String right() throws Exception{
		
		return "right";
	}
	
	/**下*/
	public String bottom() throws Exception{
		
		return "bottom";
	}
}
