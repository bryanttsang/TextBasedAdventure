package Board;

import Tiles.Tile;

public class Board {
    Tile[][] board;

    public Board(Tile[][] board)
    {
        this.board = board;
    }

    public void print(){
        String row = "";
        for (int i = 0; i < board.length; i++)
        {
            row = "";
            for (int ii = 0; ii < board[i].length; ii++)
            {
                row += board[i][ii].toString();
            }
            System.out.println(row);
        }

    }
}