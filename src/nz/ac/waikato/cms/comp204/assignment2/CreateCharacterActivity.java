package nz.ac.waikato.cms.comp204.assignment2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class CreateCharacterActivity extends Activity {

	private final int MAX_ATTRIBUTES = 15; 			// the maximum attribute points that can be used to create the character
	
	private EditText txtStrength;
	private EditText txtDexterity;
	private EditText txtPower;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_character);
		
		txtStrength = (EditText)findViewById(R.id.txtStrength);
		txtDexterity = (EditText)findViewById(R.id.txtDexterity);
		txtPower = (EditText)findViewById(R.id.txtPower);
		
		populateInitialValues();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create_character, menu);
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
	
	/**
	 * Populates the attribute fields with their initial values
	 */
	private void populateInitialValues() {
		int startValue = MAX_ATTRIBUTES;
		int indexCounter = 0;
		int numAttributes = 3;
		
		// Indices of the attributes in the attributes array 
		int strengthIndex = 0;
		int dexterityIndex = 1;
		int powerIndex = 2;
		
		// Set the array to all zeros
		int[] attributes = new int[numAttributes];
		
		// Go through all the attributes to set their respective initial values
		while (startValue != 0) {
			attributes[indexCounter]++;
			
			indexCounter++;
			
			if (indexCounter == numAttributes)
				indexCounter = 0;
			
			startValue--;
		}
		
		txtStrength.setText(String.valueOf(attributes[strengthIndex]));
		txtDexterity.setText(String.valueOf(attributes[dexterityIndex]));
		txtPower.setText(String.valueOf(attributes[powerIndex]));
	}
}
