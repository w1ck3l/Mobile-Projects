package edu.jhess9uwyo.program1;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.support.v4.app.Fragment;


public class nope extends Fragment implements Button.OnClickListener {
    TextView input, output;;
    Button but;

    public nope() {
        // Required empty public constructor
    }
    private OnFragmentInteractionListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View myView = inflater.inflate(R.layout.fragment_nope, container, false);
        output = myView.findViewById(R.id.editText2);
        input = myView.findViewById(R.id.editText);

        but = myView.findViewById(R.id.button);
        but.setOnClickListener(this);

        return myView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = getActivity();
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String stringName);
    }
    @Override
    public void onClick(View v) {
        String stringName = input.getText().toString();
        mListener.onFragmentInteraction(stringName);
    }
}
