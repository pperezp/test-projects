package test.gui;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class AppTest extends javax.swing.JFrame implements MqttCallback {

    private MqttClient client;
    private String broker;
    private String topic;
    private String clientId;

    public AppTest() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("MQTT Test");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtBroker = new javax.swing.JTextField();
        txtTopic = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtClientId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnSubscribe = new javax.swing.JButton();
        lblMensaje = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtPayload = new javax.swing.JTextArea();
        txtMensaje = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Subscribe"));

        txtBroker.setText("tcp://prez.duckdns.org:1883");

        txtTopic.setText("/test");

        jLabel1.setText("Broker:");

        jLabel2.setText("Topic:");

        txtClientId.setText("1");

        jLabel3.setText("Client ID:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtClientId)
                    .addComponent(txtTopic)
                    .addComponent(txtBroker, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBroker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTopic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtClientId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSubscribe.setText("Subscribe");
        btnSubscribe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubscribeActionPerformed(evt);
            }
        });

        lblMensaje.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        lblMensaje.setForeground(new java.awt.Color(255, 0, 0));
        lblMensaje.setText("Desconectado");
        lblMensaje.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtPayload.setColumns(20);
        txtPayload.setRows(5);
        txtPayload.setBorder(javax.swing.BorderFactory.createTitledBorder("Payloads"));
        jScrollPane2.setViewportView(txtPayload);

        txtMensaje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMensajeKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSubscribe))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMensaje))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubscribe)
                    .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubscribeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubscribeActionPerformed
        broker = txtBroker.getText();
        topic = txtTopic.getText();
        clientId = txtClientId.getText();

        if (btnSubscribe.getText().equals("Subscribe")) {
            btnSubscribe.setText("Unsubscribe");
            txtBroker.setEditable(false);
            txtTopic.setEditable(false);
            txtClientId.setEditable(false);

            try {
                /*------------- CONEXIÓN -------------*/
                client = new MqttClient(broker, clientId);
                client.setCallback(this);

                client.connect();
                client.subscribe(topic, 0);
                /*------------- CONEXIÓN -------------*/

                lblMensaje.setForeground(Color.green.darker());
                lblMensaje.setText("Conectado");
            } catch (MqttException ex) {
                txtBroker.setEditable(true);
                txtTopic.setEditable(true);
                txtClientId.setEditable(true);
                lblMensaje.setForeground(Color.red.darker());
                lblMensaje.setText("Error: " + ex.getMessage());
            }
        } else {
            btnSubscribe.setText("Subscribe");
            txtBroker.setEditable(true);
            txtTopic.setEditable(true);
            txtClientId.setEditable(true);
            try {
                client.disconnect();
                lblMensaje.setForeground(Color.red.darker());
                lblMensaje.setText("Desconectado");
            } catch (MqttException ex) {
                lblMensaje.setText("Error: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnSubscribeActionPerformed

    private void txtMensajeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMensajeKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String mensaje = txtMensaje.getText();

            try {
                MqttClient sampleClient = new MqttClient(broker, clientId+1, new MemoryPersistence());
                MqttConnectOptions connOpts = new MqttConnectOptions();
                connOpts.setCleanSession(true);
                
                System.out.println("Connecting to broker: " + broker);
                sampleClient.connect(connOpts);
                System.out.println("Connected");
                
                System.out.println("Publishing message: " + mensaje);
                MqttMessage message = new MqttMessage(mensaje.getBytes());
                message.setQos(2);
                sampleClient.publish(topic, message);
                System.out.println("Message published");
                
                sampleClient.disconnect();
                System.out.println("Disconnected");
                
                txtMensaje.setText(null);
                txtMensaje.requestFocus();
            } catch (MqttException ex) {
                Logger.getLogger(AppTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtMensajeKeyReleased

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppTest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubscribe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JTextField txtBroker;
    private javax.swing.JTextField txtClientId;
    private javax.swing.JTextField txtMensaje;
    private javax.swing.JTextArea txtPayload;
    private javax.swing.JTextField txtTopic;
    // End of variables declaration//GEN-END:variables

    @Override
    public void connectionLost(Throwable thrwbl) {
        System.out.println("Connection Lost");
        txtPayload.append("Connection Lost");
        txtPayload.append("-");
    }

    @Override
    public void messageArrived(String topic, MqttMessage mm) throws Exception {
        String payload = new String(mm.getPayload());
        System.out.println(payload);
        txtPayload.append(payload);
        txtPayload.append("-");
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken imdt) {
        System.out.println("Delivery complete");
        txtPayload.append("Delivery complete");
        txtPayload.append("-");
    }
}
