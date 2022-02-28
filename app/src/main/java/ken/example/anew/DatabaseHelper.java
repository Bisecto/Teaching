package ken.example.anew;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String dbname= "CONTACT.db";
    public static final int dbVersion= 1;
    public static final String Tablename= "CONTACTS";

    public DatabaseHelper(@Nullable Context context) {
        super(context, dbname, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "Create TABLE If not EXISTS " +Tablename+"(id INTEGER primary key AUTOINCREMENT, firstname TEXT, lastname TEXT, phone Text, email TEXT UNIQUE, about TEXT )" ;
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS "+ Tablename);
    onCreate(db);
    }


    public boolean Insert(String firstname,String lastname,String phone,String email,String about) {
        SQLiteDatabase db = getReadableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("firstname", firstname);
        contentValues.put("lastname",lastname);
        contentValues.put("phone",phone);
        contentValues.put("email",email);
        contentValues.put("about",about);
        long i = db.insert(Tablename,null,contentValues);
        if (i>0){
            return true;
        } else {
            return false;
        }
        //return super.equals(obj);
    }
    public Cursor ReadData(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from "+Tablename+" ORDER by id", new String[] {});
        return  cursor;
    }
    public Integer DeleteRow(String Email){
    SQLiteDatabase db = getReadableDatabase();

        return db.delete(Tablename,"Email=?", new String[]{Email} );
}
    public boolean UpdateRow(String id, String firstname, String lastname, String phone, String email, String about){
        SQLiteDatabase db = getReadableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("firstname", firstname);
        contentValues.put("lastname",lastname);
        contentValues.put("phone",phone);
        contentValues.put("email",email);
        contentValues.put("about",about);


        long i = db.update(Tablename,contentValues, "id=?", new String [] {id} );
        if (i==-1){
            return false;
        } else {
            return true;
        }
}


//    public boolean DeleteRo(String firstname){
//        SQLiteDatabase db = getWritableDatabase();
//        Cursor cursor =db.rawQuery("SELECT * FROM "+Tablename+" WHERE ID = ? ", new String [] {firstname});
//        if (cursor.getCount()>0){
//
//            long i = db.delete(Tablename, "id=?", new String [] {firstname} );
//            if (i==-1){
//                return false;
//            } else {
//                return true;
//            }
//
//        } else {
//            return false;
//        }
//    }
//    public Cursor returndata(){
//        SQLiteDatabase db = getWritableDatabase();
//        Cursor cursor =db.rawQuery("SELECT * FROM "+Tablename+" WHERE ID = ? ",null);
//        return cursor;
//    }
}
