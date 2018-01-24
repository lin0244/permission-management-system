package com.lyu.drp.sysmanage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyu.drp.sysmanage.entity.Menu;
import com.lyu.drp.sysmanage.mapper.MenuMapper;
import com.lyu.drp.sysmanage.service.IMenuService;

/**
 * 类名称: menuService实现类
 * 类描述: 实现了menuService的一些接口
 * 全限定性类名: com.lyu.drp.sysmanage.service.impl.MenuService
 * @author 曲健磊
 * @date 2018年1月23日 下午1:11:52
 * @version V1.0
 */
@Service("menuService")
public class MenuService implements IMenuService {
	@Autowired
	private MenuMapper menuMapper;
	
	@Override
	public List<Menu> getMenuListByUser(Long userId) {
		return menuMapper.getMenuListByUser(userId);
	}
	
}