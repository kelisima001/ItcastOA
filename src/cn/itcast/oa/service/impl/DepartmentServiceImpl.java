package cn.itcast.oa.service.impl;

import java.util.List;


import org.springframework.stereotype.Service;
import cn.itcast.oa.base.impl.BaseDaoImpl;
import cn.itcast.oa.domain.Department;
import cn.itcast.oa.service.DepartmentService;

@Service
@SuppressWarnings("unchecked")
public class DepartmentServiceImpl extends BaseDaoImpl<Department> implements DepartmentService {

	public List<Department> findTopList() {
		return getSession().createQuery(
				"from Department where parent is null")
				.list();
	}

	public List<Department> findChildren(Long id) {
		return getSession().createQuery(
				"from Department d where d.parent.id=?")
				.setParameter(0, id)
				.list();
	}

	
	
}
