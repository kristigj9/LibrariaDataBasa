package org.example.repositories;

import org.example.models.Huazim;
import org.example.models.Libri;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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


    public void deleteHuazimPerId(Connection conn, String id) throws SQLException {
        String sql = "DELETE FROM huazim WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id); // vendos id e librit që do fshihet

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Huazimi me ID " + id + " u fshi me sukses.");
            } else {
                System.out.println("⚠ Huazimi me ID " + id + " nuk u gjet në databazë.");
            }
        }
    }

    public void readHuazimiPerId(Connection conn, String id) throws SQLException {
        String sql = "SELECT libri_id ,punonjes_id, data_kthimit, data_huazimit FROM huazim WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1,id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("ID: " + id +
                            ", Libri_id: " + rs.getString("libri_id") +
                            ", Punonjes_id: " + rs.getString("punonjes_id")+
                            ", Data kthimit: " + rs.getString("data_kthimit")+
                            ", Data huazimit: " + rs.getString("data_huazimit")
                            );
                }

                else {
                    System.out.println("⚠ Huazimi me ID " + id + " nuk u gjet në databazë.");
                }
            }
        }
    }



}
