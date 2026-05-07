
import Controller.MacchinettaController;
import java.util.Scanner;
import Controller.StrategySoldati;
import Controller.StrategyNormali;
public class EsercizioMacchinetta {
    public static void main(String[] args) {
        MacchinettaController macchinetta = new MacchinettaController();
        Scanner intScanner = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);
        int scelta;
        //ciclo while con menu
        while (true) {
            macchinetta.visualizzaMenu();
            scelta = intScanner.nextInt();
            switch (scelta) {
                case 1 :
                    //crea nuova bevanda
                    macchinetta.visualizzaBevande();
                    scelta = intScanner.nextInt();
                    macchinetta.creaNuovaBevanda(scelta);
                    break;
                case 2 :
                    //aggiungi ingrediente extra
                    macchinetta.visualizzaIngredientiExtra();
                    scelta = intScanner.nextInt();
                    macchinetta.aggiungiIngredienteExtra(scelta);
                    break;
                case 3 :
                    //visualizza bevanda corrente
                    macchinetta.visualizzaBevandaCorrente();
                    break;
                case 4 :
                    //conferma ordine
                    //Sei un soldato?
                    System.out.println("Sei un soldato?(S/N)");
                    String sceltaSoldato = stringScanner.next();
                    if (sceltaSoldato.equalsIgnoreCase("S")) {
                        //se è un soldato
                        macchinetta.setStrategy(new StrategySoldati());
                    }else {
                        //se è un normalista
                        macchinetta.setStrategy(new StrategyNormali());
                    }
                    macchinetta.confermaOrdine();
                    break;
                case 5 :
                    //visualizza storico
                    macchinetta.visualizzaStorico();
                    break;
                case 6 :
                    //esci
                    return;
                default :
                    //se scelta non valida
                    System.out.println("Scelta non valida");
                    break;
            }
        }

    }
}
