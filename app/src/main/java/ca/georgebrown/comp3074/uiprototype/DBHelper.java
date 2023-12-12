package ca.georgebrown.comp3074.uiprototype;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    // Database version
    private static final int DATABASE_VERSION = 1;

    // Database name
    private static final String DATABASE_NAME = "Menu.db";

    // Table name
    private static final String TABLE_NAME = "MENU_TABLE";

    // Columns
    private static final String COLUMN_ID = "MENU_ID";
    private static final String COLUMN_CATEGORY = "MENU_CATEGORY";
    private static final String COLUMN_NAME = "MENU_NAME";
    private static final String COLUMN_PRICE = "MENU_PRICE";

    // Constructor
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_QUERY = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_CATEGORY + " TEXT,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_PRICE + " TEXT"
                + ")";
        db.execSQL(CREATE_TABLE_QUERY);
    }

    // Updating Database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if exists and recreate the table
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addOne(MenuModel menuModel){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_ID, menuModel.getId());
        cv.put(COLUMN_CATEGORY, menuModel.getCategory());
        cv.put(COLUMN_NAME, menuModel.getName());
        cv.put(COLUMN_PRICE, menuModel.getPrice());

        long insert = db.insert(TABLE_NAME,null,cv);
        if(insert == -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean deleteOne(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int deletedRows = db.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[] { String.valueOf(id) });
        db.close();
        return deletedRows > 0;
    }

    public List<MenuModel> getAllItems() {
        List<MenuModel> returnList = new ArrayList<>();

        String CREATE_TABLE_QUERY = "SELECT * FROM "+ TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

         Cursor cursor = db.rawQuery(CREATE_TABLE_QUERY,null);

         if(cursor.moveToFirst()){
             do{

                 int menuId = cursor.getInt(0);
                 String menuCategory = cursor.getString(1);
                 String menuName = cursor.getString(2);
                 int menuPrice = cursor.getInt(3);

                 MenuModel newItem = new MenuModel(menuId, menuCategory,menuName,menuPrice);
                 returnList.add(newItem);
             }while (cursor.moveToNext());


         }else{
             //nothing happens
         }

         //close cursor and db
        cursor.close();
        db.close();
        return returnList;
    }
}
