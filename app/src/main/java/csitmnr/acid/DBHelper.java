package csitmnr.acid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.widget.Toast;

import java.util.Enumeration;

/**
 * Created by Manoj Budha Ayer on 11/6/2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/database/";
    public static final String DB_NAME = "students.db";
    public static final String TABLE_NAME = "info";
    public static final String COL_1 = "id";
    public static final String COL_2 = "name";
    public static final String COL_3 = "grade";

    public DBHelper(Context context) //remove other three attributes of it

    {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String gry = "create table "+TABLE_NAME+" ("+COL_1+" integer primary key autoincrement,"+COL_2+" text not null,"+COL_3+" text );";
        sqLiteDatabase.execSQL(gry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+TABLE_NAME+";");
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String name,String grade){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(COL_2,name);
        cv.put(COL_3, grade);
        long result =  db.insert(TABLE_NAME,null,cv);
        if(result == -1){
           return false;
        }else {
            return true;
        }
    }
    public Cursor getAlldata(){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor result = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return result;
    }
    public void upDateData(String name,String grade,String id){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(COL_1,id);
        cv.put(COL_2,name);
        cv.put(COL_3,grade);

        db.update(TABLE_NAME,cv,"ID=?",new String[]{id});

    }
    public Integer deleteData(String id){
        SQLiteDatabase db =this.getWritableDatabase();
        Integer result = db.delete(TABLE_NAME,"ID=?",new String[]{id});
        return result;
    }
}
