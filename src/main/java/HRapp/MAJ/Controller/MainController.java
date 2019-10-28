package HRapp.MAJ.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import HRapp.MAJ.Banner.Banner;
import HRapp.MAJ.Banner.Menu;
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
			if(security.isUserAdmin()) {
				return "redirect:/adminhome";
			}
			return "redirect:/tmp"; // zmienić na przekierowanie do uhome jak będzie
		} else {
			return "redirect:/bad_login";
		}
	}
	
	@RequestMapping("/bad_login")
	public String bad_login() {
		return "errorpage";
		//	return "badLoginPage"; // zmienić na badLoginPage
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
			Menu menu = new Menu();
			menu.Add("logowanie", "/");
			menu.Add("strona admina", "/adminhome");
			menu.Add("test", "/test");
			menu.Add("templatka", "/tmp");
			Banner banner = new Banner(menu);
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
	public String test(Model model){

		Menu menu = new Menu();
		menu.Add("logowanie", "/");
		menu.Add("strona admina", "/adminhome");
		menu.Add("test", "/test");
		menu.Add("templatka", "/tmp");
		Banner banner = new Banner(menu);
		model.addAttribute(banner);

		List<User> ls = userdao.getUserLoginData("PLPOLAND", "Makowiec1");
		for (User user : ls) {
			System.out.println(user.toString());
		}
		return "errorpage";
	}
	/**
	 * 
	 *strona admina (lista pracownikow)
	 */
	@RequestMapping("/adminhome")
	public String adminhome(Model model,HttpServletRequest request){	

		Security security = new Security(request, userdao);
		if(!security.isLoged())
		return "redirect:/";
		if(!security.isUserAdmin())
		return "errorpage"; 

		Menu menu = new Menu();
		List<User> userList = userdao.getAllUsers();
		menu.Add("logowanie", "/");
		menu.Add("strona admina", "/adminhome");
		menu.Add("test", "/test");
		menu.Add("templatka", "/tmp");
		Banner banner = new Banner(menu);
		model.addAttribute("userList", userList);
		model.addAttribute(banner);	


		return "Amainpage";
	}
	/**
	 * 
	 * Służy do testowania 3 
	 */
	@RequestMapping("/menu")
	public String test3(Model model){
		
		Menu menu = new Menu();
		menu.Add("logowanie", "/");
		menu.Add("strona admina", "/adminhome");
		menu.Add("test","/test");
		menu.Add("templatka","/tmp");
		Banner banner = new Banner(menu);
		model.addAttribute(banner);

		return "test";
	}

/**
	 * 
	 * szczegolowy widok pracownika
	 */
	@RequestMapping("/user_profile_page")
	public String user_profile_page(@RequestParam("id") int id,Model model,HttpServletRequest request){	

		Security security = new Security(request, userdao);
		if(!security.isLoged())
		return "redirect:/";
		if(!security.isUserAdmin())
		return "errorpage";

		Menu menu = new Menu();
		User user1 = userdao.find_user_by_id(id);
		menu.Add("logowanie", "/");
		menu.Add("strona admina", "/adminhome");
		menu.Add("test", "/test");
		menu.Add("templatka", "/tmp");
		Banner banner = new Banner(menu);
		model.addAttribute("user", user1);
		model.addAttribute(banner);	


		return "UserProfilePage";
	}

}
