package com.migro.jobcenter.enums;

/**
 * <p>
 * 统一接口数据类型
 * </p>
 *
 * @author migro
 * @since 2020/11/6 10:43
 */
public enum MsgDataType {
    // 统一接口数据类型  1--采购订单
    采购订单(1),
    响应单(2),
    配送单(3),
    耗材字典(4),
    供应商(5),
    耗材品种(6)
    ;

    private int value = 0;

    private MsgDataType(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
