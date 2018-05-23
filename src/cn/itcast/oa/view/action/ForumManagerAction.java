package cn.itcast.oa.view.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Forum;

@Controller
@Scope("prototype")
public class ForumManagerAction extends BaseAction<Forum>{

	private static final long serialVersionUID = 1L;

	/**列表*/
	public String list() throws Exception{
		
//		准备数据formList
		List<Forum> forumList=forumService.findAll();
		ActionContext.getContext().put("forumList", forumList);
		return "list";
	}
	
	/**删除*/
	public String delete() throws Exception{
		forumService.delete(model.getId());
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
		forumService.save(model);
		return "toList";
	}
	
	
	/**更新页面*/
	public String editUI() throws Exception{
		//准备数据departmentList
		//准备数据roleList
		//准备回显的数据
		Forum forum = forumService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(forum);
		return "saveUI";
	}
	
	/**更新*/
	public String edit() throws Exception{
		//取出原对象
		Forum forum = forumService.getById(model.getId());
		//设置要修改的属性
		forum.setName(model.getName());
		forum.setDescription(model.getDescription());
		//更新到数据库
		forumService.update(forum);
		return "toList";
	}

	/**上移*/
	public String moveUp() throws Exception{
		forumService.moveUp(model.getId());
		return "list";
	}
	
	/**下移*/
	public String moveDown() throws Exception{
		forumService.moveDown(model.getId());
		return "list";
	}
	
	//------------------------
	@Override
	public Forum getModel() {
		return model;
	}
}
