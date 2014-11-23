package com.example.android.securityappversionone;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Eric on 11/19/2014.
 */
public class FragmentCCTVSystem extends FragmentMenu {

    TextView cctv,mTextView;
    EditText mEditText;
    Button mButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cctv_system,container,false);

        cctv = (TextView) view.findViewById(R.id.textViewCCTV);
        mEditText = (EditText) view.findViewById(R.id.editText);
        mTextView = (TextView) view.findViewById(R.id.textView);
        mButton = (Button) view.findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = mEditText.getText().toString();
                cctv.setText(s);
            }
        });


        return view;
    }

}
