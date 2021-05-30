package com.prueba.listas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val adaptador = Adaptador({
        clickListener -> showItemClick(clickListener)
    })

    val items : MutableList<String> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val items : MutableList<String> = mutableListOf()
        items.add("Prueba 1")
        items.add("Prueba 2")
        items.add("Prueba 3")*/

        //val  adaptador = Adaptador(items)


        val boton: Button = findViewById(R.id.button)


        boton.setOnClickListener{


            val t = "Prueba-"

            adaptador.addItem(t)

        }

        adaptador.setItems(items)

       /* val items : MutableList<String> = mutableListOf()
        items.add("Prueba 1")
        items.add("Prueba 2")
        items.add("Prueba 3")

        adaptador.setItems(items)*/


        lista.layoutManager = LinearLayoutManager(this)
        lista.adapter = adaptador
    }

    fun showItemClick(position:Int){
        val item = adaptador.getItem(position)
        Toast.makeText(this, item, Toast.LENGTH_SHORT).show()
        items.remove(item)
        adaptador.setItems(items)
    }


    fun onItemLongClicked(position:Int){

        adaptador.reload(adaptador.getItem(position).toInt(),"Actualizando")
    }

}