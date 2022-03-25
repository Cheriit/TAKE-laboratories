/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.take.PrimeFaces.view.backing;

import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author cherit
 */
@Named(value = "formBean")
@RequestScoped
public class FormBean {

    private int number0;
    private int number1;
    private Date date;
    private int sum;
    
    /**
     * Creates a new instance of FormBean
     */
    public FormBean() {
        this.date = new Date();
    }

    /**
     * @return the number0
     */
    public int getNumber0() {
        return number0;
    }

    /**
     * @param number0 the number0 to set
     */
    public void setNumber0(int number0) {
        this.number0 = number0;
    }

    /**
     * @return the number1
     */
    public int getNumber1() {
        return number1;
    }

    /**
     * @param number1 the number1 to set
     */
    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }
    
    public void add() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.renderResponse();
        setSum(getNumber0() + getNumber1());
        FacesContext.getCurrentInstance().addMessage(null, 
            new FacesMessage(
                    String.format("%d + %d = %d", number0, number1, sum)
            ));

    }

    /**
     * @return the sum
     */
    public int getSum() {
        return sum;
    }

    /**
     * @param sum the sum to set
     */
    public void setSum(int sum) {
        this.sum = sum;
    }
}
