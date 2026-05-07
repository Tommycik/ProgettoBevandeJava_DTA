package Model;

public class DecoratorPanna extends DecoratorBevanda {
    public DecoratorPanna(Bevanda bevanda) {
        super(bevanda);
    }
    @Override
    public String getDescrizione() {
        return bevanda.getDescrizione() + ", con Panna";
    }
    @Override
    public double getCosto() {
        return bevanda.getCosto() + 0.4;
    }
    // metodo per applicare la decorazione
    @Override
    public Bevanda applica(Bevanda bevanda) {
        return new DecoratorPanna(bevanda);
    }
}
