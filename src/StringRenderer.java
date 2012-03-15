public class StringRenderer {

	private boolean[][] board;
	private int width;
	private int height;

	public String asString() {
		String retVal = "";
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				if (board[col][row])
					retVal += 'X';
				else
					retVal += '.';
			}
			if (row < height - 1)
				retVal += "\r\n";
		}
		return retVal;
	}

	public void setBoard(boolean[][] board, int width, int height) {
		this.board = board;
		this.width = width;
		this.height = height;

	}

}
