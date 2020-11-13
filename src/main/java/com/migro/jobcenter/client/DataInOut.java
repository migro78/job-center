package com.migro.jobcenter.client;

/**
 * <p>
 * 类描述
 * </p>
 *
 * @author migro
 * @since 2020/11/13 11:20
 */
public enum DataInOut {
    // 接口数据流向
    平台(1),
    院内(2);

    private int value = 0;

    private DataInOut(int value) {
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
