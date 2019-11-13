package HRapp.MAJ.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HRapp.MAJ.DAO.UsersDAO;
import HRapp.MAJ.Model.User;
import HRapp.MAJ.Security.Security;



/**
 * RESTController Tu coś jeszcze będzie. Puki co nie funkcjonuje
 */
@RequestMapping("/api")
@RestController
public class RESTController {
    @Autowired
    UsersDAO database;
    
    @RequestMapping("/login")
    public boolean login(HttpServletRequest request) {
        Security security = new Security(request, database);

        if (security.login()) {
            return true;
        } else {
            return false;
        }
    }
    @RequestMapping("/alluserslist")
    public List<User> allusers(HttpServletRequest request) {
        Security security = new Security(request, database);
        if(security.isLoged()){
            return database.getAllUsers();
        }
        else
            return null;
    }
        
}