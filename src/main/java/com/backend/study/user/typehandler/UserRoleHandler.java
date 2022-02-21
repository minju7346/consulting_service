package com.backend.study.user.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import com.backend.study.user.model.enums.UserRole;

@MappedTypes(UserRole.class)
public class UserRoleHandler implements TypeHandler<UserRole> {

	@Override
	public void setParameter(PreparedStatement ps, int index, UserRole parameter, JdbcType jdbcType) throws
		SQLException {
		ps.setString(index, parameter.name());
	}

	@Override
	public UserRole getResult(ResultSet rs, String columnName) throws SQLException {
		String name = rs.getString(columnName);

		return UserRole.valueOf(name);
	}

	@Override
	public UserRole getResult(ResultSet rs, int columnIndex) throws SQLException {
		String name = rs.getString(columnIndex);

		return UserRole.valueOf(name);
	}

	@Override
	public UserRole getResult(CallableStatement cs, int columnIndex) throws SQLException {
		String name = cs.getString(columnIndex);

		return UserRole.valueOf(name);
	}
}
