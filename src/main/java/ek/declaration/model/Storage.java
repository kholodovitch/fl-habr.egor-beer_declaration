package ek.declaration.model;

public class Storage implements Table {
    String loc;
    String locinfo;
    String grouping;
    String inn;
    String kpp;
    int state;
    String addr;

    @Override
    public String toString() {
        return "Storage{" +
                "loc='" + loc + '\'' +
                ", locinfo='" + locinfo + '\'' +
                ", grouping='" + grouping + '\'' +
                ", inn='" + inn + '\'' +
                ", kpp='" + kpp + '\'' +
                ", state=" + state +
                ", addr='" + addr + '\'' +
                '}';
    }

    public String getLoc() {
        return loc;
    }

    public String getLocinfo() {
        return locinfo;
    }

    public String getGrouping() {
        return grouping;
    }

    public String getInn() {
        return inn;
    }

    public String getKpp() {
        return kpp;
    }

    public int getState() {
        return state;
    }

    public String getAddr() {
        return addr;
    }
}
