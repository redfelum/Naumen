package helpers;


import beans.XMLBean;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class XMLHelpers {
    private XMLBean XMLBean;

    public void setConfiguration(XMLBean bean) {
        XMLEncoder encoder = null;
        try {
            encoder = new XMLEncoder(new BufferedOutputStream(
                    new FileOutputStream("InintDB.xml")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        encoder.writeObject(bean);
        encoder.close();

    }

    public XMLBean getConfiguration(String ConfXML) {
        XMLDecoder dencoder = null;
        try {
            dencoder = new XMLDecoder(new BufferedInputStream(
                    new FileInputStream(ConfXML)));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        XMLBean = (XMLBean) dencoder.readObject();
        dencoder.close();
        return XMLBean;
    }

}
