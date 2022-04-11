package itc.hoseo.baedal.web;



import itc.hoseo.baedal.domain.Category;
import itc.hoseo.baedal.domain.ClientUser;
import itc.hoseo.baedal.repo.CategoryRepositoryMem;
import itc.hoseo.baedal.repo.ClientUserRepository;
import itc.hoseo.baedal.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

    @Autowired
    ClientUserRepository clientUserRepository;
    @Autowired
    LoginService ls;
    @Autowired
    CategoryRepositoryMem categoryRepository;

    @RequestMapping("/login")
    public String login(){return "login";}

    @RequestMapping("/loginAction")
    public String loginAction(ClientUser cu){
        if(ls.checkPassword(cu.getId(), cu.getPassword())){
            return "index";
        } else {
            return "redirect:/login";
        }
    }

    @RequestMapping("/registerPage")
    public String registerPage(){return "registerPage";}

    @RequestMapping("/registerAction")
    public String registerAction(ClientUser cu){
        clientUserRepository.insert(cu);
        return "login";
    }

    @RequestMapping("/index")
    public String index(ModelMap mm){
        categoryRepository.save(new Category("a", "/img/a.jpg"));
        categoryRepository.save(new Category("b", "/img/b.jpg"));
        categoryRepository.save(new Category("c", "/img/c.jpg"));
        mm.put("categories", categoryRepository.findAll());
        return "index";
    }
}
