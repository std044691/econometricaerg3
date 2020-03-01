/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package econometrica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import model.CountryData;

/**
 *
 * @author themhz
 */
public class Oil {
 
    private Integer id;
    private String dataset_code;
    private String database_code;
    private String name;
    private String description;
    private String refreshed_at;
    private Date newest_available_date;
    private Date oldest_available_date;
    private ArrayList<String> column_names;
    private String frequency;
    private String type;
    private Boolean premium;
    private String limit;
    private String transform;
    private String column_index;
    private Date start_date;
    private Date end_date;
    private ArrayList<ArrayList<String>> data;
    //private Collection<CountryData> data;
    
    private String collapse;
    private String order;
    private Integer database_id;
    
    public Oil() {}
    
    public String getCollapse() {
        return collapse;
    }

    public void setCollapse(String collapse) {
        this.collapse = collapse;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Integer getDatabase_id() {
        return database_id;
    }

    public void setDatabase_id(Integer database_id) {
        this.database_id = database_id;
    }
    
   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDataset_code() {
        return dataset_code;
    }

    public void setDataset_code(String dataset_code) {
        this.dataset_code = dataset_code;
    }

    public String getDatabase_code() {
        return database_code;
    }

    public void setDatabase_code(String database_code) {
        this.database_code = database_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRefreshed_at() {
        return refreshed_at;
    }

    public void setRefreshed_at(String refreshed_at) {
        this.refreshed_at = refreshed_at;
    }

    public Date getNewest_available_date() {
        return newest_available_date;
    }

    public void setNewest_available_date(Date newest_available_date) {
        this.newest_available_date = newest_available_date;
    }

    public Date getOldest_available_date() {
        return oldest_available_date;
    }

    public void setOldest_available_date(Date oldest_available_date) {
        this.oldest_available_date = oldest_available_date;
    }

    public ArrayList<String> getColumn_names() {
        return column_names;
    }

    public void setColumn_names(ArrayList<String> column_names) {
        this.column_names = column_names;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getPremium() {
        return premium;
    }

    public void setPremium(Boolean premium) {
        this.premium = premium;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getTransform() {
        return transform;
    }

    public void setTransform(String transform) {
        this.transform = transform;
    }

    public String getColumn_index() {
        return column_index;
    }

    public void setColumn_index(String column_index) {
        this.column_index = column_index;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public ArrayList<ArrayList<String>> getData() {
        return data;
    }
    
//    public Collection<CountryData> getData() {
//        return data;
//    }
    
//    public Collection<CountryData> getData() {
//        return data;
//    }    
        

    public void setData(ArrayList<ArrayList<String>> data) {
        this.data = data;
    }
//    public void setData(Collection<CountryData> data) {
//        this.data = data;
//    }
    
    
    
}
