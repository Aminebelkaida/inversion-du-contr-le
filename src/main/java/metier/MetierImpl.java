package metier;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import dao.IDao;
import org.springframework.stereotype.Service;

@Service("metier")
public class MetierImpl implements IMetier {
    //@Autowired "inject"//n'est pas recommandée, on utilise donc le constructeur avec param
    private IDao dao;

   /* public MetierImpl() {
    }*/ //il faut utiliser un seul constructeur (avec param); pour fair l'injection des dependance vie spring annota

    public MetierImpl(@Qualifier("dao") IDao dao) {

        this.dao = dao;
    }

    @Override
    public double calcul() {
        double t= dao.getDate();
        double res= t * 23;
        return res;
    }

    /**
     * Pour injecter dans la variable dao un objet
     * d'une classe qui implemente l'interface IDoa
     */
    public void setDao(IDao dao) {

        this.dao = dao;
    }

}
