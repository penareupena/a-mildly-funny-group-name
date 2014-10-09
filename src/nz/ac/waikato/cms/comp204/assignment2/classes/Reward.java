public class Reward
{
  private int xpReward;
  
  //Constant base number used as XP calculating.
  private int BASE = 30;
  
  Party playerParty;
  Party enemyparty;
  
  
  public int enemyXpWorth(int worth)
  {
    private int adding = 0;
    for(int n = 0; n < enemyParty.members.size; n++)
    {
      int lvl = enemyParty.getByIndex(n).getLevel();
      adding += (lvl*BASE);
    }
    worth = adding;
    
    return worth;
  }
  
  //This method will be used to calculate the XP earned by each of the players in the party.
  private void xpCalculator(Player p)
  {
    if((playerParty != null) && (enemyParty != null))
    {
      //go through all members of the party to check their levels
      for(int i=0; i<playerParty.members.size; i++)
      {
        if(!playerParty.getByIndex(i).isDead)
        {
          int tmplevel = playerParty.getByIndex(i).getLevel();
          int tmpworth = enemyXpWorth();
          int reward = (tmpworth/tmplevel);
          playerParty.getByIndex(i).xp += reward;
        }
      }
    }
  }
  

  
  //This constructor takes in both the player party and enemy party.
  public Reward(Party pp, Party ep)
  {
    playerParty = pp;
    enemyParty = ep;
  }
}
