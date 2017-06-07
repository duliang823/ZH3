package DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseUtils {
	public static void closeObject(ResultSet rs, Statement stm, Connection con) {
		closeObject(rs);
		closeObject(stm, con);
	}

	public static void closeObject(Statement stm, Connection con) {
		closeObject(stm);
		closeObject(con);
	}

	public static void closeObject(Connection con) {
		try {
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
		}
	}

	public static void closeObject(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
		}
	}

	public static void closeObject(Statement st) {
		try {
			if (st != null) {
				st.close();
			}
		} catch (Exception e) {
		}
	}
}
