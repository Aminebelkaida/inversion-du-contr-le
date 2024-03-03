package dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class DaoImpl implements IDao{

    @Override
    public double getDate() {
        System.out.println("Version bases de données");
        double temp= 23;
        return temp;
    }
}
