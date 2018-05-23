package cn.itcast.oa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.base.impl.BaseDaoImpl;
import cn.itcast.oa.domain.Privilege;
import cn.itcast.oa.service.PrivilegeService;

/**
 * 权限service
 * @author wxdsg
 *
 */
@Service
@Transactional
@SuppressWarnings("unchecked")
public class PrivilegeServiceImpl extends BaseDaoImpl<Privilege> implements PrivilegeService {

	
	public List<Privilege> findTopList() {
		return getSession().createQuery(
			"from Privilege p where p.parent is null order by id asc").list();
	}

	
	@Override
	public List<String> getAllPrivUrls() {
		// 
		
		return getSession().createQuery(
			"select distinct p.url from Privilege p where p.url is not null").list();
	}

	

}
