/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

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
      public static void limpiar(JTextField textField){
      textField.setText("");
      
      }
      public static void vaciarFocus(JTextField textField){
      
            textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Este método se llama cuando el JTextField gana el foco
                textField.setText(""); // Vaciar el JTextField
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Este método se llama cuando el JTextField pierde el foco
            }
        });
      }
}



