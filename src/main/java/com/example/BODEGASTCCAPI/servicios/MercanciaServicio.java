package com.example.BODEGASTCCAPI.servicios;

import com.example.BODEGASTCCAPI.helpers.validaciones.MercanciaValidacion;
import com.example.BODEGASTCCAPI.modelos.Mercancia;
import com.example.BODEGASTCCAPI.repositorios.IMercanciaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class MercanciaServicio {

    //los servicios contienen metodos asociados
    //a alguna operacion en la base de datos
    //generalmente estas asociados a uno o mas
    //repositorios

    //Inyectar una dependencia al repositorio
    @Autowired
    IMercanciaRepositorio repositorio;

    @Autowired
    MercanciaValidacion validacion;

    //guardar
    public Mercancia almacenarMercancia(Mercancia datosMercancia) throws Exception{
        try{

            //aplicar validaciones a los datos recibidos
            //si sale bien la validacion llamo al repo para guardar los datos
            if(!this.validacion.validarPeso(datosMercancia.getPeso())){
                throw new Exception("Peso negativo, revisa");
            }

            if(!this.validacion.validarVolumen(datosMercancia.getVolumen())){
                throw new Exception("Volumen negativo, revisa");

            }

            if(!this.validacion.validarFechas(datosMercancia.getFechaIngreso(), LocalDate.now())){
                throw new Exception("Revisa la fecha ingresada");
            }

            return this.repositorio.save(datosMercancia);

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //buscar todos
    public List<Mercancia> buscarTodasMercancias(){
        return null;
    }

    //buscar por id
    public Mercancia buscarMercanciaPorId(Integer idMercancia){
        return null;
    }

    //buscar nombre
    public Mercancia buscarMercanciaPorNombre(String nombreMercancia){
        return null;
    }

    //modificar
    public Mercancia modificarMercancia(Integer idMercancia, Mercancia datosMercancia){
        return null;
    }

    //eliminar
    public boolean eliminarMercancia(Integer idMercancia){
        return true;
    }




}
