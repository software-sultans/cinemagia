package angajati;

import java.time.LocalDate;
import java.time.LocalTime;

public class Angajat {
    String nume;
    String password;
    LocalDate dataAngajare; //Represents a date (year, month, day (yyyy-MM-dd))

    public Angajat(String nume, String password, LocalDate dataAngajare) {
        this.nume = nume;
        this.password = password;
        this.dataAngajare = dataAngajare;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDataAngajare() {
        return dataAngajare;
    }

    public void setDataAngajare(LocalDate dataAngajare) {
        this.dataAngajare = dataAngajare;
    }
}
