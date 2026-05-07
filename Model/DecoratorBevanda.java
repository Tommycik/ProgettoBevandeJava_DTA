package Model;

public abstract class DecoratorBevanda implements Bevanda {
    protected Bevanda bevanda;
    public DecoratorBevanda(Bevanda bevanda) {
        this.bevanda = bevanda;
    }
    //metodo per applicare la decorazione
    public abstract Bevanda applica(Bevanda bevanda);
    @Override
    public String getDescrizione() {
        return bevanda.getDescrizione();
    }
    @Override
    public double getCosto() {
        return bevanda.getCosto();
    }   
}
