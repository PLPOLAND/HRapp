package HRapp.MAJ.Banner;

import HRapp.MAJ.Banner.Menu;

/**
 * Banner
 * Klasa służąca do Odpowiedniego wyświetlania banneru
 */
public class Banner {

    /**
     * Printuje Banner.
     * @return String
     */
    public String printBanner(){
        Menu menu = new Menu();
        return menu.printMenu();
    };
    
}