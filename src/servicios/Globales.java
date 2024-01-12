/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import models.Contrato;

/**
 *
 * @author Mario
 */
public class Globales {

    //COMPORTAMIENTOS
    public static void comportamientoTextField(javax.swing.JTextField textField, String placeholder) {
        textField.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                }
            }
        });

        textField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                }
            }
        });

    }

    public static void revertirComportamientoTextField(javax.swing.JTextField textField, String placeholder) {
        // Elimina el MouseListener
        for (java.awt.event.MouseListener listener : textField.getMouseListeners()) {
            textField.removeMouseListener(listener);
        }

        // Elimina el FocusListener
        for (java.awt.event.FocusListener listener : textField.getFocusListeners()) {
            textField.removeFocusListener(listener);
        }

        // Restaura el valor del campo de texto al marcador de posición si es necesario
        if (textField.getText().isEmpty()) {
            textField.setText(placeholder);
        }
    }

    public static void activarBuscarConEnter(JTextField textField, JLabel label) {
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                    MouseEvent event = new MouseEvent(label, MouseEvent.MOUSE_CLICKED, System.currentTimeMillis(), 0, 0, 0, 1, false);
                    label.dispatchEvent(event);
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    public static void activarBuscarConEnterBtn(JTextField textField, JButton button) {
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    button.doClick(); // Simular un clic en el botón
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
                // No es necesario implementar esta función
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // No es necesario implementar esta función
            }
        });

    }

    public static void limpiar(JTextField textField) {
        textField.setText("");

    }

    public static void vaciarFocus(final JTextField textField, final String valorPorDefecto) {

        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(valorPorDefecto)) {
                    textField.setText(""); // Borra el contenido solo si es igual al valor por defecto
                }
            }
        });
    }

    public static String mostrarImportesAnteriores(Contrato contrato) {
        StringBuilder incrementosText = new StringBuilder();
        List<Double> importesAnteriores = contrato.getImportesAlquiler();

        for (int i = 0; i < importesAnteriores.size() - 1; i++) {
            String valorAnterior = importesAnteriores.get(i).toString();
            String valorNuevo = importesAnteriores.get(i + 1).toString();

            // Agregar el par de valores a incrementosText
            incrementosText.append(valorAnterior)
                    .append(" >>> ")
                    .append(valorNuevo)
                    .append("\n");
        }

        // Añadir el último valor sin " >>> " al final
        incrementosText.append(importesAnteriores.get(importesAnteriores.size() - 1));

        String resultado = incrementosText.toString();
        return resultado;
    }
   

    public static String convertirNumeroALetras(int numero) {
    String[] UNIDADES = {"", "UN", "DOS", "TRES", "CUATRO", "CINCO", "SEIS", "SIETE", "OCHO", "NUEVE"};
    String[] DECENAS = {"", "", "VEINTE", "TREINTA", "CUARENTA", "CINCUENTA", "SESENTA", "SETENTA", "OCHENTA", "NOVENTA"};
    String[] DIEZ_DIECINUEVE = {"DIEZ", "ONCE", "DOCE", "TRECE", "CATORCE", "QUINCE", "DIECISEIS", "DIECISIETE", "DIECIOCHO", "DIECINUEVE"};
    String[] VEINTI_ = {"", "", "VEINTI", "VEINTIDOS", "VEINTITRES", "VEINTICUATRO", "VEINTICINCO", "VEINTISEIS", "VEINTISIETE", "VEINTIOCHO", "VEINTINUEVE"};
    
    if (numero < 0 || numero > 999999) {
        return "Número fuera de rango";
    }

    if (numero < 10) {
        return UNIDADES[numero];
    } else if (numero < 20) {
        return DIEZ_DIECINUEVE[numero - 10];
    } else if (numero < 30) {
        return VEINTI_[numero - 20];
    } else if (numero < 100) {
        return DECENAS[numero / 10] + ((numero % 10 != 0) ? " Y " + UNIDADES[numero % 10] : "");
    } else if (numero < 1000) {
        return UNIDADES[numero / 100] + " CIENTO " + convertirNumeroALetras(numero % 100);
    } else if (numero < 1000000) {
        return convertirNumeroALetras(numero / 1000) + " MIL " + convertirNumeroALetras(numero % 1000);
    } else {
        return "Número fuera de rango";
    }
}

    
}
