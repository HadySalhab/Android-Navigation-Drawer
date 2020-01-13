package com.android.drawerandtab



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener {


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_message -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container,MessageFragment()).commit()
            }
            R.id.nav_chat -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container,ChatFragment()).commit()
            }
            R.id.nav_profile -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container,ProfileFragment()).commit()
            }
            R.id.nav_share-> {
                Toast.makeText(this,"Share",Toast.LENGTH_SHORT).show()
            }
            R.id.nav_send-> {
                Toast.makeText(this,"Send",Toast.LENGTH_SHORT).show()
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private lateinit var drawerLayout:DrawerLayout
    private lateinit var navigationView:NavigationView

private lateinit var toolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        navigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener (this)

        drawerLayout = findViewById(R.id.drawer_layout)

        val toggle = ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        if(savedInstanceState==null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, MessageFragment()).commit()
        }
navigationView.setCheckedItem(R.id.nav_message)
    }


    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
