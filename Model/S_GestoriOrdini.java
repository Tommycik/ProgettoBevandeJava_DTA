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
    public String confermaOrdine(Bevanda bevanda) {

        String ordine = bevanda.getDescrizione()  + " - euro" + String.format("%.2f", bevanda.getCosto());

        storicoOrdini.add(ordine);

        return "Ordine confermato!";
    }

    public String visualizzaStorico() {
        String listaOrdini = "";
        // Controllo se sono presenti ordini
        if (storicoOrdini.isEmpty()) {
            return "Nessun ordine presente.";
        }

        for (int i = 0; i < storicoOrdini.size(); i++) {
            listaOrdini += (i + 1) + ". " + storicoOrdini.get(i) + "\n";
        }
        return listaOrdini;
    }
}
