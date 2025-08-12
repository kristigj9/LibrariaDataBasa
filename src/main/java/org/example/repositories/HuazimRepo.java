package org.example.repositories;

import org.example.models.Huazim;
import org.example.models.Libri;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HuazimRepo {
    public void shtoHuazim(Connection connection, Huazim huazim) throws SQLException {
        String sql = "INSERT INTO huazim (libri_id,punonjes_id, data_huazimit,data_kthimit) VALUES (?, ?, ?,?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, huazim.getLibri().getId());
        stmt.setString(2, huazim.getPunonjesit().getId());
        stmt.setDate(3, new java.sql.Date(huazim.getGetData_Huazimit().getTime()));
        stmt.setDate(4, new java.sql.Date(huazim.getData_Kthimit().getTime()));
        stmt.executeUpdate();

        System.out.println("Huazimi u shtua me sukses!");

    }
}
