/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio;

import com.empleado.Director;
import com.empleado.Operador;
import com.empleado.Supervisor;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

import utilitarios.Constantes;
/**
 *
 * @author leonardofabiancortesvasquez
 */
public class Dispatcher {

    private static Dispatcher instance = null;

    private Dispatcher() {
        // TODO Auto-generated constructor stub
    }

    /**
     *
     * @return
     */
    public static Dispatcher getDispatcherInstance() {
        if (instance == null) {
            instance = new Dispatcher();
        }
        return instance;
    }

    public synchronized void dispachCall() {
        if (contestarLlamadaDirector() || contestarLlamadaSupervisor() || contestarLlamadaOperator()) {
            return;
        } else {
            System.out.println(Constantes.ERROR_LLAMADA + (Thread.currentThread().getId() - 10)
                    + Constantes.SIN_DISPONIBILIDAD);
        }
    }

    /**
     *
     * @return
     */
    public boolean contestarLlamadaDirector() {

        for (Director director : directorList) {
            if (director.esDisponible()) {
                director.contestarLlamada();
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @return
     */
    public boolean contestarLlamadaOperator() {

        for (Operador operador : operadorList) {
            if (operador.esDisponible()) {
                operador.contestarLlamada();
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @return
     */
    public boolean contestarLlamadaSupervisor() {

        for (Supervisor supervisor : supervisorList) {
            if (supervisor.esDisponible()) {
                supervisor.contestarLlamada();
                return true;
            }
        }
        return false;
    }

    public void inicializar() {

        IntStream.range(0, Constantes.OPERADOR).mapToObj(i -> new Operador()).forEach(operador -> operadorList.add(operador));

        IntStream.range(0, Constantes.SUPERVISOR).mapToObj(i -> new Supervisor()).forEach(supervisor -> supervisorList.add(supervisor));

        IntStream.range(0, Constantes.DIRECTOR).mapToObj(i -> new Director()).forEachOrdered(director -> directorList.add(director));
    }

    private final List<Director> directorList = new LinkedList<>();
    private final List<Supervisor> supervisorList = new LinkedList<>();
    private final List<Operador> operadorList = new LinkedList<>();

}
