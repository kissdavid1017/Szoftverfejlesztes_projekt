package Naplozas;

import jakarta.xml.bind.annotation.*;
import lombok.Data;


    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(propOrder = {"mozgásirány","sor","oszlop"})
    @Data

    public class naploz {

        private String mozgasirany;
        private int sor;
        private int oszlop;



}
