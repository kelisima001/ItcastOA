package cn.itcast.oa.base;

import javax.annotation.Resource;

import cn.itcast.oa.dao.DepartmentDao;
import cn.itcast.oa.dao.RoleDao;
import cn.itcast.oa.dao.UserDao;

public interface BaseResource {

	@Resource
	UserDao userDao;
	@Resource
	RoleDao roleDao;
	@Resource
	DepartmentDao departmentDao;
}
