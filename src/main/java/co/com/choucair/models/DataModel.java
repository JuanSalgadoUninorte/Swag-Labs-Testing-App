package co.com.choucair.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataModel {

    private String user;

    private String infoName;
    private String infoLast;
    private String postal;


    private String password;
    private String lastName;
    private String name;
    private String postalCode;
    private String message;

    public String getInfoName() {
        return infoName;
    }

    public void setInfoName(String infoName) {
        this.infoName = infoName;
    }

    public String getInfoLast() {
        return infoLast;
    }

    public void setInfoLast(String infoLast) {
        this.infoLast = infoLast;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static List<DataModel> setData(DataTable dataTable) {
        List<DataModel> data = new ArrayList<>();
        List<Map<String, String>> mapIfo = dataTable.asMaps();
        for (Map<String, String> map : mapIfo) {
            data.add(new ObjectMapper().convertValue(map, DataModel.class));
        }
        return data;
    }

}
