package com.claudio.samples;

import org.apache.beam.sdk.options.Default;
import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptions;

public interface MyOptions extends PipelineOptions {

	 @Description("getOutput")
	    @Default.String("gs://bucked-desarrollo/input/")
	public String getOutput();
	public void setOutput(String output);
	
	
}
