package io.wilderness.thrift.service.impl;

import io.wilderness.thrift.data.DataException;
import io.wilderness.thrift.data.Persion;
import io.wilderness.thrift.data.PersionService;
import org.apache.thrift.TException;

/**
 * @author an_qiang
 */
public class PersionServiceImpl implements PersionService.Iface {

    @Override
    public Persion getPersionByName(String username) throws DataException, TException {
        System.out.println("get getPersionByName " + username);

        Persion persion = new Persion();
        persion.setUsername(username);
        persion.setAge(18);
        persion.setMarried(false);
        return persion;
    }

    @Override
    public void savePersion(Persion persion) throws DataException, TException {
        System.out.println("get savePersion" + persion);
    }
}
