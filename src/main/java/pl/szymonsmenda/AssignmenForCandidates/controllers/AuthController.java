package pl.szymonsmenda.AssignmenForCandidates.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.szymonsmenda.AssignmenForCandidates.forms.RegisterForm;
import pl.szymonsmenda.AssignmenForCandidates.services.AuthService;
import pl.szymonsmenda.AssignmenForCandidates.services.SessionService;


@Controller
public class AuthController{

    final AuthService authService;

    final SessionService sessionService;

    @Autowired
    public AuthController(AuthService authService, SessionService sessionService) {
        this.authService = authService;
        this.sessionService = sessionService;
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        Model model) {
        if (!authService.isLogin(email, password)) {
            model.addAttribute("infoAboutLogin", "Nieprawidłowy login lub hasło");
            return "login";
        }
        return "redirect:/";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("registerForm", new RegisterForm());
        return "register";
    }


    @PostMapping("/register")
    public String register(@ModelAttribute("registerForm") RegisterForm registerForm,
                           Model model) {
        if (!authService.isRegister(registerForm)) {
            model.addAttribute("infoAboutRegister", "Email zajęty");
            return "register";
        }
        return "redirect:/login"; //Po rejestracji przenies na logowanie
    }

    @GetMapping("/logout")
    public String logout() {
        sessionService.setLogin(false);
        sessionService.setUserEntity(null);

        return "redirect:/login";
    }
}




