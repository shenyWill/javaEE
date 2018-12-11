package www.yuanwill.transfer;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.yuanwill.utils.JDBCUtilsConfig;

public class TransferDao {

	public void out(String out, double money, Connection conn) throws SQLException {
		
		QueryRunner runner = new QueryRunner();
		String sql = "update account set money=money-? where name=?";
		runner.update(conn, sql, money, out);
	}

	public void in(String in, double money, Connection conn) throws SQLException {
		QueryRunner runner = new QueryRunner();
		String sql = "update account set money=money+? where name=?";
		runner.update(conn, sql, money, in);
	}

}
