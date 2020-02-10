package gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author themhz
 * @param <String>
 */
public abstract class ItemCountries implements Comparable{
    private String value;
    private String description;

    public ItemCountries(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public ItemCountries() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
            
    @Override
    public String toString(){
        
        return this.description;
    }
   
}
