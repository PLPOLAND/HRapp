package HRapp.MAJ.Banner;

import HRapp.MAJ.Banner.Menu;

/**
 * Banner
 * Klasa służąca do Odpowiedniego wyświetlania banneru
 */
public class Banner {

    Menu menu;
    String srcimg;
    public Banner(Menu menu, String userlogosrc){
        this.menu = menu;
        this.srcimg = userlogosrc;
    }
    
    public String printDataSpace(){
        System.out.println(srcimg);
        return "<div id=\"BannerDataSpace\"> \n <div class=\"left\"><a href=\"/\"><img class=\"pagelogo\" src=\"/img/icon.png\"></a></div> <div class=\"right\"><div class=\"userdata\">Marek Pałdyna <img class=\"userlogo\" src=\""+srcimg+"\"></div></div>\n </div>";
    }

    /**
     * Printuje Banner.
     * 
     * @return String
     */
    public String printBanner(){
                
        return this.printDataSpace() + menu.printMenu();
    };
    
}