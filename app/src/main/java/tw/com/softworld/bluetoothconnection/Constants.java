package tw.com.softworld.bluetoothconnection;

/**
 * Defines several constants used between {@link BluetoothChatService} and the UI.
 */
public class Constants {

    // Message types sent from the BluetoothChatService Handler
    public static final int MESSAGE_STATE_CHANGE = 101;
    public static final int MESSAGE_READ = 102;
    public static final int MESSAGE_WRITE = 103;
    public static final int MESSAGE_DEVICE_NAME = 104;
    public static final int MESSAGE_CONNECTION_FAILED = 105;
    public static final int MESSAGE_CONNECTION_LOST = 106;

    // Key names received from the BluetoothChatService Handler
    public static final String DEVICE_NAME = "device_name";
    public static final String TOAST = "TOAST";

    // Result types from Get vendor
    public static final int SUCCESS = 1;
    public static final int FAILURE = 0;

}
