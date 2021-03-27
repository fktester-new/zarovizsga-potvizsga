package hu.nive.ujratervezes.zarovizsga.words.hu.nive.ujratervezes.zarovizsga.peoplesql;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleDao {

    private DataSource dataSource;

    public PeopleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String findIpByName(String firstName, String lastName) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("select ip_address from people where first_name = ? and last_name = ?")
        ) {
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            return findIp(stmt);

        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot connect", sqle);
        }
    }

    private String findIp(PreparedStatement statement) {
        try (
                ResultSet rs = statement.executeQuery()
        ) {
            if (rs.next()) {
                return rs.getString("ip_address");
            }

        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot execute", sqle);
        }
        throw new IllegalArgumentException("No result");
    }
}
