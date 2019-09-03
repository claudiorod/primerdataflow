package com.claudio.samples;

import org.apache.beam.sdk.options.Default;
import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptions;

public interface MyOptions extends PipelineOptions {

	@Description("getOutput")
	@Default.String("gs://bucked-desarrollo/out")
	public String getOutput();
	public void setOutput(String output);
	
	@Description("getInput")
	@Default.String("gs://bucked-desarrollo/input")
	public String getInput();
	public void setInput(String input);
	
}
