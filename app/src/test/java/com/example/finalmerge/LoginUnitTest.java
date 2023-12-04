package com.example.finalmerge;

import static org.junit.Assert.assertEquals;

import android.text.Editable;
import android.widget.EditText;

import com.example.finalmerge.LoginPage.Login.LoginModel;
import com.example.finalmerge.LoginPage.Login.LoginView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(MockitoJUnitRunner.class)
public class LoginUnitTest {

    @Mock
    LoginModel model;

    @Mock
    LoginView view;

    @Mock
    EditText editText;

    @Mock
    Editable edit;

    @Test
    public void test(){
        assertEquals(2+2, 4);
    }

    /*
    @Test
    public void checkEmptyEmail(){

        when(view.getEmail()).thenReturn("");
        when(view.getPassword()).thenReturn("password");

        LoginPresenter presenter=new LoginPresenter(model, view);
        presenter.checkInput();
        verify(view).displayEmailError("Email cannot be empty");
    }

    @Test
    public void checkEmptyPassword(){
        when(view.getEmail()).thenReturn("email@email.com");
        when(view.getPassword()).thenReturn("");

        LoginPresenter presenter=new LoginPresenter(model, view);
        presenter.checkInput();
        verify(view).displayEmailError("Password cannot be empty");
    }

    @Test
    public void checkPasswordLength(){
        when(view.getEmail()).thenReturn("email@email.com");
        when(view.getPassword()).thenReturn("hello");

        LoginPresenter presenter=new LoginPresenter(model, view);
        presenter.checkInput();
        verify(view).displayEmailError("Password must be at least 6 characters");
    }

     */



}