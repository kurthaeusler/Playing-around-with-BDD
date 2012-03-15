import java.util.List;
import java.util.Locale;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.Keywords;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;

public class StoryConfig {
	
	public Configuration configuration() {
		Keywords keywords = new LocalizedKeywords(new Locale("de"));
		return new MostUsefulConfiguration()
				.useKeywords(keywords)
				.useStoryParser(new RegexStoryParser(keywords))
				.useStoryLoader(new LoadFromClasspath(this.getClass()))
				// CONSOLE and TXT reporting
				.useStoryReporterBuilder(
						new StoryReporterBuilder().withDefaultFormats()
								.withFormats(Format.CONSOLE, Format.TXT)
								.withKeywords(keywords))
				.usePendingStepStrategy(new FailingUponPendingStep());
	}

	public List<CandidateSteps> candidateSteps() {
		// varargs, can have more that one steps classes
		return new InstanceStepsFactory(configuration(), new GridSteps())
				.createCandidateSteps();
	}
}
