package com.backend.study.user.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import com.backend.study.user.model.enums.UserStatus;

@MappedTypes(UserStatus.class)
public class UserStatusHandler implements TypeHandler<UserStatus> {

	@Override
	public void setParameter(PreparedStatement ps, int index, UserStatus parameter, JdbcType jdbcType) throws
		SQLException {
		ps.setString(index, parameter.name());
	}

	@Override
	public UserStatus getResult(ResultSet rs, String columnName) throws SQLException {
		String name = rs.getString(columnName);

		return UserStatus.valueOf(name);
	}

	@Override
	public UserStatus getResult(ResultSet rs, int columnIndex) throws SQLException {
		String code = rs.getString(columnIndex);

		return UserStatus.valueOf(code);
	}

	@Override
	public UserStatus getResult(CallableStatement cs, int columnIndex) throws SQLException {
		String code = cs.getString(columnIndex);

		return UserStatus.valueOf(code);
	}
}
