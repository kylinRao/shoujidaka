package com.rao.shoujidaka;


import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.test.AndroidTestCase;

import org.junit.Test;

/**
 * Created by Administrator on 2018/4/5.
 */

public class TestCase extends AndroidTestCase {


    @Test
    public void test() {
        //getContext() 获取虚拟的上下文对象。
        SQLiteOpenHelper mydb = new MySQLDatabase(getContext());
        //oh.getReadableDatabase();
        //如果数据库不存在就创建数据库并获取可读可写的数据库对象，如果数据库存在就直接打开数据库。
        SQLiteDatabase db= mydb.getWritableDatabase();
        db.execSQL("insert into wx_user (id,name) values (1,'raoqilin')");
    }

}
