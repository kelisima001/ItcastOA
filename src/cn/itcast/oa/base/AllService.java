package cn.itcast.oa.base;

import javax.annotation.Resource;

import cn.itcast.oa.service.RoleService;

public interface AllService {

	@Resource
	RoleService roleService;
}
