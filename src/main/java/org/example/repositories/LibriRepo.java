package org.example.repositories;

import org.example.models.Libri;
import org.example.models.Punonjesit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LibriRepo {

    public void shtoLiber(Connection connection, Libri libri) throws SQLException {
        String sql = "INSERT INTO libri (id,titulli,faqe, gjinia) VALUES (?, ?, ?,?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, libri.getId());
        stmt.setString(2, libri.getTitulli());
        stmt.setInt(3,libri.getNumriFaqeve());
        stmt.setString(4,libri.getGjiniaLibrit().name());

        stmt.executeUpdate();
    }



    public void updateKolonaRe(Connection conn, Libri libri) throws SQLException {
        String sql = "UPDATE libri SET formati = ? WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, libri.getFormati()); // ose metoda tjetër get nga objekti Libri
            stmt.setString(2, libri.getId());


            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Libri me ID " + libri.getId() + " u përditësua me sukses.");
            } else {
                System.out.println("⚠ Libri me ID " + libri.getId() + " nuk u gjet në databazë.");
            }
        }
    }

    public void updateKolonaRe1(Connection conn, Libri libri) throws SQLException {
        String sql = "UPDATE libri SET tipi = ? WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, libri.getTipi().name()); // ose metoda tjetër get nga objekti Libri
            stmt.setString(2, libri.getId());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Libri me ID " + libri.getId() + " u përditësua me sukses.");
            } else {
                System.out.println("⚠ Libri me ID " + libri.getId() + " nuk u gjet në databazë.");
            }
        }
    }
    public void updateTipiPerId(Connection conn, Libri libri) throws SQLException {
        String sql = "UPDATE libri SET titulli = ?, faqe = ?, gjinia = ?, formati = ? , tipi= ? WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, libri.getTitulli());
            stmt.setInt(2, libri.getNumriFaqeve());
            stmt.setString(3, String.valueOf(libri.getGjiniaLibrit()));
            stmt.setString(4, libri.getFormati());
            stmt.setString(5,String.valueOf(libri.getTipi()));
            stmt.setString(6, libri.getId());


            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Libri me ID " + libri.getId() + " u përditësua me sukses.");
            } else {
                System.out.println("Libri me ID " + libri.getId() + " nuk u gjet në databazë.");
            }
        }
    }
    public void deleteLibriPerId(Connection conn, String id) throws SQLException {
        String sql = "DELETE FROM libri WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id); // vendos id e librit që do fshihet

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Libri me ID " + id + " u fshi me sukses.");
            } else {
                System.out.println("⚠ Libri me ID " + id + " nuk u gjet në databazë.");
            }
        }
    }


    public void readLibriPerId(Connection conn, String id) throws SQLException {
        String sql = "SELECT titulli, faqe, gjinia, formati, tipi FROM libri WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("ID: " + id +
                            ", Titulli: " + rs.getString("titulli") +
                            ", Faqet: " + rs.getInt("faqe") +
                            ", Gjinia: " + rs.getString("gjinia") +
                            ", Formati: " + rs.getString("formati") +
                            ", Tipi: " + rs.getString("tipi"));
                }

                else {
                    System.out.println("⚠ Libri me ID " + id + " nuk u gjet në databazë.");
                }
            }
        }
    }

}





