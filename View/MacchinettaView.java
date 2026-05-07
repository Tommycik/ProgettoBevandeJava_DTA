package View;
import Model.Bevanda;

public class MacchinettaView {
    //visualizza storico ordini
    public void visualizzaStorico(String storicoOrdini) {
        System.out.println("Storico ordini: ");
        System.out.println(storicoOrdini);
    }
    
    //visualizza descrizione bevanda
    public void StampaBevanda(Bevanda bevanda) {
        System.out.println("Bevanda scelta:");
        System.out.println(bevanda.getDescrizione());
        System.out.println(bevanda.getCosto());
    }
}
