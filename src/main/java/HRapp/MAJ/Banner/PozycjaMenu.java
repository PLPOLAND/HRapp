package HRapp.MAJ.Banner;

/**
 * Klasa odpowiadająca z stworzenie , przetrzymywanie pozycji Menu
 * @author Marek Pałdyna
 */
public class PozycjaMenu {
    /**Napis na pozycji menu */
    String opis;
    /**Adres docelowy pozycji menu (Adres strony)*/
    String adres;
    /**Czy pozycja menu z dodatkowym wysuwanym menu */
    boolean czy_drop_down;
    /**Wysuwane menu */
    DropDownMenu dropDownMenu;
    
    public PozycjaMenu(String opis, String adres){
        this.opis = opis;
        this.adres = adres;
        this.czy_drop_down = false;
    }
    public PozycjaMenu(String opis, String adres, boolean czy_drop_down) {
        this.opis = opis;
        this.adres = adres;
        this.czy_drop_down = true;
        this.dropDownMenu = new DropDownMenu();        
    }
    public void addDropDownPos(String opis, String adres){
        this.dropDownMenu.Add(opis, adres);
    }
    public String print() {
        String pozycja;
        if (czy_drop_down == true) {
            pozycja = "<li><a href=\"" + adres + "\"> " + opis + " </a>";
            pozycja += dropDownMenu.printMenu();
            pozycja+="</li>";
        }
        else{
            pozycja = "<li><a href=\"" + adres + "\"> " + opis + " </a></li>";
        }
        return pozycja;
    }

}