import org.jbehave.core.annotations.Aliases;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class GridSteps {
	private Game game;
	private StringRenderer renderer;

	@Given("a $width by $height game")
	@Aliases(values = { "a new game: $width by $height" })
	public void theGameIsRunning(int width, int height) {
		game = new Game(width, height);
		renderer = new StringRenderer();
		game.setObserver(renderer);
	}

	@When("I toggle the cell at ($column, $row)")
	public void iToggleTheCellAt(int column, int row) {
		game.toggleCellAt(column, row);
	}

	@When("I reset the board")
	public void whenIResetTheBoard() {
		game.reset();
	}

	@Then("the grid should look like $grid")
	@Aliases(values = { "the grid should be $grid" })
	public void theGridShouldLookLike(String grid) {
		assertThat(renderer.asString(), equalTo(grid));
	}
}
