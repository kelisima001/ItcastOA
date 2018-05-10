package cn.itcast.oa.dao;

import java.util.List;

import cn.itcast.oa.base.BaseDao;
import cn.itcast.oa.domain.Department;

public interface DepartmentDao extends BaseDao<Department>{

	List<Department> findTopList();
	List<Department> findChildren(Long id);
}
