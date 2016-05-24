package ru.technotrack.divlev.messenger.fragment.login;


public interface LoginLogic {

    interface OnLoginFinishedListener {
        void onUsernameError(String msg);

        void onPasswordError(String msg);

        void onConnectionError(String msg);
    }

    void login(String username, String password, OnLoginFinishedListener listener);

    void openRegisterScreen();
}

