package com.migro.jobcenter.utils;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

/**
 * <p>
 * Oracle Clob字段处理类
 * </p>
 *
 * @author migro
 * @since 2020/12/11 10:10
 */
public class OracleClobTypeHandler implements TypeHandler<Object> {
    protected Logger logger = LogManager.getLogger();

    @Override
    public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        Clob clob = ps.getConnection().createClob();
        clob.setString(1, (String) parameter);
        ps.setClob(i, clob);
        logger.debug("set Clob parameter is {}",parameter);
    }

    @Override
    public Object getResult(ResultSet rs, String columnName) throws SQLException {
        Clob clob = rs.getClob(columnName);
        return (clob == null || clob.length() == 0) ? null : clob.getSubString((long) 1, (int) clob.length());
    }

    @Override
    public Object getResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public Object getResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
