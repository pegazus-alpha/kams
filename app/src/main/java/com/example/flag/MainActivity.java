package com.example.flag;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TableLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private ImageButton menu;
    private NavigationView menuLay;
    private DrawerLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* ********************************LES ONGLETS************************** */
        TabLayout tableLayout=findViewById(R.id.barre);
        ViewPager viewPager=findViewById(R.id.viewpage);
        MonFragmentPagerAdapter adapter=new MonFragmentPagerAdapter(getSupportFragmentManager());
        Fragment onglet1=new Onglet1();
        Fragment onglet2=new Onglet2();
        Fragment onglet3=new Onglet3();
        Fragment onglet4=new Onglet4();
        MenuItem men4=findViewById(R.id.men4);
        MenuItem men1=findViewById(R.id.men1);
        adapter.ajouterFragment(onglet1,R.drawable.maison);
        adapter.ajouterFragment(onglet2,R.drawable.ampoule);
        adapter.ajouterFragment(onglet3,R.drawable.cours);
        adapter.ajouterFragment(onglet4,R.drawable.exercices);
        viewPager.setAdapter(adapter);
        tableLayout.setupWithViewPager(viewPager);
        tableLayout.getTabAt(0).setIcon(R.drawable.maison);
        tableLayout.getTabAt(1).setIcon(R.drawable.ampoule);
        tableLayout.getTabAt(2).setIcon(R.drawable.cours);
        tableLayout.getTabAt(3).setIcon(R.drawable.exercices);



        /* ****************************LE MENU ********************************* */
        menuLay=findViewById(R.id.menulay);

        menu=findViewById(R.id.menu);
        container=(DrawerLayout)findViewById(R.id.container);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                container.openDrawer(GravityCompat.START);
                Log.d("TAG","tu as cliqué");
            }
        });
        menuLay.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                container.closeDrawer(GravityCompat.START);
                int id=item.getItemId();
                if (id== R.id.men4){
                    Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://wa.me/+237696531290"));
                    startActivity(intent);
                    return true;
                }
                /*else if(id== R.id.men1){
                    Intent intent=new Intent(MainActivity.this,Profil.class);
                    startActivity(intent);
                    return true;
                }
                else if(id== R.id.men2){
                    Intent intent=new Intent(MainActivity.this,Param.class);
                    startActivity(intent);
                    return true;
                }
                else if(id== R.id.men3){
                    Intent intent=new Intent(MainActivity.this,Info.class);
                    startActivity(intent);
                    return true;
                }*/
                else if(id==R.id.men5){
                    Intent partage=new Intent(Intent.ACTION_SEND);
                    partage.setType("text/plain");
                    String lienApp="https://whatsapp.com/channel/0029VaEJh7WEgGfKGl7Fyd3j";
                    String message="Hey!!!!! rejoignez nous pour obtebir l'application:\n"+lienApp;
                    partage.putExtra(Intent.EXTRA_TEXT,message);
                    startActivity(Intent.createChooser(partage,"Partager via"));
                    return true;
                }
                else{
                    SharedPreferences sh=getSharedPreferences("MyPref",MODE_PRIVATE);
                    SharedPreferences.Editor ed=sh.edit();
                    ed.putBoolean("isLog",false);
                    ed.apply();
                    Intent intent=new Intent(MainActivity.this,Connect.class);
                    startActivity(intent);
                    finishAffinity();
                }
                return true;
            }
        });
        //menuLay.setVisibility(View.GONE);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appmenu,menu);
        return true;
    }

}

