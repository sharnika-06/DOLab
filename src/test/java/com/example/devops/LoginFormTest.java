package com.example.devops;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginFormTest {

    @Test
    public void testValidAuthentication() {
        LoginForm form = new LoginForm("admin", "secret123");
        
        assertEquals("admin", form.getUsername());
        assertEquals("secret123", form.getPassword());
        assertTrue(form.isValid(), "Form should be valid with non-empty credentials");
    }

    @Test
    public void testEmptyUsernameAuthentication() {
        LoginForm form = new LoginForm("", "secret123");
        
        assertFalse(form.isValid(), "Form should be invalid with empty username");
    }

    @Test
    public void testEmptyPasswordAuthentication() {
        LoginForm form = new LoginForm("admin", " ");
        
        assertFalse(form.isValid(), "Form should be invalid with blank password");
    }

    @Test
    public void testNullCredentialsAuthentication() {
        LoginForm form = new LoginForm(null, null);
        
        assertFalse(form.isValid(), "Form should be invalid with null credentials");
    }

    @Test
    public void testSetters() {
        LoginForm form = new LoginForm();
        form.setUsername("user1");
        form.setPassword("pass1");

        assertEquals("user1", form.getUsername());
        assertEquals("pass1", form.getPassword());
        assertTrue(form.isValid());
    }
}
