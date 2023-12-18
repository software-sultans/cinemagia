package filme;

import java.time.LocalDate;

public class Film {
    String nume;
    int durata;
    String descriere;
    LocalDate dataLansare;
    float pret;
    String regizor;
    String gen;
    String parentalGuidance;
    String salaRulare;
    byte[] poster;


    public Film(String nume, int durata, String descriere, LocalDate dataLansare, float pret, String regizor, String gen, String parentalGuidance, String salaRulare, byte[] poster) {
        this.nume = nume;
        this.durata = durata;
        this.descriere = descriere;
        this.dataLansare = dataLansare;
        this.pret = pret;
        this.regizor = regizor;
        this.gen = gen;
        this.parentalGuidance = parentalGuidance;
        this.salaRulare = salaRulare;
        this.poster = poster;
    }

    public Film()
    {}

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public LocalDate getDataLansare() {
        return dataLansare;
    }

    public void setDataLansare(LocalDate dataLansare) {
        this.dataLansare = dataLansare;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public String getRegizor() {
        return regizor;
    }

    public void setRegizor(String regizor) {
        this.regizor = regizor;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public String getParentalGuidance() {
        return parentalGuidance;
    }

    public void setParentalGuidance(String parentalGuidance) {
        this.parentalGuidance = parentalGuidance;
    }

    public String getSalaRulare() {
        return salaRulare;
    }

    public void setSalaRulare(String salaRulare) {
        this.salaRulare = salaRulare;
    }

    public void setPoster(byte[] poster) {
        this.poster = poster;
    }
    public byte[] getPoster() {
        return poster;
    }
}
