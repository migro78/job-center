package com.migro.jobcenter.client;

/**
 * <p>
 * 接口数据类型
 * </p>
 *
 * @author migro
 * @since 2020/11/13 11:17
 */
public enum DataType {
    // 接口数据类型  1--订单
    采购订单(1),
    响应单(2),
    配送单(3),
    耗材字典(4),
    供应商(5),
    耗材品种(6),
    企业证照(7),
    耗材注册证(8)
    ;

    private int value = 0;

    private DataType(int value) {
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
