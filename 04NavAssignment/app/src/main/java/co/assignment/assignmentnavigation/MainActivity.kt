package co.assignment.assignmentnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import co.assignment.assignmentnavigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Music())

        binding.bottomNavigationView.setOnItemSelectedListener{

            when(it.itemId){

                R.id.music -> replaceFragment(Music())
                R.id.online -> replaceFragment(Online())
                R.id.search -> replaceFragment(Search())
                R.id.watch -> replaceFragment(Watch())

                else -> {

                }

            }

            true
        }

    }

    private fun replaceFragment(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()

    }

}