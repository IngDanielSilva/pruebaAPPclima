package vox.com.retrofit.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vox.com.retrofit.Adapter.MyAdapter;
import vox.com.retrofit.R;

public class ListaActivity extends Activity {

    public List<String> names;
    private RecyclerView mRecyclerView;
    // Puede ser declarado como 'RecyclerView.Adapter' o como nuetra clase adaptador 'MyAdapter'
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        names = this.getAllNames();
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new MyAdapter(names, R.layout.recycler_view_item, new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String name, int position) {

                Intent star = new Intent(ListaActivity.this, ClimaCiudades.class);
                star.putExtra("country", name);
                startActivity(star);

            }
        });
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }

    private List<String> getAllNames() {
        return new ArrayList<String>() {{
            add("Paris, FR");
            add("Mexicali, MX");
            add("San Diego, US");
            add("Dallas, US");
            add("Sevilla, ES");
            add("Culiacan, MX");
            add("Monterrey, MX");
            add("Ensenada, MX");
            add("London, UK");
            add("Sao Paulo, BR");
        }};
    }

}
