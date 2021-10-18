package com.code.lahiri.basicbankingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.code.lahiri.basicbankingapp.Models.CustomersModel;
import com.code.lahiri.basicbankingapp.Models.Main_Models;
import com.code.lahiri.basicbankingapp.Models.TransactionsModel;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "bank.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Customers ( " +
                "id INTEGER ," +
                "Name TEXT," +
                "Email Text," +
                "Address Text," +
                "Balance Integer," +
                "Photo TEXT," +
                "Phone INTEGER," +
                "PRIMARY KEY (id) )");

        db.execSQL("create table Transfer ( " +
                "id INTEGER ," +
                "Sender TEXT," +
                "Receiver Text," +
                "Amount Text," +
                "PRIMARY KEY (id) )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists Transfer");
        db.execSQL("drop Table if exists Customers");

    }

    public boolean insertData(String sender, String receiver, String amount) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Receiver", receiver);
        contentValues.put("Sender", sender);
        contentValues.put("Amount", amount);
        long result = db.insert("Transfer", null, contentValues);
        if (result == -1) return false;
        else return true;
    }

    public boolean insertDataCustomer(String name, String email, String address, int bal, String photo, int phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", name);
        contentValues.put("Email", email);
        contentValues.put("Address", address);
        contentValues.put("Balance", bal);
        contentValues.put("Balance", bal);
        contentValues.put("Photo", photo);
        contentValues.put("Phone", phone);
        long result = db.insert("Customers", null, contentValues);
        if (result == -1) return false;
        else {
            System.out.println("Data inserted successfully");
            return true;
        }
    }

    public boolean updateData(String name, String status, int amount) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        Cursor c = db.rawQuery("select Balance from Customers where Name = ?", new String[]{name});
        if (c.moveToFirst()) {
            int balance = c.getInt(0);
            c.close();
            if (status.equals("S")) {
                contentValues.put("Balance", balance - amount);
            } else if (status.equals("R")) {
                contentValues.put("Balance", balance + amount);
            }
            Cursor cursor = db.rawQuery("Select * from Customers where  Name = ? ", new String[]{name});
            if (cursor.getCount() > 0) {
                long result = db.update("Customers", contentValues, "name=?", new String[]{name});
                db.close();
                cursor.close();
                if (result == -1) {
                    return false;
                } else {
                    return true;
                }
            } else {
                db.close();
                cursor.close();
                return false;
            }
        }
        return false;
    }

    public boolean updateCustomerEmail(String email, String name, int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Email", email);
        Cursor cursor = db.rawQuery("Select * from Customers where  Name = ? ", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = db.update("Customers", contentValues, "name=?", new String[]{name});
            db.close();
            cursor.close();
            if (result == -1) return false;
            else return true;
        } else return false;
    }

    public ArrayList<CustomersModel> readCustomers() {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<CustomersModel> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("Select * from Customers", null);
        while (cursor.moveToNext()) {
            list.add(new CustomersModel
                    (R.drawable.people1, cursor.getString(1), cursor.getInt(6) + "", cursor.getString(2),
                            cursor.getString(3), cursor.getString(4)));

        }

        cursor.close();
        db.close();
        return list;
    }

    public ArrayList<CustomersModel> readPeopleByName(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<CustomersModel> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("Select * from Customers where Name = ?", new String[]{name});
        if (cursor.moveToFirst()) {
            list.add(new CustomersModel
                    (R.drawable.people1, cursor.getString(1), cursor.getInt(6) + "", cursor.getString(2),
                            cursor.getString(3), cursor.getString(4)));
        }
        cursor.close();
        db.close();
        return list;
    }

    public ArrayList<Main_Models> readCustomersPicName() {
        ArrayList<Main_Models> list = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<String> names = new ArrayList<>();
        Cursor cursor = db.rawQuery("Select Name from Customers", null);
        while (cursor.moveToNext()) {
            list.add(new Main_Models(R.drawable.people1, cursor.getString(0)));
        }
        cursor.close();
        db.close();
        return list;
    }

    public ArrayList<String> getCustomerNames() {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<String> names = new ArrayList<>();
        Cursor cursor = db.rawQuery("Select Name from Customers", null);
        while (cursor.moveToNext()) {
            names.add(cursor.getString(0));
        }
        cursor.close();
        db.close();
        return names;
    }

    public ArrayList<TransactionsModel> readTrans() {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<TransactionsModel> trans = new ArrayList<>();
        Cursor cursor = db.rawQuery("Select Sender , Receiver , Amount from Transfer  ", null);
        while (cursor.moveToNext()) {
            trans.add(new TransactionsModel(cursor.getString(0), cursor.getString(1), cursor.getString(2)));
        }
        db.close();
        cursor.close();
        return trans;
    }


}
