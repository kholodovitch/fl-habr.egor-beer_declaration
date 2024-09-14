package ek.declaration.model;

public class Ostatki implements Table{

    String loc;
    String article;
    double lastpricen;
    double ostnach;
    double ostkonec;
    String sdate;
    String cdate;

    @Override
    public String toString() {
        return "Ostatki{" +
                "loc='" + loc + '\'' +
                ", article='" + article + '\'' +
                ", lastpricen=" + lastpricen +
                ", ostnach=" + ostnach +
                ", ostkonec=" + ostkonec +
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

    public double getLastpricen() {
        return lastpricen;
    }

    public double getOstnach() {
        return ostnach;
    }

    public double getOstkonec() {
        return ostkonec;
    }

    public String getSdate() {
        return sdate;
    }

    public String getCdate() {
        return cdate;
    }
}
