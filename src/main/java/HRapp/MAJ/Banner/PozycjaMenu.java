package HRapp.MAJ.Banner;

/**
 * Klasa odpowiadająca z stworzenie , przetrzymywanie pozycji Menu
 * 
 * @author Marek Pałdyna
 */
public class PozycjaMenu {
    /** Napis na pozycji menu */
    String opis;
    /** Adres docelowy pozycji menu (Adres strony) */
    String adres;
    /** Czy pozycja menu z dodatkowym wysuwanym menu */
    boolean czy_drop_down;
    /** Wysuwane menu */
    DropDownMenu dropDownMenu;

    /**
     * Kostruktor Tworzy Pozycję w menu
     * 
     * @param opis  - tekst pozycji menu
     * @param adres - adres linku
     */
    public PozycjaMenu(String opis, String adres) {
        this.opis = opis;
        this.adres = adres;
        this.czy_drop_down = false;
    }

    /**
     * Kostruktor Tworzy Pozycję w menu
     * 
     * @param opis          - tekst pozycji menu
     * @param adres         - adres linku
     * @param czy_drop_down - czy pozycja z rozwijanym menu
     */
    public PozycjaMenu(String opis, String adres, boolean czy_drop_down) {
        this.opis = opis;
        this.adres = adres;
        this.czy_drop_down = true;
        this.dropDownMenu = new DropDownMenu();
    }

    /**
     * Dodawnanie pozycji w menu rozwijanym
     * 
     * @param opis  - tekst pozycji menu
     * @param adres - adres linku
     */
    public void addDropDownPos(String opis, String adres) {
        if (czy_drop_down) {
            this.dropDownMenu.Add(opis, adres);
        } else {
            System.out.println("Pozycja menu: \"" + this.opis
                    + "\" nie ma zdefiniowanego menu rozwijanego. Dodaj odpowiedni argument w konstruktorze");
        }

    }

    /**
     * Zwraca kod HTML z pozycją menu / pozycją menu i rozwijanym menu
     * 
     * @return String - kod HTML z pozycją menu / pozycją menu i rozwijanym menu
     */
    public String print() {
        String pozycja;
        if (czy_drop_down == true) {
            pozycja = "<li><a href=\"" + adres + "\"> " + opis + " </a>";
            pozycja += dropDownMenu.printMenu();
            pozycja += "</li>";
        } else {
            pozycja = "<li><a href=\"" + adres + "\"> " + opis + " </a></li>";
        }
        return pozycja;
    }

}