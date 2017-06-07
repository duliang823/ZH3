package DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.ub.beans.*;

public class ControlDB {

	public void executeUpdate(String sql) throws Exception {
		Connection con = null;
		Statement stmt = null;
		try {
			con = ConnectionFactory.getConnection();
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DatabaseUtils.closeObject(stmt, con);
		}
	}
}
