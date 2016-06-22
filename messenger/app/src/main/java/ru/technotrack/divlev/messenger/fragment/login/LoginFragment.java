package ru.technotrack.divlev.messenger.fragment.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import ru.technotrack.divlev.messenger.R;
import ru.technotrack.divlev.messenger.fragment.BaseFragment;

public class LoginFragment extends BaseFragment implements LoginView {
    private LoginPresenter presenter;
    private ProgressBar progressBar;
    private Button loginButton;
    private Button registerButton;
    private EditText login;
    private EditText password;

    public LoginFragment() {
        presenter = new LoginPresenterImpl(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        progressBar = (ProgressBar) findViewById(R.id.progress);
        loginButton = (Button) findViewById(R.id.loginButton);
        registerButton = (Button) findViewById(R.id.registerButton);
        login = (EditText) findViewById(R.id.loginText);
        password = (EditText) findViewById(R.id.passText);

        loginButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        presenter.validateCredentials(login.getText().toString(),
                                password.getText().toString());
                    }
                }
        );

        registerButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        presenter.openRegisterScreen();
                    }
                }
        );
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.login_fragment, container, false);
        return result;
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    private void showMessage(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void setUserNameError(String msg) {
        showMessage(msg);
    }

    @Override
    public void setPasswordError(String msg) {
        showMessage(msg);
    }

    @Override
    public void showConnectionError(String msg) {
        showMessage(msg);
    }
}
