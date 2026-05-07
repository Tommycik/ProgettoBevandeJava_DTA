package View;
import Model.Bevanda;

public class MacchinettaView {
    //visualizza storico ordini
    public void visualizzaStorico(String storicoOrdini) {
        System.out.println("Storico ordini: ");
        System.out.println(storicoOrdini);
    }
    
    //helper stampa bevanda
    private void stampaBevanda(Bevanda bevanda) {
        System.out.println(bevanda.getDescrizione());
        System.out.println(bevanda.getCosto());
    }
    //conferma ordine
    public void confermaOrdine(Bevanda bevanda) {
        System.out.println("Ordine confermato");
        stampaBevanda(bevanda);
    }
    //bevanda corrente
    public void visualizzaBevandaCorrente(Bevanda bevanda) {
        System.out.println("Bevanda corrente");
        stampaBevanda(bevanda);
    }
    //Stampa menu azioni
    public void visualizzaMenu() {
        System.out.println("Menu azioni:");
        System.out.println("1. Crea nuova bevanda");
        System.out.println("2. Aggiungi ingrediente ");
        System.out.println("3. Conferma ordine");
        System.out.println("3. Visualizza bevanda corrente");
        System.out.println("4. Esci");
    }

}
