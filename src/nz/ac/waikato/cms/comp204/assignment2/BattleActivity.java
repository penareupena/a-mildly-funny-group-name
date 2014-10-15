package nz.ac.waikato.cms.comp204.assignment2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View.OnClickListener;

import java.util.*;

import nz.ac.waikato.cms.comp204.assignment2.classes.AttributeName;
import nz.ac.waikato.cms.comp204.assignment2.classes.Party;
import nz.ac.waikato.cms.comp204.assignment2.classes.Player;
import nz.ac.waikato.cms.comp204.assignment2.classes.Character;

public class BattleActivity extends Activity implements OnClickListener {

    boolean turn = false, canCancel, BattleOver = false, BattleLost = false, BattleStarted = false;

    Party pp, ep;
    Player p;

    Character attacker = null;
    ArrayList<Character> targets = new ArrayList<Character>();

    String action = "";
    String TERM_ATTACK = "attack";
    String TERM_SKILL = "skill";
    String TERM_ITEM = "item";

    //add btns
    Button btnEndTurn;
    Button btnLeft;
    Button btnMiddle;
    Button btnRight;

    TextView EnemyHp1;
    TextView EnemyHp2;
    TextView EnemyHp3;

    TextView PartyHp1;
    TextView PartyHp2;
    TextView PartyHp3;

    ImageButton EnemyMember1;
    ImageButton EnemyMember2;
    ImageButton EnemyMember3;

    ImageButton PartyMember1;
    ImageButton PartyMember2;
    ImageButton PartyMember3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        btnEndTurn = (Button) findViewById(R.id.btnEndTurn);
        btnLeft = (Button) findViewById(R.id.btnLeft);
        btnMiddle = (Button) findViewById(R.id.btnMiddle);
        btnRight = (Button) findViewById(R.id.btnRight);

        EnemyHp1 = (TextView) findViewById(R.id.EnemyHp1);
        EnemyHp2 = (TextView) findViewById(R.id.EnemyHp2);
        EnemyHp3 = (TextView) findViewById(R.id.EnemyHp3);

        PartyHp1 = (TextView) findViewById(R.id.PartyHp1);
        PartyHp2 = (TextView) findViewById(R.id.PartyHp2);
        PartyHp3 = (TextView) findViewById(R.id.PartyHp3);

        EnemyMember1 = (ImageButton) findViewById(R.id.EnemyMember1);
        EnemyMember2 = (ImageButton) findViewById(R.id.EnemyMember2);
        EnemyMember3 = (ImageButton) findViewById(R.id.EnemyMember3);

        PartyMember1 = (ImageButton) findViewById(R.id.PartyMember1);
        PartyMember2 = (ImageButton) findViewById(R.id.PartyMember2);
        PartyMember3 = (ImageButton) findViewById(R.id.PartyMember3);

        Player _p;
        Party _pp, _ep;
        ArrayList<Character> group1 = new ArrayList<Character>();
        group1.add(new Character(5,5,5));
        _ep = new Party(group1);
        ArrayList<Character> group2 = new ArrayList<Character>();
        group2.add(new Character(5,5,5));
        group2.add(new Character(5,5,5));
        _pp = new Party(group2);
        _p = new Player(_pp);
        startBattle(_p, _ep);
        
        /*
        runBattle(_p, _ep);

        BattleStarted = true;
        */
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.battle, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void startBattle(Player _p, Party _ep) {
    	p = _p;
        ep = _ep;
        pp = p.getParty();


        setTextFields();

        if (pp.totalDex() > ep.totalDex())
            turn = true;
    }
    
    public void runBattle(Player _p, Party _ep) {
        //create interface
        //create each party's sprites and pressable things

        while (!pp.allDead() || !ep.allDead()) {

            pp.resetActions();
            ep.resetActions();

            while (turn == true) {
                if (attacker != null && !attacker.takenAction()) {
                    if (!action.isEmpty()) {
                        if (action.equals(TERM_ATTACK) && targets.size() == 1) {
                            attacker.WeaponAttack(targets.get(0));
                            attacker.takeAction();
                            action = "";
                            attacker = null;
                            targets.clear();
                            setTextFields();
                        }
                    }
                }
                if(pp.allTakenAction()) turn = false;
            }
            enemyTurn();
            setTextFields();
        }

        if (pp.allDead())
            BattleLost = true;
        else
            getReward();
    }

    private void setTextFields() {
        PartyHp1.setText(pp.getCharacter(0).getAttributeValue(AttributeName.hp) + "/" + pp.getCharacter(0).maxHp());
        if(pp.characterCount()>1)
            PartyHp2.setText(pp.getCharacter(1).getAttributeValue(AttributeName.hp) + "/" + pp.getCharacter(1).maxHp());
        if(pp.characterCount()>2)
            PartyHp3.setText(pp.getCharacter(2).getAttributeValue(AttributeName.hp) + "/" + pp.getCharacter(2).maxHp());

        EnemyHp1.setText(pp.getCharacter(0).getAttributeValue(AttributeName.hp) + "/" + ep.getCharacter(0).maxHp());
        if(ep.characterCount()>1)
            EnemyHp2.setText(pp.getCharacter(1).getAttributeValue(AttributeName.hp) + "/" + ep.getCharacter(1).maxHp());
        if(ep.characterCount()>2)
            EnemyHp3.setText(pp.getCharacter(2).getAttributeValue(AttributeName.hp) + "/" + ep.getCharacter(2).maxHp());


    }

    public void onClick(View v){
        if(turn) {
            if (v.getId() == btnEndTurn.getId()) {
                //set btns text Blank, fade BtnEndturn,
                turn = false;
            }
            if (v.getId() == btnLeft.getId()) {
                if (attacker != null) {
                    //allow target choosing
                    //set this and middle blank, right to cancel
                }
            }
            if (v.getId() == btnMiddle.getId()) {

            }
            if (v.getId() == btnRight.getId()) {

            }
            if(v.getId() == PartyMember1.getId()){
                if(!pp.getCharacter(0).isDead()) {
                    attacker = pp.getCharacter(0);
                    action = "";
                }
            }
            if(v.getId() == PartyMember2.getId()){
                if(pp.characterCount()>1&&!pp.getCharacter(1).isDead()) {
                    attacker = pp.getCharacter(1);
                    action = "";
                }
            }
            if(v.getId() == PartyMember3.getId()){
                if(pp.characterCount()>2&&!pp.getCharacter(2).isDead()){
                    attacker = pp.getCharacter(2);
                    action = "";
                }
            }
            if(v.getId() == EnemyMember1.getId()){
                if(attacker!=null&&action.equals(TERM_ATTACK)&&!ep.getCharacter(0).isDead())
                    targets.add(ep.getCharacter(0));
            }
            if(v.getId() == EnemyMember2.getId()){
                if(pp.characterCount()>1&&attacker!=null&&action.equals(TERM_ATTACK)&&!pp.getCharacter(1).isDead())
                    targets.add(ep.getCharacter(1));
            }
            if(v.getId() == EnemyMember3.getId()){
                if(pp.characterCount()>2&&attacker!=null&&action.equals(TERM_ATTACK)&&!pp.getCharacter(2).isDead())
                    targets.add(ep.getCharacter(2));
            }
        }
    }

    public void enemyTurn() {
        while (turn == false) {
            //For each of the characters in the enemy party, make
            for (int i = 0; i < ep.characterCount(); i++) {
                attacker = ep.getCharacter(i);
                for (int k = 0; k < pp.characterCount(); k++) {
                    if (!pp.getCharacter(k).isDead() && !attacker.takenAction()) {
                        attacker.WeaponAttack(pp.getCharacter(k));
                        attacker.takeAction();
                        setTextFields();
                    }
                }
            }
            turn = true;
        }
    }
    private void getReward(){
        //Reward r = new Reward(pp, ep);
    }
}
