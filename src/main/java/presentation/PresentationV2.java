package presentation;

import dao.IDao;
import ext.DaoImplV2;
import metier.IMetier;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class PresentationV2 {
    public static void main(String[] args)  {
        try {
            Scanner scanner = new Scanner(new File("config.txt"));
            //DaoImplV2 d = new DaoImplV2()
            String daoClassname = scanner.nextLine();
            Class cDao= Class.forName(daoClassname);
            IDao dao=(IDao) cDao.getConstructor().newInstance();
            //Instanciation dynamique

            //MetierImpl metier = new MetierImpl(d)
            String metierClassname = scanner.nextLine();
            Class cMetier= Class.forName(metierClassname);
            IMetier metier=(IMetier) cMetier.getConstructor(IDao.class).newInstance(dao);
            System.out.println("Resultat :"+metier.calcul());

            //metier.setDao(d);
            Method setDao= cMetier.getDeclaredMethod("setDao", IDao.class);
            setDao.invoke(metier, dao);



        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
