import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.steps.CandidateSteps;

public class GridStories extends JUnitStories {

	private StoryConfig storyConfig;

	public GridStories(StoryConfig storyConfig) {
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

	@Override
	protected List<String> storyPaths() {
		return new StoryFinder().findPaths(
				CodeLocations.codeLocationFromClass(this.getClass()),
				"**/*.story", "**/excluded*.story");
	}
}
