package cn.itcast.oa.base;

import java.util.List;

public interface BaseService<T> {
	
	/**
	 * 查询所有岗位
	 * @return
	 */
	List<T> findAll();
	
	/**
	 * 删除一个岗位信息
	 * @param id
	 */
	void delete(Long id);

	void save(T entity);

	T getById(Long id);
	
	List<T> findById(Long[] ids);

	void update(T entity);
}
