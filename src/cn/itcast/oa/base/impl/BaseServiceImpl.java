package cn.itcast.oa.base.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cn.itcast.oa.base.BaseService;

@SuppressWarnings("unchecked")
public abstract class BaseServiceImpl<T> implements BaseService<T> {

	@Resource
	private SessionFactory sessionFactory;
	protected Class<T> clazz;	//这是一个类型
	
	public BaseServiceImpl(){
		//通过反射得到t的真实类型
		ParameterizedType pt = 
			(ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz = (Class) pt.getActualTypeArguments()[0];
		System.out.println("clazz:"+clazz.getName());
	}
	
	public void save(T entity) {
		// 
		getSession().save(entity);
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		
		Object obj=getSession().get(clazz,id);
		getSession().delete(obj);
	}

	public void update(T entity) {
		// 
		getSession().update(entity);
	}

	public T getById(Long id) {
		// 
		
		return (T) getSession().get(clazz, id);
	}

	public List<T> findById(Long[] ids) {
		// 
		if(ids==null||ids.length==0){
			return Collections.EMPTY_LIST;
		}
		return getSession().createQuery(//
				"from "+clazz.getSimpleName()+" where id in (:ids)")//
				.setParameterList("ids", ids)//
				.list();
	}

	
	public List<T> findAll() {
		// 
		return getSession().createQuery(
			"from "+clazz.getSimpleName())
			.list();
		
	}

	/**
	 * 取得当前可用的session
	 * @return
	 */
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
}
