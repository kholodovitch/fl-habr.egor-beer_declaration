package ek.declaration.services;

import ek.declaration.model.Nomenklature;
import ek.declaration.model.Ostatki;
import ek.declaration.model.Receipts;
import ek.declaration.model.Sales;
import ek.declaration.model.Storage;
import ek.declaration.model.Suppliers;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DeclarationService {
    private final Statement statement;

    public DeclarationService(Statement statement) {
        this.statement = statement;
    }

    public void sendNomenclature(List<Nomenklature> nomenclatureList) throws SQLException {
        //очистка таблицы перед вставкой
        statement.execute("delete from nomenklatura_");
        System.out.println("delete from nomenklatura_");

        for (Nomenklature nomenklature : nomenclatureList) {
            //вставка новых данных из запроса
            String selectSql = String.format("insert into  nomenklatura_" +
                    " (ARTICLE, NAME, NALOG, MESABBREV, PXT3, COD_PROD, PRODUCER) values ('%s', '%s', %s, '%s', '%s', '%s', '%s');",
                    nomenklature.getArtcent(), nomenklature.getName(), nomenklature.getVat(), nomenklature.getMeasabbr(), nomenklature.getPht3(), nomenklature.getCod_prod(), nomenklature.getProducer());
            System.out.println(selectSql);
            statement.execute(selectSql);
            System.out.println("statement.execute(selectSql);");
        }
    }

    public void sendStorage(List<Storage> storageList) throws SQLException {
        //очистка таблицы перед вставкой
        statement.execute("delete from sclady_");
        System.out.println("delete from sclady_");

        for (Storage storage : storageList) {
            //вставка новых данных из запроса
            String selectSql = String.format("insert into  sclady_" +
                    " (LOC, LOCINFO, [GROUPING], INN, KPP, STATE, ADDRESS) values ('%s', '%s', '%s', '%s', '%s', %d, '%s');",
                    storage.getLoc(), storage.getLocinfo(), storage.getGrouping(), storage.getInn(), storage.getKpp(), storage.getState(), storage.getAddr());
            System.out.println(selectSql);
            statement.execute(selectSql);
            System.out.println("statement.execute(selectSql);");
        }
    }

    public void sendSuppliers(List<Suppliers> suppliersList) throws SQLException {
        //очистка таблицы перед вставкой
        statement.execute("delete from postavchiki_");
        System.out.println("delete from postavchiki_");

        for (Suppliers suppliers : suppliersList) {
            //вставка новых данных из запроса
            String selectSql = String.format("insert into  postavchiki_" +
                    " (ID, INN, KPP, NAMEP) values ('%s', '%s', '%s', '%s');",
                    suppliers.getId(), suppliers.getInn(), suppliers.getKpp(), suppliers.getNamep());
            System.out.println(selectSql);
            statement.execute(selectSql);
            System.out.println("statement.execute(selectSql);");
        }
    }

    public void sendReceipts(List<Receipts> receiptsList) throws SQLException {
        //очистка таблицы перед вставкой
        statement.execute("delete from postupleniya_");
        System.out.println("delete from postupleniya_");

        for (Receipts receipts : receiptsList) {
            //вставка новых данных из запроса
            String selectSql = String.format("insert into  postupleniya_" +
                    " (NOMER, [DATA], LOC, CLIENTID, INN, KPP, NACLPOST, CHFPOST, DATACHF, ARTICLE, KOLVO, ITPRNOTAX, TOTPRNOTAX, ITPRICE, TOTPRICE, TAXRATE, TAXSUM, OPCODE, PRODUCER, USEROP, LOCFROM, RECIVER)" +
                    " values ('%s%s%s', '%s', '%s', '%s', '%s', '%s%s%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%d', '%s', '%s', '%s', '%s');",
                    receipts.getNomer(), createDateString(receipts.getDt()), receipts.getLoc(), receipts.getClientid(), receipts.getInn(), receipts.getKpp(), receipts.getNaclpost(), receipts.getChfpost(),
                    createDateString(receipts.getDatachf()), receipts.getArticle(), receipts.getKolvo(), receipts.getItprnotax(), receipts.getTotprnotax(), receipts.getItprice(), receipts.getTotprice(),
                    receipts.getTaxrate(), receipts.getTaxsum(), receipts.getOpcode(), receipts.getProducer(), receipts.getUserop(), receipts.getLocfrom(), receipts.getReciver());
            System.out.println(selectSql);
            statement.execute(selectSql);
            System.out.println("statement.execute(selectSql);");
        }
    }

    public String createDateString(String dateString) {
        if (dateString == null) {
            return "', null, '";
        } else
            return "', CAST('" + dateString + "' as datetime), '";
    }

    public void sendOstatki(List<Ostatki> ostatkiList) throws SQLException {
        //очистка таблицы перед вставкой
        statement.execute("delete from ostatki_");
        System.out.println("delete from ostatki_");

        for (Ostatki ostatki : ostatkiList) {
            //вставка новых данных из запроса
            String selectSql = String.format("insert into  ostatki_" +
                    " (LOC, ARTICLE, LASTPRICEN, OSTNACH, OSTKONEC, SDATE, CDATE)" +
                    " values ('%s', '%s', %s, %s, %s, CAST('%s' as datetime), CAST('%s' as datetime));",
                    ostatki.getLoc(), ostatki.getArticle(), ostatki.getLastpricen(), ostatki.getOstnach(), ostatki.getOstkonec(), ostatki.getSdate(), ostatki.getCdate());
            System.out.println(selectSql);
            statement.execute(selectSql);
            System.out.println("statement.execute(selectSql);");
        }
    }

    public void sendSales(List<Sales> salesList) throws SQLException {
        //очистка таблицы перед вставкой
        statement.execute("delete from prodazhy_");
        System.out.println("delete from prodazhy_");

        for (Sales sales : salesList) {
            //вставка новых данных из запроса
            String selectSql = String.format("insert into  prodazhy_" +
                    " (loc, article, kolvo, totprice, taxsum, taxrate, sdate, cdate)" +
                    " values ('%s', '%s', '%s', '%s', '%s', '%s', CAST('%s' as datetime), CAST('%s' as datetime));",
                    sales.getLoc(), sales.getArticle(), sales.getKolvo(), sales.getTotprice(), sales.getTaxsum(), sales.getTaxrate(), sales.getSdate(), sales.getCdate());
            System.out.println(selectSql);
            statement.execute(selectSql);
            System.out.println("statement.execute(selectSql);");
        }
    }
}
