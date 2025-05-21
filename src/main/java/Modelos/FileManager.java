package Modelos;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import Modelos.Cliente;
import Modelos.Funcion;
import Modelos.Pelicula;
import Modelos.Reserva;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rocio
 */
public class FileManager {
 public static void guardarPeliculas(String nombreArchivo, List<Pelicula> peliculas) throws IOException {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
        for (Pelicula p : peliculas) {
            writer.write(p.getTitulo() + "," + p.getGenero() + "," + p.getDuracion() + "," + p.getClasificacion() + "," + p.getDirector());
            writer.newLine();
        }
    }
}
    public static ArrayList<Pelicula> cargarPeliculas(String nombreArchivo) throws IOException {
    ArrayList<Pelicula> peliculas = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
        String linea;
        while ((linea = reader.readLine()) != null) {
            String[] partes = linea.split(",");
            if (partes.length == 5) {
                Pelicula pelicula = new Pelicula(
                    partes[0].trim(),
                    partes[1].trim(),
                    Integer.parseInt(partes[2].trim()),
                    partes[3].trim(),
                    partes[4].trim()
                );
                peliculas.add(pelicula);
            }
        }
    }

    return peliculas;
}

    public static void guardarCliente(Cliente cliente, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(String.join(",", cliente.getNombre(), cliente.getApellido(),
                    cliente.getEmail(), cliente.getTelefono()));
            writer.newLine();
        }
    }

    public static List<Cliente> cargarClientes(String filename) throws IOException {
        List<Cliente> clientes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 4) {
                    clientes.add(new Cliente(partes[0], partes[1], partes[2], partes[3]));
                }
            }
        }
        return clientes;
    }

    public static void guardarFunciones(List<Funcion> funciones, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Funcion funcion : funciones) {
                writer.write(funcion.getIdPelicula() + "," + funcion.getFecha() + "," +
                        funcion.getHora() + "," + funcion.getSala());
                writer.newLine();
            }
        }
    }

    public static void guardarFuncion(Funcion funcion, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(funcion.getIdPelicula() + "," + funcion.getFecha() + "," +
                    funcion.getHora() + "," + funcion.getSala());
            writer.newLine();
        }
    }

    public static List<Funcion> cargarFunciones(String filename) throws IOException {
        List<Funcion> funciones = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 4) {
                    try {
                        int idPelicula = Integer.parseInt(partes[0]);
                        Date fecha = Date.valueOf(partes[1]);
                        Time hora = Time.valueOf(partes[2]);
                        int sala = Integer.parseInt(partes[3]);
                        funciones.add(new Funcion(idPelicula, fecha, hora, sala));
                    } catch (IllegalArgumentException e) {
                        System.err.println("Error al parsear línea: " + linea);
                    }
                }
            }
        }
        return funciones;
    }

    public static void guardarReserva(Reserva reserva, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(reserva.getIdFuncion() + "," + reserva.getIdCliente() + "," +
                    reserva.getNumAsientos() + "," + reserva.getFechaReserva());
            writer.newLine();
        }
    }

    public static List<Reserva> cargarReservas(String filename) throws IOException {
        List<Reserva> reservas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 4) {
                    try {
                        int idFuncion = Integer.parseInt(partes[0]);
                        int idCliente = Integer.parseInt(partes[1]);
                        int numAsientos = Integer.parseInt(partes[2]);
                        Date fechaReserva = Date.valueOf(partes[3]);
                        reservas.add(new Reserva(idFuncion, idCliente, numAsientos, fechaReserva));
                    } catch (IllegalArgumentException e) {
                        System.err.println("Error en formato de reserva: " + linea);
                    }
                }
            }
        }
        return reservas;
    }
}
