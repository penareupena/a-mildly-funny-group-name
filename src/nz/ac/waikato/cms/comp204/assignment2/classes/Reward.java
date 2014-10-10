package nz.ac.waikato.cms.comp204.assignment2.classes;

public class Reward
{
  //Constant base number used as XP calculating.
  private int BASE = 30;

  private Party playerParty;
  private Party enemyParty;
  private int xpReward;
  
  /**
   * This constructor takes in both the player party and enemy party.
   * 
   * @param pp the player party
   * @param ep the enemy party
   */
  public Reward(Party pp, Party ep)
  {
    playerParty = pp;
    enemyParty = ep;
  }
  
  public int enemyXpWorth()
  {
    int adding = 0;
    
    for(int n = 0; n < enemyParty.characterCount(); n++)
    {
      int lvl = enemyParty.getCharacter(n).getAttributeValue(AttributeName.level);
      adding += (lvl*BASE);
    }
    
    return adding;
  }
  
  //This method will be used to calculate the XP earned by each of the players in the party.
  private void xpCalculator(Player p)
  {
    if((playerParty != null) && (enemyParty != null))
    {
      //go through all members of the party to check their levels
      for(int i=0; i < playerParty.characterCount(); i++)
      {
        if(!playerParty.getCharacter(i).isDead())
        {
          int tmplevel = playerParty.getCharacter(i).getAttributeValue(AttributeName.level);
          int tmpworth = enemyXpWorth();
          int reward = (tmpworth/tmplevel);
          playerParty.getCharacter(i).changeAttributeValue(AttributeName.xp, reward);
        }
      }
    }
  }
  

  
  
}
