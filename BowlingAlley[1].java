
public class BowlingAlley 
{
	private BowlingLane[] alley;
	
	public BowlingAlley(int numOfLanes)
	{
		alley = new BowlingLane[numOfLanes];
		
		for (int i = 0; i < alley.length; i++)
			alley[i] = new BowlingLane();
	}
	
	/**
	 * checks if the wished lane is occupied - if it is, it returns the number of the lane, if not, it returns the number
	 * of the next free lane - if all lanes are occupied, it returns -1
	 * @param numLane number of the lane
	 * @param numPlayers how many players
	 * @return
	 */
	public int playAtLane (int numLane, int numPlayers)
	{
		numLane = numLane-1;
		if(numLane < 0 || numLane > alley.length-1)
			System.out.println("Nicht moeglich!");
		
		for (int lane = numLane; lane < alley.length; lane++)
		{
			if (alley[lane].getIfOccupied() == false)
			{
				alley[lane].setNumPlayers(numPlayers);
				return lane;
			}
			
			if (lane == alley.length-1)
				lane = 0;
			
			if (lane+1 == numLane)
				break;
		}
		return -1;
	}
	
	public void printBowlingHallStatus()
	{
		for (int i = 0; i < alley.length; i++)
		{
			System.out.println("Bahn "+(i+1)+": "
				+ (alley[i].getIfOccupied() ? alley[i].getNumOfPlayers()+" Personen." : " frei!"));
		}
		System.out.println();
	}
	
	/**
	 * ends the game at a lane
	 * @param numLane lane that is to leave
	 */
	public void endGameAtLane(int numLane)
	{
		numLane = numLane -1;
		alley[numLane].setNumPlayers(0);
	}
	
	public static void main (String[] args)
	{
		BowlingAlley test = new BowlingAlley(6);
		
		test.printBowlingHallStatus();
		
		test.playAtLane(3, 12);
		test.printBowlingHallStatus();
		test.playAtLane(4, 6);
		test.playAtLane(5, 20);
		test.playAtLane(1, 10);
		test.playAtLane(3, 8);
		test.endGameAtLane(3);
		
		test.printBowlingHallStatus();
	}
}
