package com.example.appmonedaserver.provider

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import com.example.appmonedaserver.MiApplication
import com.example.appmonedaserver.db.MiDbMonedas

private val sUriMatcher = UriMatcher(UriMatcher.NO_MATCH).apply {

    addURI("com.example.appmonedaserver", "monedas", 1)
    addURI("com.example.appmonedaserver", "monedas/#", 2)
    addURI("com.example.appmonedaserver", "monedas/*", 3)
}

class MiProveedorDeContenido : ContentProvider() {
    private lateinit var db: MiDbMonedas

    override fun onCreate(): Boolean {
        db = (context as MiApplication).database
        return true
    }

    override fun query(
        p0: Uri,
        p1: Array<out String>?,
        p2: String?,
        p3: Array<out String>?,
        p4: String?
    ): Cursor? {
        var cursor: Cursor? = null
        when( sUriMatcher.match(p0)){
            //"content://com.example.appmonedaserver/monedas"
            //query / insert
            1 -> {
                //ir  a la bd y traer el getall
                cursor =  db.cambioDao().getAllCambioCursor()
            }

            //"content://com.example.appmonedaserver/monedas/*"
            //query
            2 -> {}

            //"content://com.example.appmonedaserver/monedas/#"
            //query / update  /  delete
            3 -> {}
            else -> {}

        }
        return cursor
    }

    override fun getType(p0: Uri): String? {
        var typeMime: String = "vnd.android.cursor.dir/vnd.com.example.provider.monedas"
        when( sUriMatcher.match(p0)){

            //"content://com.example.appmonedaserver/monedas"
            //query / insert
            1 -> {
                //ir  a la bd y traer el getall
                typeMime = "vnd.android.cursor.dir/vnd.com.example.provider.monedas"
            }

            //"content://com.example.appmonedaserver/monedas/#"
            //query
            2 -> {
                typeMime = "vnd.android.cursor.item/vnd.com.example.provider.monedas"
            }

            //"content://com.example.appmonedaserver/monedas/*"
            //query / update  /  delete
            3 -> {
                typeMime = "vnd.android.cursor.item/vnd.com.example.provider.monedas"
            }
            else -> {

            }

        }
        return  typeMime
    }

    override fun insert(p0: Uri, p1: ContentValues?): Uri? {
        when( sUriMatcher.match(p0)){

            //"content://com.example.appmonedaserver/monedas"
            //query / insert
            1 -> {
                //ir  a la bd y llamar insert. Mapear ContentValues con Pojo
            }

            //"content://com.example.appmonedaserver/monedas/*"
            //query
            2 -> {

            }

            //"content://com.example.appmonedaserver/monedas/#"
            //query / update  /  delete
            3 -> {

            }
            else -> {

            }

        }
        return null
    }

    override fun delete(p0: Uri, p1: String?, p2: Array<out String>?): Int {
        when( sUriMatcher.match(p0)){

            //"content://com.example.appmonedaserver/monedas"
            //query / insert
            1 -> {
                //ir  a la bd y traer el getall
            }

            //"content://com.example.appmonedaserver/monedas/*"
            //query
            2 -> {

            }

            //"content://com.example.appmonedaserver/monedas/#"
            //query / update  /  delete
            3 -> {
                //mandar llamar el dao para un delete
            }
            else -> {

            }

        }
        return  0
    }

    override fun update(p0: Uri, p1: ContentValues?, p2: String?, p3: Array<out String>?): Int {
        when( sUriMatcher.match(p0)){

            //"content://com.example.appmonedaserver/monedas"
            //query / insert
            1 -> {
                //ir  a la bd y traer el getall
            }

            //"content://com.example.appmonedaserver/monedas/*"
            //query
            2 -> {

            }

            //"content://com.example.appmonedaserver/monedas/#"
            //query / update  /  delete
            3 -> {
                //Mandar llamar el dao para actuailizar un registro por ID
            }
            else -> {

            }

        }
        return  0
    }

}
