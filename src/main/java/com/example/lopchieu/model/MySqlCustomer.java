package com.example.lopchieu.model;

import com.example.lopchieu.entity.Customer;
import com.example.lopchieu.urtil.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class MySqlCustomer implements CustomerModel {

    @Override
    public Customer save(Customer customer) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "insert into customers " +
                    "(Id, Name, phone, Image, dob, createdAt, updatedAt, status) " +
                    "values " +
                    "(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, customer.getId());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getPhone());
            preparedStatement.setString(4, customer.getImage());
            preparedStatement.setString(5, customer.getDob().toString());
            preparedStatement.setString(6, customer.getCreateAt().toString());
            preparedStatement.setString(7, customer.getUpdateAt().toString());
            preparedStatement.setInt(8, customer.getStatus());
            System.out.println("Connection success!");
            preparedStatement.execute();
            return customer;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> list = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from customer where status = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, 1);
            System.out.println("Connection success!");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int Id = resultSet.getInt("Id");
                String Name = resultSet.getString("Name");
                String phone = resultSet.getString("phone");
                String Image = resultSet.getString("Image");
                LocalDateTime dob =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("dob").toInstant(), ZoneId.systemDefault());
                LocalDateTime CreatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime UpdatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int status = resultSet.getInt("status");
                Customer customer = new Customer(Id, Name, phone, Image, dob, CreatedAt, UpdatedAt, status);
                list.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Customer findById(int Id) {
        Customer customer = null;
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from customers where status = ? and Id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, 1);
            preparedStatement.setInt(2, Id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                String Name = resultSet.getString("Name");
                String phone = resultSet.getString("phone");
                String Imager = resultSet.getString("Imager");
                LocalDateTime dob =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("dob").toInstant(), ZoneId.systemDefault());
                LocalDateTime CreatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime UpdatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int status = resultSet.getInt("status");
                customer = new Customer(Id, Name, phone, Imager, dob, CreatedAt, UpdatedAt, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public Customer update(int Id, Customer updateCustomer) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update customers " +
                    "set Id = ?, Name = ?, phone = ?, Image = ?, dob = ?, createdAt = ?, updatedAt = ?, status = ? where  Id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, updateCustomer.getId());
            preparedStatement.setString(2, updateCustomer.getName());
            preparedStatement.setString(3, updateCustomer.getPhone());
            preparedStatement.setString(4, updateCustomer.getImage());
            preparedStatement.setString(5, updateCustomer.getDob().toString());
            preparedStatement.setString(6, updateCustomer.getCreateAt().toString());
            preparedStatement.setString(7, updateCustomer.getUpdateAt().toString());
            preparedStatement.setInt(8, updateCustomer.getStatus());
            preparedStatement.setInt(9, Id);
            System.out.println("Connection success!");
            preparedStatement.execute();
            return updateCustomer;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(int Id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update customers " +
                    "set status = ? where Id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, -1);
            preparedStatement.setInt(2, Id);
            System.out.println("Connection success!");
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
