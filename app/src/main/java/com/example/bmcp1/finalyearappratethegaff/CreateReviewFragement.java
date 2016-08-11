package com.example.bmcp1.finalyearappratethegaff;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

/**
 * Created by bmcp1 on 20/05/2016.
 */


public class CreateReviewFragement extends Fragment {

    protected EditText mRentalAgent, mAddress;
    protected EditText mPostcode;
    protected EditText mBedType;
    protected RadioGroup mRadioGroup;
    protected RadioButton mGas;
    protected RadioButton mOil;
    protected EditText mHeatingType;
    protected EditText mWindowType;
    private RatingBar mRating;
    protected EditText mRatingValue;
    protected Button mSend;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_create_review, container, false);
        listenerForRatingBar();




        mSend = (Button) mSend.findViewById(R.id.sendButton);
        mRentalAgent =(EditText)mRentalAgent.findViewById(R.id.rentalAgent);
        mAddress =(EditText)mAddress.findViewById(R.id.address);
        mPostcode =(EditText)mPostcode.findViewById(R.id.postcode);
        mBedType =(EditText)mBedType.findViewById(R.id.bedType);
        mGas =(RadioButton)mGas.findViewById(R.id.gasRadioButton);
        mOil = (RadioButton)mOil.findViewById(R.id.oilRadioButton);
        mWindowType = (EditText)mWindowType.findViewById(R.id.windowType);
        mRentalAgent =(EditText)mRentalAgent.findViewById(R.id.rentalAgent);

        switch (int.getItemId()){

        }
        if (mGas == null){
            mHeatingType.setText("Gas");

        }

        mSend.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String rentalAgent = mRentalAgent.getText().toString();
                String address = mAddress.getText().toString();
                String postcode = mPostcode.getText().toString();
                String bedType = mBedType.getText().toString();
                String address = mAddress.getText().toString();
                String address = mAddress.getText().toString();
                String address = mAddress.getText().toString();
                String address = mAddress.getText().toString();

                password = password.trim();
                email = email.trim();

                mRadioGroup = (RadioGroup)mRadioGroup.findViewById(R.id.rg_heating);

                if( password.isEmpty() || email.isEmpty()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setMessage(R.string.empty_field)
                            .setTitle(R.string.title_missing_information)
                            .setPositiveButton(android.R.string.ok, null);
                    AlertDialog dialog = builder.create();
                    dialog.show();

                }
                else {
                    // successfully lodged in
                    ParseUser.logInInBackground(email, password, new LogInCallback(){
                        @Override
                        public void done(ParseUser user, ParseException e){
                            if (e == null){
                                //sucess
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                            }
                            else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                builder.setMessage(e.getMessage())
                                        .setTitle(R.string.title_missing_information)
                                        .setPositiveButton(android.R.string.ok, null);
                                AlertDialog dialog = builder.create();
                                dialog.show();

                            }
                        }
                    });

                }
            }
        }); return rootView;
    }
    public void listenerForRatingBar(){
        mRating = (RatingBar)mRating.findViewById(R.id.ratingBar);

        mRating.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        mRatingValue.setText(String.valueOf(rating));

                    }
                }
        );
    }



}

