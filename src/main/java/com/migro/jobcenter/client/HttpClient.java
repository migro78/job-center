package com.migro.jobcenter.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.migro.jobcenter.model.vo.UnifiedInterfaceDataVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import top.doublewin.core.builder.DataBuilder;
import top.doublewin.core.exception.BusinessException;
import top.doublewin.core.util.DataUtil;
import top.doublewin.core.util.HttpUtil;

import java.util.Base64;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 调用平台服务的接口
 * </p>
 *
 * @author migro
 * @since 2020/11/13 10:19
 */
public class HttpClient {
    protected static Logger logger = LogManager.getLogger();
    /**
     * URL 获取授权token
     */
    private static final String URL_GET_ACCESS_TOKEN = "/interface/login";

    /**
     * URL 统一数据上传
     */
    private static final String URL_DATA_UPLOAD = "/interface/unifiedDataUpload";

    private static Base64.Encoder encoder = Base64.getEncoder();

    /**
     * 获取授权码
     *
     * @param
     * @return
     */
    public static String getAccessToken() {
        Map<String, Object> param = DataBuilder.<String, Object>map()
                .put("orgCode", GlobalParams.getAccount())
                .put("secret", GlobalParams.getSecret()).build();
        logger.debug("getAccessToken: url==>{}   param==> {}", GlobalParams.getHost() + URL_GET_ACCESS_TOKEN, JSON.toJSONString(param));
        // 调用服务
        String resp = HttpUtil.post(GlobalParams.getHost() + URL_GET_ACCESS_TOKEN, JSON.toJSONString(param));
        // 解析响应结果
        JSONObject obj = parseResponse(resp);
        // 获取token,保存到全局变量中
        String token = obj.getString("Authorization");
        GlobalParams.setAccessToken(token);
        logger.debug("getAccessToken:  token==>{}", token);

        return GlobalParams.getAccessToken();
    }

    /**
     * 订单上传
     *
     * @param
     * @return
     */
    public static String uploadOrders(List orderList) {
        UnifiedInterfaceDataVO vo = new UnifiedInterfaceDataVO();
        vo.setDataType(DataType.订单.value());
        vo.setDataInOut(DataInOut.平台.value());
        vo.setCount(orderList.size());
        vo.setDataContent(encoder.encodeToString(JSON.toJSONString(orderList).getBytes()));
        // 包装请求头
        if (DataUtil.isEmpty(GlobalParams.getAccessToken())) {
            GlobalParams.setAccessToken(getAccessToken());
            logger.debug("token为空，从新获取token==>{}", GlobalParams.getAccessToken());
        } else {
            logger.debug("使用已有token==>{}", GlobalParams.getAccessToken());
        }
        Map<String, String> header = DataBuilder.<String, String>map().put("Authorization", GlobalParams.getAccessToken()).build();

        String resp = HttpUtil.post(GlobalParams.getHost() + URL_DATA_UPLOAD, JSON.toJSONString(vo), header);
        // 解析响应结果
        parseResponse(resp);

        return resp;
    }

    /**
     * 远程服务调用结果处理
     *
     * @param
     * @return
     */
    private static JSONObject parseResponse(String response) {
        if (DataUtil.isEmpty(response)) {
            throw new BusinessException("远程服务调用失败！ 失败原因：无响应结果");
        }
        // 解析结果
        JSONObject obj = JSON.parseObject(response);
        if (!"200".equals(obj.getString("code"))) {
            throw new BusinessException("远程服务调用出错！ 错误信息：" + obj.getString("msg"));
        }
        return obj;
    }
}
