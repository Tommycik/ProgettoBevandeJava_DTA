package Model;

import java.util.List;


public class BarFacade {

    private S_GestoriOrdini gestore; // Il tuo Singleton
    private Bevanda bevandaCorrente; // L'oggetto dinamico (Decorator)

    public BarFacade() {
        // Usa il metodo getIstanza() come definito nel tuo codice
        this.gestore = S_GestoriOrdini.getIstanza();
        this.bevandaCorrente = null;
    }

    // --- 1. CREAZIONE BEVANDA BASE ---
    public void creaBevanda(int scelta) {
        switch (scelta) {
            case 1 -> bevandaCorrente = new Caffè();
            case 2 -> bevandaCorrente = new Tè();
            case 3 -> bevandaCorrente = new CioccolataCalda();
            default -> bevandaCorrente = null;
        }
    }

    // --- 2. AGGIUNTA EXTRA (DECORATOR) ---
    public void aggiungiExtra(int scelta) {
        if (bevandaCorrente == null) return;

        // Utilizzo i nomi esatti delle tue classi Decorator
        switch (scelta) {
            case 1 -> bevandaCorrente = new DecoratorLatte(bevandaCorrente);
            case 2 -> bevandaCorrente = new DecoratorZucchero(bevandaCorrente);
            case 3 -> bevandaCorrente = new DecoratorCacao(bevandaCorrente);
            case 4 -> bevandaCorrente = new DecoratorPanna(bevandaCorrente);
            case 5 -> bevandaCorrente = new DecoratorCannella(bevandaCorrente);
        }
    }

    // --- 3. AZIONI SULL'ORDINE ---
    public void confermaOrdine() {
        if (bevandaCorrente != null) {
            // Chiama il metodo confermaOrdine del tuo Singleton
            gestore.confermaOrdine(bevandaCorrente);
            bevandaCorrente = null; // Reset per nuova bevanda
        }
    }

    public void mostraStorico() {
        // Delega la visualizzazione al Singleton
        gestore.visualizzaStorico();
    }

    // --- 4. METODI PER LA VIEW (REVERSE FACADE) ---
    // Servono alla View per sapere cosa stampare senza toccare il Model
    
    public String getDescrizioneCorrente() {
        if (bevandaCorrente == null) return "Nessuna bevanda selezionata";
        return bevandaCorrente.getDescrizione();
    }

    public String getCostoCorrente() {
        if (bevandaCorrente == null) return "0.00";
        return String.format("%.2f", bevandaCorrente.getCosto());
    }

    public boolean haBevandaAttiva() {
        return bevandaCorrente != null;
    }
}
