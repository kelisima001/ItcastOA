package cn.itcast.oa.service.impl;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.base.impl.BaseDaoImpl;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.service.ForumService;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class ForumServiceImpl extends BaseDaoImpl<Forum> implements ForumService {

	
	public void moveUp(Long id) {
		// 找出当前forum
		Forum forum=getById(id);
		
		//找出上面的forum
		Forum upperForum=getUpperForum(forum.getPosition());
		
		if(upperForum==null){
			return;
		}
		//交换position值
		int temp=0;
		temp=forum.getPosition();
		forum.setPosition(upperForum.getPosition());
		upperForum.setPosition(temp);
		//更新数据库
		update(forum);
		update(upperForum);
		
		
	}

	public void moveDown(Long id) {
		// 找出当前forum
		Forum forum=getById(id);
		
		//找出上面的forum
		Forum lowerForum=getLowerForum(forum.getPosition());
		
		if(lowerForum==null){
			return;
		}
		//交换position值
		int temp=0;
		temp=forum.getPosition();
		forum.setPosition(lowerForum.getPosition());
		lowerForum.setPosition(temp);
		//更新数据库
		update(forum);
		update(lowerForum);
		
	}

	/**
	 * 覆盖父方法,设置排序
	 */
	@Override
	public List<Forum> findAll() {
		return getSession().createQuery(
				"from Forum order by position asc")
				.list();
	}
	
	/**取得上一个*/
	public Forum getUpperForum(int position){
		return (Forum) getSession().createQuery(
			"from Forum f where f.position<? " +
			"order by f.position desc")
			.setParameter(0, position)
			.setFirstResult(0)
			.setMaxResults(1)
			.uniqueResult();
	}

	/**取得下一个*/
	public Forum getLowerForum(int position){
		return (Forum) getSession().createQuery(
			"from Forum f where f.position>? " +
			"order by f.position asc")
			.setParameter(0, position)
			.setFirstResult(0)
			.setMaxResults(1)
			.uniqueResult();
	}
	
	/**取得最大position的forum*/
	public Forum getLastForum(int position){
		return (Forum) getSession().createQuery(
			"select * from Forum f order by position desc")
			.setFirstResult(0)
			.setMaxResults(1)
			.uniqueResult();
	}

	@Override
	public void save(Forum entity) {
		// 用id做position,因为id是唯一的
		super.save(entity);
		entity.setPosition(entity.getId().intValue());
		
	}
	
	
}
