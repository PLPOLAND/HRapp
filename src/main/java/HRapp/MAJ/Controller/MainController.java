package HRapp.MAJ.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import HRapp.MAJ.DAO.UsersDAO;
import HRapp.MAJ.Model.User;


@Controller
public class MainController {

	@Autowired
	UsersDAO userdao;


	@RequestMapping("/")
	public String loadLoginPage() {
		return "loginPage";
	}
	@RequestMapping("/tmp")
	public String showTemplate(){
		return "template";
	}
	@RequestMapping("/test")
	public String test(){
		List<User> ls = userdao.getUserLoginData("PLPOLAND", "Makowiec1");
		for (User user : ls) {
			System.out.println(user.toString());
		}
		return "";
	}

}
