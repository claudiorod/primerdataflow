package com.claudio.samples;

import org.apache.beam.sdk.transforms.DoFn;

public class CustomerNAMEFunction extends DoFn<Customer,Customer>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ProcessElement
	public void processElement(ProcessContext c)
  {
		Customer customer=new Customer();
			customer.setAge(c.element().getAge());
			customer.setCountry(c.element().getCountry());
			customer.setGender(c.element().getGender());
			customer.setCheck(c.element().getCheck());
			customer.setName("(P)"+c.element().getName());
	
	
			c.output(customer);
		
			System.out.println(c.element());

  }
	
}
