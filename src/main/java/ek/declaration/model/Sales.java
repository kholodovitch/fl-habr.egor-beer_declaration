package ek.declaration.model;

public class Sales implements Table{

    String loc;
    String article;
    double kolvo;
    double totprice;
    double taxsum;
    double taxrate;
    String sdate;
    String cdate;

    @Override
    public String toString() {
        return "Sales{" +
                "loc='" + loc + '\'' +
                ", article='" + article + '\'' +
                ", kolvo=" + kolvo +
                ", totprice=" + totprice +
                ", taxsum=" + taxsum +
                ", taxrate=" + taxrate +
                ", sdate='" + sdate + '\'' +
                ", cdate='" + cdate + '\'' +
                '}';
    }

    public String getLoc() {
        return loc;
    }

    public String getArticle() {
        return article;
    }

    public double getKolvo() {
        return kolvo;
    }

    public double getTotprice() {
        return totprice;
    }

    public double getTaxsum() {
        return taxsum;
    }

    public double getTaxrate() {
        return taxrate;
    }

    public String getSdate() {
        return sdate;
    }

    public String getCdate() {
        return cdate;
    }
}
