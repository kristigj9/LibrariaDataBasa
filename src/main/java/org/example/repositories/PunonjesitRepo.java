package org.example.repositories;

import org.example.models.Punonjesit;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
    }
