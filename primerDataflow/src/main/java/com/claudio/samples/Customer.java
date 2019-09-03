package com.claudio.samples;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



@XmlRootElement(name = "customer")
public class Customer implements Serializable {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String country;

	    private String gender;

	    private String name;

	    private String age;
	    
	    private String check;
	    
	    

	    public String getCheck() {
			return check;
		}
	    @XmlElement
		public void setCheck(String check) {
			this.check = check;
		}
		public String getCountry ()
	    {
	        return country;
	    }
	    @XmlElement
	    public void setCountry (String country)
	    {
	        this.country = country;
	    }

	    public String getGender ()
	    {
	        return gender;
	    }
	    @XmlElement
	    public void setGender (String gender)
	    {
	        this.gender = gender;
	    }

	    public String getName ()
	    {
	        return name;
	    }
	    @XmlElement
	    public void setName (String name)
	    {
	        this.name = name;
	    }

	    public String getAge ()
	    {
	        return age;
	    }
	    @XmlElement
	    public void setAge (String age)
	    {
	        this.age = age;
	    }

	    @Override
	    public String toString()
	    {
	        return "["+
	        		"country = "+country+", "+
	        		"gender = "+gender+", "+
	        		"name = "+name+", "+
	        		"age = "+age+", "+
	        		"check = "+check+
	        		"]";
	    }
	}
