package Lab6;

import java.time.LocalDate;

class Angajat {
    private String nume;
    private String postare;
    private LocalDate dataAngajarii;
    private float salariu;

    public Angajat() {
    }

    public Angajat(String nume, String postare, LocalDate data, float salariu) {
        this.nume = nume;
        this.postare = postare;
        this.dataAngajarii = data;
        this.salariu = salariu;
    }

    public String toString() {
        String var10000 = this.nume;
        return var10000 + "," + this.postare + "," + String.valueOf(this.dataAngajarii) + "," + this.salariu;
    }

    public String getNume() {
        return this.nume;
    }

    public void setNume() {
        this.nume = this.nume;
    }

    public String getPostare() {
        return this.postare;
    }

    public void setPostare() {
        this.postare = this.postare;
    }

    public float getSalariu() {
        return this.salariu;
    }

    public LocalDate getDataAngajarii() {
        return this.dataAngajarii;
    }

    public void setSalariu() {
        this.salariu = this.salariu;
    }

    public void setDataAngajarii() {
        this.dataAngajarii = this.dataAngajarii;
    }
}
