package produse;

public class Produs {
    String nume;
    String producator;
    float pretVanzare;
    String continut;

    public Produs(String nume, String producator, float pretVanzare, String continut) {
        this.nume = nume;
        this.producator = producator;
        this.pretVanzare = pretVanzare;
        this.continut = continut;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getProducator() {
        return producator;
    }

    public void setProducator(String producator) {
        this.producator = producator;
    }

    public float getPretVanzare() {
        return pretVanzare;
    }

    public void setPretVanzare(float pretVanzare) {
        this.pretVanzare = pretVanzare;
    }

    public String getContinut() {
        return continut;
    }

    public void setContinut(String continut) {
        this.continut = continut;
    }
}
