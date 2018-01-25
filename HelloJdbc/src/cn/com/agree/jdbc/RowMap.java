package cn.com.agree.jdbc;

import java.sql.ResultSet;

public interface RowMap<T> {
	public T rowMapping(ResultSet rs);
}
