package com.example.salaraycalculation;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DatabaseHelper extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "employee.db";
    public static final String TABLE_NAME = "employee_table";
    public static final String COL_1 = "Name";
    public static final String COL_2 = "ID";
    public static final String COL_3 = "Mobile_NUMBER";
    public static final String COL_4 = "Email";
    public static final String COL_5 = "Basic_Salary";
    public static final String COL_6 = "Other_Benifits";
    public static final String COL_7 = "Total_Salary";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT, Mobile_NUMBER INTEGER,Email TEXT,Basic_Salary DOUBLE, Other_Benifits DOUBLE, Total_Salary DOUBLE)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
    public boolean Add(String name, Integer mnum, String email, Double bsal,Double ob,Double tsal)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,mnum);
        contentValues.put(COL_4,email);
        contentValues.put(COL_4,bsal);
        contentValues.put(COL_4,ob);
        contentValues.put(COL_4,tsal);

        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public Cursor ViewAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
    public boolean Update(Integer id, String name, Integer mnum, String email, Double bsal,Double ob,Double tsal)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,mnum);
        contentValues.put(COL_4,email);
        contentValues.put(COL_4,bsal);
        contentValues.put(COL_4,ob);
        contentValues.put(COL_4,tsal);

        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { "id" });
        return true;
    }
    public Integer Delete(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
    }
}
