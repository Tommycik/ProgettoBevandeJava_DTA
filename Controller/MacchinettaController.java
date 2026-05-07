package Controller;

import Model.*;
import View.MacchinettaView;

public class MacchinettaController {

    private BarFacade facade;
    private MacchinettaView view;

    private Bevanda bevandaCorrente;
    private StrategySconti strategy;

    public MacchinettaController() {
        this.facade = new BarFacade();
        this.view = new MacchinettaView();
    }

    // Strategy setter
    public void setStrategy(StrategySconti strategy) {
        this.strategy = strategy;
    }

    // MENU
    public void visualizzaMenu() {
        view.visualizzaMenu();
    }

    public void visualizzaBevande() {
        view.visualizzaBevande();
    }

    public void visualizzaIngredientiExtra() {
        view.visualizzaIngredientiExtra();
    }

    // BEVANDA
    public void creaNuovaBevanda(int scelta) {

        switch (scelta) {
            case 1:
                bevandaCorrente = facade.creaCaffe();
                break;
            case 2:
                bevandaCorrente = facade.creaTe();
                break;
            case 3:
                bevandaCorrente = facade.creaCioccolata();
                break;
            default:
                System.out.println("Scelta non valida");
                return;
        }

        view.visualizzaBevandaCorrente(bevandaCorrente);
    }

    // EXTRA
    public void aggiungiIngredienteExtra(int scelta) {

        if (bevandaCorrente == null) {
            System.out.println("Devi prima creare una bevanda!");
            return;
        }

        switch (scelta) {

            case 1:
                bevandaCorrente = new DecoratorLatte(bevandaCorrente);
                break;

            case 2:
                bevandaCorrente = new DecoratorCannella(bevandaCorrente);
                break;

            case 3:
                bevandaCorrente = new DecoratorCacao(bevandaCorrente);
                break;

            case 4:
                bevandaCorrente = new DecoratorPanna(bevandaCorrente);
                break;

            case 5:
                bevandaCorrente = new DecoratorZucchero(bevandaCorrente);
                break;

            default:
                System.out.println("Ingrediente non valido");
                return;
        }

        view.visualizzaBevandaCorrente(bevandaCorrente);
    }

    // ORDINE
    public void confermaOrdine() {

        if (bevandaCorrente == null) {
            System.out.println("Nessuna bevanda da confermare");
            return;
        }

        facade.archiviaOrdine(bevandaCorrente);

        view.confermaOrdine(bevandaCorrente);
        if (strategy != null) {
            double prezzoFinale = strategy.processaSconti(bevandaCorrente);
            view.visualizzaMessaggio("Prezzo finale con evantueli sconti: " + prezzoFinale);
        }
        
        bevandaCorrente = null;
    }

    // STORICO
    public void visualizzaStorico() {
        view.visualizzaStorico(facade.stampaStorico());
    }

    // GETTER (opzionale debug)
    public Bevanda getBevandaCorrente() {
        return bevandaCorrente;
    }

    public void visualizzaBevandaCorrente() {
        view.visualizzaBevandaCorrente(getBevandaCorrente());
    }
}