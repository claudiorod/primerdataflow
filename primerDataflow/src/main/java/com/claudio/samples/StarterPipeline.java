/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.claudio.samples;

import java.util.logging.XMLFormatter;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.FileIO;
import org.apache.beam.sdk.io.xml.XmlIO;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;;




/**
 * A starter example for writing Beam programs.
 *
 * <p>The example takes two strings, converts them to their upper-case
 * representation and logs them.
 *
 * <p>To run this starter example locally using DirectRunner, just
 * execute it without any additional parameters from your favorite development
 * environment.
 *
 * <p>To run this starter example using managed resource in Google Cloud
 * Platform, you should specify the following command-line options:
 *   --project=<YOUR_PROJECT_ID>
 *   --stagingLocation=<STAGING_LOCATION_IN_CLOUD_STORAGE>
 *   --runner=DataflowRunner
 */
public class StarterPipeline {
  private static final Logger LOG = LoggerFactory.getLogger(StarterPipeline.class);

  public static void main(String[] args) {
	  
	  PipelineOptionsFactory.register(MyOptions.class);
	  MyOptions options = PipelineOptionsFactory.fromArgs(args)
	                                            .withValidation()
	                                            .as(MyOptions.class);
	  
	  System.out.println("lectura "+options.getInput());
	  System.out.println("escritura "+options.getOutput());
	  
	  Pipeline pipeline = Pipeline.create(options);
      
	  
	  pipeline.apply("leyendo",XmlIO.<Customer>read().from(options.getInput()).withRootElement("customers")
	             .withRecordElement("customer")
	             .withRecordClass(Customer.class))
		  	 .apply("Agregar check",new CustomerCHECKTransformation())
		  	 .apply("Agregar ceros",new CustomerNAMETransformation())
		  	 .apply("Listar",new CustomerVIEWTransformation())
		  	 
//		  	.apply(XmlIO.<Customer>write().to(options.getOutput()).withRootElement("customer")
//		             .withRecordClass(Customer.class)
//		              );
	  
	  
	  .apply(FileIO.<Customer>write().to(options.getOutput())
			     .via(XmlIO.sink(Customer.class).withRootElement("customer")) );
	  
//		.apply(XmlIO.<Customer>write().to(options.getOutput()).withRecordClass(Customer.class).withRootElement("customer") );
	  
   pipeline.run().waitUntilFinish();

  }
}
