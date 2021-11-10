package business.persistence;

import business.entities.Bottom;
import business.entities.User;
import business.exceptions.UserException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BottomMapper {

    private Database database;

    public BottomMapper(Database database) {
        this.database = database;
    }

    public List<Bottom> getAllBottoms() throws UserException {
        List<Bottom> bottomList = null;

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM bottoms";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    if (bottomList == null) {
                        bottomList = new ArrayList<>();
                    }

                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    double price = rs.getDouble("price");
                    Bottom bottom = new Bottom(name, price, id);
                    bottomList.add(bottom);
                }
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
        return bottomList;
    }
}
