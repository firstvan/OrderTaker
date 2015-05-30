package hu.firstvan.model;

import javax.xml.bind.JAXBException;

/**
 * Created by firstvan on 5/30/15.
 */
public interface IXmlDAO {
    public SalesByPeopleList getSalesByPeople() throws JAXBException;
}
