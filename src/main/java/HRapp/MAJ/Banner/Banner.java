package HRapp.MAJ.Banner;

import HRapp.Gravatar.Gravatar;
import HRapp.MAJ.Banner.Menu;
import HRapp.MAJ.Model.User;

/**
 * Banner
 * Klasa służąca do Odpowiedniego wyświetlania banneru
 */
public class Banner {

    Menu menu;
    User userdata;
    public Banner(Menu menu, User userlogosrc){
        this.menu = menu;
        this.userdata = userlogosrc;
    }
    
    public String printDataSpace(){
        // return "<div id=\"BannerDataSpace\"> \n <div class=\"left\"><a href=\"/\"><img class=\"pagelogo\" src=\"/img/icon.png\"></a></div> <div class=\"right\"><div class=\"userdata\">" + userdata.getImie() + " " + userdata.getNazwisko() + "<img class=\"userlogo\" src=\""+Gravatar.getUrl(userdata.getEmail())+"\"></div></div>\n </div>";
        return "<div id=\"BannerDataSpace\">"+
                    "<div class=\"left\">"+
                        "<a href=\"/\">"+
                            "<img class=\"pagelogo\" src=\"/img/icon.png\">"+
                        "</a>"+
                    "</div>"+
                    "<div class=\"right\">"+
                        "<div class=\"userdata\">" +
                            "<div class=\"userlogo\">"+
                                "<img class=\"userlogoimg\" src=\"" + Gravatar.getUrl(userdata.getEmail()) + "\">"+
                                "<div class=\"cover\">"+
                                    "<i class=\"icon-conf\"></i>"+
                                "</div>"+
                            "</div>"+
                            "<div class=\"banner-icons-etc\">"+
                                "<span>" + userdata.getImie() + " " + userdata.getNazwisko() + "</span>"+
                                "<i class=\"icon icon-conf\" onclick=\"location.href='/edit_user_page?id="+userdata.getID()+"'\"></i>"+
                                "<i class=\"icon logout icon-logout\" onclick=\"location.href='/logout'\"></i>"+
                            "</div>"+
                        "</div>"+
                    "</div>" +
                "</div>";
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