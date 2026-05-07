package Model;

public class DecoratorCacao extends DecoratorBevanda {
    public DecoratorCacao(Bevanda bevanda) {
        super(bevanda);
    }

    @Override
    public String getDescrizione() {
        return bevanda.getDescrizione() + ", con Cacao";
    }
    @Override
    public double getCosto() {
        return bevanda.getCosto() + 0.5;
    }
    // metodo per applicare la decorazione
    @Override
    public Bevanda applica(Bevanda bevanda) {
        return new DecoratorCacao(bevanda);
    }
    
}
