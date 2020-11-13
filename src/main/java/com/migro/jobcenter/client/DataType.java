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
    订单(1),
    其他(2);

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
