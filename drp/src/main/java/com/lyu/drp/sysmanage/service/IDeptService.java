package com.lyu.drp.sysmanage.service;

import java.util.List;

import com.lyu.drp.sysmanage.dto.DeptDto;
import com.lyu.drp.sysmanage.entity.Dept;

/**
 * 类名称: 部门服务接口
 * 类描述: 为部门服务
 * 全限定性类名: com.lyu.drp.sysmanage.service.IDeptService
 * @author 曲健磊
 * @date 2018年1月30日 下午4:40:38
 * @version V1.0
 */
public interface IDeptService {
	
	/**
	 * 获取部门的详细信息，包括父部门的名称...
	 * @param 
	 * @return
	 */
	public DeptDto getDeptDetailById(Long deptId);
	
	/**
	 * 获取所有的部门列表
	 * @param 
	 * @return
	 */
	public List<Dept> getAllDeptList();
	
	/**
	 * 判断父部门下面是否有子部门
	 * @param 
	 * @return
	 */
	public boolean hasSubDept(Long parentId);
	
	/**
	 * 添加部门
	 * @param 
	 * @return
	 */
	public boolean saveDept(Dept dept);
	
	/**
	 * 修改部门
	 * @param 
	 * @return
	 */
	public boolean updateDept(Dept dept);
}
