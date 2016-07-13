package ly.generalassemb.drewmahrt.shoppinglistver2.setup;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jamesrondina on 7/13/16.
 */
public class ShoppingSQLiteHelper extends SQLiteOpenHelper {

    private static ShoppingSQLiteHelper instance;

    public static final String DATABASE_NAME = "SHOPPING_DB";
    private static final int DATABASE_VERSION = 7;

    public static final String TABLE_NAME = "SHOPPING_LIST";
    public static final String COL_ID = "_id";
    public static final String COL_ITEM_NAME = "ITEM_NAME";
    public static final String COL_DESCRIPTION = "DESCRIPTION";
    public static final String COL_PRICE = "PRICE";
    public static final String COL_TYPE = "TYPE";

    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
            COL_ID + "INTEGER PRIMARY KEY, " +
            COL_ITEM_NAME + "NAME," +
            COL_DESCRIPTION  + "TEXT," +
            COL_PRICE + "TEXT," +
            COL_TYPE + "TEXT)";


    public ShoppingSQLiteHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS SHOPPING_LIST");

        this.onCreate(db);
    }

    public static ShoppingSQLiteHelper getInstance(Context context){
        if (instance == null) {
            instance = new ShoppingSQLiteHelper(context);
        }
        return instance;
    }

    public Cursor getShoppingList(){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME,null,null,null,null,null,null,null);

        return cursor;
    }
}
