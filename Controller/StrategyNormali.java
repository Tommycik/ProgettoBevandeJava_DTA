package Controller;
import Model.Bevanda;
public class StrategyNormali implements StrategySconti {

    @Override
    public double processaSconti(Bevanda bevanda) {
        double costo = bevanda.getCosto();
        return costo;
    }

    
}
