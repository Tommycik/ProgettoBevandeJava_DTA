package Model;

public class DecoratorLatte extends DecoratorBevanda {
    public DecoratorLatte(Bevanda bevanda) {
        super(bevanda);
    }
    @Override
    public String getDescrizione() {
        return bevanda.getDescrizione() + ", con Latte";
    }
    @Override
    public double getCosto() {
        return bevanda.getCosto() + 0.2;
    }
    // metodo per applicare la decorazione
    @Override
    public Bevanda applica(Bevanda bevanda) {
        return new DecoratorLatte(bevanda);
    }
}
