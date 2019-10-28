package HRapp.MAJ.Banner;

import HRapp.MAJ.Banner.Menu;

/**
 * Banner
 * Klasa służąca do Odpowiedniego wyświetlania banneru
 */
public class Banner {

    Menu menu;

    public Banner(Menu menu){
        this.menu = menu;
    }
    
    /**
     * Printuje Banner.
     * 
     * @return String
     */
    public String printBanner(){
        
        return menu.printMenu();
    };
    
}