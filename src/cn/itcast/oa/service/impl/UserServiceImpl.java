package cn.itcast.oa.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import cn.itcast.oa.base.impl.BaseDaoImpl;
import cn.itcast.oa.domain.User;
import cn.itcast.oa.service.UserService;

@Service
public class UserServiceImpl extends BaseDaoImpl<User> implements UserService {

	/**
	 * 验证登陆
	 */
	public User findByLoginNameAndPassword(String loginName,String password) {
		
		/*if(loginName==null ||password ==null){
			return null;
		}*/
//		System.out.println("用户名:"+loginName+"密码:"+password);
		String md5Digest=DigestUtils.md5Hex(password);
		User user=(User) getSession().createQuery(
				"from User u where u.loginName=? and u.password=?")
				.setParameter(0, loginName)
				.setParameter(1, md5Digest)
				.uniqueResult();
//		System.out.println(user);
		return user;
	}

	
}
