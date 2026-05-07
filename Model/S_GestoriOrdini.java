package Model;

import java.util.ArrayList;
import java.util.List;

public class S_GestoriOrdini {
    // Istanza unica
    private static S_GestoriOrdini istanza;

    private List<String> storicoOrdini;

    // Costruttore
    private S_GestoriOrdini() {
        storicoOrdini = new ArrayList<>();
    }

    public static S_GestoriOrdini getIstanza() {

        if (istanza == null) {
            istanza = new S_GestoriOrdini();
        }

        return istanza;
    }

    // Metodi di gestione ordini:
    public void confermaOrdine(Bevanda bevanda) {

        String ordine = bevanda.getDescrizione()  + " - €" + String.format("%.2f", bevanda.getCosto());

        storicoOrdini.add(ordine);

        System.out.println("Ordine confermato!");
    }

    public void visualizzaStorico() {

        System.out.println("\n===== STORICO ORDINI =====");

        // Controllo se sono presenti ordini
        if (storicoOrdini.isEmpty()) {
            System.out.println("Nessun ordine presente.");
            return;
        }

        for (int i = 0; i < storicoOrdini.size(); i++) {
            System.out.println((i + 1) + ". " + storicoOrdini.get(i));
        }
    }
}
