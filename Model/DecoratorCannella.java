package Model;

public class DecoratorCannella extends DecoratorBevanda {
    public DecoratorCannella(Bevanda bevanda) {
        super(bevanda);
    }
    @Override
    public String getDescrizione() {
        return bevanda.getDescrizione() + ", con Cannella";
    }
    @Override
    public double getCosto() {
        return bevanda.getCosto() + 0.3;
    }
    // metodo per applicare la decorazione
    @Override
    public Bevanda applica(Bevanda bevanda) {
        return new DecoratorCannella(bevanda);
    }
}
