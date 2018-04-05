package com.rao.shoujidaka;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/4.
 */

public class MySQLDatabase extends SQLiteOpenHelper {

    private static final String db_name = "myDatabse";//自定义的数据库名；
    private static final int version =2;//版本号


    public MySQLDatabase(Context context) {
        super(context, db_name, null, version);

    }
    //该方法会自动调用，首先系统会检查该程序中是否存在数据库名为‘myDatabase’的数据库，如果存在则不会执行该方法，如果不存在则会执行该方法。
    @Override
    public void onCreate(SQLiteDatabase arg0) {
        String  sql ="create table wx_user(" +
                "status int," +
                "rentName varchar(30)," +
                "rentPhone varchar(30)," +

                "rentTime DATETIME DEFAULT (  datetime( 'now', 'localtime' )   )," +
                "returnName varchar(50)," +
                "returnPhone varchar(50)," +

                "returnTime DATETIME "+
                ")";
        arg0.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub

    }
    public static boolean isPhoneRented(SQLiteDatabase sqlDatabase){
        Cursor cusor = sqlDatabase.rawQuery("select rowid from wx_user where status = 1",null);
        while (cusor.moveToNext()){
            return true;
        }
        return false;
    }
    public static Map getPhoneRenter(SQLiteDatabase sqlDatabase){
        Cursor cusor = sqlDatabase.rawQuery("select * from wx_user where status = 1",null);
        Map map=new HashMap();
        while (cusor.moveToNext()){

            map.put("rentName",cusor.getString(cusor.getColumnIndex("rentName")));
            map.put("rentPhone",cusor.getString(cusor.getColumnIndex("rentPhone")));
            Log.d("-----------map:",map.toString());

        }
        return map;
    }
    public static void getPhoneData(SQLiteDatabase sqlDatabase){



        Cursor cusor = sqlDatabase.rawQuery("select rowid,* from wx_user",null);
        while (cusor.moveToNext()) {
            String id = cusor.getString(cusor.getColumnIndex("rowid"));
            String rentName = cusor.getString(cusor.getColumnIndex("rentName"));
            String rentPhone = cusor.getString(cusor.getColumnIndex("rentPhone"));
            String rentTime = cusor.getString(cusor.getColumnIndex("rentTime"));

            String returnName = cusor.getString(cusor.getColumnIndex("returnName"));
            String returnPhone = cusor.getString(cusor.getColumnIndex("returnPhone"));
            String returnTime = cusor.getString(cusor.getColumnIndex("returnTime"));
            String status = cusor.getString(cusor.getColumnIndex("status"));
            if (status.equals("1")){
                Log.d("db","当前手机处于借出状态，status:"+status);
            }else{
                Log.d("db","当前手机处于归还在库状态，status:"+status);
            }

            Log.d("db","【谁借的】rentName:"+rentName+",rentPhone:"+rentPhone+",rentTime:"+rentTime);
            Log.d("db","【谁还的】returnName:"+returnName+",returnPhone:"+returnPhone+",returnTime:"+returnTime);


        }


    }

//    public static void main(String[] args){
//        SQLiteOpenHelper mydb = new MySQLDatabase(this);
//
//
//
//    }


}
