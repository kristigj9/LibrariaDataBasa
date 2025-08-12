package org.example;

import org.example.db.DatabaseConnection;
import org.example.models.*;
import org.example.repositories.HuazimRepo;
import org.example.repositories.LibriRepo;
import org.example.repositories.PunonjesitRepo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class Main {
    public static void main(String[] args) {
        try {
            // Hapi 1: Krijo lidhjen me databazën
            Connection conn = DatabaseConnection.getConnection();

            //Hapi 2: Krijo objektin punonjes dhe repository
            Punonjesit p1 = new Punonjesit( "Cako","Berti","P001");
//
//
             PunonjesitRepo pr = new PunonjesitRepo();
           //  pr.shtoPunonjes(conn,p1);



//

//            System.out.println("Punonjesi u shtua me sukses!");
            Libri libri= new Libri_Digjital("L001", "Kodi Davincit", 456, Gjinia_Librit.ROMAN);
            LibriRepo lr = new LibriRepo();
           // lr.shtoLiber(conn,libri);


            Date dataHuazimit = Date.valueOf("2024-05-05");  // yyyy-MM-dd
            Date dataKthimit = Date.valueOf("2024-06-05");

            Huazim h1 = new Huazim( p1, libri, dataKthimit, dataHuazimit);
            HuazimRepo hr = new HuazimRepo();
            hr.shtoHuazim(conn,h1);



        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Gabim gjatë lidhjes ose shtimit të librit.");

        }
    }
}
