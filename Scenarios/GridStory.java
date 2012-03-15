import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.steps.CandidateSteps;
import org.junit.Test;

public abstract class GridStory extends JUnitStory {

	private StoryConfig storyConfig;

	public GridStory(StoryConfig storyConfig) {
		super();
		this.storyConfig = storyConfig;
	}

	@Override
	public Configuration configuration() {
		return storyConfig.configuration();
	}

	@Override
	public List<CandidateSteps> candidateSteps() {
		return storyConfig.candidateSteps();
	}

	@Test
	public void run() throws Throwable {
		super.run();
	}

}