//package handlers;
//
//import retrofit2.Response;
//
//import javax.swing.*;
//import javax.swing.border.Border;
//import java.awt.*;
//import java.awt.event.ActionListener;
//
//public class ResponseErrorHandler<T> {
//    private Response<T> response;
//    private JFrame frame;
//    private JLabel label;
//    private JButton button;
//
//    public ResponseErrorHandler(Response<T> response) {
//        this.response = response;
//    }
//
//    public void errorDialog(String error, ActionListener listener) {
//        frame = new JFrame();
//        frame.setTitle(error);
//
//        label.setText(response.message());
//        button = new JButton("Try again.");
//        button.setPreferredSize(new Dimension(50, 25));
//
//        button.addActionListener(listener);
//
//        frame.add(label);
//        frame.add(button);
//
//        frame.pack();
//        frame.setVisible(true);
//    }
//}
