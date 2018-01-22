/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.negocio.Dispatcher;
import utilitarios.Constantes;
import java.util.stream.IntStream;

/**
 *
 * @author leonardofabiancortesvasquez
 */
public class Principal implements Runnable {

    private static Dispatcher dispatcher = Dispatcher.getDispatcherInstance();

    public static void main(String[] args) {
        dispatcher.inicializar();
        IntStream.range(0, Constantes.LLAMADAS).forEachOrdered(i -> new Thread(new Principal(), Constantes.ATENDIENDO_LLAMADA).start());
    }

    @Override
    public void run() {
        Dispatcher.getDispatcherInstance().dispachCall();
    }
}
