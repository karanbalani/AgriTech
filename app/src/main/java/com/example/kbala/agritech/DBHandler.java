package com.example.kbala.agritech;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBHandler extends SQLiteOpenHelper {

    SQLiteDatabase db;
    Context context;
    DBHandler(Context context)
    {
        super(context,"machinedb",null,1);
        this.context = context;
        db = this.getReadableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table machine( pk int primary key, type text, district text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addMachine(Machine m)
    {
        ContentValues cv = new ContentValues();
        cv.put("type",m.getType());
        cv.put("district",m.getDistrict());
        long id = db.insert("machine",null,cv);
        
        if(id < 0)
        {
            Toast.makeText(context, "Add Machine Issue", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(context, "1 machine added", Toast.LENGTH_SHORT).show();
        }
    }

    public String viewMachine()
    {
        StringBuffer sb = new StringBuffer();
        Cursor cursor = db.query("machine",null,null,null,null,null,null);

        if(cursor.getCount()>0) {
            cursor.moveToFirst();

            do {
               String type = cursor.getString(1);
                String district = cursor.getString(2);
                sb.append(" Machine type : " + type + " \n " + " District : " + district + "\n");
            } while (cursor.moveToNext());
        }
        return sb.toString();
    }

    public void deleteMachine(Machine m)
    {
        long id = db.delete("machine","Type="+m.getType(),null);

        if( id <0 )
            Toast.makeText(context, "Delete Issue", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(context, " Record Deleted", Toast.LENGTH_SHORT).show();


    }

}
