package com.example.peluchitosenterprise.ui.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.peluchitosenterprise.R
import com.example.peluchitosenterprise.comunicador
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    var interfaz: comunicador?= null

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        view.btagregar.setOnClickListener {
            var id = view.etaid.text.toString()
            var nombre = view.etanombre.text.toString()
            var cantidad = view.etacantidad.text.toString()
            var precio = view.etaprecio.text.toString()

            view.tvagregar.text="Id: " + id + "\nNombre: " + nombre + "\nCantidad: " + cantidad + "\nPrecio: " + precio
            interfaz?.enviarDatos(id,nombre,cantidad,precio,"0")

            view.etaid.text.clear()
            view.etanombre.text.clear()
            view.etacantidad.text.clear()
            view.etaprecio.text.clear()
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try{
            interfaz=context!! as comunicador
        } catch (e: ClassCastException){
            Log.d("exception",e.toString())
        }
    }
}