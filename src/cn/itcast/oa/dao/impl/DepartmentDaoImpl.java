package cn.itcast.oa.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.itcast.oa.base.impl.BaseDaoImpl;
import cn.itcast.oa.dao.DepartmentDao;
import cn.itcast.oa.domain.Department;

@Repository
@SuppressWarnings("unchecked")
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao {

	
	public List<Department> findTopList() {
		// TODO Auto-generated method stub
		return getSession().createQuery(
			"from Department where parent is null")
			.list();
	}

	public List<Department> findChildren(Long id) {
		// TODO Auto-generated method stub
		return getSession().createQuery(
			"from Department d where d.parent.id=?")
			.setParameter(0, id)
			.list();
	}

	
	
}
