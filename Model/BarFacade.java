package Model;

public class BarFacade {

   // Riferimento al Singleton per la gestione 
    private S_GestoriOrdini gestore = S_GestoriOrdini.getIstanza();

    // --- 1. Creazione bevanda ---
    public Bevanda creaBevandaBase(int scelta) {
        return switch (scelta) {
            case 1 -> new Caffe();
            case 2 -> new Te();
            case 3 -> new CioccolataCalda();
            default -> null;
        };
    }

    // --- 2.Decorazione bevanda e ne restituisce una decorata ---
    public Bevanda aggiungiExtra(Bevanda bevandaDaDecorare, int sceltaExtra) {
        if (bevandaDaDecorare == null) return null;

        return switch (sceltaExtra) {
            case 1 -> new DecoratorLatte(bevandaDaDecorare);
            case 2 -> new DecoratorZucchero(bevandaDaDecorare);
            case 3 -> new DecoratorCacao(bevandaDaDecorare);
            case 4 -> new DecoratorPanna(bevandaDaDecorare);
            case 5 -> new DecoratorCannella(bevandaDaDecorare);
            default -> bevandaDaDecorare; // Se la scelta è errata, restituisce l'originale
        };
    }

    // --- 3. interfaccia verso il singleton ---
    public void archiviaOrdine(Bevanda bevandaFinale) {
        if (bevandaFinale != null) {
            gestore.confermaOrdine(bevandaFinale);
        }
    }

    public void stampaStorico() {
        gestore.visualizzaStorico();
    }
       
}
