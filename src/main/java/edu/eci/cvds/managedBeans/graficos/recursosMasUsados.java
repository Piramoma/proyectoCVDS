package edu.eci.cvds.managedBeans.graficos;


import com.google.inject.Inject;
import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.managedBeans.BasePageBean;
import edu.eci.cvds.persistence.exception.PersistenceException;
import edu.eci.cvds.services.ServiciosBiblioteca;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;


@ManagedBean(name = "recursosMasUsados")
@SessionScoped
public class recursosMasUsados extends BasePageBean {

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
     * Metodo para consultar Reservas mas Usadas
     * @return Lista de reservas menos Usadas
     * @throws PersistenceException clase errores
     */
    public List<Reserva> consultarrecursosMasUsados() throws PersistenceException {
        return serviciosBiblioteca.recursosMasUsados();
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
            reservas = serviciosBiblioteca.recursosMasUsados();
            ArrayList<Integer> cantidades = new ArrayList<>();

            for (Reserva r : reservas) {
                graph.set(r.getTitulo(), r.getCantidad());
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
     * Metodo para crear el grafico
     */
    private void createBarModel() {
        grafico = initBarModel();
        grafico.setTitle("Recursos más usados");
        grafico.setLegendPosition("ne");
        Axis yAxis = grafico.getAxis(AxisType.Y);
        yAxis.setLabel("Cantidad de reservas");
        yAxis.setMin(0);
        yAxis.setMax(max + 5);
        grafico.setSeriesColors("B00000");
    }
}
