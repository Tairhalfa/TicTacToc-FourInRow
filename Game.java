package game;

import java.util.Scanner;

public class Game extends Board{

	protected Player[] players;
	protected Scanner s;
	
	public Game(int n, int m, Player p1, Player p2)
	{
		super(n, m);
		players = new Player[2];
		players[0] = p1;
		players[1] = p2;
	}
	
	protected boolean doesWin(int i, int j)
	{
		if(i == 0 && j == 0)
		{
			return true;
		}
		return false;
	}
	
	protected boolean onePlay(Player p)
	{
		int i, j, flag;
		s = new Scanner(System.in);
		
		do
		{	
			
			flag = 0;
			System.out.println(p.toString() +", Please enter x and y: ");
			i = s.nextInt();
			j = s.nextInt();
			
			if(super.set(i, j, p) == false)
			{
				System.out.println("There is a piece there already...\n");
				flag = 1;
			}
		
		}while(flag != 0);
		
		if(doesWin(i,j))
		{
			System.out.println(p.toString() +"Won!\n");
			return true;
		}
			
		return false;
	}
	
	public Player play() 
	{
		int i = 0;
		Boolean winFlag = false;
		do
		{	//all the players are plays (one by one ) until the board is full or someone is win
			winFlag = onePlay(players[i]);
			if(i==0) i=1;
			else i=0;
			
		}while(super.isFull() == false && winFlag == false);
		
		if(winFlag == true)
		{
			if(i == 0) return players[1];
			else return players[0];
		}
		return null;
	}
}
