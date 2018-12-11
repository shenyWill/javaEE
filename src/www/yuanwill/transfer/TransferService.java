package www.yuanwill.transfer;

import java.sql.Connection;
import java.sql.SQLException;

import com.yuanwill.utils.JDBCUtilsConfig;

public class TransferService {

	public boolean transfer(String out, String in, double money) {
		
		TransferDao dao = new TransferDao();
		boolean isTranferSunccess = true;
		
		Connection conn = JDBCUtilsConfig.getConnection();
		try {
			// ��������
			conn.setAutoCommit(false);
			// ת��Ǯ�ķ���
			dao.out(out, money,conn);
			// ת��Ǯ�ķ���
			dao.in(in,money,conn);
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			isTranferSunccess = false;
			e.printStackTrace();
		} finally {
			try {
				conn.commit();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		return isTranferSunccess;
	}

}
