/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

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
}
