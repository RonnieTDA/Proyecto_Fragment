package com.example.proyecto_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.proyecto_fragment.Fragments.*
import com.example.proyecto_fragment.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

   // esto es para hacer refrencia a los elementos de la vista por su id
   private lateinit var binding : ActivityMainBinding

   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

            binding = ActivityMainBinding.inflate(layoutInflater)
         setContentView(binding.root)

       // se declara la instancia de cada fragments
        val HomeFragment = HomeFragment()
        val BuscarFragment = BuscarFragment()
        val AgregarFragment = AgregarFragment()
        val ComentariosFragment = ComentariosFragment()
        val PerfilFragment = PerfilFragment()

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.btn_home ->{
                    setCurrentFragment(HomeFragment)
                    true
                }

                R.id.btn_buscar ->{
                    setCurrentFragment(BuscarFragment)
                    true
                }

                R.id.btn_agregar ->{
                    setCurrentFragment(AgregarFragment)
                    true
                }

                R.id.btn_comentarios ->{
                    setCurrentFragment(ComentariosFragment)
                    true
                }
                R.id.btn_perfil ->{
                    setCurrentFragment(PerfilFragment)
                    true
                }

                else -> false
            }
        }

    }



    private fun setCurrentFragment(fragment: Fragment){

        supportFragmentManager.beginTransaction().apply {
            replace( R.id.ContainerView,fragment)
            commit()
        }
    }
}