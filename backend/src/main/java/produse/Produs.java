package produse;

import java.time.LocalDate;

public class Produs {
    String nume;
    String producator;
    float pretVanzare;
    String continut;
    String tipProdus; // Adăugare tip produs
    LocalDate dataExpirare; // Adăugare data de expirare

    int cantitateDisponibila;

    public Produs(String nume, String producator, float pretVanzare, String continut, String tipProdus, LocalDate dataExpirare, int cantitateDisponibila) {
        this.nume = nume;
        this.producator = producator;
        this.pretVanzare = pretVanzare;
        this.continut = continut;
        this.tipProdus = tipProdus;
        this.dataExpirare = dataExpirare;
        this.cantitateDisponibila = cantitateDisponibila;
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

    public String getTipProdus() {
        return tipProdus;
    }

    public void setTipProdus(String tipProdus) {
        this.tipProdus = tipProdus;
    }

    public LocalDate getDataExpirare() {
        return dataExpirare;
    }

    public void setDataExpirare(LocalDate dataExpirare) {
        this.dataExpirare = dataExpirare;
    }

    public int getCantitateDisponibila() {
        return cantitateDisponibila;
    }

    public void setCantitateDisponibila(int cantitateDisponibila) {
        this.cantitateDisponibila = cantitateDisponibila;
    }
}