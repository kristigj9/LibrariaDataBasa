package org.example.repositories;

import org.example.models.Libri;
import org.example.models.Punonjesit;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
}

