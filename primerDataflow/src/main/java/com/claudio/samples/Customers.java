package com.claudio.samples;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "customers")
public class Customers implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Customer[] customer;

    public Customer[] getCustomer ()
    {
        return customer;
    }
	@XmlElement
    public void setCustomer (Customer[] customer)
    {
        this.customer = customer;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [customer = "+customer+"]";
    }
    
    
}
