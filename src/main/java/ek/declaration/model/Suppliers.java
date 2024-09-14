package ek.declaration.model;

public class Suppliers implements Table{

    String id;
    String inn;
    String kpp;
    String namep;

    @Override
    public String toString() {
        return "Suppliers{" +
                "id='" + id + '\'' +
                ", inn='" + inn + '\'' +
                ", kpp='" + kpp + '\'' +
                ", namep='" + namep + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getInn() {
        return inn;
    }

    public String getKpp() {
        return kpp;
    }

    public String getNamep() {
        return namep;
    }
}
