package edu.eci.cvds.managedBeans;

import java.io.IOException;
import java.io.Serializable;
import java.security.Security;
import java.util.Objects;
import java.util.logging.Level;

import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("deprecation")
@ManagedBean(name="loginBean")
@ApplicationScoped
public class LoginBean implements Serializable{
    private static final Logger log = LoggerFactory.getLogger(LoginBean.class);
    private String user;
    private String passwd;
    public boolean logeado = false;
    public String showError = "";
    public String ultimaPagina = "";

    public void login() {
        Subject userActual = SecurityUtils.getSubject();
        UsernamePasswordToken uPToken = new UsernamePasswordToken(getUser(), getPasswd());
        if (Objects.equals(this.user, "") || Objects.equals(this.passwd, "")) {
            showError = "Algunos de los campos es nulo";}
        try{
            userActual.login(uPToken);
            userActual.getSession().setAttribute("correo", user);
            showError="";
            FacesContext.getCurrentInstance().getExternalContext().redirect(this.ultimaPagina);
            setLogeado(true);
        } catch (UnknownAccountException ex) {
            if (Objects.equals(this.user, "") || Objects.equals(this.passwd, "")) {
                showError = "El campo Correo esta nulo";}
            else {
                showError = "El usuario no se encuentra registrado";
            }
        } catch (IncorrectCredentialsException ex) {
            if (Objects.equals(this.user, "") || Objects.equals(this.passwd, "")) {
                showError = "El campo Contraseña esta nulo";}
            else {
                showError = "La contraseña que ingreso no es correcta";
            }
        } catch (LockedAccountException ex) {
            showError = "El usuario esta deshabilitado para el ingreso";
        } catch (IOException ex) {
            showError = "A ocurrido un error desconocido";
            error("Unknown error: " + ex.getMessage());
            log.error(ex.getMessage(), ex);
        }
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public boolean isLogeado() {
        return logeado;
    }

    public void setLogeado(boolean logeado) {
        this.logeado = logeado;
    }

    public void setUltimaPagina(String ultimaPagina) {
        this.ultimaPagina = ultimaPagina;
    }

    public String getUltimaPagina() {
        return ultimaPagina;
    }

    private void error(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Intente de nuevo: ", message));
    }

    public void logOut(String redirect) {
        setUser("");
        setPasswd("");
        showError="";
        setLogeado(false);
        SecurityUtils.getSubject().logout();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(redirect);
        } catch (IOException ex) {
            error("Unknown error: " + ex.getMessage());
            log.error(ex.getMessage(), ex);
        }
    }

    public void reset() {
        setUser("");
        setPasswd("");
        showError="";
    }

    public void redirect() {
        try {
            Subject user = SecurityUtils.getSubject();
            if (user.hasRole("estudiante")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/index.xhtml");
            } else if (user.hasRole("admin")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/index.xhtml");
            }
        } catch (IOException ex) {
            error("Unknown error: " + ex.getMessage());
            log.error(ex.getMessage(), ex);
        }
    }

    public String showError(){
        return showError;
    }

    public boolean isAdmin() {
        Subject user = SecurityUtils.getSubject();
        return user.hasRole("admin");
    }

    public boolean isEstudiante() {
        Subject user = SecurityUtils.getSubject();
        return user.hasRole("estudiante");
    }

    public boolean isVisitante() {
        Subject user = SecurityUtils.getSubject();
        return !(user.hasRole("estudiante") || user.hasRole("admin"));
    }

}
