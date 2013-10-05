import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(format={"html:output"},
		glue = {"com.ravi.cucumberjvm.appdemo"})
public class ValidateFeatures {
	
}
