package com.migro.jobcenter.web;

import com.migro.jobcenter.client.HttpClient;
import com.migro.jobcenter.model.vo.OrderVO;
import com.migro.jobcenter.service.IOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import top.doublewin.core.base.BaseController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 类描述
 * </p>
 *
 * @author migro
 * @since 2020/11/12 15:09
 */
@Controller
@RequestMapping("/test/")
@Api(value = "接口测试", description = "接口测试" ,tags = {"接口测试"})
public class TestController extends BaseController<OrderVO, IOrderService> {


    @PutMapping("getAccessToken")
    @ApiOperation(value = "登录获取授权码")
    public Object getAccessToken(ModelMap modelMap, @RequestBody Map<String,Object> param) {
        String ret = HttpClient.getAccessToken();
        return setSuccessModelMap(modelMap,ret);
    }

    @PutMapping("uploadOrder")
    @ApiOperation(value = "上传订单")
    public Object uploadOrder(ModelMap modelMap, @RequestBody Map<String,Object> param) {
        return setSuccessModelMap(modelMap,service.uploadOrder(param));
    }

}
