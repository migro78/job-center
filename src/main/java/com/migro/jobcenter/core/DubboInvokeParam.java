package com.migro.jobcenter.core;

/**
 * <p>
 * Dubbo RPC 服务调用参数对象类
 * </p>
 *
 * @author migro
 * @since 2020/4/13 11:17
 */
public class DubboInvokeParam {

    private String paramType;
    private Object paramValue;

    public DubboInvokeParam(){}

    public DubboInvokeParam(String paramType,Object paramValue){
        this.paramType = paramType;
        this.paramValue = paramValue;
    }

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    public Object getParamValue() {
        return paramValue;
    }

    public void setParamValue(Object paramValue) {
        this.paramValue = paramValue;
    }
}
