package com.example.androidtestproject.ui.main.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.androidtestproject.R;
import com.example.androidtestproject.data.repository.PopularMoviesRepository;
import com.example.androidtestproject.databinding.ActivityMainBinding;
import com.example.androidtestproject.ui.main.viewmodel.MainViewModel;
import com.example.androidtestproject.ui.main.viewmodel.PopularMoviesViewModel;
import com.example.androidtestproject.ui.main.viewmodel.PopularViewModelFactory;

import java.util.Observer;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    private MainViewModel mainViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainViewModel =new ViewModelProvider(this).get(MainViewModel.class);
        activityMainBinding.setMyModel(mainViewModel);
        activityMainBinding.setLifecycleOwner(this);
        mainViewModel.setMessgae();
        mainViewModel.setState();
        mainViewModel.message.observe(this,mess->{
            if(mess.getContentIfNotHandled()!=null){

            }

        });
        mainViewModel.inputEmail.observe(this,it->{
            mainViewModel.validate();
        });
        mainViewModel.inputPassword.observe(this,it->{
            mainViewModel.validate();
        });

       mainViewModel.isBtnEnabled.observe(this,enabled->{
          activityMainBinding.submitBtn.setEnabled(enabled);
       });
       activityMainBinding.submitBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               goToScreen2();
           }
       });




    }
    public void goToScreen2(){
        Intent intent = new Intent(MainActivity.this, PopularMovieListActivity.class);
        startActivity(intent);
    }
}