package HRapp.MAJ.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import HRapp.MAJ.Banner.Banner;
import HRapp.MAJ.DAO.UsersDAO;
import HRapp.MAJ.Model.User;
import HRapp.MAJ.Security.Security;


@Controller
public class MainController {

	/**
	 * Obiekt do łączenia z bazą danych i pobierania z niej danych o userach 
	 */
	@Autowired
	UsersDAO userdao;

	/**
	 * Strona logowania
	 */
	@RequestMapping("/")
	public String loadLoginPage() {
		return "loginPage";
	}
	/**
	 * obsługa logowania urzytkownika
	 */
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		Security security = new Security(request, userdao);

		if (security.login()) {
			return "redirect:/tmp";
		} else {
			return "redirect:/bad_login";
		}
	}
	/**
	 * 
	 * Templatka. Jako podastawa. Kopiujemy to, zmieniamy adres strony (w "" po requestmapping), nazwę funkcji i odpowiedni return.
	 * 
	 */
	@RequestMapping("/tmp")
	public String showTemplate(Model model,HttpServletRequest request){
		Security security = new Security(request, userdao);
		if(security.isLoged()){
			Banner banner = new Banner();
			model.addAttribute(banner);
			return "template";
		}
		else{
			return "redirect:/";
		}
		
	}
	/**
	 * 
	 * Służy do testowania 
	 */
	@RequestMapping("/test")
	public String test(){
		List<User> ls = userdao.getUserLoginData("PLPOLAND", "Makowiec1");
		for (User user : ls) {
			System.out.println(user.toString());
		}
		return "";
	}

}