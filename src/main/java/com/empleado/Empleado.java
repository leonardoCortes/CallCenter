/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empleado;

import java.util.Random;

/**
 *
 * @author leonardofabiancortesvasquez
 */
public abstract class Empleado {

    private Random r = new Random();

    public abstract void contestarLlamada();

    protected int generarLlamada() {
        int duracion = r.nextInt(6) + 5;
        return (duracion * 1000);
    }

}
