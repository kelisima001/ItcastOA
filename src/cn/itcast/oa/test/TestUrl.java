package cn.itcast.oa.test;

import org.junit.Test;

import cn.itcast.oa.domain.User;

public class TestUrl {

	@Test
	public void testUrl(){
		String url="roleAction_delete?id=%{id}";
		int index = url.indexOf('?');
        if (index != -1) {
            String params = url.substring(index);
            url = url.substring(0, index) + ".action" + params;
        } else {
            url = url + ".action";
        }
        System.out.println(url);
	}
	
	@Test
	public void testUrl2(){
		String privUrl="/uerAction_login";
		boolean a =privUrl.equals("/uerAction_login")||privUrl.equals("/uerAction_logout");
		System.out.println(a);
	}
	
	@Test
	public void testUrl3(){
		/*User user=new User();
		String privUrl="/uerAction_logout";
		boolean a =user.hasPrivilegeByUrl(privUrl);
		System.out.println(a);*/
		Long a=1L;
		int b=1;
		System.out.println(a<=b);
		
	}
}
