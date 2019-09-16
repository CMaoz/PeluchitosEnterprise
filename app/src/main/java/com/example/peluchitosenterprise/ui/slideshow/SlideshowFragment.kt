package com.example.peluchitosenterprise.ui.slideshow

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
import com.example.peluchitosenterprise.User
import com.example.peluchitosenterprise.comunicador
import kotlinx.android.synthetic.main.fragment_slideshow.view.*

class SlideshowFragment : Fragment() {

    var interfaz: comunicador?= null

    private lateinit var slideshowViewModel: SlideshowViewModel

    private lateinit var user: User
    var listUser: ArrayList<User> = ArrayList()
    private  var peluche = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        val view = inflater.inflate(R.layout.fragment_slideshow, container, false)



        view.bteliminar.setOnClickListener {
            var id = view.eteid.text.toString()
            var nombre = view.etenombre.text.toString()

            if (arguments != null) {
                listUser = arguments!!.getParcelableArrayList(ARG_PARAM)!!
                var listUser2 = listUser
                var i = 0
                for (user in listUser) {

                    if (id == user.id) {
                        listUser2= listUser.filterIndexed { index, user ->  index !=i } as ArrayList<User>
                        peluche =  "Id: " + user.id  + "\nNombre: " + user.nombre + "\nCantidad: " + user.cantidad + "\nPrecio: " + user.precio
                    }

                    if (nombre == user.nombre) {
                        listUser2= listUser.filterIndexed { index, user ->  index !=i } as ArrayList<User>
                        peluche =  "Id: " + user.id  + "\nNombre: " + user.nombre + "\nCantidad: " + user.cantidad + "\nPrecio: " + user.precio
                    }
                    i+=1
                }
                view.tveliminar.text = "Eliminado...\n\n" + peluche
                peluche=""

                interfaz?.enviarDatos("1","1", "1","1","1")

                for (user in listUser2) {


                    peluche = peluche + user.id + user.nombre + user.cantidad + user.precio + "\n"
                    var cid=user.id.toString()
                    var cnombre=user.nombre.toString()
                    var ccantidad=user.cantidad.toString()
                    var cprecio=user.precio.toString()
                    interfaz?.enviarDatos(cid,cnombre,ccantidad,cprecio ,"0")

                }

            }
            else {
                view.tveliminar.text = "La lista se encuentra vacia"
            }
            view.eteid.text.clear()
            view.etenombre.text.clear()
        }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context!!)
        try{
            interfaz=context as comunicador
            Log.d("exception","entro")
        } catch (e: ClassCastException){
            Log.d("exception",e.toString())
        }
    }

    companion object{
        private val ARG_PARAM = "MyObject"

        fun newInstance(userList: ArrayList<User>): SlideshowFragment{
            val datosFragment= SlideshowFragment()
            val args = Bundle()
            args.putParcelableArrayList(ARG_PARAM,userList)
            datosFragment.arguments=args
            return  datosFragment

        }

    }
}