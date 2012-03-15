public class Game {

	private boolean board[][];
	private int width;
	private int height;
	private StringRenderer renderer;

	public Game(int width, int height) {
		board = new boolean[width][height];
		this.width = width;
		this.height = height;
	}

	public void setObserver(StringRenderer renderer) {
		this.renderer = renderer;
		renderer.setBoard(board, width, height);
	}

	public void toggleCellAt(int column, int row) {
		board[column][row] = !board[column][row];

	}

	public void reset() {
		board = new boolean[width][height];
		renderer.setBoard(board, width, height);
	}

}
