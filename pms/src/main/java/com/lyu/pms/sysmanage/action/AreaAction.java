package com.lyu.pms.sysmanage.action;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.lyu.pms.sysmanage.dto.AreaDto;
import com.lyu.pms.sysmanage.dto.TreeDto;
import com.lyu.pms.sysmanage.entity.Area;
import com.lyu.pms.sysmanage.service.IAreaService;
import com.lyu.pms.util.TreeUtils;
import com.lyu.pms.util.UserUtils;

/**
 * 类名称: 区域业务控制类
 * 类描述: 用于管理区域的业务控制类
 * 全限定性类名: com.lyu.pms.sysmanage.action.AreaAction
 * @author 曲健磊
 * @date 2018年2月2日 上午10:02:25
 * @version V1.0
 */
public class AreaAction {
	
	// 发送给前台的部门列表的json字符串数组
	private String jsonObj;
	
	// 返回给前台的消息
	private String message;
	
	// 修改(2)还是增加(1)
	private Integer editFlag;
	
	// 区域id
	private Long areaId;
	
	// 区域对象
	private AreaDto area;
	
	// 查询到的区域列表
	private List<Area> areaList;
	
	// spring注入
	private IAreaService areaService;

	/**
	 * 处理前往区域列表页面的请求
	 * @param null
	 * @return 视图名称
	 */
	public String gotoAreaList() {
		// 只获取当前用户所拥有的区域
		List<Area> tempAreaList = areaService.getAreaListByUId(UserUtils.getCurrentUserId());
		List<Area> returnAreaList = new ArrayList<Area>();
		
		TreeUtils.sortTreeList(returnAreaList, tempAreaList, 0L);
		this.areaList = returnAreaList;
		
		return "success";
	}
	
	/**
	 * 处理前往区域编辑页面的请求
	 * @param null
	 * @return 视图名称
	 */
	public String gotoAreaEdit() {
		if (editFlag == 2 && this.areaId != null) { // 修改
			// 调用service查询一下该id的信息
			this.area = this.areaService.getAreaDetailById(this.areaId);
			
		} else if (editFlag == 1 && this.areaId != null) { // 添加下级区域
			this.area = this.areaService.getAreaDetailById(this.areaId);
			Long parentId = this.area.getId();
			String parentName = this.area.getName();
			this.area = null;
			this.area = new AreaDto();
			this.area.setParentId(parentId);
			this.area.setParentName(parentName);
		}
		
		return "success";
	}
	
	/**
	 * 保存区域，新增的话editFlag为1，修改为2
	 * @param null
	 * @return 视图名称
	 */
	public String saveArea() {
		Area area = JSON.parseObject(jsonObj, Area.class);
		if (area.getId() == null) { // 新增区域
			boolean flag = areaService.saveArea(area);
			this.message = "no";
			if (flag) {
				this.message = "yes";
			}
		} else { // 修改区域
			boolean flag = areaService.updateArea(area);
			this.message = "no";
			if (flag) {
				this.message = "yes";
			}
		}
		return "success";
	}
	
	/**
	 * 确认是否有子区域
	 * @param null
	 * @return 视图名称
	 */
	public String confirmHasSubArea() {
		boolean flag = true;
		flag = areaService.hasSubArea(this.areaId);
		
		if (!flag) { // 为false则表示没有子区域，可以删除
			this.message = "no";
			
		} else { // 为true则表示由子区域，不能删除
			this.message = "yes";
		}
		
		return "success";
	}
	
	/**
	 * 删除子区域
	 * @param null
	 * @return 视图名称
	 */
	public String delArea() {
		if (!areaService.hasSubArea(this.areaId)) {
			boolean flag = areaService.delArea(this.areaId);
			if (flag) {
				this.message = "删除区域成功！";
			} else {
				this.message = "删除失败，请先删除子区域！";
			}
		} else {
			this.message = "删除失败，请先删除子区域！";
		}
		
		return "success";
	}
	
	/**
	 * 加载区域zTree
	 * @param null
	 * @return 视图名称
	 */
	public String getAreaTree() {
		List<Area> areaList = areaService.getAreaListByUId(UserUtils.getCurrentUserId());
		List<TreeDto> treeList = new ArrayList<TreeDto>();
		
		// 说明是通过单击修改按钮进来的，要剔除掉自己以及它的子孙节点
		if (areaId != null) {
			// 根据该id查询出当前区域的所有子孙区域并把他们从treeList中剔除掉
			List<Area> sonAreaList = areaService.getAllSubAreasByPId(this.areaId); 
			// 使用listIterator迭代器剔除
			for (ListIterator<Area> it = areaList.listIterator(); it.hasNext();) {
				Area area = it.next();
				if (sonAreaList.contains(area) || area.getId().longValue() == this.areaId) {
					it.remove();
				}
			}
		}
		
		for (Area area : areaList) {
			TreeDto treeNode = new TreeDto();
			treeNode.setId(area.getId());
			treeNode.setName(area.getName());
			treeNode.setParentId(area.getParentId());
			treeList.add(treeNode);
		}
		
		this.jsonObj = JSONArray.toJSONString(treeList);
		
		return "success";
	}
	
	/**
	 * 一系列的setter和getter方法
	 */
	public String getJsonObj() {
		return jsonObj;
	}
	
	public void setJsonObj(String jsonObj) {
		this.jsonObj = jsonObj;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Integer getEditFlag() {
		return editFlag;
	}
	
	public void setEditFlag(Integer editFlag) {
		this.editFlag = editFlag;
	}
	
	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public AreaDto getArea() {
		return area;
	}

	public void setArea(AreaDto area) {
		this.area = area;
	}

	public List<Area> getAreaList() {
		return areaList;
	}

	public void setAreaList(List<Area> areaList) {
		this.areaList = areaList;
	}

	public IAreaService getAreaService() {
		return areaService;
	}

	public void setAreaService(IAreaService areaService) {
		this.areaService = areaService;
	}
}
