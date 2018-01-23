/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empleado;

import utilitarios.Constantes;
/**
 *
 * @author leonardofabiancortesvasquez
 */
public class Operador extends Empleado implements Runnable {

    private boolean disponible = true;

    @Override
    public void contestarLlamada() {
        System.out.println(Constantes.LLAMADA_ATENDIDA + (Thread.currentThread().getId() - 10) +Constantes.CONTESTADA_OPERADOR);
        disponible = false;
        Thread terminarLlamadaOperador = new Thread(new Operador(), Constantes.FIN_LLAMADA);
        terminarLlamadaOperador.start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(super.generarLlamada());
            System.out.println(Constantes.ATENDIDA_OPERADOR);
            disponible = false;
        } catch (InterruptedException e) {
            System.out.println(Constantes.ERROR_LLAMADA);
        }
    }

    /**
     * @return the disponible
     */
    public boolean esDisponible() {
        return disponible;
    }

}
