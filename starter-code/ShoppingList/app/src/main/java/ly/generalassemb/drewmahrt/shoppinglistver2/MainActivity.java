package ly.generalassemb.drewmahrt.shoppinglistver2;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import ly.generalassemb.drewmahrt.shoppinglistver2.setup.DBAssetHelper;
import ly.generalassemb.drewmahrt.shoppinglistver2.setup.ShoppingSQLiteHelper;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.shopping_list_view);

        DBAssetHelper dbSetup = new DBAssetHelper(MainActivity.this);
        dbSetup.getReadableDatabase();

        Cursor cursor = ShoppingSQLiteHelper.getInstance(MainActivity.this).getShoppingList();

        String[] columns = new String[]{"ITEM_NAME"};

        int[] viewNames = new int[]{android.R.id.text1};

        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(MainActivity.this, android.R.layout.simple_list_item_1, cursor, columns, viewNames, 0);

        listView.setAdapter(cursorAdapter);

    }
}
