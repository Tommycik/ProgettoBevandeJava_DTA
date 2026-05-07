package Controller;
import Model.Bevanda;
public class StrategyNormali implements StrategyConferma {

    @Override
    public double processaSconti(Bevanda bevanda) {
        double costo = bevanda.getCosto();
        return costo;
    }

    
}
