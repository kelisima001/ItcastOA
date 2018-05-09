package cn.itcast.oa.base;

import java.util.List;

public interface BaseDao<T> {

	void save(T entity);
	
	void delete(Long id);
	
	void update(T entity);
	
	T getById(Long id);
	
	List<T> findById(Long[] ids);
	
	List<T> findAll();
	
	
}
