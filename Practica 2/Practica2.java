package practica2;

import javax.swing.*;
import java.awt.*;

// Clase Punto
class Punto {
    int x, y;

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

// Clase Línea
class Linea {
    Punto p1, p2;

    public Linea(Punto p1, Punto p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public String toString() {
        return "Línea[" + p1 + ", " + p2 + "]";
    }
}

// Clase Círculo
class Circulo {
    Punto centro;
    int radio;

    public Circulo(Punto centro, int radio) {
        this.centro = centro;
        this.radio = radio;
    }

    @Override
    public String toString() {
        return "Círculo[centro=" + centro + ", radio=" + radio + "]";
    }
}

// Clase para dibujar las figuras
class Dibujo extends JPanel {
    private Linea linea;
    private Circulo circulo;

    public Dibujo(Linea linea, Circulo circulo) {
        this.linea = linea;
        this.circulo = circulo;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Dibuja la línea
        g.setColor(Color.BLUE);
        g.drawLine(linea.p1.x * 50, linea.p1.y * 50, linea.p2.x * 50, linea.p2.y * 50);
        g.fillOval(linea.p1.x * 50 - 3, linea.p1.y * 50 - 3, 6, 6);
        g.fillOval(linea.p2.x * 50 - 3, linea.p2.y * 50 - 3, 6, 6);
        
        // Dibuja el círculo
        g.setColor(Color.RED);
        g.drawOval(circulo.centro.x * 50 - circulo.radio * 50, 
                   circulo.centro.y * 50 - circulo.radio * 50, 
                   circulo.radio * 100, 
                   circulo.radio * 100);
    }
}

// Clase principal
public class Practica2 {
    public static void main(String[] args) {
        Punto p1 = new Punto(1, 5);
        Punto p2 = new Punto(3, 6);
        Linea linea = new Linea(p1, p2);
        System.out.println(linea);

        Punto centro = new Punto(6, 4);
        Circulo circulo = new Circulo(centro, 2);
        System.out.println(circulo);

        JFrame frame = new JFrame("Dibujo de Figuras");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.add(new Dibujo(linea, circulo));
        frame.setVisible(true);
    }
}