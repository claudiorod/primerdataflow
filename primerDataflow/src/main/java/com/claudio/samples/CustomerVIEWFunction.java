package com.claudio.samples;

import org.apache.beam.sdk.transforms.DoFn;

public class CustomerVIEWFunction extends DoFn<Customer,Customer>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ProcessElement
	public void processElement(ProcessContext c)
  {


			System.out.println(c.element());
  }
	
}
