package com.migro.jobcenter.mapper;

import com.migro.jobcenter.model.vo.OrderDetailVO;
import com.migro.jobcenter.model.vo.OrderVO;
import top.doublewin.core.base.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 类描述
 * </p>
 *
 * @author migro
 * @since 2020/11/12 14:59
 */
public interface OrderMapper extends BaseMapper<OrderVO> {

    /**
     * 查询订单明细
     * @param
     * @return
     */
    List<OrderDetailVO> listDetails(Map<String,Object> param);

    /**
     * 更新消息表状态
     * @param
     * @return
     */
    void updateMsgStatus(Map<String,Object> param);

}
