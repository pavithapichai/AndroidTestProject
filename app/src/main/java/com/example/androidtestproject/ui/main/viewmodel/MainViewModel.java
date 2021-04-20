package com.example.androidtestproject.ui.main.viewmodel;

import android.util.Patterns;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidtestproject.utils.Event;



public class MainViewModel extends ViewModel  {

    public MutableLiveData<String> inputEmail = new MutableLiveData<>();
    public MutableLiveData<String> inputPassword = new MutableLiveData<>();
    public MutableLiveData<Boolean> isEnabled = new MutableLiveData<>(false);
    public LiveData<Boolean> isBtnEnabled = new LiveData<Boolean>() {};

    public MutableLiveData<Event<String>> statusMessage = new MutableLiveData<>();
    public LiveData<Event<String>> message = new LiveData<Event<String>>() {
    };

    public LiveData<Boolean> getState() {
        return isBtnEnabled;
    }

    public LiveData<Event<String>> getMessage() {
        return message;
    }
    public void setMessgae() {
        this.message = statusMessage;
    }
    public void setState() {
        this.isBtnEnabled = isEnabled;
    }


    public void validate() {
        String mail = inputEmail.getValue();
        String password = inputPassword.getValue();
        if (mail == null) {
            statusMessage.setValue(new Event("Please enter mail"));
        } else if (password == null) {
            statusMessage.setValue(new Event("Please enter password"));
        } else if (!Patterns.EMAIL_ADDRESS.matcher(mail).matches()) {
            statusMessage.setValue(new Event("Enter a correctmail address"));
        } else if (password.length() < 6) {
            statusMessage.setValue(new Event("Password must be 6 to 12 characters"));
        } else {
            statusMessage.setValue(new Event("Successfully Logged in"));
            isEnabled.setValue(true);
        }

    }
}
