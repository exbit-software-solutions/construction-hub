package hub.constructor.constructorhub;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {

                Intent intent = new Intent(MainActivity.this,SwitchActivity.class);
                startActivity(intent);

        } else if (id == R.id.nav_notifications) {
            Intent intent = new Intent(MainActivity.this,NotificationsActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_settings) {
            Intent intent = new Intent(MainActivity.this,SettingsActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_log_out) {

            AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this); //-------Main is name of the activity
            builder.setMessage("Do you want to exit?");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {

                    finish();
                    Intent i=new Intent();
                    i.putExtra("finish", true);
                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //----------------------------------- To clean up all activities
                    //startActivity(i);
                    finish();

                }
            });

            builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });

            AlertDialog alert=builder.create();
            alert.show();


        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_web) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse("http://www.constructorhub.com"));  //---------------------------------website name
            startActivity(intent);

        }
        else if (id == R.id.nav_feedback) {
            Intent intent = new Intent(MainActivity.this,FeedbackActivity.class);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    CardView products, watch, transaction, orders, chat;

    public void products(View view) {
        Intent intent = new Intent(MainActivity.this,ProductsActivity.class);
        startActivity(intent);
    }

    public void watch(View view) {
        Intent intent = new Intent(MainActivity.this,WatchActivity.class);
        startActivity(intent);
    }

    public void transaction(View view) {
        Intent intent = new Intent(MainActivity.this,TransactionsActivity.class);
        startActivity(intent);
    }

    public void orders(View view) {
        Intent intent = new Intent(MainActivity.this,OrdersActivity.class);
        startActivity(intent);
    }

    public void chat(View view) {
        Intent intent = new Intent(MainActivity.this,ChatActivity.class);
        startActivity(intent);
    }



}