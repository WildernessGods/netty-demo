package io.wilderness.thrift;

import io.wilderness.thrift.data.Persion;
import io.wilderness.thrift.data.PersionService;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFastFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * @author an_qiang
 */
public class ThrftClient {

    public static void main(String[] args) {
        TTransport tTransport = new TFastFramedTransport(new TSocket("127.0.0.1", 8899), 600);
        TProtocol tProtocol = new TCompactProtocol(tTransport);
        PersionService.Client client = new PersionService.Client(tProtocol);

        try {
            tTransport.open();
            Persion persion = client.getPersionByName("haha");
            System.out.println("getPersionByName " + persion);

            System.out.println("--------------------");

            persion.setUsername("hehe").setAge(22).setMarried(true);
            client.savePersion(persion);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            tTransport.close();
        }
    }
}
