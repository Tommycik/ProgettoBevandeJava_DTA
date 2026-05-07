package Model;

public class DecoratorZucchero extends DecoratorBevanda {
    public DecoratorZucchero(Bevanda bevanda) {
        super(bevanda);
    }

    @Override
    public String getDescrizione() {
        return bevanda.getDescrizione() + ", con Zucchero";
    }
    @Override
    public double getCosto() {
        return bevanda.getCosto() + 0.1;
    }
    
}
