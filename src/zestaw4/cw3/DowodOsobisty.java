package zestaw4.cw3;

class DowodOsobisty extends Dokument
{
    Osoba wlasciciel;

    DowodOsobisty(Osoba wlasciciel) {
        super();
        this.wlasciciel = wlasciciel;
    }

    public boolean czyPasuje(String wzorzec) {
        if (this.wlasciciel.nazwisko.toUpperCase().equals(wzorzec.toUpperCase())) {
            return true;
        }
        else {
            return false;
        }
    }

    public String toString() {
        return this.wlasciciel.imie+" "+this.wlasciciel.nazwisko;
    }
}
