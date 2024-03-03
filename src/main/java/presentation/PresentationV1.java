package presentation;

import dao.DaoImpl;
import ext.DaoImplV2;
import metier.MetierImpl;

public class PresentationV1 {
    public static void main(String[] args) {
        /*
        * Injection des dependances par instanciation static
         */
        DaoImplV2 d = new DaoImplV2();
        MetierImpl metier = new MetierImpl(d);//Injection via le constructeur
        metier.setDao(d); //Injection via setter
        System.out.println("Resultat="+metier.calcul());


    }
}
