package course.examples.UI.Button;

import java.util.Observable;
import java.util.Observer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ButtonActivity extends Activity implements Observer{
	int count = 0;
	ButtonModel model;
	private EditText display;
	private Button buttonUp, buttonDown;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
         model=new ButtonModel();
         model.addObserver(this);
        // Get a reference to the Press Me Button
        buttonUp = (Button) findViewById(R.id.buttonUp);
        buttonDown = (Button) findViewById(R.id.buttonDown);
         
       
       display= (EditText)  findViewById(R.id.display);
       display.setKeyListener(null);
        // Set an OnClickListener on this Button
        // Called each time the user clicks the Button
      
       
       buttonUp.setOnClickListener(new ButtonListener());
       buttonDown.setOnClickListener(new ButtonListener());
       
  
    }
    
    private class ButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(v.equals(buttonDown))
				model.decreaseCounter(1);
			else if(v.equals(buttonUp))
				model.increaseCounter(1);
		}
   	   
      }

	@Override
	public void update(Observable observable, Object data) {
		// TODO Auto-generated method stub
		display.setText(""+model.getCounter());
	}
}