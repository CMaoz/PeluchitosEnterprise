package com.example.peluchitosenterprise.ui.gallery

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
import kotlinx.android.synthetic.main.fragment_gallery.view.*

class GalleryFragment : Fragment() {

    private lateinit var galleryViewModel: GalleryViewModel
    private lateinit var user: User
    var listUser: ArrayList<User> = ArrayList()
    private var peluche = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_gallery, container, false)

        view.btbuscar.setOnClickListener {
            var id = view.etbid.text.toString()
            var nombre = view.etbnombre.text.toString()

            if (arguments != null) {

                listUser = arguments!!.getParcelableArrayList(ARG_PARAM)!!

                for (user in listUser) {

                    if (id == user.id) {
                        peluche = "Id: " + user.id  + "\nNombre: " + user.nombre + "\nCantidad: " + user.cantidad + "\nPrecio: " + user.precio
                    }
                    if (nombre == user.nombre) {
                        peluche = "Id: " + user.id  + "\nNombre: " + user.nombre + "\nCantidad: " + user.cantidad + "\nPrecio: " + user.precio

                    }
                }
                view.tvbuscar.text = peluche
                peluche = ""
            }
            else{
                view.tvbuscar.text = "La lista se encuentra vacia"
            }
            view.etbid.text.clear()
            view.etbnombre.text.clear()
        }

        return view
    }

    companion object {
        private val ARG_PARAM = "MyObject"

        fun newInstance(userList: ArrayList<User>): GalleryFragment {
            val datosFragment = GalleryFragment()
            val args = Bundle()
            args.putParcelableArrayList(ARG_PARAM, userList)
            datosFragment.arguments = args
            return datosFragment

        }

    }
}