package com.lyu.pms.sysmanage.service;

import com.github.pagehelper.PageInfo;
import com.lyu.pms.common.dto.PageParam;
import com.lyu.pms.sysmanage.dto.LogDto;
import com.lyu.pms.sysmanage.entity.Log;

/**
 * 类名称: 日志服务类接口
 * 类描述: 封装了一些对日志的操作
 * 全限定性类名: com.lyu.pms.sysmanage.service.ILogService
 * @author 曲健磊
 * @date 2018年2月11日 下午10:27:25
 * @version V1.0
 */
public interface ILogService {
	
	/**
	 * 根据日志的某些已知信息查询日志的完整信息
	 * @param 
	 * @return
	 */
	PageInfo<LogDto> getLogListPage(LogDto logDto, PageParam pageParam);
	
	/**
	 * 添加日志
	 * @param 
	 * @return
	 */
	boolean insertLog(Log log);
	
	/**
	 * 删除日志
	 * @param 
	 * @return
	 */
	boolean removeLog(Long logId);
	
}