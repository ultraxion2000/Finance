package com.dorrrke.finanseproject.presentation

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.dorrrke.finanseproject.R
import com.dorrrke.finanseproject.data.adapters.MainPageRecyclerAdapter
import com.dorrrke.finanseproject.data.db.AppDatabase
import com.dorrrke.finanseproject.data.dbModels.PlanModel
import com.dorrrke.finanseproject.presentation.fragments.*
import com.dorrrke.finanseproject.presentation.fragments.TableFragment.Companion.newInstance
import com.dorrrke.finanseproject.presentation.viewmodels.MainViewModel
import io.reactivex.Completable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_login.*


class MainActivity : AppCompatActivity() {

    lateinit var db: AppDatabase


    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportFragmentManager.beginTransaction().replace(R.id.place_holder, MainFragment())
            .commit()


        db = AppDatabase.getAppDatabase(applicationContext)!!
//        db = Room.databaseBuilder(
//            applicationContext,
//            AppDatabase::class.java, "Chanse1"
//        ).build()


        //loadDb().subscribeOn(Schedulers.newThread())
        //.subscribe()


        //testList()

        //val recycler: RecyclerView = findViewById(R.id.recycler)
        //recycler.layoutManager = LinearLayoutManager(this)
        // recycler.adapter = MainPageRecyclerAdapter(db.plans().getAll())

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.nav_Menu -> {
                Toast.makeText(this, "Главное меню", Toast.LENGTH_SHORT).show()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.place_holder, MainFragment.newInstance())
                    .commit()
                item.isChecked = true
                true
            }
            R.id.nav_Create -> {

                Toast.makeText(this, "Создание плана", Toast.LENGTH_SHORT).show()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.place_holder, CreatePlanFragment())
                    .commit()
                item.isChecked = true
                return true

            }
//            R.id.nav_Edit -> {
//                Toast.makeText(this, "Редактирование плана", Toast.LENGTH_SHORT).show()
//                supportFragmentManager
//                    .beginTransaction()
//                    .replace(R.id.place_holder, EditFragment.newInstance())
//                    .commit()
//                item.isChecked = true
//                return true
//            }
            R.id.nav_Family -> {
                Toast.makeText(
                    this,
                    "Семейный план пока в разработке! Функционал будет добавлен в следующем обновлении.",
                    Toast.LENGTH_SHORT
                ).show()
//                supportFragmentManager
//                    .beginTransaction()
//                    .replace(R.id.place_holder, FamilyFragment.newInstance())
//                    .commit()
//                item.isChecked = true
                item.isEnabled = false
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
