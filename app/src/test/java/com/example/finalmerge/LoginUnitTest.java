package com.example.finalmerge;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.finalmerge.LoginPage.Login.LoginModel;
import com.example.finalmerge.LoginPage.Login.LoginPresenter;
import com.example.finalmerge.LoginPage.Login.LoginView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
@RunWith(MockitoJUnitRunner.class)
public class LoginUnitTest {

    @Mock
    LoginModel model;
    @Mock
    LoginView view;

    @Test
    public void checkEmptyEmail(){
        when(view.getEmail()).thenReturn("");
        when(view.getPassword()).thenReturn("password");
        LoginPresenter presenter = new LoginPresenter(model,view);

        presenter.checkInput();

        verify(view).displayError("Email cannot be empty");
    }
    @Test
    public void checkEmptyPassword(){
        when(view.getEmail()).thenReturn("admin@utoronto.ca");
        when(view.getPassword()).thenReturn("");
        LoginPresenter presenter = new LoginPresenter(model,view);

        presenter.checkInput();

        verify(view).displayError("Password cannot be empty");
    }
    
    @Test
    public void checkPasswordLength(){
        when(view.getEmail()).thenReturn("student@mail.utoronto.ca");
        when(view.getPassword()).thenReturn("pass1");
        LoginPresenter presenter = new LoginPresenter(model,view);

        presenter.checkInput();

        verify(view).displayError("Password must be at least 6 characters");
    }

    @Test
    public void checkMultiEmptyInputMessages(){
        when(view.getEmail()).thenReturn("");
        when(view.getPassword()).thenReturn("");
        LoginPresenter presenter = new LoginPresenter(model,view);

        presenter.checkInput();

        verify(view).displayError("Email cannot be empty");
        verify(view).displayError("Password cannot be empty");
    }

    @Test
    public void checkLoginAttempt(){
        when(view.getEmail()).thenReturn("student@mail.utoronto.ca");
        when(view.getPassword()).thenReturn("password");
        LoginPresenter presenter = new LoginPresenter(model,view);

        presenter.checkInput();

        verify(model).signInWithEmailAndPassword(view.getEmail(), view.getPassword(), presenter);
    }

    @Test
    public void checkStudentLoginSuccess(){
        LoginPresenter presenter = new LoginPresenter(model,view);

        presenter.onLoginSuccess(0);

        verify(view).buildLoginSuccess("Student Login Successful");
    }

    @Test
    public void checkAdminLoginSuccess(){
        LoginPresenter presenter = new LoginPresenter(model,view);

        presenter.onLoginSuccess(1);

        verify(view).buildLoginSuccess("Admin Login Successful");
    }

    @Test
    public void checkLoginDBError(){
        LoginPresenter presenter = new LoginPresenter(model,view);

        presenter.onLoginSuccess(2);

        verify(view).displayError("Please try again");
    }

    @Test
    public void checkLoginInfoNotFound(){
        LoginPresenter presenter = new LoginPresenter(model,view);

        presenter.onLoginError("Email or password is incorrect");

        verify(view).displayError("Email or password is incorrect");
    }

    @Test
    public void checkStudentRegisterClick(){
        LoginPresenter presenter = new LoginPresenter(model,view);

        presenter.onStudentRegisterClick();

        verify(view).navigateToStudentRegister();
    }

    @Test
    public void checkAdminRegisterClick(){
        LoginPresenter presenter = new LoginPresenter(model,view);

        presenter.onAdminRegisterClick();

        verify(view).navigateToAdminRegister();
    }

    @Test
    public void checkProgressBarHide(){
        LoginPresenter presenter = new LoginPresenter(model,view);

        presenter.hideProgressBar();

        verify(view).hideProgressBar();
    }

    @Test
    public void checkProgressBarDisplay(){
        LoginPresenter presenter = new LoginPresenter(model,view);

        presenter.displayProgressBar();

        verify(view).displayProgressBar();
    }

}