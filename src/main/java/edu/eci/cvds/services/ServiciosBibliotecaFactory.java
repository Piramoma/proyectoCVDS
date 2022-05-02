package edu.eci.cvds.services;

import com.google.inject.Injector;
import edu.eci.cvds.services.impl.ServiciosBibliotecaImpl;
import org.mybatis.guice.XMLMyBatisModule;
import edu.eci.cvds.persistence.*;
import edu.eci.cvds.persistence.mybatisimpl.*;
import edu.eci.cvds.services.*;
import java.util.Optional;

import static com.google.inject.Guice.createInjector;

public class ServiciosBibliotecaFactory {
    private static ServiciosBibliotecaFactory instance = new ServiciosBibliotecaFactory();

    private static Optional<Injector> optInjector;

    private Injector myBatisInjector(String env, String pathResource) {
        return createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setEnvironmentId(env);
                setClassPathResource(pathResource);
                bind(ServiciosBiblioteca.class).to(ServiciosBibliotecaImpl.class);
                bind(UsuarioDAO.class).to(MyBATISUsuarioDAO.class);
                bind(RecursoDAO.class).to(MyBATISRecursoDAO.class);
                bind(ReservaDAO.class).to(MyBATISReservaDAO.class);
                bind(HorarioDAO.class).to(MyBATISHorarioDAO.class);

            }
        });
    }

    private ServiciosBibliotecaFactory(){
        optInjector = Optional.empty();
    }

    public ServiciosBiblioteca getServiciosBiblioteca(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }

        return optInjector.get().getInstance(ServiciosBiblioteca.class);
    }

    public static ServiciosBibliotecaFactory getInstance(){
        return instance;
    }
}
