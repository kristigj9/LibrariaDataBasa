package org.example.repositories;

import org.example.models.Punonjesit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PunonjesitRepo {

        public void shtoPunonjes(Connection connection, Punonjesit p) throws SQLException {
            String sql = "INSERT INTO punonjesi (id, emri) VALUES (?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, p.getId());
            stmt.setString(2, p.getEmer());

            System.out.println("ID që po futet: " + p.getId());

            stmt.executeUpdate();


        }


    public void updateKolonaPunonjesit(Connection conn, Punonjesit punonjesit) throws SQLException {
        String sql = "UPDATE punonjesi SET emri = ?, mbiemer = ? WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, punonjesit.getEmer());
            stmt.setString(2,punonjesit.getMbiemer());
            stmt.setString(3, punonjesit.getId());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Punonjesi me ID " + punonjesit.getId() + " u përditësua me sukses.");
            } else {
                System.out.println("⚠ Punonjesi me ID " + punonjesit.getId() + " nuk u gjet në databazë.");
            }
        }
    }

    public void deletePunonjesiPerId(Connection conn, String id) throws SQLException {
        String sql = "DELETE FROM punonjesi WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id); // vendos id e librit që do fshihet

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Punonjesi me ID " + id + " u fshi me sukses.");
            } else {
                System.out.println("⚠ Punonjesi me ID " + id + " nuk u gjet në databazë.");
            }
        }
    }


    public void readPunonjesiPerId(Connection conn, String id) throws SQLException {
        String sql = "SELECT emri , mbiemer FROM punonjesi WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1,id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("ID: " + id +
                            ", Emri: " + rs.getString("emri") +
                            ", Mbiemri: " + rs.getString("mbiemer"));
                }

                else {
                    System.out.println("⚠ Punonjesi me ID " + id + " nuk u gjet në databazë.");
                }
            }
        }
    }


}
