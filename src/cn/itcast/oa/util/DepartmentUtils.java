package cn.itcast.oa.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cn.itcast.oa.domain.Department;

public class DepartmentUtils {

	/**
	 * 遍历部门树,把集合返回,修改部门名称,以表示层次
	 * @param topList
	 * @return
	 */
	public static List<Department> getAllDepartments(List<Department> topList){
		List<Department> list=new ArrayList<Department>();
		walkDepartmentTreeList(topList,"┣",list);
		return list;
		
		
	}
	
	/**
	 * 遍历部门树,把遍历出的部门信息放到指定的集合中
	 * @param topList
	 */
	private static void walkDepartmentTreeList(Collection<Department> topList,String prefix,List<Department> list){
		for(Department top:topList){
			//顶点
			Department copy=new Department();
			copy.setId(top.getId());
			copy.setName(prefix+top.getName());
			list.add(copy);
//			top.setName(prefix+top.getName());
			//子树
			walkDepartmentTreeList(top.getChildren(),"　"+prefix,list);
		}
	}
}
