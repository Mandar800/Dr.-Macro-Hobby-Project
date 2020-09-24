package org.tensorflow.lite.examples.classification;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB extends SQLiteOpenHelper {
    public static final String dbn="mydb";
    private static final int version = 1;

    public  DB(Context context){
        super(context,dbn,null, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table product (name text primary key, cal real, pro real, carb real, fat real, sug real , sfat real,  allergy text, rich text,veg INTEGER);  ";
        db.execSQL(sql);
        insertdata("ParleG",451,6,78,12,25,6,null,null,1,db);
        insertdata("Snickers",467,9,64,20,49,7.3f,"P","Calcium",1,db);
        insertdata("Amul Butter",722,0,0,80,0,51,null,null,1,db);
        insertdata("eggs",72,6,0.4f,5,0.2f,1.6f,null,"Protein",0,db);
        insertdata("nutella",546,6,57f,31,56f,11f,null,"Calcium & Iron",1,db);
        insertdata("Amul Dahi",62,4,4,3,1,1,"L","Calcium & Vitamin A",1,db);
        insertdata("Quaker Oats",374,11,60,8,1,1,null,"Dietary Fibre",1,db);
        insertdata("Kissan Ketchap",140,0.2f,35,0,32,0,null,null,1,db);
        insertdata("pickle",60,1,3,5,0,1,null,null,1,db);
        insertdata("lays",521,6.3f,52,33,0.3f,3.3f,null,null,1,db);



    }
    public void insertdata(String name, float cal, float pro, float carb, float fat, float sug , float sfat, String allergy, String rich,int veg,SQLiteDatabase database){
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("cal",cal);
        values.put("pro",pro);
        values.put("carb",carb);
        values.put("fat",fat);
        values.put("sug",sug);
        values.put("sfat",sfat);
        values.put("allergy",allergy);
        values.put("rich",rich);
        values.put("veg",veg);
        database.insert("product",null,values);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
