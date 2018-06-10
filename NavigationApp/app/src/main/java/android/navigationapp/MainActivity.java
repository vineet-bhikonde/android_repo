package android.navigationapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawerLayout);
        mToggle=new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView=(NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id=item.getItemId();

        if(id == R.id.my_account){
            Intent intent=new Intent(MainActivity.this,my_account.class);
            startActivity(intent);
            Toast.makeText(this,"This is my Account", Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.settings){
            Intent intent=new Intent(MainActivity.this,settings.class);
            startActivity(intent);
            Toast.makeText(this,"This is Settings",Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.logout){
            Intent intent=new Intent(MainActivity.this,logout.class);
            startActivity(intent);
            Toast.makeText(this,"Logged Out",Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}
