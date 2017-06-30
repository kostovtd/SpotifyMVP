package com.kostovtd.spotifymvp.view;

import android.os.Bundle;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.kostovtd.spotifymvp.R;
import com.kostovtd.spotifymvp.base.BaseActivity;
import com.kostovtd.spotifymvp.model.UserProfile;
import com.kostovtd.spotifymvp.presenter.ProfilePresenter;
import com.kostovtd.spotifymvp.presenter.ProfilePresenterImpl;
import com.kostovtd.spotifymvp.util.Is;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kostovtd on 28.06.17.
 */
public class ProfileActivity extends BaseActivity implements ProfileView {

    private static final String TAG = ProfileActivity.class.getSimpleName();

    private ProfilePresenter profilePresenter;

    @BindView(R.id.text_id_label)
    TextView textIdLabel;

    @BindView(R.id.text_id_value)
    TextView textIdValue;

    @BindView(R.id.text_birthdate_label)
    TextView textBirthdateLabel;

    @BindView(R.id.text_birthdate_value)
    TextView textBirthdateValue;

    @BindView(R.id.text_country_label)
    TextView textCountryLabel;

    @BindView(R.id.text_country_value)
    TextView textCountryValue;

    @BindView(R.id.text_email_label)
    TextView textEmailLabel;

    @BindView(R.id.text_email_value)
    TextView textEmailValue;

    @BindView(R.id.text_product_label)
    TextView textProductLabel;

    @BindView(R.id.text_product_value)
    TextView textProductValue;

    @BindView(R.id.text_followers_label)
    TextView textFollowersLabel;

    @BindView(R.id.text_followers_value)
    TextView textFollwersValue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: hit");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_layout);
        setTitle(R.string.profile_screen_title);

        ButterKnife.bind(this);

        profilePresenter = new ProfilePresenterImpl(this, this);

        profilePresenter.fetchProfileData();
    }


    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: hit");
        super.onResume();
    }


    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: hit");
        super.onPause();
    }


    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: hit");
        super.onDestroy();
    }


    @Override
    public void showProfileData(UserProfile userProfile) {
        Log.d(TAG, "showProfileData: hit");

        if(userProfile != null) {
            // ID
            String id = userProfile.getId();
            if(Is.empty(id)) {
                textIdLabel.setVisibility(View.GONE);
                textIdValue.setVisibility(View.GONE);
            } else{
                textIdLabel.setVisibility(View.VISIBLE);
                textIdValue.setVisibility(View.VISIBLE);
                textIdValue.setText(id);
            }

            // BIRTHDATE
            String birthdate = userProfile.getBirthdate();
            if(Is.empty(birthdate)) {
                textBirthdateLabel.setVisibility(View.GONE);
                textBirthdateValue.setVisibility(View.GONE);
            } else {
                textBirthdateLabel.setVisibility(View.VISIBLE);
                textBirthdateValue.setVisibility(View.VISIBLE);
                textBirthdateValue.setText(birthdate);
            }

            // COUNTRY
            String country = userProfile.getCountry();
            if(Is.empty(country)) {
                textCountryLabel.setVisibility(View.GONE);
                textCountryValue.setVisibility(View.GONE);
            } else {
                textCountryLabel.setVisibility(View.VISIBLE);
                textCountryValue.setVisibility(View.VISIBLE);
                textCountryValue.setText(country);
            }

            // EMAIL
            String email = userProfile.getEmail();
            if(Is.empty(email)) {
                textEmailLabel.setVisibility(View.GONE);
                textEmailValue.setVisibility(View.GONE);
            } else {
                textEmailLabel.setVisibility(View.VISIBLE);
                textEmailLabel.setVisibility(View.VISIBLE);
                textEmailValue.setText(email);
            }

            // PRODUCT
            String product = userProfile.getProduct();
            if(Is.empty(product)) {
                textProductLabel.setVisibility(View.GONE);
                textProductValue.setVisibility(View.GONE);
            } else {
                textProductLabel.setVisibility(View.VISIBLE);
                textProductValue.setVisibility(View.VISIBLE);
                textProductValue.setText(product);
            }

            // FOLLOWERS
            int followers = userProfile.getFollowers().getTotal();
            textFollwersValue.setText(String.valueOf(followers));
        } else {
            Log.e(TAG, "showProfileData: userProfile is NULL");
        }
    }
}