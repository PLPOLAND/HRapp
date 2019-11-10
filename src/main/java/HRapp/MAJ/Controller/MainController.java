package HRapp.MAJ.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import HRapp.Gravatar.Gravatar;
import HRapp.MAJ.Banner.Banner;
import HRapp.MAJ.Banner.Menu;
import HRapp.MAJ.DAO.UsersDAO;
import HRapp.MAJ.Model.User;
import HRapp.MAJ.DAO.StanowiskaDAO;
import HRapp.MAJ.Model.Stanowiska;
import HRapp.MAJ.DAO.TypyUmowyDAO;
import HRapp.MAJ.DAO.UprawnieniaDAO;
import HRapp.MAJ.Model.TypyUmowy;
import HRapp.MAJ.Security.Security;


@Controller
public class MainController {

	/**
	 * Obiekt do łączenia z bazą danych i pobierania z niej danych o userach 
	 */
	@Autowired
	UsersDAO userdao;
	@Autowired
	StanowiskaDAO stanowiskadao;
	@Autowired
	TypyUmowyDAO typyumowydao;
	@Autowired 
	UprawnieniaDAO uprawnieniadao;


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
		
		Banner banner = new Banner(menu, security.getFullUserData());
		model.addAttribute("userList", userList);
		model.addAttribute(banner);	


		return "Amainpage";
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
		Banner banner = new Banner(menu, security.getFullUserData());
		model.addAttribute("user1", user1);
		model.addAttribute(banner);	


		return "AuserProfilPage";
	}

	/**
	 * 
	 * edycja pracownika
	 */
	@RequestMapping("/edit_user_page")
	public String edit_user_page(@RequestParam("id") int id,Model model,HttpServletRequest request){	

		Security security = new Security(request, userdao);
		if(!security.isLoged())
		return "redirect:/";
		if(!security.isUserAdmin())
		return "errorpage";

		Menu menu = new Menu();
		User user1 = userdao.find_user_by_id(id);
		List<Stanowiska> st= stanowiskadao.getAllStanowiska();
		List<TypyUmowy> um = typyumowydao.getAllTypyUmowy();

		Banner banner = new Banner(menu, security.getFullUserData());
		model.addAttribute("user1", user1);
		model.addAttribute("stanowiska", st);
		model.addAttribute("typyUmowy", um);
		model.addAttribute(banner);	


		return "AeditUserPage";
	}

	@RequestMapping("/edit_user")
	public String editUser(HttpServletRequest request, HttpServletResponse response) {
		Security security = new Security(request, userdao);
		if(!security.isLoged())
		return "redirect:/";
		if(!security.isUserAdmin())
		return "errorpage";

		int id = Integer.parseInt(request.getParameter("x1"));
		String imie = request.getParameter("Imie");
		String nazwisko = request.getParameter("nazwisko");
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
		String nrkonta = request.getParameter("nrkonta");
		int typumowy = Integer.parseInt(request.getParameter("umowy"));
		int stanowisko=Integer.parseInt(request.getParameter("stanowiska"));
		float wyplatabrutto=Float.parseFloat(request.getParameter("wyplatabruttto"));
		
		userdao.editUser(id, imie, nazwisko, nickname, email, nrkonta, typumowy, stanowisko, wyplatabrutto);

		return "redirect:/user_profile_page?id=" + id;
	
	}

	@RequestMapping("/add_user_page")
	public String loadAddUserPage(HttpServletRequest request, Model model) {
		Security security = new Security(request, userdao);
		if(!security.isLoged())
		return "redirect:/";
		if(!security.isUserAdmin())
		return "errorpage";

		Menu menu = new Menu();
		List<Stanowiska> st= stanowiskadao.getAllStanowiska();
		List<TypyUmowy> um = typyumowydao.getAllTypyUmowy();
		
		Banner banner = new Banner(menu, security.getFullUserData());
		model.addAttribute("stanowiska", st);
		model.addAttribute("typyUmowy", um);
		model.addAttribute(banner);	

		

		return "AddUserPage";		
		
	}

	@RequestMapping("/add_user")
	public String addUser(HttpServletRequest request) {
		Security security = new Security(request, userdao);
		if(!security.isLoged())
		return "redirect:/";
		if(!security.isUserAdmin())
		return "errorpage";

		String imie = request.getParameter("Imie");
		String nazwisko = request.getParameter("nazwisko");
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
		String nrkonta = request.getParameter("nrkonta");
		int typumowy = Integer.parseInt(request.getParameter("typumowy"));
		int stanowisko=Integer.parseInt(request.getParameter("stanowiska"));
		double wyplatabrutto = Double.parseDouble(request.getParameter("wyplatabrutto"));
		String haslo = request.getParameter("haslo");
		String upr = request.getParameter("uprawnienia");
		int uprawnienia;
		if(upr == null) uprawnienia =0;
		else uprawnienia = 1;

		int id = userdao.addUser(imie, nazwisko, nickname, email, nrkonta, typumowy, stanowisko, wyplatabrutto, haslo);
		uprawnieniadao.addPermission(id, uprawnienia);

		return "redirect:/adminhome";

	}
	/**
	 * 
	 * wylogowywanie
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		Security sec = new Security(request, userdao);
		sec.logout();
		return "redirect:/";
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
			Banner banner = new Banner(menu, security.getFullUserData());
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
	public String test(Model model, HttpServletRequest request){

		Menu menu = new Menu();

		Security security = new Security(request, userdao);
		Banner banner = new Banner(menu, security.getFullUserData());
		model.addAttribute(banner);
		
		List<User> ls = userdao.getUserLoginData("PLPOLAND", "Makowiec1");
		for (User user : ls) {
			System.out.println(user.toString());
		}
		return "errorpage";
	}
	
	/**
	 * 
	 * Służy do testowania 3 
	 */
	@RequestMapping("/menu")
	public String test3(Model model, HttpServletRequest request){
		
		Security security = new Security(request, userdao);
		if(!security.isLoged())
			return "redirect:/";
		
		Menu menu = new Menu();
		Banner banner = new Banner(menu, security.getFullUserData());
		
		
		String gravatarUrl = Gravatar.getUrl("marekpaldyna@wp.pl");
		System.out.println(gravatarUrl);
		model.addAttribute("grav",gravatarUrl);
		model.addAttribute(banner);
		
		return "test";
	}

	/**
	 * 
	 * julek cos testuje 
	 * 
	 */
	@RequestMapping("/xxx")
	public String Stonoga(){
		return "AuserAccStatement";
	}

}
