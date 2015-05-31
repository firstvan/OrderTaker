package hu.firstvan.model;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStream;


/**
 * Created by firstvan on 5/30/15.
 */
public class XmlDAO implements IXmlDAO{

    @Override
    public SalesByPeopleList getSalesByPeople() {
        SalesByPeopleList sbpl = null;
        try {
            JAXBContext jbc = JAXBContext.newInstance(SalesByPeopleList.class);

            Unmarshaller un = jbc.createUnmarshaller();

            InputStream in = this.getClass().getResource("/salesByPeople.xml").openStream();//new File("salesByPeople.xml");
            sbpl = (SalesByPeopleList) un.unmarshal(in);

        } catch (JAXBException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sbpl;
    }
}
