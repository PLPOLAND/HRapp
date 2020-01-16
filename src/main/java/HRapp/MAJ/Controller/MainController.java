package HRapp.MAJ.Controller;

import java.util.List;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import HRapp.Gravatar.Gravatar;
import HRapp.MAJ.Banner.Banner;
import HRapp.MAJ.Banner.Menu;
import HRapp.MAJ.DAO.UsersDAO;
import HRapp.MAJ.DAO.StanowiskaDAO;
import HRapp.MAJ.DAO.TypyUmowyDAO;
import HRapp.MAJ.DAO.UprawnieniaDAO;
import HRapp.MAJ.DAO.WyplatyDAO;
import HRapp.MAJ.Model.User;
import HRapp.MAJ.Model.Stanowiska;
import HRapp.MAJ.Model.TypyUmowy;
import HRapp.MAJ.Model.Uprawnienia;
import HRapp.MAJ.Model.Wyplaty;
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
	@Autowired
	WyplatyDAO wyplatydao;


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

		if(!security.isLoged())
			return "redirect:/";	
		if(security.isUserAdmin()) {
			return "redirect:/adminhome";
		}
		HttpSession session = request.getSession();
		int id = (Integer) session.getAttribute("id");

		return "redirect:/user_profile_page?id=" + id; // zmienić ewentualnie na coś innego

	}
	

	/**
	 * 
	 *strona admina (lista pracownikow z dostępem do wszystkiego)
	 */
	@RequestMapping("/adminhome")
	public String adminhome(Model model,HttpServletRequest request){	

		Security security = new Security(request, userdao);
		if(!security.isLoged())
			return "redirect:/";
		if (!(security.getUserPremissions().isAdmin())){
			return "errorpage";//TODO strona error dla braku uprawnien
			// int id = (Integer)request.getSession().getAttribute("id"); //usunąć jak będzie działać logowanie dla nie-userów
			// return "redirect:/user_profile_page?id=" + id; //usunąć jak będzie działać logowanie dla nie-userów
		}
		Menu menu = new Menu(security.getUserPremissions(), request.getSession());
		List<User> userList = userdao.getAllUsers();
		
		Banner banner = new Banner(menu, security.getFullUserData());
		model.addAttribute("userList", userList);
		model.addAttribute(banner);	

		return "Amainpage";
	}

	/**
	 * 
	 * lista użytkowników (dostępna dla wszystkich)
	 */
	@RequestMapping("/users_list")
	public String users_list(Model model, HttpServletRequest request){	

		Security security = new Security(request, userdao);
		if(!security.isLoged())
			return "redirect:/";

		Menu menu = new Menu(security.getUserPremissions(), request.getSession());
		List<User> userList = userdao.getAllUsers();
		
		Banner banner = new Banner(menu, security.getFullUserData());
		model.addAttribute("userList", userList);
		model.addAttribute(banner);	

		return "UsersList";
	}
	
	/**
	 * 
	 * lista użytkowników z dostępem do szczegółowych danych (tylko dla uprawnionych)
	 */
	@RequestMapping("/details_users_list")
	public String details_users_list(Model model, HttpServletRequest request){	

		Security security = new Security(request, userdao);
		if(!security.isLoged())
			return "redirect:/";
		if (!(security.getUserPremissions().isShow_d_data() || security.getUserPremissions().isAdmin()))
			return "errorpage";//TODO strona error dla braku uprawnien

		Menu menu = new Menu(security.getUserPremissions(), request.getSession());
		List<User> userList = userdao.getAllUsers();
		
		Banner banner = new Banner(menu, security.getFullUserData());
		model.addAttribute("userList", userList);
		model.addAttribute(banner);	

		return "DetailsUsersList";
	}

	/**
	 * 
	 * lista użytkowników z dostępem do ich edytowania (tylko dla uprawnionych)
	 */
	@RequestMapping("/edit_users_list")
	public String edit_users_list(Model model, HttpServletRequest request){	

		Security security = new Security(request, userdao);
		if(!security.isLoged())
			return "redirect:/";
		if (!(security.getUserPremissions().isEdit_user() || security.getUserPremissions().isAdmin()))
			return "errorpage";//TODO strona error dla braku uprawnien

		Menu menu = new Menu(security.getUserPremissions(), request.getSession());
		List<User> userList = userdao.getAllUsers();
		
		Banner banner = new Banner(menu, security.getFullUserData());
		model.addAttribute("userList", userList);
		model.addAttribute(banner);	

		return "EditUsersList";
	}

	/**
	 * 
	 * lista użytkowników z dostępem do ich usuwania (tylko dla uprawnionych)
	 */
	@RequestMapping("/delete_users_list")
	public String delete_users_list(Model model, HttpServletRequest request){	

		Security security = new Security(request, userdao);
		if(!security.isLoged())
			return "redirect:/";
		if (!(security.getUserPremissions().isDel_user() || security.getUserPremissions().isAdmin()))
			return "errorpage";//TODO strona error dla braku uprawnien

		Menu menu = new Menu(security.getUserPremissions(), request.getSession());
		List<User> userList = userdao.getAllUsers();
		
		Banner banner = new Banner(menu, security.getFullUserData());
		model.addAttribute("userList", userList);
		model.addAttribute(banner);	

		return "DeleteUsersList";
	}
	
	/**
	 * 
	 * lista użytkowników z dostępem do informacji o ich finansach (tylko dla uprawnionych)
	 */
	@RequestMapping("/payment_data_users_list")
	public String payment_data_users_list(Model model, HttpServletRequest request){	

		Security security = new Security(request, userdao);
		if(!security.isLoged())
			return "redirect:/";
		if (!(security.getUserPremissions().isFinance_management() || security.getUserPremissions().isAdmin())) 
			return "errorpage";//TODO strona error dla braku uprawnien

		Menu menu = new Menu(security.getUserPremissions(), request.getSession());
		List<User> userList = userdao.getAllUsers();
		
		Banner banner = new Banner(menu, security.getFullUserData());
		model.addAttribute("userList", userList);
		model.addAttribute(banner);	

		return "PaymentDataUsersList";
	}

	/**
	 * 
	 * lista użytkowników z dostępem do dodania im wypłaty (tylko dla uprawnionych)
	 */
	@RequestMapping("/add_payment_users_list")
	public String add_payment_users_list(Model model, HttpServletRequest request){	

		Security security = new Security(request, userdao);
		if(!security.isLoged())
			return "redirect:/";
		if (!(security.getUserPremissions().isFinance_management() || security.getUserPremissions().isAdmin()))
			return "errorpage";//TODO strona error dla braku uprawnien

		Menu menu = new Menu(security.getUserPremissions(), request.getSession());
		List<User> userList = userdao.getAllUsers();
		
		Banner banner = new Banner(menu, security.getFullUserData());
		model.addAttribute("userList", userList);
		model.addAttribute(banner);	

		return "AddPaymentUsersList";
	}

	/**
	 * 
	 * szczegolowy widok pracownika (dostęny dla uprawnionych oraz dla każdego, jeśli chodzi o jego własny profil)
	 */
	@RequestMapping("/user_profile_page")
	public String user_profile_page(@RequestParam("id") int id, Model model, HttpServletRequest request){	

		Security security = new Security(request, userdao);
		if(!security.isLoged())
			return "redirect:/";
		//HttpSession session = ;
        if ((Integer) request.getSession().getAttribute("id") != id  && !(security.getUserPremissions().isShow_d_data() || security.getUserPremissions().isAdmin()))
        	return "errorpage";

		Menu menu = new Menu(security.getUserPremissions(), request.getSession());
		User user1 = userdao.find_user_by_id(id);
		Banner banner = new Banner(menu, security.getFullUserData());
		model.addAttribute("user1", user1);
		model.addAttribute(banner);	

		if(security.getUserPremissions().isEdit_user() || security.getUserPremissions().isAdmin() || (Integer) request.getSession().getAttribute("id") == id)
		return "AuserProfilPage";
		return "AuserProfilPageNoEditButton";
	}

	/**
	 * 
	 * strona edycji pracownika (tylko dla uprawnionych)
	 * przekierowuje do ogranicznej edycji, jeśli chodzi o innych użytkowników, którzy chcą wyedytować własne dane
	 */
	@RequestMapping("/edit_user_page")
	public String edit_user_page(@RequestParam("id") int id, Model model, HttpServletRequest request){	

		Security security = new Security(request, userdao);
		if(!security.isLoged())
		return "redirect:/";
		HttpSession session = request.getSession();
		if (!(security.getUserPremissions().isEdit_user() || security.getUserPremissions().isAdmin()))
			if((Integer) session.getAttribute("id") == id)
			return "redirect:/edit_profile_page?id=" + id; 
			else return "errorpage";

		Menu menu = new Menu(security.getUserPremissions(), request.getSession());
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

	/**
	 * 
	 * strona edycji swojego profilu (dostępna dla wszystkich bez uprawnień edycji użytkowników)
	 */
	@RequestMapping("/edit_profile_page")
	public String edit_profile_page(@RequestParam("id") int id, Model model, HttpServletRequest request){	

		Security security = new Security(request, userdao);
		if(!security.isLoged())
		return "redirect:/";

		Menu menu = new Menu(security.getUserPremissions(), request.getSession());
		User user1 = userdao.find_user_by_id(id);

		Banner banner = new Banner(menu, security.getFullUserData());
		model.addAttribute("user1", user1);
		model.addAttribute(banner);	


		return "EditProfilPage";
	}

	/**
	 * 
	 * edycja pracownika dla uprawnionych (zapis do bazy danych)
	 */
	@RequestMapping("/edit_user")
	public String editUser(HttpServletRequest request, HttpServletResponse response) {
		Security security = new Security(request, userdao);
		if(!security.isLoged())
		return "redirect:/";
		if (!(security.getUserPremissions().isEdit_user() || security.getUserPremissions().isAdmin()))
			return "errorpage";// TODO strona error dla braku uprawnien

		int id = Integer.parseInt(request.getParameter("id"));
		String imie = request.getParameter("Imie");
		String nazwisko = request.getParameter("nazwisko");
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
		String nrkonta = request.getParameter("nrkonta");
		int typumowy = Integer.parseInt(request.getParameter("typumowy"));
		int stanowisko=Integer.parseInt(request.getParameter("stanowiska"));
		double wyplatabrutto = Double.parseDouble(request.getParameter("wyplatabrutto"));
		String pesel = request.getParameter("pesel");
		String dataurodzenia = request.getParameter("dataurodzenia");
		String nrtelefonu = request.getParameter("nrtelefonu");
		String ulica = request.getParameter("ulica");
		String nrdomu = request.getParameter("nrdomu");
		String nrm = request.getParameter("nrmieszkania");
		String miasto = request.getParameter("miasto");
		String kodpocztowy = request.getParameter("kodpocztowy");

		String adm = request.getParameter("admin");
		int admin, add_user, del_user, edit_user, finance_management, show_d_data;
		if(adm == null) {
		admin =0;	
		String add = request.getParameter("add_user");
		String del = request.getParameter("del_user");
		String edit = request.getParameter("edit_user");
		String fin_mag = request.getParameter("finance_management");
		String show_d = request.getParameter("show_d_data");
		add_user = add == null ? 0:1;
		del_user = del == null ? 0:1;
		edit_user = edit == null ? 0:1;
		finance_management = fin_mag == null ? 0:1;
		show_d_data = show_d == null ? 0:1;
		}
		else {
			admin = 1;
			add_user = del_user = edit_user = finance_management = show_d_data = 0;
		}
		
		
		

		int nrmieszkania;
		if(nrm.isEmpty()) nrmieszkania = 0;
		else nrmieszkania = Integer.parseInt(nrm);

		
		userdao.editUser(id, imie, nazwisko, nickname, email, nrkonta, typumowy, stanowisko, wyplatabrutto, pesel, dataurodzenia, nrtelefonu, ulica, nrdomu, nrmieszkania, miasto, kodpocztowy); //dodać nrmieszkania
		uprawnieniadao.editPermission(id, admin, add_user, del_user, edit_user, finance_management, show_d_data);
		if(id == security.getUserID()){
			Uprawnienia u = new Uprawnienia();
			u.setID(id);
			u.setAdmin(admin);
			u.setAdd_user(add_user >= 1);
			u.setDel_user(del_user >= 1);
			u.setEdit_user(edit_user >= 1);
			u.setFinance_management(finance_management>=1);
			u.setShow_d_data(show_d_data >= 1);
			security.updateUprawnienia(u);
		}
		if(security.getUserPremissions().isAdmin())
		return "redirect:/user_profile_page?id=" + id;
		if(security.getUserPremissions().isShow_d_data())
		return "redirect:/user_profile_page?id=" + id;
		return "redirect:/users_list";	
	}

	/**
	 * 
	 * edycja swojego konta dla nieuprawnionych do edycji (zapis do bazy danych)
	 */
	@RequestMapping("/edit_profile")
	public String editProfile(HttpServletRequest request, HttpServletResponse response) {
		Security security = new Security(request, userdao);
		if(!security.isLoged())
		return "redirect:/";
		int id = Integer.parseInt(request.getParameter("id"));
		if ((Integer) request.getSession().getAttribute("id") != id)
			return "errorpage";// TODO strona error dla braku uprawnien
		
		String imie = request.getParameter("Imie");
		String nazwisko = request.getParameter("nazwisko");
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
		String nrkonta = request.getParameter("nrkonta");
		String pesel = request.getParameter("pesel");
		String dataurodzenia = request.getParameter("dataurodzenia");
		String nrtelefonu = request.getParameter("nrtelefonu");
		String ulica = request.getParameter("ulica");
		String nrdomu = request.getParameter("nrdomu");
		String nrm = request.getParameter("nrmieszkania");
		String miasto = request.getParameter("miasto");
		String kodpocztowy = request.getParameter("kodpocztowy");
	

		int nrmieszkania;
		if(nrm.isEmpty()) nrmieszkania = 0;
		else nrmieszkania = Integer.parseInt(nrm);

		
		userdao.limitedEditUser(id, imie, nazwisko, nickname, email, nrkonta, pesel, dataurodzenia, nrtelefonu, ulica, nrdomu, nrmieszkania, miasto, kodpocztowy);

		return "redirect:/user_profile_page?id=" + id;

	}

	/**
	 * 
	 * strona dodawania pracownika (tylko dla uprawnionych)
	 */
	@RequestMapping("/add_user_page")
	public String loadAddUserPage(HttpServletRequest request, Model model) {
		Security security = new Security(request, userdao);
		if(!security.isLoged())
		return "redirect:/";
		if (!(security.getUserPremissions().isAdd_user() || security.getUserPremissions().isAdmin()))
			return "errorpage";// TODO strona error dla braku uprawnien

		Menu menu = new Menu(security.getUserPremissions(), request.getSession());
		List<Stanowiska> st= stanowiskadao.getAllStanowiska();
		List<TypyUmowy> um = typyumowydao.getAllTypyUmowy();
		
		Banner banner = new Banner(menu, security.getFullUserData());
		model.addAttribute("stanowiska", st);
		model.addAttribute("typyUmowy", um);
		model.addAttribute(banner);	

		

		return "AddUserPage";		
		
	}

	/**
	 * 
	 * dodawanie pracownika (zapis do bazy danych)
	 */
	@RequestMapping("/add_user")
	public String addUser(HttpServletRequest request) {
		Security security = new Security(request, userdao);
		if(!security.isLoged())
		return "redirect:/";
		if (!(security.getUserPremissions().isAdd_user() || security.getUserPremissions().isAdmin()))
			return "errorpage";// TODO strona error dla braku uprawnien

		String imie = request.getParameter("Imie");
		String nazwisko = request.getParameter("nazwisko");
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
		String nrkonta = request.getParameter("nrkonta");
		int typumowy = Integer.parseInt(request.getParameter("typumowy"));
		int stanowisko=Integer.parseInt(request.getParameter("stanowiska"));
		double wyplatabrutto = Double.parseDouble(request.getParameter("wyplatabrutto"));
		String haslo = request.getParameter("haslo");
		String pesel = request.getParameter("pesel");
		String dataurodzenia = request.getParameter("dataurodzenia");
		String nrtelefonu = request.getParameter("nrtelefonu");
		String ulica = request.getParameter("ulica");
		String nrdomu = request.getParameter("nrdomu");
		String nrm = request.getParameter("nrmieszkania");
		String miasto = request.getParameter("miasto");
		String kodpocztowy = request.getParameter("kodpocztowy");

		String adm = request.getParameter("admin");
		int admin, add_user, del_user, edit_user, finance_management, show_d_data;
		if(adm == null) {
		admin =0;	
		String add = request.getParameter("add_user");
		String del = request.getParameter("del_user");
		String edit = request.getParameter("edit_user");
		String fin_mag = request.getParameter("finance_management");
		String show_d = request.getParameter("show_d_data");
		add_user = add == null ? 0:1;
		del_user = del == null ? 0:1;
		edit_user = edit == null ? 0:1;
		finance_management = fin_mag == null ? 0:1;
		show_d_data = show_d == null ? 0:1;
		}
		else {
			admin = 1;
			add_user = del_user = edit_user = finance_management = show_d_data = 0;
		}

		int nrmieszkania;
		if(nrm.isEmpty()) nrmieszkania = 0;
		else nrmieszkania = Integer.parseInt(nrm);

		int id = userdao.addUser(imie, nazwisko, nickname, email, nrkonta, typumowy, stanowisko, wyplatabrutto, haslo, pesel, dataurodzenia, nrtelefonu, ulica, nrdomu, nrmieszkania, miasto, kodpocztowy);
		uprawnieniadao.addPermission(id, admin, add_user, del_user, edit_user, finance_management, show_d_data);

		if(security.getUserPremissions().isAdmin())
		return "redirect:/adminhome";
		if(security.getUserPremissions().isShow_d_data())
		return "redirect:/details_users_list";
		return "redirect:/users_list";

	}

	/**
	 * 
	 * usuwanie pracownika (usuwanie z bazy danych)
	 */
	@RequestMapping("/delete_user")
	public String deleteUser(@RequestParam("id") int id, HttpServletRequest request) {
		Security security = new Security(request, userdao);
		if(!security.isLoged())
		return "redirect:/";
		if (!(security.getUserPremissions().isDel_user() || security.getUserPremissions().isAdmin()))
			return "errorpage";// TODO strona error dla braku uprawnien

		userdao.deleteUser(id);

		if(security.getUserPremissions().isAdmin())
		return "redirect:/adminhome";
		return "redirect:/delete_users_list";
	
	}

	/**
	 * 
	 * strona z historią wypłat (tylko dla uprawnionych)
	 */
	@RequestMapping("/payment_history")
	public String payment_history(Model model, HttpServletRequest request){	
		Security security = new Security(request, userdao);
		if(!security.isLoged())
		return "redirect:/";
		if(!(security.getUserPremissions().isFinance_management() || security.isUserAdmin()))
		return "errorpage"; 

		Menu menu = new Menu(security.getUserPremissions(), request.getSession());	
		Banner banner = new Banner(menu, security.getFullUserData());
		List<Wyplaty> wyp = wyplatydao.getAllWyplaty();
		model.addAttribute("wyplaty", wyp);
		model.addAttribute(banner);	

		return "PaymentHistory";
	}

	/**
	 * 
	 * strona z info o finansach uzytkownika (tylko dla uprawnionych oraz dla każdego,
	 * kto chce zobaczyć własne info o finansach)
	 */
	@RequestMapping("/user_payment_page")
	public String userPaymentPage(@RequestParam("id") int id, Model model, HttpServletRequest request){	
		Security security = new Security(request, userdao);
		if(!security.isLoged())
			return "redirect:/";
		HttpSession session = request.getSession();
		if((Integer) session.getAttribute("id") != id  && !(security.getUserPremissions().isFinance_management() || security.getUserPremissions().isAdmin()))
			return "errorpage"; 

		Menu menu = new Menu(security.getUserPremissions(), request.getSession());
		User user1 = userdao.find_user_by_id(id);		
		Banner banner = new Banner(menu, security.getFullUserData());
		List<Wyplaty> wyp = wyplatydao.getAllUsersWyplaty(id);
		model.addAttribute("user1", user1);
		model.addAttribute("wyplaty", wyp);
		model.addAttribute(banner);	

		return "AuserAccStatement";
	}

	/**
	 * 
	 * szczegolowe dane o wynagrodzeniu uzytkownika (dostępne dla każdego - uprawnieni mogą zobaczyć wszystkich, nieuprawnieni tylko swoje)
	 */
	@RequestMapping("/user_specific_payment_data_page")
	public String userSpecificPaymentDataPage(@RequestParam("id") int id, Model model, HttpServletRequest request){	
		Security security = new Security(request, userdao);
		if(!security.isLoged())
		return "redirect:/";

		Menu menu = new Menu(security.getUserPremissions(), request.getSession());
		User user1 = userdao.find_user_by_id(id);
		TypyUmowy typUmowy = typyumowydao.find_typ_umowy_by_user_id(id);	
		Banner banner = new Banner(menu, security.getFullUserData());
		model.addAttribute("user1", user1);
		model.addAttribute("typUmowy", typUmowy);
		model.addAttribute(banner);	

		return "AuserSpecificPaymentData";
	}

	/**
	 * 
	 * strona dodawania wynagrodzenia dla pracownika (tylko dla uprawnionych)
	 */
	@RequestMapping("/user_add_payment_page")
	public String userAddPaymentPage(@RequestParam("id") int id, Model model, HttpServletRequest request){	
		Security security = new Security(request, userdao);
		if(!security.isLoged())
		return "redirect:/";
		if(!(security.isUserAdmin() || security.getUserPremissions().isFinance_management()))
		return "errorpage"; 

		Menu menu = new Menu(security.getUserPremissions(), request.getSession());
		User user1 = userdao.find_user_by_id(id);
		LocalDate locDate = null;	
		String dzis = locDate.now().toString();	
		Banner banner = new Banner(menu, security.getFullUserData());
		model.addAttribute("user1", user1);
		model.addAttribute("dzis", dzis);
		model.addAttribute(banner);	

		return "AuserAddPayment";
	}

	/**
	 * 
	 * dodawanie wynagrodzenia dla pracownika (zapis do bazy danych)
	 */
	@RequestMapping("/user_add_payment")
	public String userAddPayment(Model model,HttpServletRequest request){	
		Security security = new Security(request, userdao);
		if(!security.isLoged())
		return "redirect:/";
		if(!(security.isUserAdmin() || security.getUserPremissions().isFinance_management()))
		return "errorpage"; 

		int id = Integer.parseInt(request.getParameter("id"));
		String dataOd = request.getParameter("dataOd");
		String dataDo = request.getParameter("dataDo");
		int dniUrlopu = Integer.parseInt(request.getParameter("dniUrlopu"));
		int nadgodziny = Integer.parseInt(request.getParameter("iloscNadgodzin"));
		int premia = Integer.parseInt(request.getParameter("premia"));

		int iloscGodzin = 0;
		DateFormat format = new SimpleDateFormat("yyy-MM-dd", Locale.ENGLISH);
		Date date1 = null, date2=null;
		try {
			date1 = format.parse(dataOd);
			date2 = format.parse(dataDo);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar startCal = Calendar.getInstance();
	    startCal.setTime(date1);        
	    Calendar endCal = Calendar.getInstance();
	    endCal.setTime(date2);

	    int workDays = 0;

	    //Return 0 if start and end are the same
	    if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
	        workDays = 1;
	    }
	    else if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
	        startCal.setTime(date1);
	        endCal.setTime(date2);
	    }else{
			do {
				 if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
					 ++workDays;
				 }
				 startCal.add(Calendar.DAY_OF_MONTH, 1);
			 } while (startCal.getTimeInMillis() <= endCal.getTimeInMillis());    
		}
		iloscGodzin = workDays*8;
		iloscGodzin -= dniUrlopu*8;
		iloscGodzin += nadgodziny;

		User user1 = userdao.find_user_by_id(id);
		double wyplata = user1.getWyplataBrutto() * iloscGodzin + premia;

		LocalDate locDate = null;	
		String dzis = locDate.now().toString();	

		wyplatydao.addWyplata(id, dataOd, dataDo, dzis, wyplata, iloscGodzin);

		return "redirect:/add_payment_users_list"; 
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
			Menu menu = new Menu(security.getUserPremissions(), request.getSession());
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
		Security security = new Security(request, userdao);
		
		Menu menu = new Menu(security.getUserPremissions(), request.getSession());

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
		
		Menu menu = new Menu(security.getUserPremissions(), request.getSession());
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
		return "BUserHourPage";
	}

}
