package ek.declaration.model;

import java.sql.Date;

public class Receipts implements Table {

    String nomer;
    String dt; //Дата
    String loc;
    String clientid;
    String inn;
    String kpp;
    String naclpost;
    String chfpost;
    String datachf; //Дата
    String article;
    double kolvo;
    double itprnotax;
    double totprnotax;
    double itprice;
    double totprice;
    double taxrate;
    double taxsum;
    int opcode;
    String producer;
    double userop;
    String locfrom;
    String reciver;

    @Override
    public String toString() {
        return "Receipts{" +
                "nomer='" + nomer + '\'' +
                ", dt=" + dt +
                ", loc='" + loc + '\'' +
                ", clientid='" + clientid + '\'' +
                ", inn='" + inn + '\'' +
                ", kpp='" + kpp + '\'' +
                ", naclpost='" + naclpost + '\'' +
                ", chfpost='" + chfpost + '\'' +
                ", datachf=" + datachf +
                ", article='" + article + '\'' +
                ", kolvo=" + kolvo +
                ", itprnotax=" + itprnotax +
                ", totprnotax=" + totprnotax +
                ", itprice=" + itprice +
                ", totprice=" + totprice +
                ", taxrate=" + taxrate +
                ", taxsum=" + taxsum +
                ", opcode=" + opcode +
                ", producer='" + producer + '\'' +
                ", userop=" + userop +
                ", locfrom='" + locfrom + '\'' +
                ", reciver='" + reciver + '\'' +
                '}';
    }

    public String getNomer() {
        return nomer;
    }

    public String getDt() {
        return dt;
    }

    public String getLoc() {
        return loc;
    }

    public String getClientid() {
        return clientid;
    }

    public String getInn() {
        return inn;
    }

    public String getKpp() {
        return kpp;
    }

    public String getNaclpost() {
        return naclpost;
    }

    public String getChfpost() {
        return chfpost;
    }

    public String getDatachf() {
        return datachf;
    }

    public String getArticle() {
        return article;
    }

    public double getKolvo() {
        return kolvo;
    }

    public double getItprnotax() {
        return itprnotax;
    }

    public double getTotprnotax() {
        return totprnotax;
    }

    public double getItprice() {
        return itprice;
    }

    public double getTotprice() {
        return totprice;
    }

    public double getTaxrate() {
        return taxrate;
    }

    public double getTaxsum() {
        return taxsum;
    }

    public int getOpcode() {
        return opcode;
    }

    public String getProducer() {
        return producer;
    }

    public double getUserop() {
        return userop;
    }

    public String getLocfrom() {
        return locfrom;
    }

    public String getReciver() {
        return reciver;
    }
}
