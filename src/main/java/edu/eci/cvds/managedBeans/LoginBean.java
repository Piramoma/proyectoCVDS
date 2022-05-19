package edu.eci.cvds.managedBeans;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("deprecation")
@ManagedBean(name="loginBean")
@ApplicationScoped
public class LoginBean implements Serializable{
    private static final Logger log = LoggerFactory.getLogger(LoginBean.class);
    private String user;
    private String passwd;
    public String ultimaPagina = "";

    /**
     * Metodo para logearse
     */
    public void login() {
        Subject userActual = SecurityUtils.getSubject();
        UsernamePasswordToken uPToken = new UsernamePasswordToken(getUser(), getPasswd());
        if (this.user == null || Objects.equals(this.user.trim(), "")) {
            error("El campo de correo esta vacio");
            }
        if (this.passwd == null || this.passwd.trim().equals("")){
            error("El campo de contraseña esta vacio");
        }
        try{
            userActual.login(uPToken);
            userActual.getSession().setAttribute("correo", user);
            FacesContext.getCurrentInstance().getExternalContext().redirect(this.ultimaPagina);

        } catch (UnknownAccountException ex) {
            error("El usuario no se encuentra registrado");
        } catch (IncorrectCredentialsException ex) {
            error("La contraseña ingresada no es correcta");
        } catch (LockedAccountException ex) {
            error("El usuario esta deshabilitado para el ingreso");
        } catch (IOException ex) {
            error("A ocurrido un error desconocido" + ex.getMessage());
        }
    }

    /**
     * Metodo para cambiar mensaje de error
     * @param message mensaje
     */
    private void error(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Intente de nuevo: ", message));
    }

    /**
     * Metodo para deslogearse
     * @param redirect pagina a redirigir
     */
    public void logOut(String redirect) {
        reset();
        SecurityUtils.getSubject().logout();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(redirect);
        } catch (IOException ex) {
            error("Unknown error: " + ex.getMessage());
            log.error(ex.getMessage(), ex);
        }
    }

    /**
     *  Metodo para resetear usuario, correo
     */
    public void reset() {
        setUser("");
        setPasswd("");
    }

    /**
     * Metodo para redireccionar
     */
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

    /**
     * Metodo que te dice si un usuario Admin
     * @return boolean
     */
    public boolean isAdmin() {
        Subject user = SecurityUtils.getSubject();
        return user.hasRole("admin");
    }

    /**
     * Metodo que te dice si un usuario Estudiante
     * @return boolean
     */
    public boolean isEstudiante() {
        Subject user = SecurityUtils.getSubject();
        return user.hasRole("estudiante");
    }

    /**
     * Metodo que te dice si un usuario Visitante
     * @return boolean
     */
    public boolean isVisitante() {
        Subject user = SecurityUtils.getSubject();
        return !(user.hasRole("estudiante") || user.hasRole("admin"));
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

    public void setUltimaPagina(String ultimaPagina) {
        this.ultimaPagina = ultimaPagina;
    }

    public String getUltimaPagina() {
        return ultimaPagina;
    }



}
