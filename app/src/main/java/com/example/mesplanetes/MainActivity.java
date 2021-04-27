package com.example.mesplanetes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DetecteurDeClicSurRecycler{

    private RecyclerView mRecyclerView;
    private MonRecyclerViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    CoordinatorLayout mcoordinatorLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager=new LinearLayoutManager(this);
        /*((GridLayoutManager)mLayoutManager) .setSpanSizeLookup(
                new GridLayoutManager.SpanSizeLookup() {
                    @Override
                    public int getSpanSize(int arg0) {
                        return (arg0 % 3) == 0 ? 2 : 1;
                    }
                });*/
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MonRecyclerViewAdapter(getDataSource());
        mRecyclerView.setAdapter(mAdapter);
        mcoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
/*
        TextView titre = (TextView) findViewById(R.id.tv_principal);
        TextView sous = (TextView) findViewById(R.id.tv_auxiliaire);
        TextView vitesse = (TextView) findViewById(R.id.tv_vitesse);
        TextView taille = (TextView) findViewById(R.id.tv_taille);
// Create the TypeFace from the TTF asset
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/OliverBold.ttf");
        Typeface font2 = Typeface.createFromAsset(getAssets(), "fonts/OliverBold.ttf");
// Assign the typeface to the view
        titre.setTypeface(font);
        sous.setTypeface(font2);
        vitesse.setTypeface(font2);
        taille.setTypeface(font2);
*/



        /*RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(this, R.drawable.divider);
        mRecyclerView.addItemDecoration(itemDecoration);*/

    }

    private ArrayList<Planetes> getDataSource() {
        ArrayList listePlanetes = new ArrayList<Planetes>();
        //ArrayList listePlanetes= new ArrayList();
        listePlanetes.add (new Planetes("Mercure" ,"1st Planet","4 900 km", "200 m/s" ,R.drawable.mercure));
        listePlanetes.add (new Planetes("Vénus" ,"2nd Planet" ,"12 000 km", "653 m/s" ,R.drawable.venus));
        listePlanetes.add (new Planetes("Terre" ,"3rd Planet" ,"12 800 km", "327 m/s" ,R.drawable.earth));
        listePlanetes.add (new Planetes("Mars" ,"4th Planet" ,"6 800 km", "412 m/s" ,R.drawable.mars));
        listePlanetes.add (new Planetes("Jupiter" ,"5th Planet" ,"144 000 km", "784 m/s" ,R.drawable.jupiter));
        listePlanetes.add (new Planetes("Saturne" ,"6th Planet" ,"120 000 km", "358 m/s" ,R.drawable.saturne));
        listePlanetes.add (new Planetes("Uranus" ,"7th Planet" ,"52 000 km", "424 m/s" ,R.drawable.uranus));
        listePlanetes.add (new Planetes("Neptune" ,"8th Planet" ,"50 000 km", "320 m/s" ,R.drawable.neptune));
        listePlanetes.add (new Planetes("Pluton" ,"9th Planet" ,"2 300 km", "245 m/s" ,R.drawable.pluton));
        return listePlanetes;
    }


    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.setDetecteurDeClicSurRecycler(this);
    }


    public void clicSurRecyclerItem(int position, View v) {
        TextView titre= v.findViewById(R.id.tv_principal);
        Snackbar.make(mcoordinatorLayout, "La planète " + titre.getText(),Snackbar.LENGTH_LONG).show();
    }




}