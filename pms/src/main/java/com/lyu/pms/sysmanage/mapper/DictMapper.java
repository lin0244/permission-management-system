package com.lyu.pms.sysmanage.mapper;

import java.util.List;

import com.lyu.pms.sysmanage.entity.Dict;

/**
 * 类名称: 字典映射接口
 * 类描述: 用于访问字典数据库中字典表的一些信息
 * 全限定性类名: com.lyu.pms.sysmanage.mapper.DictMapper
 * @author 曲健磊
 * @date 2018年1月19日 下午8:37:10
 * @version V1.0
 */
public interface DictMapper {
	
	/**
	 * 根据类型和描述获得字典列表
	 * @param type 字典的类型
	 * @param description 字典的描述
	 * @return 字典列表
	 */
	List<Dict> getDictList(Dict dict);
	
	/**
	 * 获取所有的字典类型
	 * @return 所有的字典类型的list集合
	 */
	List<String> getDictTypeList();
	
	/**
	 * 获取指定id的字典
	 * @param dictId 字典的id
	 * @return id为dictId的字典
	 */
	Dict getDictById(Long dictId);
	
	/**
	 * 新增字典
	 * @param dict 要增加的字典
	 * @return 受影响的行数1表示添加成功，否则失败
	 */
	int saveDict(Dict dict);
	
	/**
	 * 修改字典
	 * @param dict 要修改的字典
	 * @return 受影响的行数1表示修改成功，否则失败
	 */
	int updateDict(Dict dict);
	
	/**
	 * 根据字典id删除字典
	 * @param dictId 待删除的字典id
	 * @return 受影响的行数1表示删除成功，否则失败
	 */
	int delDictById(Long dictId);
}
