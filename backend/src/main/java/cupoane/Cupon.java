package cupoane;

import produse.Produs;

public class Cupon {
    String nume;
    float valoare;
    Produs produs;

    public Cupon(String nume, float valoare, Produs produs) {
        this.nume = nume;
        this.valoare = valoare;
        this.produs = produs;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public float getValoare() {
        return valoare;
    }

    public void setValoare(float valoare) {
        this.valoare = valoare;
    }

    public Produs getProdus() {
        return produs;
    }

    public void setProdus(Produs produs) {
        this.produs = produs;
    }
}
