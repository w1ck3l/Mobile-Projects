package edu.jhess9uwyo.program1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

public class HelloName extends AppCompatActivity implements nope.OnFragmentInteractionListener {
    nope frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_name);

        if (savedInstanceState == null) {
            frag = new nope();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, frag).commit();
        }
    }
    public void hideSoftKeyboard() {
        if(getCurrentFocus()!=null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }
    @Override
    public void onFragmentInteraction(String stringName) {
        TextView output = frag.output;
        hideSoftKeyboard();
        if (!stringName.isEmpty()) {
            Log.v("Success", "Name was entered");

            output.setText("Hello " + stringName);
            output.setVisibility(View.VISIBLE);
            output.setFocusable(false);


        } else {
            output.setVisibility(View.INVISIBLE);
            Log.e("Error", "Name was not entered");
        }

    }

}



