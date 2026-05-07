package Controller;
import Model.Bevanda;
public class StrategySoldati implements StrategySconti {

    @Override
    public double processaSconti(Bevanda bevanda) {
        double costo = bevanda.getCosto();
        return costo*0.8;
    }
    
}
