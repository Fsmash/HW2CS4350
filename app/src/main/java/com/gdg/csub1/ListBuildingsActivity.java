package com.gdg.csub1;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
//import android.widget.Toast;
//import android.widget.Toast;
import android.view.View;

public class ListBuildingsActivity extends ListActivity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
    	// Called when the activity is first created.
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.listbuildings);
        Csub1Activity.places = getResources().getStringArray(R.array.campus_buildings);
        String[] dll = getResources().getStringArray(R.array.campus_dlatlon);
    	int len = dll.length;
		Csub1Activity.dlatlon = new double[len];
		len = len / 2;
		//Toast.makeText(getBaseContext(), "Len: " + len, Toast.LENGTH_SHORT).show();
		//Toast.makeText(getBaseContext(), "sd[0]: " + dll[0], Toast.LENGTH_SHORT).show();
		//Toast.makeText(getBaseContext(), "sd[1]: " + dll[1], Toast.LENGTH_SHORT).show();
		//move decimal point of all lat/lon...
		for (int i=0; i<len; i++) {
			Csub1Activity.dlatlon[i*2]   = Double.valueOf(dll[i*2]);
			Csub1Activity.dlatlon[i*2+1] = Double.valueOf(dll[i*2+1]);
		}
		setListAdapter(new ArrayAdapter<String>(this, R.layout.main2, Csub1Activity.places));
		ListView listView = getListView();
		listView.setTextFilterEnabled(true);
    }

    @Override
	public void onListItemClick(ListView parent, View view, int position, long id) {
	    //Jump to CompassActivity!
	    Intent intent = new Intent(); 
	    intent.setClass(getApplicationContext(), CompassActivity.class);
	    Csub1Activity.currentSelection = position;
		startActivity(intent); 
	}
}
