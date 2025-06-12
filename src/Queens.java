

public class Queens {
    private class Space {
        private boolean placeable;
        private boolean occupied;
        private char symbol;

        public Space() {
            this.placeable = true;
            this.occupied = false;
            symbol = '-';
        }

        public boolean isPlaceable() {
            return placeable;
        }

        public void occupy() {
            this.placeable = false;
            this.occupied = true;
            this.symbol = 'Q';
        }

        public void setPlaceable(boolean placeable) {
            this.placeable = placeable;
            if (this.symbol == '-') this.symbol = '~';
        }

        public boolean isOccupied() {
            return occupied;
        }

        public void setOccupied(boolean occupied) {
            this.occupied = occupied;
        }
    }
    Space[][] board;
    int height;
    int width;
    Space[][] found;
    int iterations;
    long time;
    int instructions;

    public Queens(int height) {
        this.height = height;
        this.width = height;
        board = new Space[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                instructions++;
                board[i][j] = new Space();
            }
        }
        found = board;
        this.findAllPossible();
    }

    public void findAllPossible() {
        time = System.nanoTime();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j].isPlaceable()) {
                    board[i][j].occupy();
                    this.placeQueen(i, j);
                    instructions++;
                }
            }
        }
        /* for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j].symbol + " ");
            }
            System.out.println();
        } */
        time = System.nanoTime() - time;
        System.out.println();
        System.out.print("Tamanho " + height + ", ");
        System.out.print(time + " nanosegundos de duração, ");
        System.out.print(iterations + " iterações e ");
        System.out.print(instructions + " instruções.");
    }

    public void placeQueen(int i, int j) {
        board[i][j].setOccupied(true);
        instructions++;
        markDiagonals(i,j);
        iterations++;
        markLines(i,j);
        iterations++;
    }

    public void markDiagonals(int i, int j) {
        for (int k = i, l = j; (k < height) & (l < width); k++,l++) {
            board[k][l].setPlaceable(false);
            instructions++;
        }
        for (int k = i, l = j; (k < height) & (l >= 0); k++,l--) {
            board[k][l].setPlaceable(false);
            instructions++;
        }
        for (int k = i, l = j; (k >= 0) & (l >= 0); k--,l--) {
            board[k][l].setPlaceable(false);
            instructions++;
        }
        for (int k = i, l = j; (k >= 0) & (l < width); k--,l++) {
            board[k][l].setPlaceable(false);
            instructions++;
        }
    }
    public void markLines(int i, int j) {
        for (int k = 0; k < height; k++) {
            board[k][j].setPlaceable(false);
            instructions++;
        }
        for (int k = 0; k < width; k++) {
            board[i][k].setPlaceable(false);
            instructions++;
        }
    }
}
