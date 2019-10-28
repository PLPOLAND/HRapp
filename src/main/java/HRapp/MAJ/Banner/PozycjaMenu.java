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
    
    public PozycjaMenu(String opis, String adres){
        this.opis = opis;
        this.adres = adres;
    }

    public String print() {
        String pozycja = "<a href=\""+adres+"\"> <li>"+opis+"</li> </a>";
        return pozycja;
    }

}