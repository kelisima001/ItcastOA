package cn.itcast.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import cn.itcast.oa.base.impl.BaseDaoImpl;
import cn.itcast.oa.dao.DepartmentDao;
import cn.itcast.oa.domain.Department;
import cn.itcast.oa.service.DepartmentService;

@Service
public class DepartmentServiceImpl extends BaseDaoImpl<Department> implements DepartmentService {

	@Resource
	private DepartmentDao departmentDao;
	
	public List<Department> findTopList() {
		// TODO Auto-generated method stub
		return departmentDao.findTopList();
	}

	public List<Department> findChildren(Long id) {
		// TODO Auto-generated method stub
		return departmentDao.findChildren(id);
	}

	
	
}
