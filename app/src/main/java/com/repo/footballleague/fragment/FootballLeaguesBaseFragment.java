package com.repo.footballleague.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import com.repo.footballleague.R;

/**
 * Created by Doha on 09/07/19.
 */
public class FootballLeaguesBaseFragment extends Fragment {
    private ProgressDialog progressDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressDialog = new ProgressDialog(getContext(), R.style.ProgressDialogTheme);
        progressDialog.setCancelable(false);

    }

    protected void showProgressDialog() {
        if(progressDialog != null && !progressDialog.isShowing()) {
            progressDialog.show();
        }
    }

    protected void dismissProgressDialog() {
        if(progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    protected void setToolbarWithBackBtn(String title) {
        if (((AppCompatActivity) getActivity()).getSupportActionBar() != null) {
            setToolbar(true);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        }
    }
    protected void setToolbarWithoutBackBtn(String title) {
        if (((AppCompatActivity) getActivity()).getSupportActionBar() != null) {
            setToolbar(false);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        }
    }
    protected void hideToolbarWithBackBtn() {
        if (((AppCompatActivity) getActivity()).getSupportActionBar() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        }
    }


    private void setToolbar(Boolean backButtonEnabled) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(backButtonEnabled);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        dismissProgressDialog();
    }
}
