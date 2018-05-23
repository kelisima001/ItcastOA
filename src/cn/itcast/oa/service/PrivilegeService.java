package cn.itcast.oa.service;

import java.util.List;
import cn.itcast.oa.base.BaseDao;
import cn.itcast.oa.domain.Privilege;

public interface PrivilegeService extends BaseDao<Privilege>{

	/**
	 * 查询所有顶级权限
	 */
	List<Privilege> findTopList();

	/**
	 * 查询所有权限url
	 */
	List<String> getAllPrivUrls();

}
