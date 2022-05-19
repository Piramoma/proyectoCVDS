package edu.eci.cvds.managedBeans.graficos;



import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


import com.google.inject.Inject;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Reserva;

import edu.eci.cvds.managedBeans.BasePageBean;
import edu.eci.cvds.persistence.exception.PersistenceException;
import edu.eci.cvds.services.ServiciosBiblioteca;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;


@ManagedBean(name = "recursosPorCarrera")
@SessionScoped
public class recursosPorCarrera extends BasePageBean {

    @Inject
    private ServiciosBiblioteca serviciosBiblioteca;
    private int max;


    private BarChartModel grafico;

    /**
     * Netodo que selecciona el item del evento
     * @param event evento
     */
    public void itemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
                "Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    /**
     * Retorna el Grafico
     * @return Grafico
     */
    public BarChartModel getGrafico() {
        createBarModel();
        return grafico;
    }

    /**
     * Metodo para iniciar BarChartModel
     * @return BarChartModel
     */
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
        ChartSeries graph = new ChartSeries();
        graph.setLabel("Cantidad de reservas");
        List<Reserva> reservas;
        try {
            reservas = serviciosBiblioteca.consultarReservasPorCarrera();
            ArrayList<Integer> cantidades = new ArrayList<>();

            for (Reserva r : reservas) {
                graph.set(r.getCarrera(), r.getCantidad());
                cantidades.add(r.getCantidad());
            }

            max = 0;
            for (int i = 0; i < cantidades.size(); i++) {
                if (cantidades.get(i) > max) {
                    max = cantidades.get(i);
                }
            }
            model.addSeries(graph);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return model;
    }

    /**
     * Metodo para consultar Reservas Por Carrera
     * @return Lista de reservas por carrera
     * @throws PersistenceException clase errores
     */
    public List<Reserva> consultarReservasPorCarrera() throws PersistenceException {
        return serviciosBiblioteca.consultarReservasPorCarrera();
    }

    /**
     * Metodo para crear el grafico
     */
    private void createBarModel() {
        grafico = initBarModel();
        grafico.setTitle("Reservas Por Carrera");
        grafico.setLegendPosition("ne");
        Axis xAxis = grafico.getAxis(AxisType.X);
        Axis yAxis = grafico.getAxis(AxisType.Y);
        yAxis.setLabel("Cantidad de reservas");
        yAxis.setMin(0);
        yAxis.setMax(max + 5);
        grafico.setSeriesColors("B00000");
    }
}
