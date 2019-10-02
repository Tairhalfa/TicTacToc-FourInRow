package game;

public class Board {
	
	protected Player[][] board;
	protected int n,m;
	
	public Board(int n, int m)
	{
		this.n = n;
		this.m = m;
		board = new Player[n][m];
	}
	
	protected boolean set(int i, int j, Player p)
	{
		if(board[i][j] == null)
		{
			board[i][j] = p;
			return true;
		}
		return false;
	}
	
	public boolean isEmpty(int i, int j)
	{
		if(board[i][j] == null)
		{
			return true;
		}
		return false;
	}
	
	public Player get(int i, int j)
	{
		return board[i][j];
	}
	
	public boolean isFull()
	{
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < m; j++)
			{
				if (board[i][j] == null)
					return false;
			}
		}
		return true;
	}
	
	public String toString() 
	{
		String str ="" ;
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < m; j++)
			{
				
				if (board[i][j] == null)
				{
					str += ('.');
				}
				else
				{
					str += (board[i][j].getMark());
				}
			}
			str += '\n';
		}
		return str;
		
	}
	
	protected int maxLineContaining(int i, int j)
	{
		Player shape = board[i][j];
		int side1, side2;
		int maxSize = 0, sizeCount = 0;
		
		/*running on line*/
		for(side1 = j; side1 >= 0 && board[i][side1]==shape; side1--)
		{
			sizeCount++;
		}
		for(side2 = j; side1 < m && board[i][side2]==shape; side2++)
		{
			sizeCount++;
		}
		maxSize = sizeCount -1;//-1 because we counts twice board[i][j]
		sizeCount = 0;
		
		/*running on column*/
		for(side1 = i; side1 >= 0 && board[side1][j]==shape; side1--)
		{
			sizeCount++;
		}
		for(side2 = i; side2 < n && board[side2][j]==shape; side2++)
		{
			sizeCount++;
		}
		if(maxSize < (sizeCount - 1))
		{
			maxSize = sizeCount -1;//-1 because we counts twice board[i][j]
		}
		
		sizeCount = 0;
		
		/*running on diagonal line*/
		for(side1 = i, side2 = j; side1 < n && side2 >= 0 && board[side1][side2]==shape; side1++, side2--)
		{
			sizeCount++;
		}
		for(side1 = i, side2 = j; side1 >= 0 && side2 < m && board[side1][side2]==shape; side1--, side2++)
		{
			sizeCount++;
		}
		if(maxSize < (sizeCount - 1))
		{
			maxSize = sizeCount -1;//-1 because we counts twice board[i][j]
		}
		
		sizeCount = 0;
		
		/*running on diagonal line*/
		for(side1 = i, side2 = j; side1 < n && side2 < m && board[side1][side2]==shape; side1++, side2++)
		{
			sizeCount++;
		}
		for(side1 = i, side2 = j; side1 >= 0 && side2 >= 0 && board[side1][side2]==shape; side1--, side2--)
		{
			sizeCount++;
		}
		if(maxSize < (sizeCount - 1))
		{
			maxSize = sizeCount -1;//-1 because we counts twice board[i][j]
		}
		return maxSize;
	}


}
