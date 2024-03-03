package ext;

import dao.IDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("dao2")

public class DaoImplV2 implements IDao {
    @Override
    public double getDate() {
        System.out.println("Version web service :");
        double t=11;
        return t;
    }
}
