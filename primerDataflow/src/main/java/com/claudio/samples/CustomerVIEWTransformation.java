package com.claudio.samples;

import org.apache.beam.sdk.transforms.PTransform;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;


public class CustomerVIEWTransformation extends  PTransform<PCollection<Customer>,PCollection<Customer>>{ 

	private static final long serialVersionUID = 1L;

	@Override
	public PCollection<Customer> expand(PCollection<Customer> input) {
		
		return input.apply(ParDo.of(new CustomerVIEWFunction()));
	}





}