package com.claudio.samples;

import org.apache.beam.sdk.transforms.DoFn;

public class CustomerCHECKFunction extends DoFn<Customer,Customer>{

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
			customer.setName(c.element().getName());
			customer.setCheck("true");

			c.output(customer);

			System.out.println(c.element());
  }
	
}
