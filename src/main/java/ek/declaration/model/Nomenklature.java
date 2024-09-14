package ek.declaration.model;

public class Nomenklature implements Table{

    String artcent;
    String name;
    double vat;
    String measabbr;
    String pht3;
    String  cod_prod;
    String producer;

    @Override
    public String toString() {
        return "Nomenklature{" +
                "artcent='" + artcent + '\'' +
                ", name='" + name + '\'' +
                ", vat=" + vat +
                ", measabbr='" + measabbr + '\'' +
                ", pht3='" + pht3 + '\'' +
                ", cod_prod='" + cod_prod + '\'' +
                ", producer='" + producer + '\'' +
                '}';
    }

    public String getArtcent() {
        return artcent;
    }

    public String getName() {
        return name;
    }

    public double getVat() {
        return vat;
    }

    public String getMeasabbr() {
        return measabbr;
    }

    public String getPht3() {
        return pht3;
    }

    public String getCod_prod() {
        return cod_prod;
    }

    public String getProducer() {
        return producer;
    }
}
