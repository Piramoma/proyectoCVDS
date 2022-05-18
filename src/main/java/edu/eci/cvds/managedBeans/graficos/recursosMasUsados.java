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
import edu.eci.cvds.services.ServiciosBiblioteca;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;


@ManagedBean(name = "recursosMasUsados")
@SessionScoped
public class recursosMasUsados extends BasePageBean {

    @Inject
    private ServiciosBiblioteca serviciosBiblioteca;
    private int max;


    private BarChartModel grafico;

    public void itemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
                "Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }


    public BarChartModel getGrafico() {
        createBarModel();
        return grafico;
    }


    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
        ChartSeries graph = new ChartSeries();
        graph.setLabel("Cantidad de reservas");
        List<Recurso> reservas;
        try {
            reservas = serviciosBiblioteca.consultarLibros();
            System.out.println("TAMAÑO " + reservas.size());
            ArrayList<Integer> cantidades = new ArrayList<>();

            for (Recurso r : reservas) {
                graph.set(r.getNombre(), r.getCapacidad());
                cantidades.add(r.getCapacidad());
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

    private void createBarModel() {
        grafico = initBarModel();
        grafico.setTitle("Recursos más usados");
        grafico.setLegendPosition("ne");

        Axis xAxis = grafico.getAxis(AxisType.X);

        Axis yAxis = grafico.getAxis(AxisType.Y);
        yAxis.setLabel("Cantidad de reservas");
        yAxis.setMin(0);
        yAxis.setMax(max + 5);
        grafico.setSeriesColors("B00000");
    }
}