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
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Hapi 1: Krijo lidhjen me databazën
            Connection conn = DatabaseConnection.getConnection();

            //Hapi 2: Krijo objektin punonjes dhe repository
            Punonjesit p1 = new Punonjesit( "Cako","Berti","P001");
            Punonjesit p2 = new Punonjesit("Hoxha","Ana", "P002");
            Punonjesit p3 = new Punonjesit("Meta", "Diana", "P003");
            Punonjesit p4 = new Punonjesit("Duri", "Stela", "P001");
//
             PunonjesitRepo pr = new PunonjesitRepo();
          //  pr.shtoPunonjes(conn,p1);
           // pr.shtoPunonjes(conn,p2);
          //  pr.shtoPunonjes(conn,p3);


            // pr.updateKolonaPunonjesit(conn,p1);
            // pr.updateKolonaPunonjesit(conn, p2);
            // pr.updateKolonaPunonjesit(conn,p3);
           // pr.updateKolonaPunonjesit(conn,p4);
           // pr.deletePunonjesiPerId(conn,"P001");
            //pr.readPunonjesiPerId(conn,"P003");


//            System.out.println("Punonjesi u shtua me sukses!");
            Libri libri= new Libri_Digjital("L001", "Kodi Davincit", 456, Gjinia_Librit.ROMAN, Tipi.DIGJITAL,"PDF");
            Libri libri1 =new Libri_Printuar("LP001", "Engjej dhe Djaj", 564, Gjinia_Librit.ROMAN,Tipi.PRINTUAR,"Leter");
            Libri libri2=new Libri_Printuar("LP002","Chanel Sisters", 324, Gjinia_Librit.ROMAN,Tipi.PRINTUAR,"Leter");
            Libri libri3 =new Libri_Printuar("L001","Lufta e Trojes",560,Gjinia_Librit.FANTASHKENCE,Tipi.PRINTUAR,"Leter");
            LibriRepo lr = new LibriRepo();

            //lr.shtoLiber(conn,libri);
           // lr.shtoLiber(conn,libri1);
           //lr.shtoLiber(conn,libri2);
           //lr.updateKolonaRe(conn,libri);
          // lr.updateKolonaRe(conn,libri1);
          // lr.updateKolonaRe(conn,libri2);
            //lr.updateKolonaRe1(conn,libri);
            //lr.updateKolonaRe1(conn,libri1);
            //lr.updateKolonaRe1(conn,libri2);
            //lr.updateTipiPerId(conn,libri3);
            //lr.deleteLibriPerId(conn, libri.getId());
           // lr.readLibriPerId(conn,"LP001");



            Date dataHuazimit = Date.valueOf("2024-05-05");  // yyyy-MM-dd
            Date dataKthimit = Date.valueOf("2024-06-05");
            Date dataHuazimit1 = Date.valueOf("2024-05-05");  // yyyy-MM-dd
            Date dataKthimit1=Date.valueOf("2025-06-08");
            Date dataHuazimit2 = Date.valueOf("2024-05-24");  // yyyy-MM-dd
            Date dataKthimit2=Date.valueOf("2025-06-12");
            Date dataHuazimit3 = Date.valueOf("2025-04-24");  // yyyy-MM-dd
            Date dataKthimit3=Date.valueOf("2025-05-12");



            Huazim h1 = new Huazim( p1, libri, dataKthimit, dataHuazimit);
            Huazim h2 = new Huazim(p2,libri1,dataKthimit1,dataHuazimit1);
            Huazim h3 = new Huazim(p3,libri2,dataKthimit2,dataHuazimit2);
            Huazim h4 = new Huazim(p2,libri3,dataKthimit3,dataHuazimit3);

            HuazimRepo hr = new HuazimRepo();
           // hr.shtoHuazim(conn,h2);
           // hr.shtoHuazim(conn,h2);
            //hr.shtoHuazim(conn,h3);
           // hr.shtoHuazim(conn,h4);
             // hr.shtoHuazim(conn,h4);
           // hr.shtoHuazim(conn,h2);
          //  hr.shtoHuazim(conn,h3);
            //hr.deleteHuazimPerId(conn,"9");
            hr.readHuazimiPerId(conn,"12");





        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Gabim gjatë lidhjes ose shtimit të librit.");

        }
    }


}
